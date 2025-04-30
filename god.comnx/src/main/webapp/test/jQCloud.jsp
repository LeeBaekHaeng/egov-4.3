<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2025-04-10_이백행_워드클라우드 jQCloud 기술검토</title>

<script
	src="<c:url value="/js/egovframework/com/cmm/jquery-1.12.4.min.js" />"></script>

<script src="<c:url value="/test/jQCloud-2.0.3/dist/jqcloud.min.js" />"></script>

<link rel="stylesheet"
	href="<c:url value="/test/jQCloud-2.0.3/dist/jqcloud.min.css" />">

</head>
<body>

	<h1>2025-04-10_이백행_워드클라우드 jQCloud 기술검토</h1>

	<div id="wordcloud" style="width: 500px; height: 350px;"></div>

	<script type="text/javascript">
		const word_list = [ {
			text : "jQuery",
			weight : 13
		}, {
			text : "워드클라우드",
			weight : 10
		}, {
			text : "JavaScript",
			weight : 9
		}, {
			text : "프론트엔드",
			weight : 8
		}, {
			text : "시각화",
			weight : 6
		}, {
			text : "데이터",
			weight : 5
		}, {
			text : "클라우드",
			weight : 5
		}, {
			text : "HTML",
			weight : 4
		}, {
			text : "CSS",
			weight : 3
		}, {
			text : "시멘틱",
			weight : 2
		} ];

		$(function() {
			$("#wordcloud").jQCloud(word_list);
		});
	</script>

</body>
</html>