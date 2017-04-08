package changs.shiro.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by yincs on 2017/4/8.
 */
public class Filter1 implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(Filter1.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.debug("init() called with: filterConfig = [" + filterConfig + "]");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.debug("doFilter() called with1: servletRequest = [" + servletRequest + "], servletResponse = [" + servletResponse + "], filterChain = [" + filterChain + "]");
        filterChain.doFilter(servletRequest, servletResponse);
        logger.debug("doFilter() called with0: servletRequest = [" + servletRequest + "], servletResponse = [" + servletResponse + "], filterChain = [" + filterChain + "]");
    }

    @Override
    public void destroy() {
        logger.debug("destroy() called");
    }
}
