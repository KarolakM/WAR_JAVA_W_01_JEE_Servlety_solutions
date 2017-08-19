<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		int a = Integer.parseInt(request.getParameter("a"));
		int b = Integer.parseInt(request.getParameter("b"));
	%>

	a=
	<%=a%><br> b=
	<%=b%>
	<br>
	<ul>
		<%
			while (a < b) {
		%>

		<li><%=a%></li>

		<%
			a++;
			}
		%>
	</ul>

</body>
</html>

<!-- W projekcie stwórz stronę jsp3.jsp. Następnie:

    W skryptlecie pobierz z GET wartości a i b a następnie wyświetl od a do b, umieszczając je w tagach html w następujący sposób:

    <ul>
      <li>1</li>
      <li>2</li>
      <li>3</li>
      ....
    </ul>

    Zakładamy że a i b są wartościami całkowitymi liczbowymi i a < b.
 -->