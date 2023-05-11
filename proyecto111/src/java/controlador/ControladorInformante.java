/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import modelo.Conexion;
import modelo.DAOInformanteImplementacion;
import modelo.Informante;
import modelo.Robo;



@WebServlet(name = "ControladorInformante", urlPatterns = {"/ControladorInformante"})
public class ControladorInformante extends HttpServlet {

    private DAOInformanteImplementacion dInformante = new DAOInformanteImplementacion();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String tarea=request.getParameter("accion");
            
            switch(tarea){
                case "agregar": registrar(request, response);
                    break;
                case "Update": actualizar(request, response);
                    break;
                case "Eliminar": eliminar(request, response);
                    break;
                case "verificar": verificarUsuario(request, response);
            }
            
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

    
    private void registrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("txtNombre");
        String apellido = request.getParameter("txtApellido");
        String correo = request.getParameter("txtCorreo");
        String contraseña = request.getParameter("txtContraseña");
        String telefono = request.getParameter("txtTelefono");
        
        nombre = nombre.toUpperCase();
        apellido = apellido.toUpperCase();
        correo = correo.toUpperCase();
        contraseña = contraseña.toUpperCase();
        telefono = telefono.toUpperCase();
        
        Informante informante = new Informante(telefono, 0, nombre, apellido, correo, contraseña);
        
        boolean agregado = dInformante.registrar(informante);

        String mensaje = dInformante.getMensaje();

        response.sendRedirect(request.getContextPath() + "/frmInformante.jsp?mensaje=" + mensaje);
    }
    
    private void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        int id = Integer.parseInt(request.getParameter("Informante"));
        
        dInformante.eliminar(id);
        response.sendRedirect(request.getContextPath() + "/eliminarInformante.jsp?mensaje="+dInformante.getMensaje());
    }
    
    private void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        int id= Integer.parseInt(request.getParameter("Informante"));
        
        dInformante.modificar(id);
        
        response.sendRedirect(request.getContextPath() + "/frmInformante.jsp?mensaje="+dInformante.getMensaje());
    }

    private void verificarUsuario(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
            
        
        String correo = request.getParameter("txtCorreo");
        String contraseña = request.getParameter("txtContraseña");

        boolean encontrado = dInformante.verificar(correo, contraseña);
        
        if(encontrado){
            response.sendRedirect(request.getContextPath() + "/robosPorCiudad.jsp?mensaje="+dInformante.getMensaje());
        }
        else{
            
        }
        
    }
        
        
}
    
    

