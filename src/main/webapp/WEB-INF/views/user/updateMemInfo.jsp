<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
	<h1>회원정보 수정</h1>
	<form class="updateForm" method="post" action="/user/userUpdate">
		<label for="id">아이디</label><input type="text" id="userId" name="userId" readonly value="${member.userId}">
		<br><br>
		<!-- <label for="userPass">비밀번호</label><input type="password" readonly id="userPass" name="userPass" ><br><br>		 -->
		<!-- <label for="pwdCheck">비밀번호 확인</label><input type="password" id="pwdCheck" name="pwdCheck"><br><br>	 -->
		<label for="name">이름</label><input type="text" id="userName" name="userName" readonly value="${member.userName}"><br><br>
		<label for="nickname">닉네임</label><input type="text" id="userNickname" name="userNickname" value="${member.userNickname}"><br>
	 	<label for="email">이메일</label><input type="text" name="userEmail" id="userEmail" readonly value="${member.userEmail}"><br>
		<label for="phone">휴대폰번호</label><input type="tel" id="userTel" readonly name="userTel" value="${member.userTel}"><br><br>
		<!-- <input type="text" id="zipCode" readonly placeholder="우편번호">
		<input type="button" onclick="daumPostcode()" value="우편번호 찾기"><br>
		<input type="text" id="address1" readonly placeholder="주소"><br>
		<input type="text" id="address2" readonly placeholder="상세주소">
		<input type="text" id="address3" readonly placeholder="참고항목">		
		<input type="hidden" class="form-control" name="userAddr" id="userAddr"> -->
		<br>
		<input id="updateMemInfo" type="submit" value="회원정보수정">
	</form>
</body>
<script>
$(document).ready(function(){
	// 주소 저장
	  $("#address1, #address2").on("input", function() {
	        var address1 = $("#address1").val();
	        var address2 = $("#address2").val();
	        $("#userAddr").val(address1 + address2);
	    }); 
	 
	// 이메일 직접 입력 활성화
	 $("#selectEmail").on("change", function(){
		    if ($(this).val() == "직접 입력") {
		        $("#email2").attr("readonly", false);
		        $("#email2").val("");
		    } else {
		        $("#email2").attr("readonly", true);
		        $("#email2").val($(this).val());
		    }   
		    emailPlus();
		});
	
	 $("#email2").on("input", function(){
		 emailPlus();
	 });
	
	// 이메일 저장
	function emailPlus() {
		if ($("#email1").val() != "" && $("#email2").val() != "" ) {
			$("#userEmail").val($("#email1").val() + $("#email2").val());		
		}
	}

})

$("#updateMemInfo").on("click", function(){

		
		/* if($("#userPass").val()==""){
			alert("비밀번호를 입력해주세요.");
			$("#userPass").focus();
			return false;
		}
		if($("#pwdCheck").val()==""){
			alert("비밀번호를 한번 더 입력해주세요.");
			$("#pwdCheck").focus();
			return false;
		}
		if($("#pwdCheck").val()!=$("#userPass").val()){
			alert("비밀번호가 다릅니다.");
			$("#pwdCheck").focus();
			return false;
		} */
		if($("#userNickname").val()==""){
			alert("닉네임을 입력해주세요.");
			$("#userNickname").focus();
			return false;
		}		
		if($("#userEmail").val()==""){
			alert("이메일을 입력해주세요.");
			$("#email1").focus();
			return false;
		} else {
			 emailPlus();
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
		
		$(".updateForm").submit();	
		
		alert("회원정보수정이 완료되었습니다.");
		
	});
	
	// 닉네임 중복체크
	 function fn_nicknameChk(){
		
		$.ajax({
			url : "/user/nicknameChk",
			type : "post",
			dataType : "json",
			data : {"userNickname" : $("#userNickname").val()},
			success : function(data){
				if(data == 1){
					alert("사용 중인 닉네임입니다.");
				}else if(data == 0){
					$("#nicknameChk").attr("value", "Y");
					alert("사용가능한 닉네임입니다.");
				}
			}
		})
	} 

	   function daumPostcode() {
	        new daum.Postcode({
	            oncomplete: function(data) {
	                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

	                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
	                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
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
	                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
	                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
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

	                // 우편번호와 주소 정보를 해당 필드에 넣는다.
	                document.getElementById('zipCode').value = data.zonecode;
	                document.getElementById("address1").value = addr;
	                // 커서를 상세주소 필드로 이동한다.
	                document.getElementById("address2").focus();
	            }
	        }).open();
	    }
	</script>
</html>