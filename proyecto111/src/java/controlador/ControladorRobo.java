package controlador;

import com.google.gson.Gson;
import modelo.*;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author sebas
 */
@WebServlet(name = "ControladorRobo", urlPatterns = {"/ControladorRobo"})
public class ControladorRobo extends HttpServlet {

    private Datos_Robo dRobo = new Datos_Robo();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            
            String tarea=request.getParameter("accion");
            
            switch(tarea){
                case "agregar": registrar(request, response);
                    break;
                case "Update": actualizar(request, response);
                    break;
            }
            /*
            String tarea = request.getParameter("accion");
            switch (tarea) {
                case "Registar": registrar(request, response);
                    break;
            }
            */
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void registrar2(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String ciudad = request.getParameter("txtCiudad");
        String barrio = request.getParameter("txtBarrio");
        ciudad = ciudad.toUpperCase();
        barrio = barrio.toUpperCase();

        Robo robo = new Robo(ciudad, barrio,0);

        boolean agregado = dRobo.agregarRobo(robo);

        PrintWriter out= response.getWriter();
        String json=new Gson().toJson(agregado);
        out.print(json);
        
    }
    
    private void registrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String ciudad = request.getParameter("txtCiudad");
        String barrio = request.getParameter("txtBarrio");
        ciudad = ciudad.toUpperCase();
        barrio = barrio.toUpperCase();

        Robo robo = new Robo(ciudad, barrio,0);

        boolean agregado = dRobo.agregarRobo(robo);

        String mensaje = dRobo.getMensaje();

        response.sendRedirect(request.getContextPath() + "/frmCiudad.jsp?mensaje=" + mensaje);
    }
    
    private void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        int id= Integer.parseInt(request.getParameter("Ciudad"));
        
        dRobo.aumentarRobo(id);
        
        response.sendRedirect(request.getContextPath() + "/frmRobo.jsp?mensaje="+dRobo.getMensaje());
    }

}