package changs.shiro.filter;

import changs.shiro.realm.StatelessToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yincs on 2017/4/8.
 */
public class StatelessAuthcFilter extends AccessControlFilter {

    private static final Logger logger = LoggerFactory.getLogger(StatelessAuthcFilter.class);

    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        logger.debug("isAccessAllowed() called with: request = [" + request + "], response = [" + response + "], mappedValue = [" + mappedValue + "]");
        if (this.isLoginRequest(request, response)) {
            return true;
        } else {
            Subject subject = this.getSubject(request, response);
            return subject.getPrincipal() != null;
        }
    }

    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
//        this.saveRequestAndRedirectToLogin(request, response);
        logger.debug("onAccessDenied() called with: request = [" + request + "], response = [" + response + "]");
        StatelessToken token = new StatelessToken("token");
        try {
            getSubject(request, response).login(token);
        } catch (Exception e) {
            e.printStackTrace();
            onLoginFail(response); //6、登录失败
            return false;
        }
        return true;
    }

    private void onLoginFail(ServletResponse response) throws IOException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        httpResponse.getWriter().write("login error");
    }
}
