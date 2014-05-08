<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>
<head>
	<title>FouR Guys!</title>
	
	<link href="${pageContext.request.contextPath}/resources/css/smoothness/jquery-ui-1.10.4.custom.css" rel="stylesheet">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/fgs-base.css">
	
	<script src="${pageContext.request.contextPath}/resources/js/jquery-1.10.2.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery-ui-1.10.4.js"></script>
	
	<script src="${pageContext.request.contextPath}/resources/js/fgs-base.js"></script>
</head>
<body>
    <div class="root-page">
        <tiles:insertAttribute name="header" />
        <tiles:insertAttribute name="main-menu" />
        <tiles:insertAttribute name="content" />
        <tiles:insertAttribute name="footer" />
    </div>
</body>
</html>
