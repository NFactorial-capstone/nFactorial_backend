<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Select Your Exercise</h1>
    <div class="exercise_form">
        <form action="/exercise/add" name="exercise_form" method="post">
            <label for="exercise">Select Exercise:</label>
            <select name="exercise" id="exercise">
                <option value="복부">복부</option>
                <option value="이두근">이두근</option>
                <option value="삼두근">삼두근</option>
                <option value="하체">하체</option>
                <option value="가슴">가슴</option>
                <option value="어깨">어깨</option>
                <option value="등">등</option>
                <option value="전완근">전완근</option>
            </select><br>
            <input type="submit" value="Submit">
            <input type="reset" value="Reset">
        </form>
    </div>
</body>
</html>