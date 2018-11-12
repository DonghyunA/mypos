<!-- Modal -->
<div class="modal fade" id="new_item_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title" id="myModalLabel">거래처 신규등록</h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
      </div>
      <div class="modal-body">
        <?php echo form_open(base_url("item/save"), array('id'=>'customer_form', 'class'=>'form-horizontal')); ?>
        <div class="form-group form-group-sm">	
		<?php echo form_label('*품목명', 'i_name', array('class'=>'required control-label col-xl-3')); ?>
		<div class='col-xl-8'>
			<?php echo form_input(array(
					'name'=>'i_name',
					'id'=>'i_name',
					'class'=>'form-control input-sm',
					'value'=>'',
					'required'=>'required')
					);?>
		</div>
	</div>

			<div class="form-group form-group-sm">	
				<?php echo form_label('*생산자', 'i_producer', array('class'=>'required control-label col-xl-3')); ?>
				<div class='col-xl-8'>
					<?php echo form_input(array(
							'name'=>'i_producer',
							'id'=>'i_producer',
							'class'=>'form-control input-sm',
                                                        'value'=>'',
                                                        'required'=>'required')
							);?>
				</div>
			</div>
			<div class="form-group form-group-sm">	
				<?php echo form_label('품질', 'i_quality', array('class'=>'control-label col-xl-3')); ?>
				<div class='col-xl-8'>
                                        <label class="radio-inline">
                                                <?php echo form_radio(array(
                                                                'name'=>'i_quality',
                                                                'type'=>'radio',
                                                                'id'=>'i_quality',
                                                                'value'=>0,
                                                                )
                                                ); ?> 하
                                        </label>
                                        <label class="radio-inline">
                                                <?php echo form_radio(array(
                                                                'name'=>'i_quality',
                                                                'type'=>'radio',
                                                                'id'=>'i_quality',
                                                                'value'=>1,
                                                                )
                                                ); ?> 중하
                                        </label>
                                        <label class="radio-inline">
                                                <?php echo form_radio(array(
                                                                'name'=>'i_quality',
                                                                'type'=>'radio',
                                                                'id'=>'i_quality',
                                                                'value'=>2,
                                                                )
                                                ); ?> 중
                                        </label>
                                        <label class="radio-inline">
                                                <?php echo form_radio(array(
                                                                'name'=>'i_quality',
                                                                'type'=>'radio',
                                                                'id'=>'i_quality',
                                                                'value'=>3,
                                                                )
                                                ); ?> 중상
                                        </label>
                                        <label class="radio-inline">
                                                <?php echo form_radio(array(
                                                                'name'=>'i_quality',
                                                                'type'=>'radio',
                                                                'id'=>'i_quality',
                                                                'value'=>4,
                                                                'checked'=>'true')
                                                ); ?> 상
                                        </label>
				</div>
			</div>
			<div class="form-group form-group-sm">	
				<?php echo form_label('수량', 'i_quantity', array('class'=>'control-label col-xl-3')); ?>
				<div class='col-xl-8'>
					<div class="input-group">
						<span class="input-group-addon input-sm"><span class="glyphicon glyphicon-phone-alt"></span></span>
						<?php echo form_input(array(
								'name'=>'i_quantity',
								'id'=>'i_quantity',
								'class'=>'form-control input-sm',
								'value'=>'')
								);?>
					</div>
				</div>
			</div>

			<div class="form-group form-group-sm">	
				<?php echo form_label('구입처', 'i_purchased', array('class'=>'control-label col-xl-3')); ?>
				<div class='col-xl-8'>
					<?php echo form_input(array(
							'name'=>'i_purchased',
							'id'=>'i_purchased',
							'class'=>'form-control input-sm',
							'value'=>'')
							);?>
				</div>
			</div>

			<div class="form-group form-group-sm">	
				<?php echo form_label('구매 가격', 'i_price', array('class'=>'control-label col-xl-3')); ?>
				<div class='col-xl-8'>
					<?php echo form_input(array(
							'name'=>'i_price',
							'id'=>'i_price',
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