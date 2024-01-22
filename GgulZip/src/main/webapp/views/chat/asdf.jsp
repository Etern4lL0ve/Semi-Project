<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<style>

    
</style>


<head>
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>



	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1"> <!-- 반응형 웹 -->
	<link rel="stylesheet" href="css/bootstrap.css"> <!-- bootstrap.css 파일 -->
	<link rel="stylesheet" href="css/custom.css">
	<script src="js/bootstrap.js"></script>
	<title>JSP AJAX 실시간 익명 채팅 사이트</title>
</head>
<body>
	<div class="container">
		<div class="container bootstrap snippet">
			<div class="row">
				<div class="col-xs-12">
					<div class="portlet portlet-default">
						<div class="portlet-title">
							<h4><i class="fa fa-circle text-green"></i>실시간 채팅방</h4>
						</div>
						<div class="clearfix"></div>
					</div>
					<div id="chat" class="panel-collapse collapse in">
						<!-- overflow-y : auto; 는 아래로 글이 늘어났을 때 자동적으로 늘어남을 의미한다. -->
						<div class="portlet-body chat-widget" style="overflow-y: auto; width: auto; height: 300px;">
							<div class="row">
								<div class="col-lg-12">
									<p class="text-center text-muted small">2021년 08월 02일</p>
								</div>
							</div>
							<div class="row">
								<div class="col-lg-12">
									<div class="medio">
										<a class="pull-left" href="#">
											<img class="media-object img-circle" src="images/icon.jpg">
										</a>
										<div class="media-body">
											<h4 class="media-reading">홍길동
												<span class="small pull-right">오전 12:23</span>
											</h4>
										</div>
										<p>안녕하세요. 오랜만입니다. 홍길동입니다.</p>
									</div>
								</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-lg-12">
									<div class="medio">
										<a class="pull-left" href="#">
											<img class="media-object img-circle" src="images/icon.jpg">
										</a>
										<div class="media-body">
											<h4 class="media-reading">이순신
												<span class="small pull-right">오후12:28</span>
											</h4>
										</div>
										<p>저도 반갑습니다. 오랜만에 뵈니까 반갑네요.</p>
									</div>
								</div>
							</div>
						</div>
						<div class="portlet-footer">
							<div class="row">
								<div class="form-group col-xs-4">
									<input style="height: 40px;" type="text" id="chatName" class="form-control" placeholder="이름" maxlength="20">
								</div>
							</div>
							<div class="row" style="height:90px">
								<div class="form-group col-xs-10">
									<textarea style="height:80px;" id="chatContent" class="form-control" placeholder="메시지를 입력하세요" maxlength="100"></textarea>
								</div> 
							</div>
							<div class="form-group col-xs-2">
								<button type="button" class="btn btn-default pull-right" onclick="submitFunction()">전송</button>
								<div class="cleayfix"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>