import groovy.xml.MarkupBuilder


class Main {
    static void  main (String []arg) {

        print " ------------  Start ------------ \n"

        def parsedFile = new XmlSlurper().parse(new File ("d:\\InputData\\strorage.xml"))

        def fileWriter = new FileWriter ("d:\\InputData\\output.xml")
        def fileBuilder = new MarkupBuilder(fileWriter)
        fileBuilder.mkp.xmlDeclaration( version: "1.0", encoding: "utf-8" )

        fileBuilder.root(deviceType : "CiscoACI", format :"" ) {
            parsedFile.eqptStorage.each {
                def available = it.@available
                def capUtilized =it.@capUtilized
                def utilized =it.@used
                def name = it.@name
                def modTs  = it.@modTs

                group {
                    "TIM-Device"("Cisco ACI")
                    "TIM-Branch"('')
                    "TIM-BranchDescr"(name)
                    "TIM-deviceIP"("")
                    "TIM-Delta"(900)
                    "TIM-utc"(modTs)
                    "DATA-StorageAvailable"(available)
                    "DATA-StorageUsed"(utilized)
                    "DATA-CapUtilized"(capUtilized)
                }

            }

        }

        fileWriter.close()
        print " ------------ End ------------"
    }
}
