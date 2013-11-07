<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
  <head>
    <title>Step 3</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
  </head>
  <body>
    <h1>Training Feedback Webapp</h1>

    <h2>Step 3</h2>

    <h3>Summary</h3>
    <dl>
      <dt>Your Name:</dt>
      <dd>${visitorFeedback.visitor.name}</dd>

      <dt>Training Course:</dt>
      <dd>${visitorFeedback.course.name}</dd>

      <dt>Training Course Date:</dt>
      <dd><fmt:formatDate value="${visitorFeedback.date}" type="both" pattern="yyyy-MM-dd" /></dd>

      <dt>Favorite Section:</dt>
      <dd>${visitorFeedback.favoriteSection.name}</dd>

      <dt>Rating:</dt>
      <dd>${visitorFeedback.rating}</dd>

      <dt>Comments:</dt>
      <dd>${visitorFeedback.comment}</dd>
    </dl>

    <form:form cssStyle="display: inline">
      <input type="submit" name="action" value="&lt; Back" />
      <input type="submit" name="action" value="Send Feedback" style="font-weight: bold" />
    </form:form>

  </body>
</html>
