$(document).ready(function () {
	$(function () {
		$.ajax({
                url: "http://localhost:8080/crmapp/api/usertable",
                type: "post",
                
                
            })
            .done(function(value){
            	value.forEach(function(dataUser,index){
            		
            		var userTable = `
            			<tr>
            				<td>${index +1}</td>
            				<td>${dataUser.fullName}</td>
            				<td>${dataUser.email}</td>
            				<td>${dataUser.address}</td>
            				<td>${dataUser.phoneNumber}</td>
            				<td>${dataUser.role.roleName}</td>
            				
            				<td>
                                 <input name=${dataUser.id} id="btn-update-${dataUser.id}" class="btn btn-primary" type="button" value="Sửa">
                                 <input name=${dataUser.id} id="btn-delete-${dataUser.id}" class="btn btn-primary" type="button" value="Xóa">
                                 <input name=${dataUser.id} id="btn-show-${dataUser.id}" class="btn btn-primary" type="button" value="Xem">
                            </td>
            			</tr>
            		`
					
            		$("#table-user").append(userTable)
                    
            		$(`#btn-delete-${dataUser.id}`).click(function(e){
            			e.preventDefault();
            			var idUser = $(`#btn-delete-${dataUser.id}`).attr('name');
						$.ajax({
							url: "http://localhost:8080/crmapp/api/deleteuser",
							type: "post",
							data: {
								id: `${dataUser.id}`
							}
						})
						.done(function(value){
							location.href= "http://localhost:8080/crmapp/usertable";
						})
						.fail(function(error){
							console.log(error)
						})
						
						
					})
					$(`#btn-update-${dataUser.id}`).click(function(e){
            			e.preventDefault();
            			var idUser = $(`#btn-update-${dataUser.id}`).attr('name');
						$.ajax({
							url: "http://localhost:8080/crmapp/updateuser",
							type: "post",
							data: {
								id: `${dataUser.id}`
							}
						})
						.done(function(value){	
							location.href= "http://localhost:8080/crmapp/updateuser";
						})
						.fail(function(error){
							console.log(error)
						})
					})

					$(`#btn-show-${dataUser.id}`).click(function(e){
            			e.preventDefault();
            			var idUser = $(`#btn-show-${dataUser.id}`).attr('name');
						$.ajax({
							url: "http://localhost:8080/crmapp/userdetail",
							type: "post",
							data: {
								id: `${dataUser.id}`
							}
						})
						.done(function(value){	
							location.href= "http://localhost:8080/crmapp/userdetail";
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