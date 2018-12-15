package mvc

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

/**
 * See the API for {@link ControllerUnitTest} for usage instructions.
 */
class InPlaceCalculatorControllerSpec extends Specification implements ControllerUnitTest<InPlaceCalculatorController> {

    void "input1 plus input2 should equal result"(input1, input2, operator, result) {
        when:
        def model = new CalculatorModel(input1: input1, input2: input2, operator: operator)
        controller.calc(model)
        then: "add calculation"
        model.result == result
        where:
        input1  | input2 | operator | result
        0.0     | 0.0    | "+"      |"0.0"
        5.5     | 0.0    | "+"      |"5.5"
        0.0     | 13.7   | "+"      |"13.7"
        25.0    | 19.2   | "+"      |"44.2"
        -13.0   | 25.0   | "+"      |"12.0"
    }
}