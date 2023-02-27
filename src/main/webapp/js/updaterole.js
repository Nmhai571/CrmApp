$(document).ready(function () {
    $(function () {
        $("#btn-updaterole").click(function(e){
        	e.preventDefault();
        	var id = $("#ID").val()
        	var roleName = $("#rolename").val()
        	var desRole = $("#desrole").val()
        	$.ajax({
                url: "http://localhost:8080/crmapp/api/updaterole",
                type: "post",
                data: {
                	idrole: id,
                	urolename: roleName,
                	udescription: desRole,
                }
              
            })
            
            .done(function(data){
            	 location.href= "http://localhost:8080/crmapp/roletable";
     		})
     		.fail(function(error){
     			
     		})
     		
     		
         
        })	
    })    
})