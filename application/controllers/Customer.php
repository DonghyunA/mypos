<?php

class Customer extends CI_Controller {

    public function __construct(){

            parent::__construct();
    }

    public function index()
    {
        $data = array();
        $data['customers_data'] = $this->make_customer_data();
        $this->load->view('customer/customer', $data);
    }
    public function save()
    {
        if($this->Customer_model->business_name_check($this->input->post('c_business_name')))
        {
            $customer=array(
                'c_whos'=>$this->session->userdata('user_email'),
                'c_business_name'=>$this->input->post('c_business_name'),
                'c_representative'=>$this->input->post('c_representative'),
                'c_address'=>$this->input->post('c_address'),
                'c_phone'=>$this->input->post('c_phone'),
                'c_c_number'=>$this->input->post('c_c_number'),
                'c_c_category'=>$this->input->post('c_c_category'),
                'c_c_kind'=>$this->input->post('c_c_kind'),
                'c_email'=>$this->input->post('c_email'),
                'c_date'=>date("Y-m-d"),
                'c_comment'=>$this->input->post('c_comment')
                );
                
                $this->Customer_model->register_customer($customer);
                redirect('Customer');
        }
        else
        {
            $this->session->set_flashdata('error_msg', '상호명이 중복되었습니다.');
            header("Refresh");
        }
            
    }
    public function view()
    {
       // get_customer_info_all
    }
    public function make_customer_data()
    {
        $data = $this->Customer_model->get_customer_info_all();
        //echo var_dump($data);
        return $data;
    }
    public function delete_customer_info()
    {
        $customers_to_delete = $this->input->post('c_id');//isset($_POST['c_business_name']) ? $_POST['c_business_name'] : NULL;
        $this->Customer_model->delete_customer_info_row($customers_to_delete);
    }
}
?>