<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="./search-book" method="post">
		<label for="find">Wyszukaj</label> <input type="text" name="find" />
	</form>



	<h1>Lista książek</h1>
	<table>
		<tr>
		<td>| Title</td>
		<td>| Author</td>
		<td>| Isbn</td>
		<td>| Akcja</td>
		<td>|</td>
		</tr>
		<c:forEach items="${books}" var="book">
		<tr>
		<td>| ${book.title}</td>
		<td>| ${book.author}</td>
		<td>| ${book.isbn}</td>
		<td>|
		<a href='./delete-book?id=${book.id}'> Usuń</a>&nbsp
		<a href='./edit-book?id=${book.id}'> Edytuj</a>
		</td>
		<td>|</td>
		</tr>
		</c:forEach>
	</table>

</body>
</html>