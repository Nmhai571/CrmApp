$(document).ready(function () {
	$(function () {
		$.ajax({
                url: "http://localhost:8080/crmapp/api/projecttable",
                type: "post",
                
            })
            .done(function(value){
            	value.forEach(function(dataProject, index){
            		
            		var projectTable = `
            			<tr>
            				<td>${index+1}</td>
            				<td>${dataProject.projectName}</td>
            				<td>${dataProject.startDay}</td>
            				<td>${dataProject.endDay}</td>
            				<td>
                                 <input name=${dataProject.id} id="update-project-${dataProject.id}" class="btn btn-primary" type="button" value="Sửa">
                                 <input name=${dataProject.id} id="delete-project-${dataProject.id}" class="btn btn-primary" type="button" value="Xóa">
                                 
                            </td>
            			</tr>
            		`
            		$("#project-table").append(projectTable)
                    $(`#delete-project-${dataProject.id}`).click(function(e){
            			e.preventDefault();
            			var idRole = $(`#delete-project-${dataProject.id}`).attr('name');
						console.log(idRole)
						$.ajax({
							url: "http://localhost:8080/crmapp/api/deleteproject",
							type: "post",
							data: {
								id: `${dataProject.id}`
							}
						})
						.done(function(value){
							location.href= "http://localhost:8080/crmapp/project";
						})
						.fail(function(error){
							console.log(error)
						})
					})
					
					$(`#update-project-${dataProject.id}`).click(function(e){
            			e.preventDefault();
            			var idRole = $(`#update-project-${dataProject.id}`).attr('name');
						console.log(idRole)
						$.ajax({
							url: "http://localhost:8080/crmapp/updateproject",
							type: "post",
							data: {
								id: `${dataProject.id}`
							}
						})
						.done(function(value){
							location.href= "http://localhost:8080/crmapp/updateproject";
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