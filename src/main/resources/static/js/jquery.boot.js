$(function(){
	$("#userList").click(function(){
		
		fetchList("user");
	});
	$("#addressList").click(function(){
		fetchList("address");
	});
});

function fetchList(type){
	motifyData("/springboot/"+type+"/list");
}
function motifyData(url){
	$.ajax({
		type : "GET",
		url : url,
		success : function(data){
				$(".inner-jsp").html(data);
		}
		
	});
}
function addForm(type){
	motifyData("/springboot/"+type+"/form");
}

function editForm(type, id){
	motifyData("/springboot/"+type+"/edit/" + id);
}


function deleteData(type, id){
	if(confirm("Are you sure you want to delete this ?")){
		$.ajax({
			type : "GET",
			url : "/springboot/"+type+"/delete/" + id,
			success : function(data){
					fetchList(type);
					alert(data.message);
			}
		});
	}
}

