<!doctype html>
<html>
<head>
    <meta charset="UTF-8"/>
    <asset:stylesheet src="calculator.css"/>
    <title>Calculator Index</title>
</head>
<body>

<div class="main">
    <div class="wrapper">
        <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
            <g:link controller="InPlaceCalculator" action="clear"><input class="index-button" type="button" value="Start Calculating"/></g:link>
        </g:each>
        <div/>
</div>


</body>
</html>
