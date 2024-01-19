<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<c:if test="${member != null }">
<p><b>${member.userId}</b>님의 마이페이지</p>
<br>
<a href="/" id="goHome" type="button">홈</a>
<br>
<a href="/user/goUpdateInfo" id="goUpdateInfo" type="button">회원정보 수정</a>
<a href="/user/withdrawal" id="withdrawal" type="button">회원 탈퇴</a>
</c:if>
</body>
</html>