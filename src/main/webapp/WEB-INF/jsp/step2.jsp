<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
  <head>
    <title>Step 2</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
  </head>
  <body>
    <h1>Training Feedback Webapp</h1>

    <h2>Step 2</h2>

    <p>Please help us to improve our class by completing this form.</p>

    <form:form commandName="visitorFeedback" cssStyle="display: inline">
      <dl>
        <dt><span style="color: red;">*</span> Favorite Section:</dt>
        <dd>
          <form:select path="favoriteSection.id">
            <form:option value="" label="--- Select ---"/>
            <form:options items="${courseSections}" />
          </form:select>
          <form:errors path="favoriteSection.id" />
        </dd>

        <dt><span style="color: red;">*</span> Please rate the training:</dt>
        <dd>
          <form:radiobutton path="rating" value="1"/>1
          <form:radiobutton path="rating" value="2"/>2
          <form:radiobutton path="rating" value="3"/>3
          <form:radiobutton path="rating" value="4"/>4
          <form:radiobutton path="rating" value="5"/>5
          <form:errors path="rating" />
        </dd>

        <dt>Please share with us your comments on how we can improve this class for future:</dt>
        <dd>
          <form:textarea path="comment" rows="6" cols="40" />
        </dd>
      </dl>

      <input type="submit" name="action" value="&lt; Back" />
      <input type="submit" name="action" value="Continue &gt;" />
    </form:form>
  </body>
</html>
