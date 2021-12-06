package email;


import java.util.Map;

public interface EmailService {
    void runEmailService();
    void saveEmailRequest(String pathOutputFolderEmails , String emailRequest);
    Map<String,String> buildEmailRequest(String emailTemplate, String customerData);
}
