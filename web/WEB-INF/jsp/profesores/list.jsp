<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>		
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
    </head>
    <body>
        <div class="container">
			<table class="table table-condensed table-bordered table-hovered">
				<tr>
					<th>Id</th>
					<th>Nombre</th>					
				</tr>
				<c:forEach items="${lst}" var="item">
				<tr>
					<td>${item.id}</td>					
					<td>${item.nombre}</td>													
				</tr>
				</c:forEach>
			</table>
		</div>
		
    </body>
</html>
