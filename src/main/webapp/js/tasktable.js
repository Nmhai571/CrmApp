$(document).ready(function () {
	$(function () {
		$.ajax({
                url: "http://localhost:8080/crmapp/api/tasktable",
                type: "post",
                
                
            })
            .done(function(value){
            	value.forEach(function(dataTask,index){
            		
            		var taskTable = `
            			<tr>
            				<td>${index +1}</td>
            				<td>${dataTask.taskName}</td>
            				<td>${dataTask.project.projectName}</td>
            				<td>${dataTask.users.fullName}</td>
            				<td>${dataTask.startDay}</td>
            				<td>${dataTask.endDay}</td>
            				<td>${dataTask.statusTask.statusName}</td>
            				<td>
                                 <input name=${dataTask.id} id="btn-update-${dataTask.id}" class="btn btn-primary" type="button" value="Sửa">
                                 <input name=${dataTask.id} id="btn-delete-${dataTask.id}" class="btn btn-primary" type="button" value="Xóa">
                                 
                            </td>
            			</tr>
            		`
					
            		$("#table-task").append(taskTable)
            		
            		$(`#btn-delete-${dataTask.id}`).click(function(e){
            			e.preventDefault();
            			var idTask = $(`#btn-delete-${dataTask.id}`).attr('name');
						$.ajax({
							url: "http://localhost:8080/crmapp/api/daletetask",
							type: "post",
							data: {
								id: `${dataTask.id}`
							}
						})
						.done(function(value){
							location.href= "http://localhost:8080/crmapp/tasktable";
						})
						.fail(function(error){
							console.log(error)
						})

					})
					
            		
            		$(`#btn-update-${dataTask.id}`).click(function(e){
            			e.preventDefault();
            			var idTask = $(`btn-update-${dataTask.id}`).attr('name');
						$.ajax({
							url: "http://localhost:8080/crmapp/updatetask",
							type: "post",
							data: {
								id: `${dataTask.id}`
							}
						})
						.done(function(value){
							location.href= "http://localhost:8080/crmapp/updatetask";
						})
						.fail(function(error){
							console.log(error)
						})

					})
            	})
            	
            	
            })
            .fail(function(error){
            	console.log(error)
            })
            
	})
})	