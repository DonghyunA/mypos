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
                $this->db->where('c_whos', $this->session->userdata('user_email'));
                $this->db->where('c_business_name',$c_business_name);
                $query=$this->db->get();

                if($query->num_rows()>0){
                        return false;
                }else{
                        return true;
        }

        }
        public function get_customer_info_all(){
                $this->db->from('customer');
		//$this->db->join('user', 'customer.c_whos = user.user_email');
                $this->db->where('c_whos', $this->session->userdata('user_email'));
                $this->db->where('c_deleted', '0');
		//$this->db->order_by('last_name', 'asc');
                $query=$this->db->get();
		return $query->result();
        }

        public function delete_customer_info_row($customers_to_delete){
                foreach($customers_to_delete as $info)
                {
                        /* delete db -> delete flag */
                        $this->db->update('customer', array('c_deleted' => '1'), array('c_id'=> $info, 'c_whos'=> $this->session->userdata('user_email')));
                        //$this->db->delete('customer',array('c_business_name'=> $info, 'c_whos'=> $this->session->userdata('user_email')));
                }
                
        }


}


?>
