<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

 <html>
    <head><title>Цели</title></head>
    <body>
         <tag:topMenu/>
         <div class="container">
          <div style="width:201px;position: absolute; right:0px" id="f7f287ba86d8573bd4851ff66466e0c0" class="ww-informers-box-854753"><p class="ww-informers-box-854754"><a href="https://world-weather.ru/pogoda/belarus/minsk/">Минск - погода</a><br></p></div><script async type="text/javascript" charset="utf-8" src="https://world-weather.ru/wwinformer.php?userid=f7f287ba86d8573bd4851ff66466e0c0"></script><style>.ww-informers-box-854754{-webkit-animation-name:ww-informers54;animation-name:ww-informers54;-webkit-animation-duration:1.5s;animation-duration:1.5s;white-space:nowrap;overflow:hidden;-o-text-overflow:ellipsis;text-overflow:ellipsis;font-size:12px;font-family:Arial;line-height:18px;text-align:center}@-webkit-keyframes ww-informers54{0%,80%{opacity:0}100%{opacity:1}}@keyframes ww-informers54{0%,80%{opacity:0}100%{opacity:1}}</style>
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
                                                <th>Удалить</th>
                                              </tr>
                                        </thead>

                                        <tbody>
                                            <c:forEach var="task" items="${sessionScope.tasks}">
                                              <c:set var="count" value="${pageScope.count+1}"/>
                                              <tr>
                                                <th scope="row" class="scope" >${count}</th>
                                                <td>${task.name}</td>
                                                <td>${task.cost}</td>
                                                <td><a href="${pageContext.request.contextPath}/controller?command=deleteTask&id=${task.id}" class="btn btn-primary">Удалить</a></td>
                                              </tr>
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



