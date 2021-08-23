$(document).ready(function() {
	$("#getCal").click(function() {
		var wHour = $("#workout_hour").val() / 60;
		var age = $("#default_age").val();
		var height = $("#default_height").val();
		var weight = $("#default_weight").val();
		var predict_cal = 0;
		var chk_radio = document.getElementsByName('default_gender');
		var sel_type = null;

		for (var i = 0; i < chk_radio.length; i++) {
			if (chk_radio[i].checked == true) {
				sel_type = chk_radio[i].value;
			}
		}
		if (sel_type == null) {
			alert("성별을 선택하세요.");
			return false;
		}

		if (sel_type == "male") {
			predict_cal = (66 + (13.7 * weight) + (5 * height) - (6.8 * age)) * 3 / 24 * wHour;
			$("#result_cal").html(predict_cal);
		} else if (sel_type == "female") {
			predict_cal = (55 + (9.6 * weight) + (1.8 * height) - (4.7 * age)) * 3 / 24 * wHour;
			$("#result_cal").html(predict_cal);
		} else {
			alert("error");
			location.reload();
		}
	});
});

