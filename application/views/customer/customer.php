<?php $this->load->view("common/header"); ?>
<?php $this->load->view("customer/new_customer_modal"); ?>

      <div id="content-wrapper">

        <div class="container-fluid">

          <!-- Breadcrumbs-->
          <ol class="breadcrumb">
            <li class="breadcrumb-item">
              <a href="#">거래처 관리</a>
            </li>
            <li class="breadcrumb-item active">등록, 수정 및 삭제</li>
          </ol>

          <!-- Icon Cards-->
          <div class="row">
            <div class="col-xl-3 col-sm-6 mb-3">
              <div class="card text-white bg-primary o-hidden h-100">
                <div class="card-body">
                  <div class="card-body-icon">
                    <i class="fas fa-fw fa-comments"></i>
                  </div>
                  <div class="mr-5">신규등록</div>
                </div>
                <a class="card-footer text-white clearfix small z-1" href="#" data-toggle="modal" data-target="#new_customer_modal">
                  <span class="float-left">View Details</span>
                  <span class="float-right">
                    <i class="fas fa-angle-right"></i>
                  </span>
                </a>
              </div>
            </div>
            <div class="col-xl-3 col-sm-6 mb-3">
              <div class="card text-white bg-warning o-hidden h-100">
                <div class="card-body">
                  <div class="card-body-icon">
                    <i class="fas fa-fw fa-list"></i>
                  </div>
                  <div class="mr-5">거래처 목록 및 수정</div>
                </div>
                <a class="card-footer text-white clearfix small z-1" href="#">
                  <span class="float-left">View Details</span>
                  <span class="float-right">
                    <i class="fas fa-angle-right"></i>
                  </span>
                </a>
              </div>
            </div>
          </div>

          <!-- DataTables Example -->
          <div class="card mb-3">
            <div class="card-header">
              <i class="fas fa-pencil-alt"></i>
              신규 등록</div>
            <div class="card-body">
              <div class="table-responsive">
                <table id="table"
                  data-toolbar="#toolbar"
                  data-search="true"
                  data-show-refresh="true"
                  data-show-toggle="true"
                  data-show-columns="true"
                  data-show-export="true"
                  data-detail-view="true"
                  data-detail-formatter="detailFormatter"
                  data-minimum-count-columns="2"
                  data-show-pagination-switch="true"
                  data-pagination="true"
                  data-id-field="id"
                  data-page-list="[10, 25, 50, 100, ALL]"
                  data-show-footer="false"
                  data-side-pagination="server"
                  data="[1]"
                  data-response-handler="responseHandler">
               </table>
              </div>
            </div>
            <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
          </div>

        </div>
        <!-- /.container-fluid -->

<?php $this->load->view("common/footer"); ?>
 