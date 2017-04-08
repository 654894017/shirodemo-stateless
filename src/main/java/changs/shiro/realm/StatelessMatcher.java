package changs.shiro.realm;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yincs on 2017/4/8.
 */
public class StatelessMatcher implements CredentialsMatcher {

    private static final Logger logger = LoggerFactory.getLogger(StatelessMatcher.class);

    @Override
    public boolean doCredentialsMatch(AuthenticationToken authenticationToken, AuthenticationInfo authenticationInfo) {
        logger.debug("doCredentialsMatch() called with: authenticationToken = [" + authenticationToken.getPrincipal() + "], authenticationInfo = [" + authenticationInfo.getPrincipals() + "]");
        return true;
    }
}
