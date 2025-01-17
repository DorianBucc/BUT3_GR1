<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Page de connexion</title>
	<%--Résolution du bug non bloquant Nr_3 - liaison correct du css--%>
	<link rel="stylesheet" href="../style/style.css" />
</head>

<body>
	<h1>Login :</h1>
	<s:form name="myForm" action="controller.Connect.login.action"
		method="POST">
		<s:textfield label="Code user" name="userCde" />
		<s:password label="Password" name="userPwd" />
		<s:submit name="submit" />
	</s:form>
		<s:form name="myFormRetour" action="retourAccueil" method="POST">
			<s:submit name="Retour" value="Retour à l'accueil" />
		</s:form>
</body>
<jsp:include page="/JSP/Footer.jsp" />
</html>