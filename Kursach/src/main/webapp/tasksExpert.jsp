<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

 <html>
    <head><title>Цели</title></head>
    <body>
         <tag:topMenu/>
         <div class="container">
                <section class="ftco-section">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="table-wrap">
                                    <table class="table">
                                        <thead class="thead-primary">
                                              <tr>
                                                <th>ID</th>
                                                <th>Название</th>
                                                <th>Стоимость</th>
                                                <th>Оценка</th>
                                                <th>Оценить</th>

                                              </tr>
                                        </thead>
                                        <tbody>
                                             <c:forEach var="task" items="${sessionScope.tasks}">
                                                 <c:set var="count" value="${pageScope.count+1}"/>
                                                  <form id="reg-form" action="${pageContext.request.contextPath}/controller?command=updateMark&taskId=${task.id}" method="post">
                                                       <tr>
                                                        <th scope="row" class="scope" >${count}</th>
                                                        <td>${task.name}</td>
                                                        <td>${task.cost}</td>
                                                        <td><input name = "mark" type="number" min="0" max ="10" value= "${task.mark}"></td>
                                                        <td><input type="submit"class="btn btn-primary" value="Оценить"/></td>

                                                      </tr>
                                                  </form>
                                            </c:forEach>
                                        </tbody>
                                  </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
         </div>
   </body>
 </html>



