<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <title>Index</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
  </head>
  <body>
    <h1>Training Feedback Webapp</h1>

    <h2>Main page</h2>

    <!-- 10. secure the link based on associated URL -->
    <sec:authorize url="/step1.do">
      <p>Please send your <a href="<spring:url value="/step1.do" />">feedback for any our training course</a>.</p>
    </sec:authorize>

    <!-- 8. secure the link based on associated URL -->
    <sec:authorize url="/listing.do">
      <p>View <a href="<spring:url value="/listing.do" />">listing of submitted feedbacks</a></p>
    </sec:authorize>

    <!-- 7. Show Logout link only if logged in -->
    <sec:authorize access="isAuthenticated()">
      <p>
        <a href="<spring:url value="/logout.do"/>">Logout</a>
        (<sec:authentication property="principal.username" />)
      </p>
    </sec:authorize>

  </body>
</html>
