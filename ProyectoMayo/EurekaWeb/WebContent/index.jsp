<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <h1>EUREKA BANK</h1>
  <h3>INGRESO AL SISTEMA</h3>
  <div style="color: maroon; background-color: graytext;">
    ${error}
  </div>
  <form method="post" action="LogonIngreso">
    Usuario:
    <input type="text" name="usuario" /><br/>
    Clave:
    <input type="password" name="clave" /><br/>
    <input type="submit" value="Ingresar" />
  </form>
</body>
</html>