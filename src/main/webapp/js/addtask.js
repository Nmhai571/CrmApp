$(document).ready(function () {
    $(function () {
        $("#btn-addtask").click(function(e){
        	e.preventDefault();
        	var taskName = $("#taskname").val()
        	var taskDes = $("#taskdes").val()
            var startDay = $("#startday").val()
        	var endDay = $("#endday").val()
        	var userName = $("#user").val()
 			var projectName = $("#project").val()
        	$.ajax({
                url: "http://localhost:8080/crmapp/api/addtask",
                type: "post",
                data: {
                	taskname: taskName,
                    taskdes: taskDes,
                	startday: startDay,
                    endday: endDay,
                    project: projectName,
                    user: userName
                	
                } 
            })
            .done(function(value){
            	location.href = 'http://localhost:8080/crmapp/tasktable';
     		})
            .fail(function(error){
                console.log(error)
            })
        	
        	
        })
        	
    })

     

})