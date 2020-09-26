<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Tasks</title>
	</head>
	<body>
		<p> Adicionar Task: </p>
		<p> <jsp:include page="Adiciona.jsp"></jsp:include> </p> <br>
		<p> Editar Task: </p>
		<p> <jsp:include page="Edita.jsp"></jsp:include> </p> <br>
		<p> Remover Task: </p>
		<p> <jsp:include page="Remove.jsp"></jsp:include> </p> <br>
		<%@ page import="java.util.*,br.edu.insper.mvc.model.*"%>
		<table border='1'>
			<% DAO dao =new DAO();
			List<Tasks> tasks = dao.getLista();
			for(Tasks task : tasks ){%>
				<tr>
				<td><%=task.getId()%></td>
				<td><%=task.getTitle()%></td>
				<td><%=task.getCreator()%></td>
				<td><%=task.getTag()%></td>
				</tr>
			<% } %>
		</table>
	</body>
</html>