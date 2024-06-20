package org.example.lab9.servlets;
import jakarta.servlet.annotation.WebServlet;
import org.example.lab9.beans.usuario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.lab9.daos.UsuarioDao;

import java.io.IOException;
@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        usuario userLogueado = (usuario) httpSession.getAttribute("usuarioLogueado");

        if(userLogueado != null && userLogueado.getIdRol() > 0){

            if(request.getParameter("a") != null){//logout
                httpSession.invalidate();
            }
            response.sendRedirect(request.getContextPath());
        }else{
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String correo = request.getParameter("user");
        String password = request.getParameter("passwd");

        System.out.println("username: " + correo + " | password: " + password);
        UsuarioDao systemDao = new UsuarioDao();

        if(systemDao.validarUsuarioPassword(correo, password)){
            System.out.println("usuario y password válidos");
             usuario usuario = systemDao.getUsuarioCorreo(correo);
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("usuarioLogueado",usuario);
            response.sendRedirect(request.getContextPath());
            switch (usuario.getIdRol()){
                case 1:

                    System.out.println("Bienvenido usuario operativo");
                    break;
                case 2:
                    System.out.println("Bienvenido Admin");
                    break;
                case 3:
                    System.out.println("Bienvenido usuario operativo");
                    break;
                case 4:

                    System.out.println("Bienvenido Admin");
                    break;
            }



        }else{
            System.out.println("usuario o password incorrectos");
            request.setAttribute("err","Credenciales incorrectos");
            request.getRequestDispatcher("vistas/login.jsp").forward(request,response);
        }


    }
}
