
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Código</th>
                    <th>Nombre</th>
                    <th>Edad</th>
                    <th>Sexo</th>
                    <th>Sueldo</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    ArrayList <Empleado> lista = (ArrayList<Empleado>)request.getAttribute("lista");
                    for(int i = 0; i < lista.size(); i++){
                        Empleado empleado = lista.get(i);
                    
                %>
                <tr>
                    <td><%= empleado.getCodigo() %></td>
                    <td><%= empleado.getNombre() %></td>
                    <td><%= empleado.getEdad() %></td>
                    <td><%= empleado.getSexo() %></td>
                    <td><%= empleado.getSueldo() %>.</td>
                </tr>
                <%  
                    }
                %>
            </tbody>
        </table>

    </body>
</html>
