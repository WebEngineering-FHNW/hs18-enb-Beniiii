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


<div class="calculator-form">
    <form class="calculator-form" action="/inPlaceCalculator/calc" method="get">
        <input class="input-number" type="number decimal" name="input1" value="${model.input1}"
               required="true" id="input1"/>


        <input class="input-number" type="text" name="operator" value="${model.operator}"
               required="true" id="input-operator"/>


        <input class="input-number" type="number decimal" name="input2" value="${model.input2}"
               required="true" id="input2"/>


        <label for='add'></label>
        <input class="operator-button" type="button" name="add" value="+" onclick="setAddOperator('input-operator')"
               required="true" id="add"/>
        <input class="operator-button" type="button" name="sub" value="-" onclick="setSubOperator('input-operator')"
               required="true" id="sub"/>
        <label for='div'></label>
        <input class="operator-button" type="button" name="mult" value="*" onclick="setMultOperator('input-operator')"
               required="true" id="mult"/>
        <input class="operator-button" type="button" name="div" value="/" onclick="setDivOperator('input-operator')"
               required="true" id="div"/>

        <label for='div'></label>
        <input class="calculate-button" type="submit" value="="/>
    </form>
</div>


<div>
  <label></label>
  <output class="output-number">${model.result}</output>
</div>


</body>
</html>

