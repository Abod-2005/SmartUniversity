package core;
//Abd Al-Rhman Saleem Al Nawati
//120230777


// كلاس يمثل طلب مورد مقدم من طالب
// يستخدم نمط Builder لأن الحقول الاختيارية كثيرة — كل طالب يحدد فقط ما يحتاجه
public class ResourceRequest {

    // الحقول كلها final لأن الطلب لا يتغير بعد الإنشاء
    private final String studentId;          // رقم الطالب — إلزامي
    private final String resourceType;       // نوع المورد المطلوب — إلزامي
    private final int durationMinutes;       // مدة الاستخدام بالدقائق
    private final int priority;             // مستوى الأولوية
    private final String notes;             // ملاحظات إضافية اختيارية
    private final String softwareRequired;  // البرنامج المطلوب اختياري
    private final boolean supervisorApproval; // هل يحتاج موافقة المشرف؟

    // Constructor خاص — يُستدعى فقط من Builder
    private ResourceRequest(Builder builder) {
        this.studentId = builder.studentId;
        this.resourceType = builder.resourceType;
        this.durationMinutes = builder.durationMinutes;
        this.priority = builder.priority;
        this.notes = builder.notes;
        this.softwareRequired = builder.softwareRequired;
        this.supervisorApproval = builder.supervisorApproval;
    }

    // Getters للوصول لبيانات الطلب
    public String getStudentId()            { return studentId; }
    public String getResourceType()         { return resourceType; }
    public int getDurationMinutes()         { return durationMinutes; }
    public String getNotes()                { return notes; }
    public String getSoftwareRequired()     { return softwareRequired; }
    public boolean isSupervisorApprovalNeeded() { return supervisorApproval; }
    public int getPriority()               { return priority; }

    // الـ Builder — يبني الطلب خطوة بخطوة
    public static class Builder {
        private final String studentId;    // إلزامي — لا قيمة افتراضية
        private final String resourceType; // إلزامي — لا قيمة افتراضية
        private int durationMinutes = 60;  // اختياري — افتراضي 60 دقيقة
        private int priority = 1;          // اختياري — افتراضي أولوية عادية
        private String notes = null;       // اختياري
        private String softwareRequired = null; // اختياري
        private boolean supervisorApproval = false; // اختياري — افتراضي لا يحتاج موافقة

        // Constructor يأخذ الحقول الإلزامية فقط
        public Builder(String studentId, String resourceType) {
            this.studentId = studentId;
            this.resourceType = resourceType;
        }

        // كل method ترجع this عشان تقدر تكتب .duration().priority() على نفس السطر
        public Builder duration(int minutes) {
            this.durationMinutes = minutes;
            return this;
        }

        public Builder priority(int level) {
            this.priority = level;
            return this;
        }

        public Builder notes(String notes) {
            this.notes = notes;
            return this;
        }

        // بناء الـ object النهائي بعد تحديد كل الخصائص المطلوبة
        public ResourceRequest build() {
            return new ResourceRequest(this);
        }
    }
}