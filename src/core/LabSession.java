package core;
//Abd Al-Rhman Saleem Al Nawati
//120230777
import java.util.ArrayList;
import java.util.List;

// كلاس مجرد يمثل جلسة مختبر — الأساس لكل أنواع الجلسات
public abstract class LabSession {

    // المتغيرات الأساسية للجلسة
    protected String sessionId;                  // رقم تعريف الجلسة
    protected String labName;                    // اسم المختبر
    protected List<ResourceRequest> requests;    // قائمة طلبات الموارد المقدمة في الجلسة
    protected String status;                     // حالة الجلسة: OPEN، CLOSED، أو IN_PROGRESS


    // Constructor — يهيئ الجلسة بقيم افتراضية عند الإنشاء
    public LabSession(String sessionId, String labName) {
        this.sessionId = sessionId;
        this.labName = labName;
        this.requests = new ArrayList<>();        // تبدأ قائمة الطلبات فاضية
        this.status = "OPEN";                     // الحالة الافتراضية عند الإنشاء
    }

    // إضافة طلب مورد بعد التحقق من 3 قواعد
    public void submitRequest(ResourceRequest request) {
        LabSystemConfig config = LabSystemConfig.getInstance();

        // القاعدة 1 — التحقق ان نوع المورد مسموح به في الإعدادات
        if (!config.getAllowedResources().contains(request.getResourceType())) {
            System.out.println("  Resource not allowed: " + request.getResourceType());
            return;
        }

        // القاعدة 2 — التحقق ان الطالب لم يتجاوز الحد الأقصى من الطلبات
        long studentRequests = requests.stream()
                .filter(r -> r.getStudentId().equals(request.getStudentId()))
                .count();
        if (studentRequests >= config.getMaxRequestsPerStudent()) {
            System.out.println("  Student " + request.getStudentId()+ " reached max requests. Rejected.");
            return;
        }

        // القاعدة 3 — التحقق ان مدة الطلب لا تتجاوز الحد الأقصى المسموح
        if (request.getDurationMinutes() > config.getMaxSessionDurationMinutes()) {
            System.out.println(" Duration exceeds maximum. Rejected.");
            return;
        }

        // كل الفحوصات نجحت — أضف الطلب ونفّذه
        requests.add(request);
        processRequest(request);
    }

    // طباعة ملخص كامل للجلسة مع تفاصيل كل طلب
    public void printSessionSummary() {
        System.out.println("=*= Session Summary =*=");
        System.out.println("Session ID: " + sessionId);
        System.out.println("Lab: " + labName);
        System.out.println("Status: " + status);
        System.out.println("Total Requests: " + requests.size());

        // طباعة تفاصيل كل طلب في القائمة
        for (ResourceRequest r : requests) {
            System.out.println("  - Student: " + r.getStudentId()+ " | Resource: " + r.getResourceType()  + " | Duration: " + r.getDurationMinutes() + " min");
        }
        System.out.println("=======================");
    }

    // methods  — كل subclass لازم ينفذها بطريقته
    public abstract void setup();                                    // تجهيز المختبر قبل بدء الجلسة
    public abstract String getLabDescription();                      // وصف نوع المختبر
    protected abstract void processRequest(ResourceRequest request); // معالجة الطلب حسب نوع الجلسة
}