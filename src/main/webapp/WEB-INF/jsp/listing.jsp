<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
  <head>
    <title>Submitted feedbacks</title>
    <link href="style.css" rel="stylesheet" type="text/css" />
  </head>
  <body>
    <h1>Submitted feedbacks</h1>

    <table>
      <tr>
        <th>Record ID</th>
        <th>User ID</th>
        <th>User Name</th>
        <th>Course</th>
        <th>Date</th>
        <th>Favorite Section</th>
        <th>Rating</th>
        <th>Comments</th>
        <th>Action</th>
      </tr>

      <c:forEach var="feedback" items="${feedbackList}">
      <tr>
        <td>${feedback.id}</td>
        <td>${feedback.visitor.id}</td>
        <td>${feedback.visitor.name}</td>
        <td>${feedback.course.name}</td>
        <td>${feedback.date}</td>
        <td>${feedback.favoriteSection.name}</td>
        <td>${feedback.rating}</td>
        <td>${feedback.comment}</td>

        <spring:url value="/delete.do" var="deleteUrl">
          <spring:param name="recordId" value="${feedback.id}" />
        </spring:url>

        <td>
          <c:if test="${feedback.deletable}">
          <a href="${deleteUrl}">Delete</a>
          </c:if>
        </td>
      </tr>
      </c:forEach>
    </table>

    <br />
    <a href="<spring:url value="/index.do" />">Back to main page</a>

  </body>
</html>
