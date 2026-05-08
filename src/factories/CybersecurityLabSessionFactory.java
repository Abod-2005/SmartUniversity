package factories;
//Abd Al-Rhman Saleem Al Nawati
//120230777
import core.LabSession;
import sessions.CybersecurityLabSession;

// مصنع مخصص لإنشاء جلسات مختبر الأمن السيبراني
// يطبق نمط Factory Method — كل subclass يقرر أي نوع جلسة ينشئ
public class CybersecurityLabSessionFactory extends LabSessionFactory {

    // إنشاء جلسة مختبر أمن سيبراني جديدة بالـ sessionId المعطى
    @Override
    public LabSession createLabSession(String sessionId) {
        return new CybersecurityLabSession(sessionId);
    }
}