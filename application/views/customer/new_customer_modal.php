<!-- Modal -->
<div class="modal fade" id="new_customer_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title" id="myModalLabel">거래처 신규등록</h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
      </div>
      <div class="modal-body">
        <?php echo form_open(base_url("customer/save"), array('id'=>'customer_form', 'class'=>'form-horizontal')); ?>
        <div class="form-group form-group-sm">	
	<?php echo form_label('*상호명', 'c_business name', array('class'=>'required control-label col-xl-3')); ?>
	<div class='col-xl-8'>
		<?php echo form_input(array(
				'name'=>'c_business name',
				'id'=>'c_business name',
				'class'=>'form-control input-sm',
				'value'=>'',
				'required'=>'required')
				);?>
	</div>
</div>

<div class="form-group form-group-sm">	
	<?php echo form_label('대표자', 'c_representative', array('class'=>'required control-label col-xl-3')); ?>
	<div class='col-xl-8'>
		<?php echo form_input(array(
				'name'=>'c_representative',
				'id'=>'c_representative',
				'class'=>'form-control input-sm',
				'value'=>'')
				);?>
	</div>
</div>

<div class="form-group form-group-sm">	
	<?php echo form_label('전화번호', 'c_phone', array('class'=>'control-label col-xl-3')); ?>
	<div class='col-xl-8'>
		<div class="input-group">
			<span class="input-group-addon input-sm"><span class="glyphicon glyphicon-phone-alt"></span></span>
			<?php echo form_input(array(
					'name'=>'c_phone',
					'id'=>'c_phone',
					'class'=>'form-control input-sm',
					'value'=>'')
					);?>
		</div>
	</div>
</div>

<div class="form-group form-group-sm">	
	<?php echo form_label('주소', 'c_address', array('class'=>'control-label col-xl-3')); ?>
	<div class='col-xl-8'>
		<?php echo form_input(array(
				'name'=>'c_address',
				'id'=>'c_address',
				'class'=>'form-control input-sm',
				'value'=>'')
				);?>
	</div>
</div>

<div class="form-group form-group-sm">	
	<?php echo form_label('사업자번호', 'c_c_number', array('class'=>'control-label col-xl-3')); ?>
	<div class='col-xl-8'>
		<?php echo form_input(array(
				'name'=>'c_c_number',
				'id'=>'c_c_number',
				'class'=>'form-control input-sm',
				'value'=>'')
				);?>
	</div>
</div>

<div class="form-group form-group-sm">	
	<?php echo form_label('이메일', 'c_email', array('class'=>'control-label col-xl-3')); ?>
	<div class='col-xl-8'>
		<div class="input-group">
			<span class="input-group-addon input-sm"><span class="glyphicon glyphicon-envelope"></span></span>
			<?php echo form_input(array(
					'name'=>'c_email',
					'id'=>'c_email',
					'class'=>'form-control input-sm',
					'value'=>'')
					);?>
		</div>
	</div>
</div>



<div class="form-group form-group-sm">	
	<?php echo form_label('업태', 'c_c_category', array('class'=>'control-label col-xl-3')); ?>
	<div class='col-xl-8'>
		<?php echo form_input(array(
				'name'=>'c_c_category',
				'id'=>'c_c_category',
				'class'=>'form-control input-sm',
				'value'=>'')
				);?>
	</div>
</div>

<div class="form-group form-group-sm">	
	<?php echo form_label('종목', 'c_c_kind', array('class'=>'control-label col-xl-3')); ?>
	<div class='col-xl-8'>
		<?php echo form_input(array(
				'name'=>'c_c_kind',
				'id'=>'c_c_kind',
				'class'=>'form-control input-sm',
				'value'=>'')
				);?>
	</div>
</div>


<div class="form-group form-group-sm">	
	<?php echo form_label('기타 코멘트', 'c_comment', array('class'=>'control-label col-xl-3')); ?>
	<div class='col-xl-8'>
		<?php echo form_textarea(array(
				'name'=>'c_comment',
				'id'=>'c_comment',
				'class'=>'form-control input-sm',
				'value'=>'')
				);?>
	</div>
</div>
<div class="modal-footer">
        <button type="submit" class="btn btn-default" data-dismiss="modal">취소</button>
        <button type="submit" class="btn btn-primary">저장</button>
      </div>
<?php echo form_close(); ?>


      </div>

    </div>
  </div>
</div>