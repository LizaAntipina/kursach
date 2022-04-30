<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag pageEncoding="UTF-8" %>

 <html lang="en">
     <head>
         <link rel="stylesheet" type="text/css" href="static/profile.css">
         <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" />
         <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
         <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
     </head>

    <body>
     <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand">ООО ФастСофт</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarsupportedcontent">
              <ul class="navbar-nav mr-auto">
                 <c:if test="${(sessionScope.account.role == 'ADMIN')}">
                      <li class="nav-item dropdown">
                         <a class="nav-link dropdown-toggle" href="home.jsp" id="navbardropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Главная</a>
                         <div class="dropdown-menu" aria-labelledby="navbardropdown">
                         <a class="dropdown-item" data-toggle="modal" data-target="#modalcreatetask">Добавить предложение</a>
                        </div>
                      </li>
                </c:if>
                <c:if test="${(sessionScope.account.role == 'ADMIN')}">
                    <li class="nav-item">
                      <a class="nav-link" href="${pageContext.request.contextPath}/controller?command=readAllTask">Предложения от заказчиков</a>
                    </li>
                </c:if>
                <c:if test="${(sessionScope.account.role == 'EXPERT')}">
                    <li class="nav-item">
                      <a class="nav-link" href="${pageContext.request.contextPath}/controller?command=readTask">Предложения от заказчиков</a>
                    </li>
                </c:if>
                <c:if test="${(sessionScope.account.role == 'ADMIN')}">
                    <li class="nav-item">
                      <a class="nav-link" href="${pageContext.request.contextPath}/controller?command=readAccounts">Сотрудники</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="${pageContext.request.contextPath}/controller?command=readDataTable">Расчет</a>
                    </li>
                </c:if>

                <li class="nav-item">
                  <a class="nav-link" href="profile.jsp">Профиль</a>
                </li>

                <li class="nav-item">
                  <a class="nav-link" href="${pageContext.request.contextPath}/controller?command=getDiagramData">Диаграмма</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="${pageContext.request.contextPath}/controller?command=getGraphData">График</a>
                </li>
              </ul>

           <form class="form-inline my-2 my-lg-0">
             <a href="login.jsp" class="btn btn-primary">Выйти из аккаунта</a>
           </form>
        </div>
    </nav>

        <div class="modal fade" id="modalcreatetask" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
             <div class="modal-dialog modal-lg">
               <div class="modal-content">
                 <div class="modal-header">
                   <h5 class="modal-title" id="exampleModalLabel">Добавить предложение</h5>
                   <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                     <span aria-hidden="true">×</span>
                   </button>
                 </div>
                 <form id="reg-form" action="${pageContext.request.contextPath}/controller?command=addTask" method="post">
                     <div class="modal-body">
                                  <div class="row gutters">
                                     <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                         <div class="form-group">
                                             <label for="TaskName">Название</label>
                                             <input name="name" type="text" class="form-control" value= "${task.name}">
                                             <label for="TaskName">Стоимость(в $)</label>
                                             <input name="cost" type="number" class="form-control" value= "${task.cost}">
                                         </div>
                                     </div>
                                  </div>
                     </div>
                     <div class="modal-footer">
                       <button type="button" class="btn btn-secondary" data-dismiss="modal">Закрыть</button>
                       <button type="button" class="btn btn-primary"><input type="submit"class="btn btn-primary" value="Сохранить изменения"/></button>
                     </div>
                 </form>
               </div>
             </div>
        </div>



       <script>
       $('.dropdown-toggle').click(function(e) {
         if ($(document).width() > 768) {
            e.preventDefault();
            var url = $(this).attr('href');
            if (url !== '#') {
            window.location.href = url;
            }
         }
       });
       $(".checkbox-menu").on("change", "input[type='checkbox']", function() {
          $(this).closest("li").toggleClass("active", this.checked);
       });

       $(document).on('click', '.allow-focus', function (e) {
         e.stopPropagation();
       });
       </script>
      <c:if test="${(sessionScope.account == null)}">
        <%
        RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
        rd.forward(request, response);
        %>
      </c:if>
    </body>
 </html>