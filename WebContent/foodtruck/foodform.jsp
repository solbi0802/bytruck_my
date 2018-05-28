<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<title>foodform.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<style>
.col-lg-12 {
	padding-top: 50px;
}

.board {
	padding-top: 80px;
}

#cancel, #register {
	margin-right: 10px;
}

.result {
	display: none;
}
</style>
</head>
<script>
	$(function() {
		$('a[id=cancel]').click(function() {
			alert("취소하시면 작성하신 글이 사라지게 됩니다. \n 정말 작성 취소하시겠습니까?");
		});
	});
</script>
<body>
	<div class="menu_bar">
		<div class="row">
			<div class="container-fluid">
				<div class="col-lg-12">
					<header>
						<%@include file="/template/header.jsp"%>
					</header>
				</div>
			</div>
		</div>
	</div>
	<div class="board">
		<div class="row">
			<div class="container-fluid">
				<div class="col-lg-offset-2 col-lg-8 col-lg-offset-2">
					<!-- BASIC INPUT -->
					<div class="panel panel-default">
						<div class="panel-heading">
							<h2 class="panel-title section-heading no-margin">푸드트럭 등록</h2>
						</div>
						<div class="panel-body">
							<div class="form-horizontal">
								<div class="form-group">
									<label class="col-md-2 control-label">제목</label>
									<div class="col-md-10">
										<input type="text" class="form-control"
											placeholder="제목을 입력하세요.">
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-2 control-label">날짜</label>
									<div class="col-md-10">
										<span class="input-group-addon"><i
											class="fa fa-calendar"></i></span> <input type="date"
											class="form-control" id="bitrhday"
											placeholder="Birthday(ex.YYYY/MM/DD)">
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-2 control-label">비밀번호</label>
									<div class="col-md-10">
										<input type="password" class="form-control">
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-2 control-label">상세설명</label>
									<div class="col-md-10">
										<textarea class="form-control" placeholder="내용을 입력하세요."
											rows="10"></textarea>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-2 control-label">장소</label>
									<div class="col-md-10">
										<select class="form-control">
											<option value="cheese">서울특별시</option>
											<option value="tomatoes">광주광역시</option>
											<option value="mozarella">대구광역시</option>
											<option value="mushrooms">대전광역시</option>
											<option value="pepperoni">부산광역시</option>
											<option value="onions">울산광역시</option>
											<option value="onions">인천광역시</option>
										</select><br>
										<div class="result"></div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-2 control-label">파워링크</label>
									<div class="col-md-10">
										<div class="radio">
											<label> <input type="radio" name="radio"
												value="radio1">신청
											</label>
										</div>
										<div class="radio">
											<label> <input type="radio" name="radio"
												value="radio2">신청 안 함
											</label>
										</div>
									</div>
								</div>
								<div class="form-group">
									<label for="exampleInputFile" class="col-md-2 control-label">첨부파일</label>
									<div class="col-md-10">
										<input type="file" id="exampleInputFile">
										<p class="help-block">
											<em>첨부파일을 선택하세요.</em>
										</p>
									</div>
								</div>
							</div>
							<div
								class="button-group col-lg-offset-2 col-lg-8 col-lg-offset-2">
								<a class="btn btn-success col-lg-4 col-lg-offset-1"
									id="register" href="<%=root %>/foodtruck/foodboard.jsp">등록</a> <a
									class="btn btn-danger col-lg-4 col-lg-offset-1" id="cancel"
									href="<%=root %>/foodtruck/foodboard.jsp">취소</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="foot">
		<div class="row">
			<div class="container-fluid">
				<div class="col-lg-12">
					<footer>
						<%@include file="/template/footer.jsp"%>
					</footer>
				</div>
			</div>
		</div>
	</div>
</body>
</html>