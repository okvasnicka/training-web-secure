<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
  <head>
    <title>Login</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
  </head>

  <body>
    <h1>Training Feedback Webapp</h1>
    <h2>Login</h2>

    <c:if test="${!empty param.login_error}">
      <div style="color: red; margin-bottom:1em; font-size:large;"> Incorrect username and/or password </div>
    </c:if>

    <div style="float: left">
    <form action="<c:url value='/j_spring_security_check'/>" method="post">
      <div class="table">
        <div class="row">
          <div class="cell"><label for="j_username">Username:</label></div>
          <div class="cell"><input type="text" id="j_username" name="j_username"/></div>
        </div>
        <div class="row">
          <div class="cell"><label for="j_password">Password:</label></div>
          <div class="cell"><input type="password" id="j_password" name="j_password"/></div>
        </div>
        <div class="row">
          <div class="cell"><input id="submit" name="submit" type="submit" value="Login"/></div>
        </div>
      </div>
    </form>
    </div>

    <div style="float: left;margin-left: 50px">
      Available logins:<br />
      <ul>
        <li><a href="javascript:loginAs('guest', 'guest')">guest</a>/guest</li>
        <li><a href="javascript:loginAs('viewer', 'viewer')">viewer</a>/viewer</li>
        <li><a href="javascript:loginAs('student', 'student')">student</a>/student</li>
        <li><a href="javascript:loginAs('superstudent', 'superstudent')">superstudent</a>/superstudent</li>
        <li><a href="javascript:loginAs('admin', 'admin')">admin</a>/admin</li>
      </ul>
    </div>

    <script type="text/javascript">
      function loginAs(userName, password) {
        var userNameField = document.getElementById("j_username");
        var passwordField = document.getElementById("j_password");
        userNameField.value = userName;
        passwordField.value = password;
        document.getElementById('submit').click()
      }
    </script>

  </body>

</html>
