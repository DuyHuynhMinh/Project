import constant.Constant;
import email.EmailService;
import email.EmailServiceImpl;
import path.InputPath;

public class Main {

    public static void main(String[] arg) {

        String pathEmailTemplate = arg[0];
        String pathCustomerData = arg[1];
        String outputFolderEmails = arg[2];
        String outputErrorEmails = arg[3];

        InputPath inputPath = new InputPath();
        inputPath.setPathEmailTemplate(pathEmailTemplate);
        inputPath.setPathCustomerData(pathCustomerData);
        inputPath.setOutputFolderEmails(outputFolderEmails);
        inputPath.setOutputErrorEmails(outputErrorEmails);

        EmailService emailService = new EmailServiceImpl(inputPath);

        emailService.runEmailService();

    }
}
