package sessions;

import core.LabSession;
import core.ResourceRequest;
//Abd Al-Rhman Saleem Al Nawati
//120230777
// جلسة مختبر الذكاء الاصطناعي — تدعم التعلم العميق ومعالجة اللغة والرؤية الحاسوبية
public class AILabSession extends LabSession {

    // تهيئة الجلسة باسم المختبر الثابت
    public AILabSession(String sessionId) {
        super(sessionId, "AI Lab");
    }

    // تجهيز بيئة الـ AI: تحميل CUDA + Jupyter + تفعيل الـ GPU
    @Override
    public void setup() {
        System.out.println("  [AI Lab] Loading CUDA drivers...");
        System.out.println("  [AI Lab] Initialising Jupyter environment...");
        System.out.println("  [AI Lab] GPU cluster is ready.");
    }

    // وصف قدرات المختبر للعرض أو التقارير
    @Override
    public String getLabDescription() {
        return "AI Lab — Supports deep learning, NLP, and computer vision workloads. "
                + "Equipped with high-performance GPUs and large datasets.";
    }

    // معالجة الطلب: تخصيص المورد مع أولوية — وجدولة GPU إذا كان المورد المطلوب
    @Override
    protected void processRequest(ResourceRequest request) {
        System.out.println("  [AI Lab] Allocating " + request.getResourceType()
                + " for training task. Priority level: " + request.getPriority() + ".");

        // جدولة خاصة لطلبات الـ GPU على الكلاستر
        if ("GPU".equalsIgnoreCase(request.getResourceType())) {
            System.out.println("  [AI Lab] Scheduling GPU job on the cluster...");
        }
    }
}