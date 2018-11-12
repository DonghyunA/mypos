<?php 

    error_reporting(E_ALL); 
    ini_set('display_errors',1); 

    include('dbcon2.php');
        

    $stmt = $con->prepare('select * from item ORDER BY i_name ASC, i_date ASC');
    $stmt->execute();

    if ($stmt->rowCount() > 0)
    {
        $data = array(); 

        while($row=$stmt->fetch(PDO::FETCH_ASSOC))
        {
            extract($row);
			if( $i_whos ==$_POST['i_whos'])
			{
				array_push($data, 
					array('i_id'=>$i_id,
					'i_name'=>$i_name,
					'i_producer'=>$i_producer,
					'i_quality'=>$i_quality,
					'i_quantity'=>$i_quantity,
					'i_purchased'=>$i_purchased,
					'i_price'=>$i_price,					
					'i_date'=>$i_date
				));
			}
        }

        header('Content-Type: application/json; charset=utf8');
        $json = json_encode(array("i_list"=>$data), JSON_PRETTY_PRINT+JSON_UNESCAPED_UNICODE);
        echo $json;
    }

?>