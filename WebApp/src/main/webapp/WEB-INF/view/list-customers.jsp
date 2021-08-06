<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>
  list
  </title>

  <link type="text/css"
  rel="stylesheet"
  href="${pageContext.request.contextPath}/resources/CSS/style.css"/>
  </head>
  <body>
  <div id="wrapper">
      <div id="header">
      <h2> CRM-Customer Relationship Manager</h2>
      </div>
       </div>
       <div id="container">
             <div id="content">



       <input type="button" value="Add Customer"
       onclick="window.location.href='showFormForAdd';return false;"
        class="add-button"
       />
             <table>
             <tr>
             <th> FirstName </th>
             <th>  Last Name  </th>
             <th>  Email  </th>
             <th>Action</th>
             </tr>
             <c:forEach var="tempCustomer" items="${customers}">
             <c:url var="updateLink" value="/customer/showFormForUpdate">
             <c:param name="customerId" value="${tempCustomer.id}"/>
             </c:url>
               <c:url var="deleteLink" value="/customer/delete">
               <c:param name="customerId" value="${tempCustomer.id}"/>
               </c:url>
             <tr>
             <td>${tempCustomer.firstName} </td>
             <td> ${tempCustomer.lastName}</td>
             <td> ${tempCustomer.email}</td>
              <td>
              <a href="${updateLink}">Update</a>|
              <a href="${deleteLink}"
              onclick="if(!(confirm('are you sure you want to delete?')))return false">Delete</a>
              </td>
             </tr>
          </c:forEach>
             </table>



             </div>
              </div>



  </body>
  </html>