<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

 <html>
    <head><title>Метод</title></head>
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
                                                <th>Эксперты</th>
                                                <c:forEach var="task" items="${sessionScope.tasks}">
                                                    <th>${task.name}</th>
                                                </c:forEach>
                                              </tr>
                                        </thead>

                                        <tbody>
                                           <c:forEach items="${marks}" var="entry">
                                              <tr>
                                                   <th scope="row" class="scope" >${entry.key.expert.login}</th>
                                                   <c:forEach items="${entry.value}" var="mark">
                                                      <td>${mark}</td>
                                                    </c:forEach>
                                              </tr>
                                           </c:forEach>
                                        </tbody>
                                  </table>
                                  <a href="${pageContext.request.contextPath}/controller?command=getBestValue" class="btn btn-primary">Посчитать</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
         </div>
   </body>
 </html>



