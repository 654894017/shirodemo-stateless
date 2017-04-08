package changs.shiro.session;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.SubjectContext;
import org.apache.shiro.web.mgt.DefaultWebSubjectFactory;

/**
 * Created by yincs on 2017/4/8.
 */
public class MineSubjectFactory extends DefaultWebSubjectFactory {
    @Override
    public Subject createSubject(SubjectContext subjectContext) {
        subjectContext.setSessionCreationEnabled(false);
        return super.createSubject(subjectContext);
    }
}
