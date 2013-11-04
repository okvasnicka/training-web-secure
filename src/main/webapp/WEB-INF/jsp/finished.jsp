<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
  <head>
    <title>Finished</title>
  </head>
  <body>
    <h1>Thank you!</h1>

    <p>Your feedback has been successfully sent.</p>

    <a href="<spring:url value="/index.do" />">Back to main page</a>

  </body>
</html>
