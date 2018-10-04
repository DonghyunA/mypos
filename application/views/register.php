<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Registration-CI Login Registration</title>

<link rel="stylesheet" href="<?php echo base_url("public/css/bootstrap.min.css");?>" media="screen" title="no title">


  </head>
  <body>

<span style="background-color:red;">
  <div class="container"><!-- container class is used to centered  the body of the browser with some decent width-->
      <div class="row"><!-- row class is used for grid system in Bootstrap-->
          <div class="col-md-4 col-md-offset-4"><!--col-md-4 is used to create the no of colums in the grid also use for medimum and large devices-->
              <div class="login-panel panel panel-success">
                  <div class="panel-heading">
                      <h3 class="panel-title">회원가입</h3>
                  </div>
                  <div class="panel-body">

                  <?php
                  $error_msg=$this->session->flashdata('error_msg');
                  if($error_msg){
                    echo $error_msg;
                  }
                   ?>

                      <form role="form" method="post" action="<?php echo base_url('user/register_user'); ?>">
                          <fieldset>
                              <div class="form-group">
                                  <input class="form-control" placeholder="이름" name="user_name" type="text" autofocus>
                              </div>

                              <div class="form-group">
                                  <input class="form-control" placeholder="이메일(E-mail)" name="user_email" type="email" autofocus>
                              </div>
                              <div class="form-group">
                                  <input class="form-control" placeholder="패스워드(Password)" name="user_password" type="password" value="">
                              </div>

                              <div class="form-group">
                                  <input class="form-control" placeholder="나이(Age)" name="user_age" type="number" value="">
                              </div>

                              <div class="form-group">
                                  <input class="form-control" placeholder="핸드폰번호(Mobile No)" name="user_mobile" type="number" value="">
                              </div>

                              <input class="btn btn-lg btn-success btn-block" type="submit" value="등록" name="register" >

                          </fieldset>
                      </form>
                      <center><b>이미 회원가입 하셨습니까?</b> <br></b><a href="<?php echo base_url('user/login_view'); ?>">로그인은 여기!</a></center><!--for centered text-->
                  </div>
              </div>
          </div>
      </div>
  </div>





</span>




  </body>
</html>
