<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%@include file="../../top.jsp"%>
<body>
<div class="container wrap">
	<div class="panel panel-info">
	 	<div class="panel-heading">
	 		Movie Profile
	 	</div>
		<div class="panel-body">
			<div class="row">
				<div class="col-sm-6" align="center">
					<img src="<c:url value="/resources/saveMovieDB/${movieBean.mnum }/${movieBean.mimg}"/>" width="75%">
				</div>
				<div class="col-sm-6">
					<h2 class="text-primary">${movieBean.mname }</h2>
					<table width="100%">
						<tr>
							<th>영화 명</th>
							<td>${movieBean.mname }</td>
						</tr>
						<tr>
							<th>장르</th>
							<td>${movieBean.mgenre }</td>
						</tr>
						<tr>
							<th>개봉일</th>
							<td>
								<fmt:formatDate value="${movieBean.mrdate}" pattern="yyyy-MM-dd" />
							</td>
						</tr>
						<tr>
							<th>관람 연령</th>
							<td>
								<c:choose>
									<c:when test="${movieBean.mage == 0}"><font color="green">전체</font></c:when>
									<c:when test="${movieBean.mage == 1}"><font color="blue">12세</font></c:when>
									<c:when test="${movieBean.mage == 2}"><font color="orange">15세</font></c:when>
									<c:otherwise><font color="red">18세</font></c:otherwise>
								</c:choose>
							</td>
						</tr>
						</table>
						<hr>
						<table width="100%">
						<tr>
							<td colspan="2">
								<b>시놉시스</b>
								<br><br>
								${movieBean.msynop }
							</td>
						</tr>
					</table>
					<hr>
					<table width="100%">
						<tr>
							<th>감독</th>
							<td>${movieBean.mdir }</td>
						</tr>
						<tr>
							<th>연출</th>
							<td>${movieBean.mpro }</td>
						</tr>
						<tr>
							<th>주연</th>
							<td>${movieBean.mactor }</td>
						</tr>
						<tr>
							<th>조연</th>
							<td>${movieBean.msup }</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<div class="panel-footer">
			<div class="row">
				<div class="col-sm-6">
					<h4 class="text-primary">운영 정보</h4>
					<table width="100%">
						<tr>
							<th>업로드</th>
							<td><fmt:formatDate value="${movieBean.midate}" pattern="yyyy-MM-dd" /></td>
						</tr>
						<tr>
							<th>관람 회원 등급</th>
							<td>
								<c:choose>
									<c:when test="${movieBean.mwcon == 1}">
										무료 관람
									</c:when>
									<c:otherwise>
										스페셜
									</c:otherwise>
								</c:choose>	
							</td>
						</tr>
						<tr>
							<th>URL</th>
							<td>${movieBean.murl}</td>
						</tr>
						<tr>
							<th>저장소</th>
							<td>${movieBean.mrepo }</td>						
						</tr>
					</table>
				</div>
				<!-- 세로 구분선 -->
				<!-- <div class="col-sm-1" style="border-left: 0px solid lightgrey;"></div> -->
				<div class="col-sm-6" style="border-left: 0px solid lightgrey;" align="center">
					<ul class="list-group" width="100%" >
						<li class="list-group-item list-group-item-info">
							<a href="movieContent.tm?mnum=${movieBean.mnum }">
								<b>상영 페이지</b>
							</a>
						</li>
						<li class="list-group-item list-group-item-info">
							<a href="updateContentsEdit.tm?mnum=${movieBean.mnum }">
								<b>정보 수정</b>
							</a>
						</li>
						<li class="list-group-item list-group-item-info">
							<a href="deleteContentsEdit.tm?mnum=${movieBean.mnum }">
								<b>삭제</b>
							</a>
						</li>
						<li class="list-group-item list-group-item-info">
							<a href="adminContentsEdit.tm">
								<b>목록으로</b>
							</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>
<%@include file="../../footer.jsp"%>
</body>
</html>