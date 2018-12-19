package mvc

class InPlaceCalculatorController {

    //Returns a list view of all calculations done
    def index(CalculatorModel model){
        def calculations = InPlaceCalculator.list()
        [calculations:calculations]
        calc(model)
    }

    //Calculates input1 with input2 depending on which operator is set and creates a new entry into the database.
    //If the operator is anything else than +, -, / and * result will be "Cannot calculate. operator was invalid."
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
                if(model.input2 == 0.0){
                    model.result = "Cannot divide by 0."
                    break
                }
                model.result = model.input1 / model.input2
                break
            default:
                model.result = "Cannot calculate. operator was invalid."

        }

        //Create a new entry to the database with the calculated values
        InPlaceCalculator calculation = new InPlaceCalculator()
        calculation.input1 = model.input1
        calculation.input2 = model.input2
        calculation.operator = model.operator
        calculation.result = model.result
        calculation.save()

        render view: 'calc', model: [model: model]
    }

    //Deletes all entries of the database and renders the view again.
    def clear (CalculatorModel model){
        InPlaceCalculator.executeUpdate('delete from InPlaceCalculator')
        render view: 'calc', model: [model: model]
    }

}


class CalculatorModel {

    //default values
    double input1 = 0.0
    double input2 = 0.0
    String operator = "+"
    String result = ""
    
}
