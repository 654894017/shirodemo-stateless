package changs.shiro.session;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.apache.shiro.util.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by yincs on 2017/4/8.
 */
public class RedisSessionDAO extends AbstractSessionDAO {

    private static final Logger logger = LoggerFactory.getLogger(RedisSessionDAO.class);
    private ConcurrentMap<Serializable, Session> sessions = new ConcurrentHashMap<>();

    @Override
    protected Serializable doCreate(Session session) {
        logger.debug("doCreate() called with: session = [" + session + "]");
        Serializable sessionId = this.generateSessionId(session);
        this.assignSessionId(session, sessionId);
        this.storeSession(sessionId, session);
        int size = getActiveSessions().size();
        System.out.println("getActiveSessions.size = " + size);
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        logger.debug("doReadSession() called with: serializable = [" + sessionId + "]");
        return this.sessions.get(sessionId);
    }

    @Override
    public void update(Session session) throws UnknownSessionException {
        logger.debug("update() called with: session = [" + session + "]");
        this.storeSession(session.getId(), session);
    }

    @Override
    public void delete(Session session) {
        logger.debug("delete() called with: session = [" + session + "]");
        if (session == null) {
            throw new NullPointerException("session argument cannot be null.");
        } else {
            Serializable id = session.getId();
            if (id != null) {
                this.sessions.remove(id);
            }

        }
    }

    @Override
    public Collection<Session> getActiveSessions() {
        logger.debug("getActiveSessions() called");
        Collection<Session> values = this.sessions.values();
        if (CollectionUtils.isEmpty(values)) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableCollection(values);
    }

    private Session storeSession(Serializable id, Session session) {
        if (id == null) {
            throw new NullPointerException("id argument cannot be null.");
        } else {
            return this.sessions.putIfAbsent(id, session);
        }
    }
}
