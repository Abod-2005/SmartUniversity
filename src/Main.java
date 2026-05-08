//Abd Al-Rhman Saleem Al Nawati
//120230777
import core.*;
import factories.*;
import sessions.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Lab Management System Startup ===\n");

        // 1.  الحصول على إعدادات النظام وتغييرها
        LabSystemConfig config = LabSystemConfig.getInstance();
        System.out.println("System Config Loaded:");
        System.out.println("- Max Requests per Student: " + config.getMaxRequestsPerStudent());
        System.out.println("- Allowed Resources: " + config.getAllowedResources());
        System.out.println("------------------------------------\n");

        // 2.  إنشاء المصانع لكل نوع مختبر
        LabSessionFactory aiFactory = new AILabSessionFactory();
        LabSessionFactory roboticsFactory = new RoboticsLabSessionFactory();
        LabSessionFactory cyberFactory = new CybersecurityLabSessionFactory();

        // 3. فتح جلسات جديدة
        System.out.println("--- Opening Lab Sessions ---");
        LabSession aiSession = aiFactory.openSession("AI-2026-001");
        System.out.println("********\n");
        LabSession roboticsSession = roboticsFactory.openSession("ROB-2026-042");
        System.out.println("********\n");
        LabSession cyberSession = cyberFactory.openSession("SEC-2026-007");
        System.out.println("----------------------------\n");


       // 4.  إنشاء طلبات موارد
        System.out.println("--- Submitting Requests ---");

        // طالب يطلب GPU لجلسة الـ AI
        ResourceRequest req1 = new ResourceRequest.Builder("S123", "GPU")
                .duration(90)
                .priority(3)
                .notes("Training a transformer model")
                .build();
        aiSession.submitRequest(req1);

        // طالب يطلب Robot Arm في مختبر الروبوتات (يحتاج موافقة مشرف مثلاً)
        ResourceRequest req2 = new ResourceRequest.Builder("S456", "Robot Arm")
                .duration(45)
                .build();
        roboticsSession.submitRequest(req2);

        // محاولة إرسال طلب مورد غير مسموح به (لاختبار Validation في LabSession)
        ResourceRequest invalidReq = new ResourceRequest.Builder("S789", "Coffee Machine")
                .build();
        aiSession.submitRequest(invalidReq);

        // محاولة تجاوز الحد الأقصى للمدة (أكثر من 120 دقيقة)
        ResourceRequest longReq = new ResourceRequest.Builder("S123", "CPU")
                .duration(500)
                .build();
        cyberSession.submitRequest(longReq);

        System.out.println("----------------------------\n");

        // 5. طباعة ملخص الجلسات
        System.out.println("--- Final Reports ---");
        aiSession.printSessionSummary();
        roboticsSession.printSessionSummary();
        cyberSession.printSessionSummary();

        // عرض وصف المختبرات
        System.out.println("\nLab Descriptions:");
        System.out.println("- " + aiSession.getLabDescription());
        System.out.println("- " + cyberSession.getLabDescription());



    }


}

