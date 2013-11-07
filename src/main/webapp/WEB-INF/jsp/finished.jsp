<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
  <head>
    <title>Finished</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
  </head>
  <body>
    <h1>Training Feedback Webapp</h1>

    <h2>Thank you!</h2>

    <p>Your feedback has been successfully sent.</p>

    <a href="<spring:url value="/index.do" />">Back to main page</a>

  </body>
</html>
