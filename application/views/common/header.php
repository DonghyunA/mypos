<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>My Pos</title>

    <!-- Bootstrap core CSS-->
    <link href="<?php echo base_url("public/vendor/bootstrap/css/bootstrap.min.css"); ?>" rel="stylesheet">
    

    <!-- Custom fonts for this template-->
    <link href="<?php echo base_url("public/vendor/fontawesome-free/css/all.min.css"); ?>" rel="stylesheet" type="text/css">
    <link href="<?php echo base_url("public/vendor/fontawesome-free/css/v4-shims.css"); ?>" rel="stylesheet" type="text/css">

    <!-- Page level plugin CSS-->
    <link href="<?php echo base_url("public/vendor/datatables/dataTables.bootstrap4.css"); ?>" rel="stylesheet">
    <link href="<?php echo base_url("public/vendor/datatables/bootstrap-table.css"); ?>" rel="stylesheet">
    <link rel="stylesheet" href="//rawgit.com/vitalets/x-editable/master/dist/bootstrap3-editable/css/bootstrap-editable.css">
    <!-- Custom styles for this template-->
    <link href="<?php echo base_url("public/css/sb-admin.css"); ?>" rel="stylesheet">

    <!-- Bootstrap core JavaScript-->
    <script src="<?php echo base_url("public/vendor/jquery/jquery.min.js");?>"></script>
    <script src="<?php echo base_url("public/vendor/bootstrap/js/bootstrap.bundle.min.js");?>"></script>
    <script src="<?php echo base_url("public/vendor/bootstrap/js/bootstrap.js");?>"></script>

    <!-- Core plugin JavaScript-->
    <script src="<?php echo base_url("public/vendor/jquery-easing/jquery.easing.min.js");?>"></script>

    <!-- Page level plugin JavaScript-->
    <script src="<?php echo base_url("public/vendor/chart.js/Chart.min.js");?>"></script>
    <script src="<?php echo base_url("public/vendor/datatables/jquery.dataTables.js")?>"></script>
    <script src="<?php echo base_url("public/vendor/datatables/dataTables.bootstrap4.js");?>"></script>
    <script src="<?php echo base_url("public/vendor/datatables/bootstrap-table.js");?>"></script>
    <script src="<?php echo base_url("public/vendor/datatables/bootstrap-table-ko-KR.js");?>"></script>
    <script src="<?php echo base_url("public/vendor/datatables/bootstrap-table-editable.js");?>"></script>

    <!-- Custom scripts for all pages-->
    <script src="<?php echo base_url("public/js/sb-admin.min.js");?>"></script>

    <!-- Demo scripts for this page-->
    <script src="<?php echo base_url("public/js/demo/datatables-demo.js");?>"></script>
    <!-- <script src="<?php echo base_url("public/js/demo/chart-area-demo.js");?>"></script> -->
    
  </head>

  <body id="page-top">

    <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

      <a class="navbar-brand mr-1" href="<?php echo site_url("home") ?>">My Pos</a>

      <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
        <i class="fas fa-bars"></i>
      </button>

      <!-- Navbar Search -->
      <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
        <div class="input-group">
          <input type="text" class="form-control" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
          <div class="input-group-append">
            <button class="btn btn-primary" type="button">
              <i class="fas fa-search"></i>
            </button>
          </div>
        </div>
      </form>

      <!-- Navbar -->
      <ul class="navbar-nav ml-auto ml-md-0">
        <li class="nav-item dropdown no-arrow mx-1">
          <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-bell fa-fw"></i>
            <span class="badge badge-danger">9+</span>
          </a>
          <div class="dropdown-menu dropdown-menu-right" aria-labelledby="alertsDropdown">
            <a class="dropdown-item" href="#">Action</a>
            <a class="dropdown-item" href="#">Another action</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">Something else here</a>
          </div>
        </li>
        <li class="nav-item dropdown no-arrow mx-1">
          <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-envelope fa-fw"></i>
            <span class="badge badge-danger">7</span>
          </a>
          <div class="dropdown-menu dropdown-menu-right" aria-labelledby="messagesDropdown">
            <a class="dropdown-item" href="#">Action</a>
            <a class="dropdown-item" href="#">Another action</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">Something else here</a>
          </div>
        </li>
        <li class="nav-item dropdown no-arrow">
          <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-user-circle fa-fw"></i>
          </a>
          <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
            <a class="dropdown-item" href="#">Settings</a>
            <a class="dropdown-item" href="#">Activity Log</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">Logout</a>
          </div>
        </li>
      </ul>

    </nav>
    <div id="wrapper">

<!-- Sidebar -->
<ul class="sidebar navbar-nav">
  <li class="nav-item active"> <!-- active는 함수를 이용할 예정 -->
    <a class="nav-link" href="<?php echo site_url('customer'); ?>">
      <i class="fas fa-fw fa-address-book"></i>
      <span>거래처관리</span>
    </a>
  </li>
  <li class="nav-item active"> <!-- active 유무는 함수를 이용할 예정 -->
    <a class="nav-link" href="<?php echo site_url('item'); ?>">
      <i class="fas fa-fw fa-boxes"></i>
      <span>물건관리</span>
    </a>
  </li>
  <li class="nav-item active"> <!-- active는 함수를 이용할 예정 -->
    <a class="nav-link" href="<?php echo site_url('home'); ?>">
      <i class="fas fa-fw fa-tachometer-alt"></i>
      <span>Dashboard</span>
    </a>
  </li>
  <li class="nav-item dropdown">
    <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
      <i class="fas fa-fw fa-folder"></i>
      <span>Pages</span>
    </a>
    <div class="dropdown-menu" aria-labelledby="pagesDropdown">
      <h6 class="dropdown-header">Login Screens:</h6>
      <a class="dropdown-item" href="<?php echo site_url('home/temp'); ?>">Login</a>
      <a class="dropdown-item" href="register.html">Register</a>
      <a class="dropdown-item" href="forgot-password.html">Forgot Password</a>
      <div class="dropdown-divider"></div>
      <h6 class="dropdown-header">Other Pages:</h6>
      <a class="dropdown-item" href="404.html">404 Page</a>
      <a class="dropdown-item" href="blank.html">Blank Page</a>
    </div>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="/chart/charts">
      <i class="fas fa-fw fa-chart-area"></i>
      <span>통계</span></a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="/table/tables">
      <i class="fas fa-fw fa-table"></i>
      <span>Tables</span></a>
  </li>
</ul>
