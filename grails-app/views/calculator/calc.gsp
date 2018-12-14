<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8"/>
  <title>
    Calculator
  </title>
  <style>
  label {
    display: block;
    width: 7em;
  }
  </style>
</head>

<body>

<h1>Calculator</h1>


<form action="/Calculator/calc" method="get">
  <fieldset class="form">
    <div>
      <label for='input1'>input1</label>
      <input type="number decimal" name="input1" value="${model.input1}"
             required="true" id="input1"/>
    </div>

    <div>
      <label for='input2'>input2</label>
      <input type="number decimal" name="input2" value="${model.input2}"
             required="true" id="input2"/>
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
