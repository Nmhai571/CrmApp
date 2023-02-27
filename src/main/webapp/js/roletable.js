$(document).ready(function () {
	$(function () {
		$.ajax({
                url: "http://localhost:8080/crmapp/api/roletable",
                type: "post",
                
            })
            .done(function(value){

			
            	value.forEach(function(dataRole, index){
            		var roleTable = `
            			<tr>
            				<td>${index+1}</td>
            				<td>${dataRole.roleName}</td>
            				<td>${dataRole.descriptionRole}</td>
            				<td>
								<input name="btn-update${dataRole.id}" id="update-role-${dataRole.id}" class="btn btn-primary" type="button" value="Sửa">
								<input name="btn-delete${dataRole.id}" id="delete-role-${dataRole.id}" class="btn btn-primary" type="button" value="Xóa">
                            </td>
            			</tr>
            		`
            		$("#role-table").append(roleTable)

					$(`#delete-role-${dataRole.id}`).click(function(e){
            			e.preventDefault();
            			var idRole = $(`#btn-delete-${dataRole.id}`).attr('name');
						$.ajax({
							url: "http://localhost:8080/crmapp/api/deleterole",
							type: "post",
							data: {
								id: `${dataRole.id}`
							}
						})
						.done(function(value){
							location.href= "http://localhost:8080/crmapp/roletable";
						})
						.fail(function(error){
							console.log(error)
						})
					})
					
					
					$(`#update-role-${dataRole.id}`).click(function(e){
            			e.preventDefault();
            			var idRole = $(`#update-role-${dataRole.id}`).attr('name');
						$.ajax({
							url: "http://localhost:8080/crmapp/updaterole",
							type: "post",
							data: {
								id: `${dataRole.id}`
							}
						})
						.done(function(value){
							location.href= "http://localhost:8080/crmapp/updaterole";
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