package factories;
//Abd Al-Rhman Saleem Al Nawati
//120230777
import core.LabSession;
import sessions.RoboticsLabSession;

// مصنع مخصص لإنشاء جلسات مختبر الروبوتات
public class RoboticsLabSessionFactory extends LabSessionFactory {

    // إنشاء جلسة Robotics جديدة بالـ sessionId المعطى
    @Override
    protected LabSession createLabSession(String sessionId) {
        return new RoboticsLabSession(sessionId);
    }
}