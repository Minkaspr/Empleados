

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Consulta por genero</h2>
        <form action="Empleado" method="get">
            Seleccione Genero:
            <label>
                Masculino
                <input type="radio" name="radGen" value="M"/>
            </label>
            <label>
                Femenino
                <input type="radio" name="radGen" value="F"/>
            </label>
            <input type="hidden" name="opcion" value="consultaGen"/>
            <input type="submit" value="Consultar Empleado"/>
        </form>
    </body>
</html>
