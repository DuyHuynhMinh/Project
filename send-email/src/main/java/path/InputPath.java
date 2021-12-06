package path;

public class InputPath {

    private String pathEmailTemplate;
    private String pathCustomerData;
    private String outputFolderEmails;
    private String outputErrorEmails;

    public String getPathEmailTemplate() {
        return pathEmailTemplate;
    }

    public void setPathEmailTemplate(String pathEmailTemplate) {
        this.pathEmailTemplate = pathEmailTemplate;
    }

    public String getPathCustomerData() {
        return pathCustomerData;
    }

    public void setPathCustomerData(String pathCustomerData) {
        this.pathCustomerData = pathCustomerData;
    }

    public String getOutputFolderEmails() {
        return outputFolderEmails;
    }

    public void setOutputFolderEmails(String outputFolderEmails) {
        this.outputFolderEmails = outputFolderEmails;
    }

    public String getOutputErrorEmails() {
        return outputErrorEmails;
    }

    public void setOutputErrorEmails(String outputErrorEmails) {
        this.outputErrorEmails = outputErrorEmails;
    }
}
