$(function(){
	$("#userList").click(function(){
		
		fetchList("user");
	});
	$("#addressList").click(function(){
		fetchList("address");
	});
});

function fetchList(type){
	$.ajax({
		type : "GET",
		url : "/springboot/"+type+"/list",
		success : function(data){
			$(".panel-body").html(data);
		}
	});
}
function motifyData(url){
	$.ajax({
		type : "GET",
		url : url,
		success : function(data){
				$(".panel-body").html(data);
		}
		
	});
}
function addForm(type){
	motifyData("/springboot/"+type+"/form");	
}

function editForm(type, id){
	motifyData("/springboot/"+type+"/edit/" + id);
}

