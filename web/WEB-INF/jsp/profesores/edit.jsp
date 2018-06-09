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
			<h2>Profesores</h2>
			<div class="row form-group">
				<div class="col-sm-12">	
					<div class="navbar navbar-default">
						<div id="navbar" class="navbar-collapse collapse">
							<ul class="nav navbar-nav">
								<li><a href="${pageContext.request.contextPath}/profesores/list.htm">Listado</a></li>
								<li><a href="${pageContext.request.contextPath}/profesores/create.htm">Crear</a></li>					
							</ul>
						</div>
					</div>
				</div>
			</div>
			<h3>Editar</h3>
			<f:form action="update.htm" modelAttribute="Profesor" method="post">				
				<input type="hidden" name="id" value="${p.id}"/>
				<div class="form-group">
					<label for="nombreid">Nombre :</label>
					<input class="form-control" type="text" id="nombreid" name="nombre" value="${p.nombre}"/>
				</div>
				<div class="form-group">
					<input class="btn btn-primary" type="submit" value="Guardar"/>
				</div>

				
			</f:form>			
		</div>

    </body>
</html>
