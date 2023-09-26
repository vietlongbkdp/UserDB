package controller;

import DAO.RoleDAO;
import DAO.UserDAO;
import model.Role;
import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet(name = "AuthController", value = "/login")
public class AuthController extends HttpServlet {
    private UserService userService;
    private UserDAO userDAO;
    public RoleDAO roleDAO;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
//            case "login" :
//                login(req, resp);
//                break;
//            case "register" :
//                register(req, resp);
//                break;
//            case "forgotPassword" :
//                forgotPassword(req, resp);
//                break;
            default:
                loginView(req, resp);
        }
    }
    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO();
        roleDAO = new RoleDAO();
        userService = new UserService();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "login" :
                checkLogin(req, resp);
                break;
//            case "register" :
//                register(req, resp);
//                break;
//            case "forgotPassword" :
//                forgotPassword(req, resp);
//                break;
        }
    }
        private void checkLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password = req.getParameter("password");
        String userName = req.getParameter("userName");
        User anonimus = userDAO.getUserByUserName(userName);
        try {
            boolean kt = userDAO.checkLogin(userName, password);
            if(kt){
                HttpSession session = req.getSession();
                session.setAttribute("user", anonimus);
                if (anonimus.getRole().getId() == 1){
                    resp.sendRedirect("/user");
                } else if (anonimus.getRole().getId() == 2) {
                    resp.sendRedirect("/user");
                }else resp.sendRedirect("/user");
                resp.sendRedirect("/user");
            }else{
                req.setAttribute("messenger", "User Name or Password is incorrect!! Please try again!");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }

    }
    private void loginView(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }



}
