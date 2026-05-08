package core;
//Abd Al-Rhman Saleem Al Nawati
//120230777
import java.util.Arrays;
import java.util.List;

// إعدادات النظام كامل — Singleton
//نستعمل لضمان نسخة واحدة فقط في كل التطبيق
public class LabSystemConfig {

    private static LabSystemConfig instance; // النسخة الوحيدة من الإعدادات
    private final int capacity;                    // السعة الكلية للمختبر
    private final List<String> allowedResources;   // الموارد المسموح بطلبها
    private final int maxRequestsPerStudent;       // الحد الأقصى للطلبات لكل طالب
    private final int maxSessionDurationMinutes;   // الحد الأقصى لمدة الجلسة بالدقائق

    // getters للوصول للإعدادات من باقي الكلاسات
    public int getMaxSessionDurationMinutes() { return maxSessionDurationMinutes; }
    public int getMaxRequestsPerStudent()     { return maxRequestsPerStudent; }
    public List<String> getAllowedResources() { return allowedResources; }
    public int getCapacity()                 { return capacity; }

    // private Constructor — يمنع إنشاء أكثر من نسخة، ويضبط القيم الافتراضية
    //ويستعمل فقط داخل ال getInstance
    private LabSystemConfig() {
        capacity = 30;
        maxRequestsPerStudent = 3;
        maxSessionDurationMinutes = 120;
        allowedResources = Arrays.asList("GPU", "CPU", "Robot Arm", "Dataset");
    }

    // نقطة الوصول الوحيدة للإعدادات — ينشئ النسخة أول مرة فقط
    public static LabSystemConfig getInstance() {
        if (instance == null) {
            instance = new LabSystemConfig();
        }
        return instance;
    }
}