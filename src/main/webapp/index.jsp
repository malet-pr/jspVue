<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>	
		<meta charset="utf-8">
		<title>Home Integration vue - jsp</title>
	</head>
	<body>
		<%@ include file="/WEB-INF/views/navBar.jsp"%>
		
		<h2>WELCOME</h2>
		<p>
			Please chose how many days to add/substract from today
		</p>
		<form action="/mock/time" method="get">
			<input type="button" onclick="javascript:clean()" value="CLEAR" />
			<input type="number" name="days" id="number" value="0"/>
			<button type="submit" value="/mock/time">SEND</button>
		</form>
		
		<script>
		    function clean() {
		       document.getElementById('number').value = "0";
		    }
		</script>
	</body>
</html>