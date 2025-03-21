<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/include/head.jsp"></c:import>
<style>
body{
	background-color:rgba(22,22,22,0.5);
}
</style>
</head>
<body>
	<div class="modal fade show" id="memoModal" tabindex="-1" role="dialog">
      <div class="modal-dialog" role="document">
         <div class="modal-content">
            <div class="modal-header">
               <h4 class="modal-title" id="myModalLabel">${empty title? "알림창":title}</h4>
            </div>
            <div class="modal-body text-center">
               <p>
                  <strong>${empty msg? "안녕하세요":msg}</strong>
               </p>
            </div>
            <div class="modal-footer">
               <button type="button" class="btn btn-primary btn-sm"
                  onclick="location.href='${empty url? "/":url}'">확인</button>
            </div>
         </div>
      </div>
   </div>
   <script>
   	window.onload = function(){
   		const modal = document.querySelector('#memoModal');
   		modal.style.display = 'block';
   	}
   </script>
</body>
</html>