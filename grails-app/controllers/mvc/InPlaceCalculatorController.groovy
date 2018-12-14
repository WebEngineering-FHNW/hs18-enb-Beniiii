package mvc

class InPlaceCalculatorController {


    def calc(CalculatorModel model) {
        model.input1 = Math.round(model.input1 * 10) / 10
        model.input2 = Math.round(model.input2 * 10) / 10
        model.result = Math.round((model.input1 + model.input2) / 2)
        if (0.0 == model.input1) {
            model.result = "Cannot calculate. input1 value was invalid."
        }
        if (0.0 == model.input2) {
            model.result = "Cannot calculate. input2 value was invalid."
        }
        render view: 'calculator', model: [model: model]
    }
}

class CalculatorModel {

    double input1 = 0.0
    double input2 = 0.0
    String result = ""
}
