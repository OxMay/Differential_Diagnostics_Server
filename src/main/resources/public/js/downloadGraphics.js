    google.charts.load('current', {'packages':['corechart']});
    google.charts.setOnLoadCallback(drawChart);

    function drawChart() {
      var data = new google.visualization.DataTable();
          data.addColumn('number', 'date');
          data.addColumn('number', 'График зависимости');
      var mas = document.getElementById("viewJson").value;
      var str = JSON.parse(mas);
          data.addRows(str);
      var options = {
          title: 'Исследование содержимого кисты поджелудочной железы',
          hAxis: {
          title: 'Т, sec'
          },
          vAxis: {
          title: 'E, mV'
          },
          curveType: 'function',
          'backgroundColor': '#F5F5F5',
          };
       var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));
          chart.draw(data, options);
      }



 