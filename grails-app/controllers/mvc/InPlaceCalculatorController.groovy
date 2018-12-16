package mvc

class InPlaceCalculatorController {


    def index(CalculatorModel model){
        def calculations = InPlaceCalculator.list()
        [calculations:calculations]
        calc(model)
    }

    /**
     * Calculates input1 with input2 depending on which operator is set and creates a new entry into the database
     *
     * @param model
     * @return
     */
    def calc(CalculatorModel model) {

        switch(model.operator){
            case "+":
                model.result = model.input1 + model.input2
                break
            case "-":
                model.result = model.input1 - model.input2
                break
            case "*":
                model.result = model.input1 * model.input2
                break
            case "/":
                model.result = model.input1 / model.input2
                break
            default:
                model.result = "Cannot calculate. operator was invalid."

        }

        InPlaceCalculator calculation = new InPlaceCalculator()
        calculation.input1 = model.input1
        calculation.input2 = model.input2
        calculation.operator = model.operator
        calculation.result = model.result
        calculation.save()

        render view: 'calc', model: [model: model]
    }
}


class CalculatorModel {

    double input1 = 0.0
    double input2 = 0.0
    String operator = "+"
    String result = ""
}
