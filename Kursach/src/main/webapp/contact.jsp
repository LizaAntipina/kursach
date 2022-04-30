<%--
  Created by IntelliJ IDEA.
  User: M.R.C CELL
  Date: 3/29/2021
  Time: 8:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Contact Us</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/contact.css">
</head>
<body>
<div class="container">
    <form class="contact-form">
        <div class="contact-form-component">
            <label>Name</label>
            <input type="text" placeholder="Enter Your Name" required>
        </div>

        <div class="contact-form-component">
            <label>Email</label>
            <input type="email" placeholder="Enter Your Email" required>
        </div>

        <div class="contact-form-component">
            <label class = "message-label">Message</label>
            <textarea id="message" placeholder="Write your message.." style="height: 20vw"></textarea>
        </div>

        <div class="contact-form-component">
            <input type="submit" value="Submit">
        </div>


    </form>

</div>

</body>
</html>
