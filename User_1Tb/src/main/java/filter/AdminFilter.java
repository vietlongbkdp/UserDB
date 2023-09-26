package filter;

import model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter("/admin/*")
public class AdminFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest)servletRequest).getSession();
        User user = (User) session.getAttribute("user");
        if(user == null){
            ((HttpServletResponse)servletResponse).sendRedirect("/login");
            return;
        }
        if(!user.getRole().getRoleName().equals("admin")){
            ((HttpServletResponse)servletResponse).sendRedirect("/login");
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);

    }
    }

