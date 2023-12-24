
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Empleado;
import util.ConexionBD;

// 52 min - Desarrollo Web Integrado Semana 7

@WebServlet(name = "EmpleadoServlet", urlPatterns = {"/Empleado"})
public class EmpleadoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String op = request.getParameter("opcion");
        ConexionBD conexion = new ConexionBD();
        
        if (op.equals("listar")) {
            try {
                PreparedStatement ps = conexion.conexionBD().prepareStatement("SELECT * FROM empleado");
                ResultSet rs = ps.executeQuery();
                
                ArrayList<Empleado> lista = new ArrayList<>();
                while (rs.next()) {                    
                    Empleado empleado = new Empleado();
                    empleado.setCodigo(rs.getString(1));
                    empleado.setNombre(rs.getString(2));
                    empleado.setEdad(rs.getInt(3));
                    empleado.setSexo(rs.getString(4));
                    empleado.setSueldo(rs.getDouble(5));
                    lista.add(empleado);
                }
                request.setAttribute("lista", lista);
                request.getRequestDispatcher("empleadoSel.jsp").forward(request, response);
            } catch (Exception e) {
            }
        } else if (op.equals("insertar")) {
            
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
