package email;

import com.samskivert.mustache.Mustache;
import constant.Constant;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import path.InputPath;
import util.ReadFileUtil;
import util.WriteFileUtil;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmailServiceImplTest {


    private static final String SEPARATOR = System.getProperty("file.separator");
    public static InputPath inputPath = null;
    public static EmailService emailService = null;

    @BeforeAll
    static void init() {

        String pathEmailTemplate = String.join(SEPARATOR,System.getProperty("user.dir"), "src", "test", "resources","email_template.json");
        String pathCustomerData = String.join(SEPARATOR,System.getProperty("user.dir"), "src", "test", "resources","customers.csv");
        String outputFolderEmails = String.join(SEPARATOR,System.getProperty("user.dir"), "src", "test", "resources\\");
        String outputErrorEmails = String.join(SEPARATOR,System.getProperty("user.dir"), "src", "test", "resources","test_error.csv");

        inputPath = new InputPath();

        inputPath.setPathEmailTemplate(pathEmailTemplate);
        inputPath.setPathCustomerData(pathCustomerData);
        inputPath.setOutputFolderEmails(outputFolderEmails);
        inputPath.setOutputErrorEmails(outputErrorEmails);

    }

    @BeforeEach
    void initEachTest() {
        emailService = new EmailServiceImpl(inputPath);
    }

    @Test
    void runEmailServiceTest() {
        emailService.runEmailService();
        assertTrue(WriteFileUtil.isExistFile(inputPath.getOutputFolderEmails()+"smith@gmail.com.json"));
        assertTrue(WriteFileUtil.isExistFile(inputPath.getOutputErrorEmails()));
    }

    @Test
    void buildEmailRequestTest() {

        SimpleDateFormat ft =   new SimpleDateFormat (Constant.DATE_FORMAT);

        String emailTemplate ="{\"from\": \"The Marketing Team<marketing@exmaple.com\", " +
                "\"subject\": \"A new product is being launched soon..\", " +
                "\"mimeType\": \"text/plain\"," +
                "\"body\": \"Hi {{TITLE}} {{FIRST_NAME}} {{LAST_NAME}}, \nToday, {{TODAY}}, we would like\"+\" to tell you that... Sincerely, \nThe Marketing Team\"}";


        String customerData = "Mr,John,Smith,michelle_smith@gmail.com";

        Map<String,String> buildResult = emailService.buildEmailRequest(emailTemplate, customerData);


        String expectedEmailRequestBody = "{" +
                        "\"from\": \"The Marketing Team<marketing@exmaple.com\", " +
                        "\"subject\": \"A new product is being launched soon..\", " +
                        "\"mimeType\": \"text/plain\"," +
                        "\"body\": \"Hi Mr John Smith, \nToday, {{TODAY}}, we would like\"+\" to tell you that... Sincerely, \nThe Marketing Team\"" +
                        "}";

        Map<String,String> customerDataMap = new HashMap<>();
        customerDataMap.put(Constant.TODAY, ft.format(new Date()));

        expectedEmailRequestBody = Mustache.compiler()
                .defaultValue("")
                .compile(expectedEmailRequestBody)
                .execute(customerDataMap);

        String requestBody  = buildResult.get("requestBody");
        assertTrue(expectedEmailRequestBody.equals(requestBody));
    }

    @Test
    void saveEmailRequestTest() {
        String outputFileName = inputPath.getOutputFolderEmails() +"testSaveEmail";
        String emailRequestBody = "{ " +
                "\"from\": \"The Marketing Team<marketing@exmaple.com\"," +
                "\"subject\": \"A new product is being launched soon..\"," +
                "\"mimeType\": \"text/plain\", " +
                "\"body\": \"Hi Mr John Smith, \nToday, 05 Dec 2021, we would like\"+\" to tell you that... Sincerely, \nThe Marketing Team\" " +
                "}";

        emailService.saveEmailRequest(outputFileName,emailRequestBody);
        assertTrue(WriteFileUtil.isExistFile(outputFileName+".json"));
        String outPutBodyEmail = ReadFileUtil.readFileAsString(outputFileName+".json");
        assertTrue(emailRequestBody.equals(outPutBodyEmail));

    }

    @AfterAll
    static void clearUp() {
        File f = new File(inputPath.getOutputFolderEmails()+"smith@gmail.com.json");
        if(f.exists()) {
            f.delete();
        }

        f = new File(inputPath.getOutputErrorEmails());
        if(f.exists()) {
            f.delete();
        }

        f = new File(inputPath.getOutputFolderEmails() +"testSaveEmail.json");
        if(f.exists()) {
            f.delete();
        }


    }
}