import groovy.json.JsonOutput

class AciXml2JsonStorage {

    String inputFile = "d:\\InputData\\strorage.xml";
    String outputFile = "d:\\InputData";


    public  boolean process() {


        def parsedFile = new XmlSlurper().parse(new File (inputFile));

        List elementList = [];

        parsedFile.eqptStorage.each {

            String available = it.@available;
            String capUtilized = it.@capUtilized;
            String utilized = it.@utilized;
            String name = it.@name;
            String modTs = it.@modTs;
            String dn = it.@dn;

            def element =[
                    eqptStorage:[
                            attributes:
                            [
                                    available: available ,
                                    capUtilized:  capUtilized,
                                    utilized: utilized,
                                    name: name,
                                    modTs: modTs,
                                    dn: dn
                            ]
                    ]

            ];

            elementList.add(element);

        }

        def jsonResult = [ totalCount: ""+elementList.size+"", imdata : elementList ];
        println jsonResult;

        def outputTempFile = File.createTempFile('AciStorage', '.json', new File(outputFile));

        JsonOutput output = new JsonOutput();
        output.toJson( jsonResult );
        outputTempFile<<output.toJson( jsonResult );
        outputFile = outputTempFile.absolutePath;


        return true;

    }
}