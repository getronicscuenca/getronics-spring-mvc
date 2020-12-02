<html>
<head>
	<title>Página de error de Departamento</title>

<style>
.tituloError, .mensajeError {
    border: 1px solid;
    margin: 10px 0px;
    padding:15px 10px 15px 50px;
    background-repeat: no-repeat;
    background-position: 10px center;
    font-family:Arial, Helvetica, sans-serif;
    font-size:13px;
    text-align:left;
    width:auto;
}
.tituloError {
    color: #00529B;
    background-color: #BDE5F8;
    background-image: url('imagenes/info.jpg');
}
.mensajeError {
    color: #4F8A10;
    background-color: #DFF2BF;
    background-image:url('imagenes/correcto.JPG');
}

</style>
</head>

<body>
<div class="tituloError"><b>Mensaje de error</b></div>
<div class="mensajeError"><b>${mensaje}</b></div>

</body>
</html>
