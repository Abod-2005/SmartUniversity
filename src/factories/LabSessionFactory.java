package factories;
//Abd Al-Rhman Saleem Al Nawati
//120230777
import core.LabSession;
/*
 الكلاس الأساسي لكل المصانع — يطبق نمط Factory Method
 ويرث منه ثلاث كلاسات
 AILabSessionFactory Ai لل
 RoboticsLabSessionFactory للريبوتات
 CybersecurityLabSessionFactory للامن السبراني
 */


public abstract class LabSessionFactory {

    // يفتح جلسه جديده: ينشئها ويجهزها  قبل التسليم
    public LabSession openSession(String sessionId) {
        LabSession session = createLabSession(sessionId);
        session.setup(); // تجهيز المختبر قبل البدء
        return session;
    }

    // كل subclass يحدد أي نوع جلسة ينشئ
    protected abstract LabSession createLabSession(String sessionId);
}
