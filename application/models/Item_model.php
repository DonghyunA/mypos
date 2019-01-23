<?php
class Item_model extends CI_model{
        public function register_item($item){

                $this->db->insert('item', $item);

        }

        public function business_name_check($c_business_name){

                $this->db->select('*');
                $this->db->from('item');
                $this->db->where('i_whos', $this->session->userdata('user_email'));
                $this->db->where('i_name',$c_business_name);
                $query=$this->db->get();

                if($query->num_rows()>0){
                        return false;
                }else{
                        return true;
        }

        }
        public function get_item_info_all(){
                $this->db->from('item');
		//$this->db->join('user', 'customer.c_whos = user.user_email');
                $this->db->where('i_whos', $this->session->userdata('user_email'));
                $this->db->where('i_deleted', '0');
		//$this->db->order_by('last_name', 'asc');
                $query=$this->db->get();
		return $query->result();
        }

        public function delete_item_info_row($items_to_delete){
                foreach($items_to_delete as $info)
                {
                        /* delete db -> delete flag */
                        $this->db->update('item', array('i_deleted' => '1'), array('i_id'=> $info, 'i_whos'=> $this->session->userdata('user_email')));
                        //$this->db->delete('item',array('i_id'=> $info, 'i_whos'=> $this->session->userdata('user_email')));
                }
                
        }


}


?>
