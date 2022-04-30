<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

 <html>
    <head><title>Результат</title></head>
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
                                            <th>Предложения от заказчиков</th>
                                            <th>Веса целей</th>
                                          </tr>
                                    </thead>

                                    <tbody>
                                            <c:forEach var="dt" items="${sessionScope.dataTasks}">
                                            <tr>
                                                <th scope="row" class="scope" >${dt.name}</th>
                                                <td>${dt.value}</td>
                                            </tr>
                                            </c:forEach>

                                    </tbody>
                              </table>
                              <p>Наиболее подходящее предложение для реализации:</p> ${bestP.name} ${bestP.value}
                            </div>
                            <a href="${pageContext.request.contextPath}/controller?command=makeReport" class="btn btn-primary">Сделать отчет</a>
                        </div>
                    </div>
                </div>
            </section>
        </div>
    </body>
 </html>