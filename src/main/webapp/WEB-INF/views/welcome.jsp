<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring Landing Page</title>
</head>
<body>
<h2>
Spring Landing Pag</h2>
Click below button to get a simple HTML page
<form:form action="/PersonWelfare/staticPage/" method="GET"><table><tbody>
<tr>     <td><input type="submit" value="Get HTML Page" />      </td>     </tr>
</tbody></table>
</form:form></body>
</html>