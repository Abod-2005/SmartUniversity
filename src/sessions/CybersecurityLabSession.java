package sessions;
//Abd Al-Rhman Saleem Al Nawati
//120230777
import core.LabSession;
import core.ResourceRequest;

// جلسة مختبر الأمن السيبراني — تدعم اختبار الاختراق وتحليل الشبكات
public class CybersecurityLabSession extends LabSession {

    // تهيئة الجلسة باسم المختبر الثابت
    public CybersecurityLabSession(String sessionId) {
        super(sessionId, "Cybersecurity Lab");
    }

    // تجهيز بيئة الأمن السيبراني: شبكة معزولة + أدوات التحليل + جدار الحماية
    @Override
    public void setup() {
        System.out.println("  [Cybersecurity Lab] Creating isolated virtual network...");
        System.out.println("  [Cybersecurity Lab] Installing Wireshark and Nmap...");
        System.out.println("  [Cybersecurity Lab] Firewall rules are active.");
    }

    // وصف قدرات المختبر للعرض أو التقارير
    @Override
    public String getLabDescription() {
        return "Cybersecurity Lab — Supports penetration testing and network security. "
                + "Equipped with isolated networks and security analysis tools.";
    }

    // معالجة الطلب: تخصيص بيئة معزولة آمنة لكل طالب
    @Override
    protected void processRequest(ResourceRequest request) {
        System.out.println("  [Cybersecurity Lab] Setting up isolated environment for "
                + request.getStudentId() + ".");
        System.out.println("  [Cybersecurity Lab] Allocating "
                + request.getResourceType() + " in secure mode.");
    }
}