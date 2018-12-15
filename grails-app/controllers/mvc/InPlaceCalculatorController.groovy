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

        render view: 'calc', model: [model: model]
    }
}

class CalculatorModel {

    double input1 = 0.0
    double input2 = 0.0
    String operator = "+"
    String result = ""
}
