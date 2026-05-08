package sessions;
//Abd Al-Rhman Saleem Al Nawati
//120230777
import core.LabSession;
import core.ResourceRequest;

// جلسة مختبر الروبوتات — تدعم الأتمتة والأنظمة المدمجة والميكاترونيكس
public class RoboticsLabSession extends LabSession {

    // تهيئة الجلسة باسم المختبر الثابت
    public RoboticsLabSession(String sessionId) {
        super(sessionId, "Robotics Lab");
    }

    // تجهيز المختبر: معايرة الأذرع الآلية + تسخين الطابعات + تفعيل حساسات الأمان
    @Override
    public void setup() {
        System.out.println("  [Robotics Lab] Calibrating robot arms...");
        System.out.println("  [Robotics Lab] Warming up 3D printers...");
        System.out.println("  [Robotics Lab] Safety sensors are active.");
    }

    // وصف قدرات المختبر للعرض أو التقارير
    @Override
    public String getLabDescription() {
        return "Robotics Lab — Supports automation, mechatronics, and embedded systems. "
                + "Equipped with robot arms, oscilloscopes, and 3D printers.";
    }

    // معالجة الطلب: حجز المورد — وإشعار المشرف إذا كان الطلب يحتاج موافقته
    @Override
    protected void processRequest(ResourceRequest request) {
        System.out.println("  [Robotics Lab] Reserving " + request.getResourceType()
                + " for student " + request.getStudentId() + ".");

        // تنبيه خاص لطلبات تحتاج إشراف مباشر
        if (request.isSupervisorApprovalNeeded()) {
            System.out.println("  [Robotics Lab]  Supervisor approval required — notifying supervisor.");
        }
    }
}