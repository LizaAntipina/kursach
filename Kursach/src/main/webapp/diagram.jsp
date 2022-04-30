<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<html>
  <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
        var inputs = document.getElementById("dataTasksId").value;
        inputs = inputs.replaceAll("MethodContent","");
        inputs = inputs.replaceAll("name",'"name"');
        inputs = inputs.replaceAll("cost",'"cost"');
        inputs = inputs.replaceAll("value",'"value"');
        inputs = inputs.replaceAll("=",' : ');
        inputs = inputs.replaceAll("'",'"');
        let value = [['Task', 'Goal Weights']];
        console.log(inputs)
        let datas = JSON.parse(inputs);
        console.log(datas);
        for (i = 0; i < datas.length; i++) {
        value.push([datas[i].name,datas[i].value]);
        };
        var data = google.visualization.arrayToDataTable(value);
        var options = {
          title: 'Диаграмма весов целей'
        };
        var chart = new google.visualization.PieChart(document.getElementById('piechart'));
        chart.draw(data, options);
      }
    </script>
  </head>
  <body>
      <tag:topMenu/>
      <div id="piechart" style="width: 900px; height: 500px;"></div>
      <input id="dataTasksId"type="hidden" name="pONumb" value="${sessionScope.dataTasks}" />
  </body>
</html>
