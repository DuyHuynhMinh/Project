
To run this application please go to folder :  /send-email-app/target/

Then run the command below :

java -jar send-email-app-1.0-SNAPSHOT-jar-with-dependencies.jar /path/to/email_template.json /path/to/customers.csv
/path/to/output_emails/ /path/to/errors.csv

For example : 

java -jar send-email-app-1.0-SNAPSHOT-jar-with-dependencies.jar f:\\EXCHANGEPTY_TEST\\email_template.json f:\\EXCHANGEPTY_TEST\\customers.csv f:\\EXCHANGEPTY_TEST\\ f:\\EXCHANGEPTY_TEST\\errors.csv