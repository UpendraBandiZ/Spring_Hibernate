<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
    <html>
    <head>
    <title>Customer Confirmation Page </title>

    </head>
    <body>
  customer confirmedd
  FirstName:<b>${customer.firstName} </b><br><br>
  LastName:<b>${customer.lastName}</b>
  <br><br>
  Number of Passes  <b>${customer.freePasses}</b>
 <br><br>
  Postal Code<b>${customer.postalCode}</b>
  <br><br>
  courseCode:<b>${customer.courseCode}</b>
    </body>
    </html>
