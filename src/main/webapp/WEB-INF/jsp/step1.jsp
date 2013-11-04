<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
  <head>
    <title>Step 1</title>
  </head>
  <body>
    <h1>Training Course Feedback Form</h1>

    <h2>Step 1</h2>

    <p>Please help us to improve our class by completing this form.</p>

    <form:form commandName="visitorFeedback" cssStyle="display: inline">
      <dl>
        <dt><span style="color: red;">*</span> Your Name:</dt>
        <dd>
          <form:input path="visitor.name" disabled="true" />
          <form:errors path="visitor.name" />
        </dd>

        <dt><span style="color: red;">*</span> Training Course:</dt>
        <dd>
          <form:select path="course.id">
            <form:option value="" label="--- Select ---"/>
            <form:options items="${availableCourses}" />
          </form:select>
          <form:errors path="course.id" />
        </dd>

        <dt><span style="color: red;">*</span> Training Course Date:</dt>
        <dd>
          <form:input path="date" /> (MM/dd/yyyy)
          <form:errors path="date" />
        </dd>
      </dl>

      <input type="submit" name="action" value="&lt; Cancel" />
      <input type="submit" name="action" value="Continue &gt;" />
    </form:form>

  </body>
</html>
