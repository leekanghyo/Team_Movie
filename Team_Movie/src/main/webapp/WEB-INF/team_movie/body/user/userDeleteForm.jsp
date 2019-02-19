<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../../top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
userDeleteForm.jsp
<div class="container">
		<h2 class="text-primary">회원 정보 관리</h2>
		<div class="row">
				<%@ include file="userMenu.jsp" %>
			<div class="col-sm-9">
					<div class="panel panel-info">
					
						<div class="panel-heading">회원탈퇴</div>
							<form action="userDelete.tm" method="POST">
							<div class="panel-body">			
								<h4 class="text-primary">${sessionScope.uname} 님 회원 탈퇴 하시겠습니까?</h4>
								<input type="hidden" name="unum" value="${userInfo.unum }">
								<input type="submit" value="탈퇴하기">	
							</div>
							</form> 
					</div> 
			</div>
		</div>
	</div>
</body>
</html>