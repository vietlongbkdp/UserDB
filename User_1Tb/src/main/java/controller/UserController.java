package controller;

import DAO.RoleDAO;
import DAO.UserDAO;
import model.EGender;
import model.Role;
import model.User;
import service.RoleService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@WebServlet(name = "UserController", value = "/user")
public class UserController extends HttpServlet {
    private UserService userService;
    private UserDAO userDAO;
    private RoleDAO roleDAO;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create" :
                showCreate(req, resp);
                break;
            case "delete" :
                delete(req, resp);
                break;
            case "restore" :
                showRestore(req, resp);
                break;
            case "restored" :
                restore(req, resp);
                break;
            case "edit" :
                showEdit(req, resp);
                break;
            default:
                showList(req, resp);
        }
    }


    private void showEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idEdit = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("user", userDAO.getUserById(idEdit));
        req.setAttribute("genders", EGender.values());
        req.setAttribute("roles", roleDAO.getAllRole());
        req.getRequestDispatcher("edit.jsp").forward(req, resp);
    }

    private void restore(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if(req.getParameter("id")==null){
        }else {
            String[] listStrIdRestore = req.getParameter("id").split("_");
            List<Integer> listIdRestore = new ArrayList<>();
            for (String s : listStrIdRestore) {
                listIdRestore.add(Integer.parseInt(s));
            }
            userDAO.restoreListId(listIdRestore);
            resp.sendRedirect("/user?message=Restore!");
        }
    }

    private void showRestore(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setAttribute("users", userDAO.getAllUserShow(true));
        req.getRequestDispatcher("restore.jsp").forward(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
            int idDelete = Integer.parseInt(req.getParameter("id"));
            userDAO.deleteUserById(idDelete);
            resp.sendRedirect("/user?message=Deleted!");
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setAttribute("users", userDAO.getAllUserShow(false));
            req.getRequestDispatcher("user.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create" :
                create(req, resp);
                break;
            case "update" :
                edit(req, resp);
                break;
        }
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String lastName = req.getParameter("lastName");
        String firstName = req.getParameter("firstName");
        String userName = req.getParameter("userName");
        String email = req.getParameter("email");
        String dob = req.getParameter("dob");
        String gender = req.getParameter("gender");
        int role = Integer.parseInt(req.getParameter("role"));
        String password = req.getParameter("password");
        userDAO.editUser(userService.createUser(lastName, firstName, userName, email, dob, gender, role, password), id);
        resp.sendRedirect("/user?message=Edited!");
    }
    private void create(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String lastName = req.getParameter("lastName");
        String firstName = req.getParameter("firstName");
        String userName = req.getParameter("userName");
        String email = req.getParameter("email");
        String dob = req.getParameter("dob");
        String gender = req.getParameter("gender");
        int role = Integer.parseInt(req.getParameter("role"));
        String password = req.getParameter("password");
        userDAO.createUser(userService.createUser(lastName, firstName, userName, email, dob, gender, role, password));
        resp.sendRedirect("/user?message=Created!");
    }

    private void showCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("genders", EGender.values());
        req.setAttribute("roles", roleDAO.getAllRole());
        req.getRequestDispatcher("create.jsp").forward(req, resp);
    }

    @Override
    public void init() throws ServletException {
        userService = new UserService();
        userDAO = new UserDAO();
        roleDAO = new RoleDAO();

    }
}
