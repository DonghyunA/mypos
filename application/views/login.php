<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Login-CI Login Registration</title>
<link rel="stylesheet" href="<?php echo base_url("public/css/bootstrap.min.css");?>" media="screen" title="no title">
  </head>
  <body>

    <div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="login-panel panel panel-success">
                <div class="panel-heading">
                    <h3 class="panel-title">Login</h3>
                </div>
                <?php
              $success_msg= $this->session->flashdata('success_msg');
              $error_msg= $this->session->flashdata('error_msg');

                  if($success_msg){
                    ?>
                    <div class="alert alert-success">
                      <?php echo $success_msg; ?>
                    </div>
                  <?php
                  }
                  if($error_msg){
                    ?>
                    <div class="alert alert-danger">
                      <?php echo $error_msg; ?>
                    </div>
                    <?php
                  }
                  ?>

                <div class="panel-body">
                    <form role="form" method="post" action="<?php echo base_url('user/login_user'); ?>">
                        <fieldset>
                            <div class="form-group"  >
                                <input class="form-control" placeholder="이메일(E-mail)" name="user_email" type="email" autofocus>
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="패스워드(Password)" name="user_password" type="password" value="">
                            </div>


                                <input class="btn btn-lg btn-success btn-block" type="submit" value="login" name="login" >

                        </fieldset>
                    </form>
                <center><b>아직 등록하지 않았습니까?</b> <br></b><a href="<?php echo base_url('user/register_view'); ?>">회원가입은 여기!</a></center><!--for centered text-->

                </div>
            </div>
        </div>
    </div>
</div>


  </body>
</html>
