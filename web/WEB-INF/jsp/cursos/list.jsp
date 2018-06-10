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
			<div class="row form-group">
				<div class="col-sm-12">	
					<div class="navbar navbar-default">
						<div id="navbar" class="navbar-collapse collapse">
							<ul class="nav navbar-nav">
								<li><a href="${pageContext.request.contextPath}/profesores/list.htm">Profesores</a></li>
								<li><a href="${pageContext.request.contextPath}/cursos/list.htm">Cursos</a></li>					
							</ul>
						</div>
					</div>
				</div>
			</div>
			<h2>Cursos</h2>
			<div class="row form-group">
				<div class="col-sm-12">	
					<div class="navbar navbar-default">
						<div id="navbar" class="navbar-collapse collapse">
							<ul class="nav navbar-nav">
								<li><a href="${pageContext.request.contextPath}/cursos/list.htm">Listado</a></li>
								<li><a href="${pageContext.request.contextPath}/cursos/create.htm">Crear</a></li>					
							</ul>
						</div>
					</div>
				</div>
			</div>
			<table class="table table-condensed table-bordered table-hovered">
				<tr>
					<th width="4%">Id</th>
					<th width="15%">Acciones</th>
					<th>Nombre</th>					
					<th>Profesor</th>					
				</tr>
				<c:forEach items="${lst}" var="item">
					<tr>
						<td>${item[0].id}</td>
						<td>
							<a class="btn btn-info" href="${pageContext.request.contextPath}/cursos/edit.htm?id=${item[0].id}">Editar</a>
							<a class="btn btn-danger" href="${pageContext.request.contextPath}/cursos/delete.htm?id=${item[0].id}" onclick="return confirm('Esta seguro de eliminar?')">Eliminar</a>
						</td>
						<td>${item[0].nombre}</td>													
						<td>${item[1].nombre}</td>													
					</tr>
				</c:forEach>
			</table>
		</div>

    </body>
</html>
