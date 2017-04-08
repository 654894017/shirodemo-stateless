package changs.shiro.realm;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * Created by yincs on 2017/4/8.
 */
public class StatelessToken implements AuthenticationToken {
    private String token;

    public StatelessToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }


    @Override
    public Object getCredentials() {
        return null;
    }
}
