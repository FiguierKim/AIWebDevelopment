$(document).ready(function() {
	var login = $.cookie('logined');
	
	//로그인 뒤 화면 유지시키기
	$.ajax({
		url:"../getCal.jes",
		type:"get",
		data:{id:login},
		success:function(data){
			if (data.name != null) {
				data = data.name + "님 환영합니다! &nbsp<input type='button' value='LOGOUT' id='logoutBtn' class='btn-primary'>";			
				$("#msgDiv").html(data);
			}
		},
		error:function(){ 
		}
	});

	//////주문하기
	$("#orderBtn").click(function() {
		const confirm_data = confirm("다음과 같이 주문하시겠습니까?\n" + items);
		if (confirm_data) {

			let basket = $.cookie("basket");

			console.log(basket);

			$.post('../order.jes',
				basket,
				function(data) {
					console.log(data);
					data = JSON.parse(data);
					if (data.order_group_no) {
						alert("주문 완료: [주문번호]" + data.order_group_no);
						$.removeCookie("basket", { path: '/' });// 장바구니 쿠키 삭제		
						window.opener.location.reload();
					} else {
						alert(data.msg);
					}
					window.close();
				}
			);
		}
	});


	///////// 장바구니 비우기
	$("#cancelBtn").click(function() {
		alert("장바구니를 모두 비웁니다");
		$.removeCookie("basket", { path: '/' });// 장바구니 쿠키 삭제
		window.opener.location.reload();
		window.close();

	});



	/////////다른 상품 주문하기
	$("#anotherBtn").click(function() {
		window.close();
	});


	////////장바구니 넣기
	$(".orderForm").click(function(event) {
		console.log(event.target.name);
		let basket = $.cookie("basket");
		console.log(basket);

		if (basket) {//장바구니 있는 상태		
			basket = JSON.parse(basket);
			let flag = true;

			basket.product.forEach(function(item, index) {
				if (item.name == event.target.name) {//이미 있는 상품이면
					item.quantity += 1;
					flag = false;
				}
			});

			if (flag) {
				basket.product.push({ name: event.target.name, quantity: 1 });//새 품목 추가			    	
			}

		} else {//없는 상태
			basket = { product: [{ name: event.target.name, quantity: 1 }] };
		}

		basket = JSON.stringify(basket);
		$.cookie("basket", basket, { path: '/' });

		window.open('html/orderForm.html', '_blank', 'width=600,height=400');

	});

	/////////////////////회원 가입 처리
	$("#memberInsertBtn").click(function() {

		const id = $("#id").val();
		const pw = $("#pw").val();
		const name = $("#name").val();
		const email = $("#email").val();
		const age = $("#age").val();
		const weight = $("#weight").val();
		const height = $("#height").val();
		const gender = $(":input:radio[name=gender]:checked").val();
		
		$.post("../memberInsert.jes",
			{
				id,
				pw,
				name,
				email,
				age,
				weight,
				height,
				gender
			},
			function(data, status) {
				alert(data);
				window.close();
			});
	});

	////////////////////////////로그인 처리	
	$("#loginBtn").click(function() {

		var id = $("#id").val();
		var pw = $("#pw").val();

		$.post("login.jes",
			{
				id,
				pw
			},
			function(data, status) {

				if (data.name) {
					$.cookie("logined", id);
					$("#msgDiv").html(data);
					location.reload();
				} else {
					alert("login fail");
					location.reload();
				}

			}
		);//end post() 
	});//end 로그인 처리

	///////////////////////로그아웃 처리
	$(document).on("click", "#logoutBtn", function(event) {

		$.post("logout.jes",
			{

			},
			function(data, status) {

				$.removeCookie("logined");
				location.reload();
			}
		);//end post() 
	});//end 로그아웃 처리

	/////////////////////회원 탈퇴
	$(document).on("click", "#deleteBtn", function(event) {
		alert("정말 탈퇴하시겠습니까?");
		$.post("memberDelete.jes",
			{

			},
			function(data, status) {

				$.removeCookie("logined");
				location.reload();
			}
		);//end post() 
	});//
	
	//문의내용 접수하기(Contact us)
	$("#contact_send_btn").click(function() {

		const name = $("#contact_name").val();
		const email = $("#contact_email").val();
		const comment = $("textarea#contact_comment").val();

		$.post("../insertContact.jes",
			{
				name,
				email,
				comment
			},
			function(data, status) {
				alert(name + "님 문의내용이 접수되었습니다.\n조속한 시일내에 답변드릴 수 있도록 하겠습니다.");
				location.reload();
			}
		);
	});


});














