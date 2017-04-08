package changs.shiro.session;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.session.mgt.SessionFactory;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Created by yincs on 2017/4/8.
 */
public class RedisSessionFactory implements SessionFactory {

    private static final Logger logger = LoggerFactory.getLogger(RedisSessionFactory.class);

    @Override
    public Session createSession(SessionContext sessionContext) {
        ServletRequest request = WebUtils.getRequest(sessionContext);
        ServletResponse response = WebUtils.getResponse(sessionContext);
        sessionContext.setSessionId("token");
        logger.debug("createSession() called with: sessionContext = [" + sessionContext + "]");
//        Serializable sessionId = sessionContext.getSessionId();
//        System.out.println("sessionId = " + sessionId);
        return null;
    }
}
