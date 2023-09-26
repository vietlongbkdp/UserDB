package controller;

import DAO.ProductDAO;
import DAO.ProductStorageDAO;
import DAO.StorageDAO;
import service.ProductService;
import service.ProductStorageService;
import service.StorageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name ="ProductController", value = "/product")
public class ProductController extends HttpServlet {
    private ProductDAO productDAO;
    private StorageDAO storageDAO;
    private ProductStorageDAO productStorageDAO;
    private ProductService productService;
    private StorageService storageService;
    private ProductStorageService productStorageService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
//            case "create" :
//                showCreate(req, resp);
//                break;
//            case "delete" :
//                delete(req, resp);
//                break;
//            case "restore" :
//                showRestore(req, resp);
//                break;
//            case "restored" :
//                restore(req, resp);
//                break;
//            case "edit" :
//                showEdit(req, resp);
//                break;
            default:
                showList(req, resp);
        }
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("products", productDAO.getAllProductD());
        req.getRequestDispatcher("product.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
//                case "create" :
//                    showCreate(req, resp);
//                    break;
//                case "delete" :
//                    delete(req, resp);
//                    break;
//                case "restore" :
//                    showRestore(req, resp);
//                    break;
//                case "restored" :
//                    restore(req, resp);
//                    break;
//                case "edit" :
//                    showEdit(req, resp);
//                    break;
//                default:
//                    showList(req, resp);
        }
    }

    @Override
    public void init() throws ServletException {
        productDAO = new ProductDAO();
        storageDAO = new StorageDAO();
        productStorageDAO = new ProductStorageDAO();
        productService = new ProductService();
        storageService = new StorageService();
        productStorageService = new ProductStorageService();
    }
}
