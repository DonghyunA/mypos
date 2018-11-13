<?php

class Item extends CI_Controller {

    public function __construct(){

            parent::__construct();
    }

    public function index()
    {
        $data = array();
        $data['items_data'] = $this->make_item_data();
        $this->load->view('item/item', $data);
    }
    public function save()
    {
        $item=array(
        'i_whos'=>$this->session->userdata('user_email'),
        'i_name'=>$this->input->post('i_name'),
        'i_producer'=>$this->input->post('i_producer'),
        'i_quality'=>$this->input->post('i_quality'),
        'i_quantity'=>$this->input->post('i_quantity'),
        'i_purchased'=>$this->input->post('i_purchased'),
        'i_price'=>str_replace(",","",$this->input->post('i_price')),
        'i_date'=>date("Y-m-d"),
        );
        
        $this->Item_model->register_item($item);
        redirect('Item');
            
    }
    public function view()
    {
       // get_customer_info_all
    }
    public function make_item_data()
    {
        $data = $this->Item_model->get_item_info_all();
        //echo var_dump($data);
        return $data;
    }
    public function delete_item_info()
    {
        $items_to_delete = $this->input->post('i_id');//isset($_POST['c_business_name']) ? $_POST['c_business_name'] : NULL;
        $this->Item_model->delete_item_info_row($items_to_delete);
    }
}
?>