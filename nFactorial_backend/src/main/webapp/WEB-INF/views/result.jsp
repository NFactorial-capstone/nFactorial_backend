<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<script>
	var foodJson = ${foodJson};
	var resultDiv = document.getElementById('result');
	var content = "";
	for(var key in foodJson) {
		if (foodJson.hasOwnProperty(key)) {  // 객체 자체의 키인지 확인
            console.log(foodJson[key]); // 키와 값을 content 문자열에 추가
        }
	}
	console.log(content);
</script>
</head>
<body>
	<div id="result">
	
	</div>
</body>
</html>