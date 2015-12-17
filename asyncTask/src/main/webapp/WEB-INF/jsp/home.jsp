<%--
  Created by IntelliJ IDEA.
  User: lvsong
  Date: 7/28/15
  Time: 11:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>

  <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js"></script>

  <script type="text/javascript">

		$(document).ready(function() {

			// Check The Status Every 2 Seconds
			var timer = setInterval(function() {

				$.ajax({
					  url: 'reportstatus.json',
					  success: function(data) {

						if(data === 'COMPLETE') {
							$('#reportLink').html("<a target='_target' href='report.html'>Download Report</a>");
							clearInterval(timer);
						}
					  }
				});

			}, 2000);
		});

	</script>


</head>
<body>

<h1>
	Report Generator
</h1>

<div id="reportLink">Please Wait While Your Report Is Being Generated</div>


</body>
</html>
