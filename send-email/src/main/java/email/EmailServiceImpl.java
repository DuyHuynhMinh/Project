package email;

import com.samskivert.mustache.Mustache;
import constant.Constant;
import path.InputPath;
import util.ReadFileUtil;
import util.WriteFileUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class EmailServiceImpl implements EmailService {

    private InputPath inputPath;

    public EmailServiceImpl(InputPath inputPath ) {
        this.inputPath = inputPath;
    }

    @Override
    public void runEmailService()  {

        System.out.println("\n Calling runEmailService \n");

        String emailTemplate = getEmailTemplate(inputPath.getPathEmailTemplate());

        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(inputPath.getPathCustomerData()));

            //Read the CSV file header to skip it
            fileReader.readLine();

            String customerData ="";

            while ((customerData = fileReader.readLine()) != null) {

                Map<String,String> buildEmailResult = buildEmailRequest(emailTemplate,customerData);

                if(buildEmailResult.get(Constant.EMAIL)==null) {
                    exportToErrorFileEmptyEmail (inputPath.getOutputErrorEmails(), customerData);
                } else {
                    saveEmailRequest(inputPath.getOutputFolderEmails() + buildEmailResult.get(Constant.EMAIL), buildEmailResult.get(Constant.REQUEST_BODY));
                }

            }
        } catch (IOException e) {
            System.out.println(" Error when calling email service " + e + "\n");
            e.printStackTrace();
        }

    }

    @Override
    public Map<String,String> buildEmailRequest(String emailTemplate, String customerData) {

        System.out.println("Calling buildEmailRequest  customerData \n" + customerData +"\n");

        Map<String,String> buildResult = new HashMap<>();

        Map<String,String> customerDataMap = new HashMap<>();
        SimpleDateFormat ft =   new SimpleDateFormat (Constant.DATE_FORMAT);
        String[] data = customerData.split(Constant.COMMA_DELIMITER);

        customerDataMap.put(Constant.TITLE, data[0]);
        customerDataMap.put(Constant.FIRST_NAME, data[1]);
        customerDataMap.put(Constant.LAST_NAME, data[2]);
        customerDataMap.put(Constant.TODAY, ft.format(new Date()));

        String requestBody = Mustache.compiler()
                                        .defaultValue("")
                                        .compile(emailTemplate)
                                        .execute(customerDataMap);


        buildResult.put(Constant.REQUEST_BODY,requestBody);

        //email is empty
        if(data.length<4||data[3].isEmpty()) {
            buildResult.put(Constant.EMAIL, null);
        } else {
            buildResult.put(Constant.EMAIL,data[3]);
        }

        return buildResult;
    }

    @Override
    public void saveEmailRequest(String pathOutputFolderEmails , String emailRequestBody)  {
        System.out.println("Calling saveEmailRequest  emailRequestBody \n" + emailRequestBody +"\n");
        WriteFileUtil.write(pathOutputFolderEmails+ Constant.JSON,emailRequestBody,false);
    }


    private void exportToErrorFileEmptyEmail (String outputErrorEmails, String customerData ) {

        System.out.println("Caliing exportToErrorFileEmptyEmail customerData " + customerData +"\n");

        if(!WriteFileUtil.isExistFile(outputErrorEmails)){
            WriteFileUtil.writeHeader(outputErrorEmails, Constant.FILE_HEADER+"\n");
        }

        WriteFileUtil.write(outputErrorEmails,customerData+"\n",true);

    }


    private String getEmailTemplate(String emailTemplate)  {
        return ReadFileUtil.readFileAsString(emailTemplate);
    }

}
