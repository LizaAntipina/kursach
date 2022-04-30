 <%@ page contentType="text/html;charset=UTF-8" language="java" %>
 <%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

 <html>
      <head><title>Профиль</title></head>
      <body>
            <tag:topMenu/>
            <div class="container">
             <div style="width:201px;position: absolute; right:0px" id="f7f287ba86d8573bd4851ff66466e0c0" class="ww-informers-box-854753"><p class="ww-informers-box-854754"><a href="https://world-weather.ru/pogoda/belarus/minsk/">Минск - погода</a><br></p></div><script async type="text/javascript" charset="utf-8" src="https://world-weather.ru/wwinformer.php?userid=f7f287ba86d8573bd4851ff66466e0c0"></script><style>.ww-informers-box-854754{-webkit-animation-name:ww-informers54;animation-name:ww-informers54;-webkit-animation-duration:1.5s;animation-duration:1.5s;white-space:nowrap;overflow:hidden;-o-text-overflow:ellipsis;text-overflow:ellipsis;font-size:12px;font-family:Arial;line-height:18px;text-align:center}@-webkit-keyframes ww-informers54{0%,80%{opacity:0}100%{opacity:1}}@keyframes ww-informers54{0%,80%{opacity:0}100%{opacity:1}}</style>
                <div class="row gutters">
                    <div class="col-xl-3 col-lg-3 col-md-12 col-sm-12 col-12">
                        <div class="card h-100">
                            <div class="card-body">
                                <div class="account-settings">
                                    <div class="user-profile">
                                        <div class="user-avatar">
                                            <img src="https://cdn-icons.flaticon.com/png/512/1144/premium/1144760.png?token=exp=1651333217~hmac=1330b94a1cdffb98efc7f8488ea60473" alt="User">
                                        </div>
                                        <h5 class="user-name">${sessionScope.account.login}</h5>
                                        <h6 class="user-id">${sessionScope.account.id}</h6>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <form id="reg-form" action="${pageContext.request.contextPath}/controller?command=updateProfile" method="post">
                        <div class="col-xl-9 col-lg-9 col-md-12 col-sm-12 col-12">
                            <div class="card h-100">
                                <div class="card-body">
                                    <div class="row gutters">
                                        <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                            <h6 class="mb-2 text-primary">Информация о пользователе</h6>
                                        </div>

                                        <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                            <div class="form-group">
                                                <label for="UserName">Логин</label>
                                                <input name ="login" type="text" class="form-control" value="${sessionScope.account.login}" placeholder="UserName">
                                            </div>
                                        </div>

                                        <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                            <div class="form-group">
                                                <label for="FisrtName">Имя</label>
                                                <input type="text" name="name" class="form-control" value="${sessionScope.account.name}" placeholder="FirstName">
                                            </div>
                                        </div>

                                        <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                             <div class="form-group">
                                                <label for="SurName">Фамилия</label>
                                                <input type="text" name="lastName" class="form-control" value="${sessionScope.account.lastName}" placeholder="SurName">
                                             </div>
                                        </div>

                                        <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                            <div class="form-group">
                                                <label for="eMail">Email</label>
                                                <input type="text" name="email" class="form-control" value="${sessionScope.account.email}" placeholder="Enter email ID">
                                            </div>
                                        </div>

                                        <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                            <div class="form-group">
                                                <label for="phone">Телефон</label>
                                                <input type="text" name="telephone" class="form-control" value="${sessionScope.account.telephone}" placeholder="Enter phone number">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row gutters">
                                        <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                            <div class="text-right">
                                                <button type="submit" class="btn btn-primary">Редактировать</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
      </body>
</html>
