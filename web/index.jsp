<%@ page import="java.util.Timer" %>
<%@ page import="java.util.TimerTask" %>

<html>

<head>
  <script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
  <link href="style.css" rel="stylesheet">
  <link href="css/layout.css" type="text/css" rel="stylesheet">
  <link href="css/clocks.css" type="text/css" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="css3clock.css" />



</head>

<title>Watering</title>

<body>

<div class="wrapper">

  <div style="padding-top:30px;">

  </div>

  <div class="title"><p>Plant Watering System</p>

  </div>

  <div class="middle">

    <div>
      <div class="textfiles">Current Temperature:</div><div class="textfiles" style="color:black;" id="temp"></div>
    </div>

    <div>
      <div class="textfiles">Current Moisture level:</div><div class="textfiles" style="color:black;" id="mos"></div>
    </div>

    <div>
      <div class="textfiles" >Humidity:</div><div class="textfiles" style="color:black;" id="hum"></div>
    </div>


  </div>

  <script type="text/javascript">

    weatherData();
    Temp_Humidity();
    var fetch =setInterval(function(){weatherData()},100);
    var fetch =setInterval(function(){Temp_Humidity()},10000);

    function weatherData()
    {
      var xmlhttprequest = new XMLHttpRequest();
      xmlhttprequest.onreadystatechange = getServerResponse;
      xmlhttprequest.open('GET', 'ajaxHandle?weather=data', true);
      xmlhttprequest.send();

      function getServerResponse()
      {
        //checking the 'readyState' and 'status' properties of the XMLHttpRequest object, set the 'suggestions' field to the response received by the server.
        if (xmlhttprequest.readyState == 4 && xmlhttprequest.status == 200)
        {
          var response=xmlhttprequest.responseText;
          var mos=document.getElementById('mos');
          mos.innerHTML=response;
        }
//        else{
//          document.getElementById("temp").innerHTML="Error with the response"+" State:"+xmlhttprequest.readyState+" Status:"+xmlhttprequest.status;
//        }
      }
    }

    function Temp_Humidity()
    {

      var xmlhttprequest = new XMLHttpRequest();
      xmlhttprequest.onreadystatechange = getResponse;
      xmlhttprequest.open('GET', 'http://api.openweathermap.org/data/2.5/weather?lat=7.47355&lon=80.6242', true);
      xmlhttprequest.send();

      function getResponse()
      {
        //checking the 'readyState' and 'status' properties of the XMLHttpRequest object, set the 'suggestions' field to the response received by the server.

        if (xmlhttprequest.readyState == 4 && xmlhttprequest.status == 200)
        {

          var json=xmlhttprequest.responseText;
          var obj = JSON.parse(json);

          var temp=document.getElementById('temp');
          var hum=document.getElementById('hum');
          var temparature=parseInt(obj['main'].temp.toString())-273;
          temp.innerHTML=temparature.toString()+'c';
          hum.innerHTML=obj['main'].humidity;
        }
//        else{
//          document.getElementById("temp").innerHTML="Error with the response"+" State:"+xmlhttprequest.readyState+" Status:"+xmlhttprequest.status;
//        }
      }
    }

  </script>



  <div class="clock">

  </div>

  <div class="aligntable">

  </div>

  <div class="CSSTableGenerator aligndisplay" >
    <table >
      <tr>
        <td>
          <div class="tablehead">Date</div>
        </td>
        <td  >
          <div class="tablehead">Time</div>
        </td>
        <td>
          <div class="tablehead">Watering<br>Time</div>
        </td>
      </tr>
      <tr>
        <td >
          <div class="rowtext"><%=request.getAttribute("sevDate")%></div>
        </td>
        <td>
          <div class="rowtext"><%=request.getAttribute("sevTime")%></div>
        </td>
        <td>
          <div class="rowtext"><%=request.getAttribute("sevWat")%></div>
        </td>
      </tr>
      <tr>
        <td >
          <div class="rowtext"></div>
        </td>
        <td>
          <div class="rowtext"></div>
        </td>
        <td>
          <div class="rowtext"></div>
        </td>
      </tr>



    </table>
  </div>

  <div class="pos_fixed">

    <div id="liveclock" class="outer_face">
      <div class="marker oneseven"></div>
      <div class="marker twoeight"></div>
      <div class="marker fourten"></div>
      <div class="marker fiveeleven"></div>

      <div class="inner_face">
        <div class="hand hour"></div>
        <div class="hand minute"></div>
        <div class="hand second"></div>
      </div>

    </div>

    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>

    <script type="text/javascript">

      /***********************************************
       * CSS3 Analog Clock- by JavaScript Kit (www.javascriptkit.com)
       * Visit JavaScript Kit at http://www.javascriptkit.com/ for this script and 100s more
       ***********************************************/

      var $hands = $('#liveclock div.hand')

      window.requestAnimationFrame = window.requestAnimationFrame
      || window.mozRequestAnimationFrame
      || window.webkitRequestAnimationFrame
      || window.msRequestAnimationFrame
      || function(f){setTimeout(f, 60)}


      function updateclock(){
        var curdate = new Date()
        var hour_as_degree = ( curdate.getHours() + curdate.getMinutes()/60 ) / 12 * 360
        var minute_as_degree = curdate.getMinutes() / 60 * 360
        var second_as_degree = ( curdate.getSeconds() + curdate.getMilliseconds()/1000 ) /60 * 360
        $hands.filter('.hour').css({transform: 'rotate(' + hour_as_degree + 'deg)' })
        $hands.filter('.minute').css({transform: 'rotate(' + minute_as_degree + 'deg)' })
        $hands.filter('.second').css({transform: 'rotate(' + second_as_degree + 'deg)' })
        requestAnimationFrame(updateclock)
      }

      requestAnimationFrame(updateclock)


    </script>



  </div>
</div>



</body>




</html>