<?php

class Home extends CI_Controller {

    public function __construct(){

            parent::__construct();
    }

    public function index()
    {
        $this->load->view('home/home');
    }
    public function temp()
    {
        $this->load->view('login/login');
    }
}
?>