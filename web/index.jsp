<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <script
          src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Insert title here</title>
</head>
<body>
<div>
  <input type="text" id="code"></input>
  <button onclick="codeString()">Generate Code</button>
  Result: <span id="result_code"></span>
</div>
<div>
  <input type="text" id="decode"></input>
  <button onclick="decodeString()">Decode string</button>
  Result: <span id="result_decode"></span>
</div>
</body>
<script type="text/javascript">
  function codeString() {
    $.ajax({
      url : "Main",
      type : "post",
      data : {
        mode : 'coding',
        data : $('#code').val()
      },
      success : function(response) {
        respJson = jQuery.parseJSON(response);
        $("#result_code").text(respJson.result);
      }
    });
  }

  function decodeString() {
    $.ajax({
      url : "Main",
      type : "post",
      data : {
        mode : 'decoding',
        data : $('#decode').val()
      },
      success : function(response) {
        respJson = jQuery.parseJSON(response);
        $("#result_decode").text(respJson.result);
      }
    });
  }
</script>
</html>