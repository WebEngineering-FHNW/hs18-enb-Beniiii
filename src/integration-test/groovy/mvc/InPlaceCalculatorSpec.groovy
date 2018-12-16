package mvc

import geb.spock.GebSpec
import grails.testing.mixin.integration.Integration

@Integration
class InPlaceCalculatorSpec extends GebSpec {

    void "Calculate in place with a self-refreshing view"() {
        when: "Go to start GSP page by calling it disguised as HTML"
        go '/InPlaceCalculator.html'
        then:
        title == "Calculator"

        when: "set valid input"
        $("form").input1 = 18.0
        $("form").input2 = 13.0
        $("form").operator = "+"
        $("input", type: "submit").click()

        then: "Result is displayed"
        $("output").text() == "31.0"

    }
}