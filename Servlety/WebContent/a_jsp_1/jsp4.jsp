<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="">
<label> Podaj ilość km: 
<input type="text" name="km"/>
</label>
<input type="submit">
</form>

	<%
		if (request.getParameter("km") != null) {

			int a = Integer.parseInt(request.getParameter("km"));
			double b = a * 0.62137;
			%>	
			Już wiem
			<%=a %> km to 
			<%=b %>mil	
			
		<%}%>	
	


</body>
</html>