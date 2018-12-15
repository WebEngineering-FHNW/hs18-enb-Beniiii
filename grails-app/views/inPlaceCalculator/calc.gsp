<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8"/>
    <asset:stylesheet src="calculator.css"/>
  <title>
    Calculator
  </title>
  <style>
  label {
    display: block;
    width: 7em;
  }
  </style>

  <script language="JavaScript">
      function setAddOperator(valueName) {
          var input = document.getElementById(valueName);
          input.value = "+";
      }
      function setSubOperator(valueName) {
          var input = document.getElementById(valueName);
          input.value = "-";
      }
      function setMultOperator(valueName) {
          var input = document.getElementById(valueName);
          input.value = "*";
      }
      function setDivOperator(valueName) {
          var input = document.getElementById(valueName);
          input.value = "/";
      }
  </script>
</head>

<body>

<h1>Calculator</h1>


<form action="/inPlaceCalculator/calc" method="get">
  <fieldset class="form">
    <div class ="inputs">
        <div class="input-field">
            <label for='input1'>input1</label>
            <input type="number decimal" name="input1" value="${model.input1}"
                   required="true" id="input1"/>
        </div>

        <div class="input-field">
            <label for='input2'>input2</label>
            <input type="number decimal" name="input2" value="${model.input2}"
                   required="true" id="input2"/>
        </div>
    </div>

    <div class="button-row1">
            <input class="operator-button" type="button" name="add" value="+" onclick="setAddOperator('operator')"
                   required="true" id="add"/>
            <input class="operator-button" type="button" name="sub" value="-" onclick="setSubOperator('operator')"
                   required="true" id="sub"/>
    </div>

    <div class="button-row2">
            <input class="operator-button" type="button" name="mult" value="*" onclick="setMultOperator('operator')"
                   required="true" id="mult"/>
            <input class="operator-button" type="button" name="div" value="/" onclick="setDivOperator('operator')"
                   required="true" id="div"/>
    </div>

    <div class="operator-field">
      <label for='operator'>Operator</label>
      <input type="text" name="operator" value="${model.operator}"
             required="true" id="operator"/>
    </div>



    <div>
      <input type="submit" value="Calculate"/>
    </div>
  </fieldset>
</form>


<div>
  <label>Result</label>
  <output>${model.result}</output>
</div>


</body>
</html>

