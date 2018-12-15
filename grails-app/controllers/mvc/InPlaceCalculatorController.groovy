package mvc

class InPlaceCalculatorController {


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


        Calculation calculation = new Calculation()
        calculation.input1 = model.input1
        calculation.input2 = model.input2
        calculation.operator = model.operator
        calculation.result = model.result
        calculation.save()

        def calculations = Calculation.list()
        [calculations:calculations]


        render view: 'calc', model: [model: model]
    }
}

class CalculatorModel {

    double input1 = 0.0
    double input2 = 0.0
    String operator = "+"
    String result = ""
}
