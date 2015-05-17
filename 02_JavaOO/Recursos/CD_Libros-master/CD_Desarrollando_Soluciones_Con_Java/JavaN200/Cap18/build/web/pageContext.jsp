<%-- 
    Document   : demo02
    Created on : 21/01/2009, 07:13:02 AM
    Author     : gustavo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>JSP Page</title>
    </head>
    <body>
	authType: ${pageContext.request.authType} <br/>
	remoteUser: ${pageContext.request.remoteUser} <br/>
	contextPath: ${pageContext.request.contextPath} <br/>
	cookies: ${pageContext.request.cookies} <br/>
	method: ${pageContext.request.method} <br/>
	queryString: ${pageContext.request.queryString} <br/>
	requestURL: ${pageContext.request.requestURL} <br/>
	session.new: ${pageContext.session.new} <br/>
	serverInfo: ${pageContext.servletContext.serverInfo} <br/>
	message: ${pageContext.exception.message}
    </body>
</html>
