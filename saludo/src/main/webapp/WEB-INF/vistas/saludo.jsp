<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Saludo</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <h1>¡${saludo}, ${nombre}!</h1>
    <p>Bienvenido/a a la aplicación de ${centro}.</p>
    <p>Contexto: <code>${pageContext.request.contextPath}</code></p>
    <p>Servidor: <code>${pageContext.servletContext.serverInfo}</code></p>
    <p><a href="index.html">Volver</a></p>
</body>
</html>
