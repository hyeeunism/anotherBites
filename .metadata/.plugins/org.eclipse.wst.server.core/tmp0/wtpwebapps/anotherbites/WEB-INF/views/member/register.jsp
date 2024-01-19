<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
	<head>
		<!-- 합쳐지고 최소화된 최신 CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<!-- 부가적인 테마 -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	 	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
		<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
		<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>	
	 	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<title>회원가입</title>
	</head>
	<body>
		<section id="container">
			<form action="/member/register" method="post" class="userJoin">>
				<div class="form-group has-feedback">
					<label class="control-label" for="userId">아이디</label>
					<input class="form-control" type="text" id="userId" name="userId" />
					<button class="idChk" type="button" id="idChk" onclick="fn_idChk();" value="N">중복확인</button><br><br>
		
				</div>
				<div class="form-group has-feedback">
					<label class="control-label" for="userPass">패스워드</label>
					<input class="form-control" type="password" id="userPass" name="userPass" />
				</div>
				<div class="form-group has-feedback">
					<label class="control-label" for="userName">성명</label>
					<input class="form-control" type="text" id="userName" name="userName" />
				</div>
				<div class="form-group has-feedback">
					<label class="control-label" for="userNickname">닉네임</label>
					<input class="form-control" type="text" id="userNickname" name="userNickname" />
					<button class="nicknameChk" type="button" id="nicknameChk" onclick="fn_nicknameChk();" value="N">중복확인</button><br><br>
				</div>
				<div class="form-group has-feedback">
					<label class="control-label" for="userTel">전화번호</label>
					<input class="form-control" type="text" id="userTel" name="userTel" />
				</div>
				<div class="form-group has-feedback">
					<label class="control-label" for="userEmail">이메일</label>
					<input class="form-control" type="email" id="userEmail" name="userEmail" />
				</div>
				
				<div class="form-group has-feedback">
					<label class="control-label" for="zipcode">우편번호</label>
					<input class="form-control" type="text" id="zipcode" name="zipcode" />
					<input type="button" value="우편번호 검색" onclick="openDaumPostcode()"><br><br>
					<label for="address1">기본주소</label>
					<input type="text" id="address1" name="address1"><br><br>
					
					<label for="userAddr">상세주소</label>
					<input type="text" id="address2" name="address2"><br><br>
					
					<label for="address3">참고항목</label>
					<input type="text" id="address3" name="address3"><br><br>
					
					<input type="hidden" id="userAddr" name="userAddr"><br><br>
				</div>
				
				<div class="form-group has-feedback">
					<button class="btn btn-success" type="submit" id="submit">회원가입</button>
					<button class="cencle btn btn-danger" type="button">취소</button>
				</div>
			</form>
		</section>
		
	</body>
	<script type="text/javascript">
	$(document).ready(function(){
		 $("#address1, #address2").on("input", function() {
		        var address1 = $("#address1").val();
		        var address2 = $("#address2").val();
		        $("#userAddr").val(address1 + address2);
		    });
		
		$(".userJoin").on("submit", function(){
			
			let idval = $('#userId').val()
		    let idvalcheck = /^[a-z0-9]+$/
		    if (!idvalcheck.test(idval) || idval.length<6){
		    	alert('아이디는 영소문자,숫자로 구성된 6글자 이상으로 조합하시오.')
		        $('#userId').focus()
		        return false
		    }
			
			if($("#userPass").val()==""){
				alert("비밀번호를 입력해주세요.");
				$("#userPass").focus();
				return false;
			}
			if($("#pwdCheck").val()==""){
				alert("비밀번호를 입력해주세요.");
				$("#pwdCheck").focus();
				return false;
			}
			if($("#userName").val()==""){
				alert("성명을 입력해주세요.");
				$("#userName").focus();
				return false;
			}
			if($("#userEmail").val()==""){
				alert("이메일을 입력해주세요.");
				$("#userEmail").focus();
				return false;
			}
			if($("#userTel").val()==""){
				alert("휴대폰번호를 입력해주세요.");
				$("#userTel").focus();
				return false;
			}
			if($("#zipcode").val()==""){
				alert("우편번호를 입력해주세요.");
				$("#zipcode").focus();
				return false;
			}
			
		});
	})
	</script>
	<script>
    function openDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
            
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수
                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }
                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
     
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("address3").value = extraAddr;
                
                } else {
                    document.getElementById("address3").value = '';
                }
                
                document.getElementById('zipcode').value = data.zonecode;
                document.getElementById("address1").value = addr;
                document.getElementById("userAddr").focus();
            }
        
        }).open();
    }
    
</script>
</html>