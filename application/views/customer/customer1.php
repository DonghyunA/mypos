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
              <table data-toggle="table"
       data=<?php echo json_encode($customers_data); ?>,
       data-click-to-select="true">
    <thead>
    <tr>
        <th data-field="state" data-checkbox="true" data-formatter="stateFormatter"></th>
        <th data-field="c_business_name">Name</th>
        <th data-field="c_representative">Stars</th>
        <th data-field="c_address">Forks</th>
        <th data-field="c_phone">Descripution</th>
    </tr>
    </thead>
</table>
              </div>
            </div>
            <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
          </div>

        </div>
        <!-- /.container-fluid -->

<?php $this->load->view("common/footer"); ?>
