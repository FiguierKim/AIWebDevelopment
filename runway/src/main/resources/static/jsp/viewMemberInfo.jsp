<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script type="text/javascript" src="../js/my.js"></script>

</head>
    <script>
        function check_pw(){
 
            var pw = document.getElementById('pw').value;
            var SC = ["!","@","#","$","%"];
            var check_SC = 0;
 
            if(pw.length < 6 || pw.length>16){
                window.alert('비밀번호는 6글자 이상, 16글자 이하만 이용 가능합니다.');
                document.getElementById('pw').value='';
            }
            for(var i=0;i<SC.length;i++){
                if(pw.indexOf(SC[i]) != -1){
                    check_SC = 1;
                }
            }
            if(check_SC == 0){
                window.alert('!,@,#,$,% 의 특수문자가 들어가 있지 않습니다.')
                document.getElementById('pw').value='';
            }
            if(document.getElementById('pw').value !='' && document.getElementById('pw2').value!=''){
                if(document.getElementById('pw').value==document.getElementById('pw2').value){
                    document.getElementById('check').innerHTML='비밀번호가 일치합니다.'
                    document.getElementById('check').style.color='blue';
                }
                else{
                    document.getElementById('check').innerHTML='비밀번호가 일치하지 않습니다.';
                    document.getElementById('check').style.color='red';
                }
            }
        }
        
        function validate(){
            if(id.value=="") {
                alert("아이디를 입력해 주세요");
                id.focus();
                return false;
            }
            
            if(pw.value=="") {
                alert("비밀번호를 입력해 주세요");
                pw.focus();
                return false;
            }
            
            if(pw.value != pw2.value) {
                alert("비밀번호가 일치하지 않습니다.");
                pw2.focus();
                return false;
            }
            
            if(name.value=="") {
                alert("이름을 입력해 주세요");
                name.focus();
                return false;
            }
            
            if(email.value=="") {
                alert("이메일을 입력해 주세요");
                email.focus();
                return false;
            }
            
            if(age.value=="") {
                alert("나이를 입력해 주세요");
                age.focus();
                return false;
            }
            
            if(weight.value=="") {
                alert("몸무게를 입력해 주세요");
                weight.focus();
                return false;
            }
            
            if(height.value=="") {
                alert("키를 입력해 주세요");
                height.focus();
                return false;
            }
            
            if(gender.value=="") {
                alert("성별을 입력해 주세요");
                gender.focus();
                return false;
            }
        	
        }
    </script>
<body>
	<article class="container"><br>
	        <div class="page-header">
                <div class="col-md-6 col-md-offset-3">
                <h3>Member Profile</h3>
                </div>
            </div>
            <div class="col-sm-6 col-md-offset-3">
                <form role="form">
                    <div class="form-group">
                        <label for="inputName">Name</label>
                        <input type="text" class="form-control" id="name" value='${vo.getName() }' readonly />
                    </div>   
                    <div class="form-group">
                        <label for="inputEmail">Email</label>
                        <input type="email" class="form-control" id="email" value='${vo.getEmail() }' disabled="disabled" />
                    </div>
                    <div class="form-group">
                    	<label for="inputAge">Age</label>
						<input type="number" class="form-control" id="age" style="width:100px;" value='${vo.getAge() }' disabled="disabled" />
                    </div>
                    <div class="form-group">
                    	<label for="inputAge">Weight</label>
						<input type="number" class="form-control" id="weight" style="width:100px;" value='${vo.getWeight() }' disabled="disabled" />
                    </div>
                    <div class="form-group">
                    	<label for="inputAge">Height</label>
						<input type="number" class="form-control" id="height" style="width:100px;" value='${vo.getHeight() }' disabled="disabled" />
                    </div>
                    <div class="form-group">
                        <label for="inputGender">Gender</label><br>
						<input type="number" class="form-control" id="gender" style="width:100px;" value='${vo.getGender() }' readonly />		
                   				<c:choose>
                   				
                   				<c:when test = "${vo.getGender() eq 'male' }" >
										<input type="radio" name="gender" value="male" checked>남자
										<input type="radio" name="gender" value="female">여자
								</c:when>
								<c:otherwise>
										<input type="radio" name="gender" value="male">남자
										<input type="radio" name="gender" value="female" checked>여자
								</c:otherwise>
								
								</c:choose>
                    </div>

                    <div class="form-group text-center"  onclick="validate();">
                        <input type="button" id="updateMemberInfoBtn" class="btn btn-primary" 
                        value="Edit Profile">
                    </div>
                    <div class="form-group text-center">
                        <input type="button" id="deleteBtn" class="btn btn-primary" 
                        value="Delete Account">
                    </div>
                </form>
            </div>

        </article>

</body>
</html>