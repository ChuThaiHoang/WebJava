<%-- 
  
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Edit Account</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
        <style>
            img{
                width: 200px;
                height: 120px;
            }
        </style>
    <body>
        <div class="container">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>Setting <b>Account</b></h2>
                        </div>
                        <div class="col-sm-6">
                        </div>
                    </div>
                </div>
            </div>
            <div id="editEmployeeModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="SettingAccount" method="post">
                            <div class="modal-header">						
                                <h4 class="modal-title">Setting Account</h4>
                                <a href="Home.jsp"><button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;
                                    </button></a>
                            </div>
                            <div class="modal-body">
                                <p class="text-danger">${messAcc}</p>
                                <div class="form-group">
                                    <label>ID</label>
                                    <input value="${requestScope.settingAcc.id}" name="id" type="text" class="form-control" readonly required>
                                </div>
                                <div class="form-group">
                                    <label>User</label>
                                    <input value="${requestScope.settingAcc.user}" name="user" type="text" class="form-control"readonly required>
                                </div>                               
                                <div class="form-group">
                                    <label>Pass</label>
                                    <input value="${requestScope.settingAcc.pass}" type="password"  name="pass"  class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Name</label>
                                    <input value="${requestScope.settingAcc.name}" name="name" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Phone Number</label>
                                    <input value="${requestScope.settingAcc.phone}" name="phone" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Address</label>
                                    <input value="${requestScope.settingAcc.address}" name="address" type="text" class="form-control" required>
                                </div>
                               
                              

                            </div>
                            <div class="modal-footer">
                                <a class="btn btn-success btn-sm ml-3" href="SignUpSeller">
                                        <i class="fa"></i> Đăng ký tài khoản với tư cánh là người bán
                                        <span class="badge badge-light"></span>
                                    </a>
                                <input type="submit" class="btn btn-success" value="Save">
                            </div>
                        </form>
                    </div>
                </div>
            </div>

        </div>


        <script src="js/manager.js" type="text/javascript"></script>
    </body>
</html>