<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="utf-8">
<head>
	<meta charset="uft-8" />
	<title>summernote</title>
	<!--  부트스트랩과 제이쿼리 라이브러리를 사용하기 위한 선언  -->
	<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
	<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.js"></script> 
	<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
	
	<!-- summernote의 스타일시트와 자바스크립트을 사용하기 위한 선언 -->
	<link href="../dist/summernote.css" rel="stylesheet">
	<script src="../dist/summernote.js"></script>
    
	<script type="text/javascript">
        /* summernote에서 이미지 업로드시 실행할 함수 */
	 	function sendFile(file, editor) {
            // 파일 전송을 위한 폼생성
	 		data = new FormData();
	 	    data.append("uploadFile", file);
	 	   // alert(data);
	 	    $.ajax({ // ajax를 통해 파일 업로드 처리
	 	        data : data,
	 	        type : "POST",
	 	        url : "http://localhost:8080/bytruck/adboard/summernote_imageUpload.jsp",
	 	        cache : false,
	 	        contentType : false,
	 	        processData : false,
	 	        success : function(data) { // 처리가 성공할 경우
                    // 에디터에 이미지 출력
                    alert("성공????")	;
	 	        	$(editor).summernote('editor.insertImage', data.url);
	 	        }, error : function(e) {alert("에러 :::: " + e);}
	 	    });
	 	}
	</script>
</head>
<body>
	<h1>summernote</h1>
	<form name="writeForm" action="./summernote_insert.jsp" method="post">
		<textarea id="summernote">Hello Summernote</textarea>
		</form>
        <script>
            $(document).ready(function() {
                $('#summernote').summernote({ // summernote를 사용하기 위한 선언
                    height: 400,
					callbacks: { // 콜백을 사용
                        // 이미지를 업로드할 경우 이벤트를 발생
					    onImageUpload: function(files, editor, welEditable) {
						    sendFile(files[0], this);
						}
					}
				});
			});
		</script>
</body>
</html>