$(document).ready(function() {
	$("#saveRecordBtn").click(function() {
		const id = $("#id").val();
		const route = $("#route").val();
		const calorie = $("#calorie").val();
		const distance = $("#distance").val();
		const memo = $("#memo").val();
		
		alert(gender);


		$.post("../local5.jes",
			{
				id,
				route, 
				calorie,
				distance,
				memo
				
			},
			function(data, status) {
				alert(data);
				window.close();
			});
	});

});