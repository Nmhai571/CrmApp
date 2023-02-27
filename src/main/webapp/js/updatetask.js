$(document).ready(function () {
    $(function () {
        $("#btn-updatetask").click(function(e){
        	e.preventDefault();
        	var id = $("#ID").val()
        	var taskName = $("#taskname").val()
        	var taskDes = $("#taskdes").val()
        	var startDay = $("#startday").val()
        	var endDay = $("#endday").val()
        	var userName = $("#user").val()
        	var projectName = $("#project").val()
        	var statusName = $("#status").val()
        	$.ajax({
                url: "http://localhost:8080/crmapp/api/updatetask",
                type: "post",
                data: {
                	idTask: id,
                	taskname: taskName,
                	taskdes: taskDes,
                	startday: startDay,
                	endday: endDay,
                	project: projectName,
                	user: userName,
                	status: statusName
                }
              
            })
            
            .done(function(data){
            	 location.href= "http://localhost:8080/crmapp/tasktable";
     		})
     		.fail(function(error){
     			
     		})
     		
     		
         
        })	
    })    
})