$(document).ready(function () {
    $(function () {
        $("#btn-addrole").click(function(e){
        	e.preventDefault();
        	var rolename = $("#rolename").val()
        	var descriptionname = $("#desname").val()
 
        	$.ajax({
                url: "http://localhost:8080/crmapp/api/addrole",
                type: "post",
                data: {
                	rolename: rolename,
                	descriptionname: descriptionname,
                	
                } 
            })
            .done(function(value){
            	 location.href= "http://localhost:8080/crmapp/roletable";
     		})
            .fail(function(error){
                console.log(error)
            })
        	
        	
        })
        	
    })

     

})