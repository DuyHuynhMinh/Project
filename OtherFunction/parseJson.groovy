package MainGroovy

import groovy.json.JsonSlurper
import groovy.xml.MarkupBuilder

import java.text.SimpleDateFormat


class MainGroovy {
    static void main(String[] arg) {

        parseJson()


    }

    static parseJson() {

        def pathFie = "d:\\DataFile\\Input.js"
        def jsonSlurper = new JsonSlurper()
        def reader = new BufferedReader(new InputStreamReader(new FileInputStream(pathFie), "UTF-8"));
        def data = jsonSlurper.parse(reader)

        def fileWriter = new FileWriter("d:\\DataFile\\output.xml")
        def fileBuilder = new MarkupBuilder(fileWriter)
        fileBuilder.mkp.xmlDeclaration(version: "1.0", encoding: "utf-8")

        println "Start"


        fileBuilder.root(deviceType: "AVINetwork", format: "") {
            data.series.each {

                def paternCovert2UTC = "yyyy-MM-dd'T'HH:mm:ssXXX"

                def device = "AVI NetWork"
                def branch =""
                def branchDescr = processName(it.header.name)
                def deviceIP=""
                def delta =900
                def value = it.data.value[0]
                def utc = covertTime2UTC(it.data.timestamp,paternCovert2UTC)
                def metric ="DATA-"+branchDescr+"Usage"

                println metric


                group {

                    "TIM-Device"(device)
                    "TIM-Branch"(branch)
                    "TIM-BranchDescr"(branchDescr)
                    "TIM-deviceIP"(deviceIP)
                    "TIM-Delta"(delta)
                    "TIM-utc"(utc)
                    "$metric"(value)

                }

                println(branchDescr)
                println(value)
                println(utc)
            }
    }

        fileWriter.close()
        println "Finish !"

    }

    static processName(String name) {
        if(name.contains("disk")) {
            return "Disk"
        } else if(name.contains("cpu")){
            return "CPU"
        } else {
            return "Memory"
        }
    }

    static covertTime2UTC(timestamp,paternCovert2UTC) {
        def calendar = Calendar.instance
        Date date = new SimpleDateFormat(paternCovert2UTC).parse(timestamp)
        calendar.setTime(date)
        return calendar.getTimeInMillis()
    }


}



