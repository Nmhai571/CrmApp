$(document).ready(function () {
    $(function () {
        $("#btn-addproject").click(function(e){
        	e.preventDefault();
        	var projectName = $("#projectname").val()
        	var descriptionName = $("#description").val()
            var startDay = $("#startday").val()
        	var endDay = $("#endday").val()
 
        	$.ajax({
                url: "http://localhost:8080/crmapp/api/addproject",
                type: "post",
                data: {
                	projectname: projectName,
                    startday: startDay,
                	endday: endDay,
                    description: descriptionName,
                	
                } 
            })
            .done(function(value){
            	location.href= "http://localhost:8080/crmapp/project";
     		})
            .fail(function(error){
                console.log(error)
            })
        	
        	
        })
        	
    })

     

})