<?php
class Customer_model extends CI_model{
        public function register_customer($customer){

                $this->db->insert('customer', $customer);

        }

        public function login_customer($email,$pass){

                $this->db->select('*');
                $this->db->from('customer');
                $this->db->where('user_email',$email);
                $this->db->where('user_password',$pass);

                if($query=$this->db->get())
                {
                        return $query->row_array();
                }
                else{
                        return false;
                }


        }
        public function business_name_check($c_business_name){

                $this->db->select('*');
                $this->db->from('customer');
                $this->db->where('c_business_name',$c_business_name);
                $query=$this->db->get();

                if($query->num_rows()>0){
                        return false;
                }else{
                        return true;
        }

        }
        public function is_logined(){
        if($this->session->userdata('user_email')!= null)
        {
                return true;
        }
        else
                {
                        return false;
                }
        }


}


?>
