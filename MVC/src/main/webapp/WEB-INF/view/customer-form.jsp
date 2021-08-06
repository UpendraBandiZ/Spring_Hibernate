<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <!DOCTYPE html>
    <html>
    <head>
    <title> Customer Reegistration Form</title>
   <style>
   .error{color:red}
   </style>
    </head>
    <body>
    <i> Fill out the form * means required<i>
    <br><br>

    <form:form action="processForm" modelAttribute="customer"> <br><br>
      <b>FirstName:<b> <form:input path="firstName" />
      <br><br>
      LastName(*) <form:input path="lastName" />
      <form:errors path="lastName"  cssClass="error" />
      <br><br>
      FreePasses(*):<form:input path="freePasses" />
      <form:errors path="freePasses" cssClass="error" />
      <br><br>
      PostalCode:<form:input path="postalCode"/>
            <form:errors path="postalCode" cssClass="error" />
            <br><br>
   courseCode<form:input path="courseCode"/>
               <form:errors path="courseCode" cssClass="error" />
               <br><br>
      <input type="submit" value="Submit"/>
      </form:form>
    </body>
    </html>