<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/include/head.jsp"></c:import>
<link href="/rescouces/css/login.css" rel="stylesheet">
</head>

<body class="text-center">
	<main class="form-signin w-100 m-auto">
		<form method="POST" action="/user/join" onsubmit="return validation()">
			<img class="mb-4" src="/resources/svg/bootstrap-logo.svg" alt=""
				width="72" height="57">
			<h1 class="h3 mb-3 fw-normal">회원가입</h1>

			<div class="form-floating">
				<input type="text" class="form-control" id="uiName" placeholder="이름"
					name="uiName"> <label for="uiName">이름</label>
			</div>
			<div class="form-floating">
				<input type="text" class="form-control" id="uiId" placeholder="아이디"
					name="uiId"> <label for="uiId">아이디</label>
			</div>
			<div class="form-floating">
				<input type="password" class="form-control" id="uiPwd" name="uiPwd"
					placeholder="비밀번호"> <label for="uiPwd">비밀번호</label>
			</div>
			<div class="select-box">
				<select class="from-control" id="uiGrade" name="uiGrade">
					<option value="">등급선택</option>
					<option value="1">일반</option>
					<option value="2">관리자</option>
				</select>
			</div>

			<button class="w-100 btn btn-lg btn-primary" type="submit">회원가입</button>
			<p class="mt-5 mb-3 text-muted">&copy; 2025–2026</p>
		</form>
	</main>

	<script>
		function validation(){
			const uiName = document.querySelector('#uiName');
			if(uiName.value.length<2){
				alert('이름은 2자리 이상입니다.');
				uiName.focus();
				return false;
			}
			const uiId = document.querySelector('#uiId');
			if(uiId.value.trim()<4){
				alert('아이디는 4자리 이상입니다.');
				uiId.focus();
				return false
			}
			const uiPwd = document.querySelector('#uiPwd');
			if(uiPwd.value.trim()<4){
				alert('비밀번호는 4자리 이상입니다.');
				uiPwd.focus();
				return false
			}
			const uiGrade = document.querySelector('#uiGrade');
			if(!uiGrade.value){
				alert('등급을 선택해주세요.');
				uiGrade.focus();
				return false;
			}
			return true;
		}
		
	</script>

</body>
</html>