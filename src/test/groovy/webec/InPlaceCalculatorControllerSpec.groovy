package mvc

import grails.testing.web.controllers.ControllerUnitTest
import grails.testing.gorm.DataTest
import spock.lang.Specification

class InPlaceCalculatorControllerSpec extends Specification implements ControllerUnitTest<InPlaceCalculatorController> , DataTest {

    //Required with the DataTest, so InPlaceCalculator gets mocked and not saved into the database
    Class<?>[] getDomainClassesToMock(){
        return [InPlaceCalculator] as Class[]
    }

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

    void "input1 minus input2 should equal result"(input1, input2, operator, result) {
        when:
        def model = new CalculatorModel(input1: input1, input2: input2, operator: operator)
        controller.calc(model)
        then: "add calculation"
        model.result == result
        where:
        input1  | input2 | operator | result
        0.0     | 0.0    | "-"      |"0.0"
        5.5     | 0.0    | "-"      |"5.5"
        0.0     | 13.7   | "-"      |"-13.7"
        25.0    | 10.2   | "-"      |"14.8"
        -13.0   | 25.0   | "-"      |"-38.0"
        -13.0   | -13.0  | "-"      |"0.0"
    }

    void "input1 multiply with input2 should equal result"(input1, input2, operator, result) {
        when:
        def model = new CalculatorModel(input1: input1, input2: input2, operator: operator)
        controller.calc(model)
        then: "add calculation"
        model.result == result
        where:
        input1  | input2 | operator | result
        0.0     | 0.0    | "*"      |"0.0"
        5.5     | 0.0    | "*"      |"0.0"
        0.0     | 13.7   | "*"      |"0.0"
        25.0    | 10.0   | "*"      |"250.0"
        -10.0   | 25.0   | "*"      |"-250.0"
        -13.0   | -10.0  | "*"      |"130.0"
    }

    void "input1 divided by input2 should equal result"(input1, input2, operator, result) {
        when:
        def model = new CalculatorModel(input1: input1, input2: input2, operator: operator)
        controller.calc(model)
        then: "add calculation"
        model.result == result
        where:
        input1  | input2 | operator | result
        0.0     | 0.0    | "/"      |"NaN"
        5.5     | 0.0    | "/"      |"Infinity"
        -5.5    | 0.0    | "/"      |"-Infinity"
        0.0     | 13.7   | "/"      |"0.0"
        25.0    | 10.0   | "/"      |"2.5"
        -25.0   | 25.0   | "/"      |"-1.0"
        -13.0   | -10.0  | "/"      |"1.3"
    }

    void "invalid operators"(input1, input2, operator, result) {
        when:
        def model = new CalculatorModel(input1: input1, input2: input2, operator: operator)
        controller.calc(model)
        then: "add calculation"
        model.result == result
        where:
        input1  | input2 | operator | result
        0.0     | 0.0    | "d"      |"Cannot calculate. operator was invalid."
        5.5     | 0.0    | "1"      |"Cannot calculate. operator was invalid."
        -5.5    | 0.0    | "hello"  |"Cannot calculate. operator was invalid."
        0.0     | 13.7   | "x"      |"Cannot calculate. operator was invalid."
        25.0    | 10.0   | "2.0"    |"Cannot calculate. operator was invalid."
        -25.0   | 25.0   | "0.0"    |"Cannot calculate. operator was invalid."
        -13.0   | -10.0  | "0"      |"Cannot calculate. operator was invalid."
    }
}