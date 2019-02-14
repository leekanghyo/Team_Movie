<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<%@include file="../../top.jsp"%>
<%@include file="./../../../common/common.jsp"%>

<script type="text/javascript">
$(function() {
    $( "#testDatepicker" ).datepicker({
    	changeMonth: true, 
        changeYear: true,
        nextText: '다음 달',
        prevText: '이전 달',
        dateFormat: 'yy-mm-dd'
    });
});
</script>

</head> 
<body>
userInsert.jsp<br>
	<div class="container">
		<form  method="POST" action="userInsert.tm">
			<!-- 가입일자와 회원등급을 controller로 보내줌  -->
			<input type="hidden" name="ugrade" value="1">
			<h2>회원 가입</h2> 
			<div class="container">  
			<!-- 아이디 입력  --> 
			<div class="form-group">
				<label class="col-sm-12">아이디</label>
				<div class="col-sm-8">    
					<input type="text" name="usid" placeholder="사용 할 ID를 입력하세요." class="form-control" autofocus>
				</div>
			</div>
			<!-- 닉네임 입력  --> 
			<div class="form-group"> 
				<label class="col-sm-12">닉네임</label>
				<div class="col-sm-8">
					<input type="text" name="uname" placeholder="사용 할 닉네임을 입력하세요." class="form-control" autofocus>
 				</div>
			</div>
			<!-- 비밀번호 입력  -->
			<div class="form-group">
				<label class="col-sm-12">비밀 번호</label>
				<div class="col-sm-8">
					<input type="password" name="upw" placeholder="비밀번호를 입력하세요." class="form-control" autofocus>
				</div>
			</div>
			<!-- 비밀번호 확인  -->
			<div class="form-group">
				<label for="password"  class="col-sm-12">비밀 번호 확인</label>
				<div class="col-sm-8">
					<input type="password" placeholder="비밀번호를 확인해주세요." class="form-control">
				</div>
			</div>
			  
      		<!-- 생년 월일   --> 
			
			<div class="form-group">
				<label class="col-sm-12 control-label">생년월일</label>   
				<div class="col-sm-8">
					<input type="text" id="testDatepicker" name="insertubirth" class="form-control"> 
				</div>
			</div>
			  
			<!-- 선호 장르 선택  -->     
			<div class="form-group">
				<label class="control-label col-sm-12">선호 장르</label>
				<div class="col-sm-8">
					<div class="row">
						<div class="col-sm-12">
					 		<label>
								<input type="checkbox" name="ugenre" value="코미디">코미디 &nbsp;&nbsp;
								<input type="checkbox" name="ugenre" value="범죄">범죄 &nbsp;&nbsp;
								<input type="checkbox" name="ugenre" value="스릴러">스릴러 &nbsp;&nbsp;
								<input type="checkbox" name="ugenre" value="공포">공포 &nbsp;&nbsp;
								<input type="checkbox" name="ugenre" value="드라마">드라마 &nbsp;&nbsp;
								<input type="checkbox" name="ugenre" value="멜로">멜로 &nbsp;&nbsp;
							  </label>
						</div>
					</div>
				</div>
			</div>
			</div>
				<center><input type="submit" value="회원가입"></center>
		</form>	
		<!-- /form -->
	</div>
	<!-- ./container -->
</body>
</html>