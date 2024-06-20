<%@page import="java.util.ArrayList" %>
<%@ page import="org.example.lab9.beans.usuario" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:useBean id="listaUsuarios" type="java.util.ArrayList<org.example.lab9.beans.usuario>" scope="request"/>
<jsp:useBean id="usuarioLogueado" class="org.example.lab9.beans.usuario" type="usuario" scope="session" />
<!DOCTYPE html>
<html>
<head>
    <title>Lista Usuarios</title>
    <jsp:include page="../includes/nav.jsp"></jsp:include>
</head>
<body>
<div class='container'>

    <div class="row mb-5 mt-4">
        <div class="col-md-7">
            <h1>Lista de usuarios</h1>
        </div>
    </div>
    <% if (request.getParameter("msg") != null) {%>
    <div class="alert alert-success" role="alert"><%=request.getParameter("msg")%>
    </div>
    <% } %>
    <% if (request.getParameter("err") != null) {%>
    <div class="alert alert-danger" role="alert"><%=request.getParameter("err")%>
    </div>
    <% } %>

    <table class="table">
        <thead>
        <tr>
            <th>#</th>
            <th>Usuario</th>
            <th>Telefono</th>
            <th>ID Rol</th>
            <th>ID Licencia</th>
            <% if(usuarioLogueado != null && usuarioLogueado.getIdUsuario() > 0) {%>
            <th></th>
            <th></th>
            <% } %>
        </tr>
        </thead>
        <tbody>
        <%
            for (usuario u : listaUsuarios) {
        %>
        <tr>
            <td><%=u.getIdUsuario()%>
            </td>
            <td><%= u.getNombres() + " " + u.getApellidos()%>
            </td>
            <td><%= u.getTelefono()%>
            </td>
            <td><%=u.getIdRol()%>
            </td>
            <td><%=u.getIdLicencia()%>
            </td>


        </tr>

        </tbody>
    </table>

</div>
</body>
</html>
