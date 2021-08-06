<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <!DOCTYPE html>
    <html>
    <head>
    <title>Student Registration</title>

    </head>
    <body>
  The Student is Confirmed:${student.getFirstName()} ${student.getLastName()}
  <br><br>
  Country:${student.country}
    <br><br>

  favourateLanguage:${student.favourateLanguage}
  <br><br>
  OperatingSystems:
  <ul>
  <c:forEach var="temp" items="${student.operatingSystems}">
  <li>${temp}</li>
  </c:forEach>
  </ul>
    </body>
    </html>