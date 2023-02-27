$(document).ready(function () {
    $(function () {
        $("#btn-updateuser").click(function(e){
        	e.preventDefault();
        	var id = $("#ID").val()
        	var fullname = $("#fullnameupdate").val()
        	var email = $("#emailupdate").val()
        	var password = $("#passwordupdate").val()
        	var phonenumber = $("#phonenumberupdate").val()
        	var address = $("#arressupdate").val()
        	$.ajax({
                url: "http://localhost:8080/crmapp/api/updateuser",
                type: "post",
                data: {
                	iduser: id,
                	ufullname: fullname,
                	uemail: email,
                	epassword: password,
                	uphone: phonenumber,
                	uaddress: address
                }
              
            })
            
            .done(function(data){
            	 location.href= "http://localhost:8080/crmapp/usertable";
     		})
     		.fail(function(error){
     			
     		})
     		
     		
         
        })	
    })    
})