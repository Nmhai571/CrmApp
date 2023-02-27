$(document).ready(function () {
    $(function () {
        $("#btn-updateproject").click(function(e){
        	e.preventDefault();
        	var id = $("#ID").val()
        	var name = $("#projectname").val()
        	var des = $("#description").val()
        	var start = $("#startday").val()
        	var end = $("#endday").val()
        	$.ajax({
                url: "http://localhost:8080/crmapp/api/updateproject",
                type: "post",
                data: {
                	uid: id,
                	uname: name,
                	ustart: start,
                	uend: end,
                	udes: des,
                }
              
            })
            
            .done(function(data){
            	 location.href= "http://localhost:8080/crmapp/project";
     		})
     		.fail(function(error){
     			
     		})
     		
     		
         
        })	
    })    
})