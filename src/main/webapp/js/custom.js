$(document).ready(function () {
    $(function () {
        $("#btn-adduser").click(function(e){
        	e.preventDefault();
        	var fullname = $("#fullname").val()
        	var email = $("#email").val()
        	var password = $("#password").val()
        	var phonenumber = $("#phonenumber").val()
        	var address = $("#address").val()
        	
        	$.ajax({
                url: "http://localhost:8080/crmapp/api/adduser",
                type: "post",
                data: {
                	fullname: fullname,
                	email: email,
                	password: password,
                	phonenumber: phonenumber,
                	address: address
                }
              
            })
            
            .done(function(value){
            	 location.href= "http://localhost:8080/crmapp/usertable";
     		})
            .fail(function(error){
                console.log(error)
            })
        	
        	
        })
        	
    })

     

})