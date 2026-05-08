package factories;
//Abd Al-Rhman Saleem Al Nawati
//120230777
import core.LabSession;
import sessions.AILabSession;

// مصنع مخصص لإنشاء جلسات مختبر الذكاء الاصطناعي
public class AILabSessionFactory extends LabSessionFactory {

    // إنشاء جلسة AI جديدة بالـ sessionId المعطى
    @Override
    public LabSession createLabSession(String sessionId) {
        return new AILabSession(sessionId);
    }
}