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
		if (foodJson.hasOwnProperty(key)) {  // ��ü ��ü�� Ű���� Ȯ��
            console.log(foodJson[key]); // Ű�� ���� content ���ڿ��� �߰�
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