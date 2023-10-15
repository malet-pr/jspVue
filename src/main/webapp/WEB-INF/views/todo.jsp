<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang=en>
	<head>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>	
		<meta charset="utf-8">
		<title>Main ToDo Page</title>		
	</head>
	<body>
		<jsp:include page="navBar.jsp"></jsp:include>
		<div class="text-center">
			<h3>${text}</h3>
		</div>
		<div class="text-center">
			<c:choose>  
			    <c:when test="${todos.size() > 0}">  
			    	<c:forEach items="${todos}" var="todo">  
			    		<div class="card text-center d-inline-flex p-2 col-example" style="width: 18rem;">
						  <div class="card-body">
						  	<h5 class="card-title"><c:out value="${todo.title}"/></h5>
						  	<p class="card-text">
						  		<c:out value="${todo.descriptionShort}"/> <br>
						  	 	Category: <c:out value="${todo.category}"/> <br>
						  	 	Completed: <c:out value="${todo.finished}"/>
						  	</p>
							<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal"
								onClick="$('#exampleModal').find('#longDesc').html('${todo.descriptionLong}')">
							  	Full Text
							</button>
						  </div>
					   </div>
					</c:forEach> 
			    </c:when>  
			    <c:otherwise>  
			       <p>There are no ToDos to show</p> 
			    </c:otherwise>  
			</c:choose>  
		</div>
		<!-- modal  -->
		<jsp:include page="modal1.jsp"></jsp:include>
	</body>
</html>