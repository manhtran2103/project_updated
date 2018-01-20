/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.Users_SessionBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Users;
import org.json.JSONObject;

/**
 *
 * @author manhtran
 */
public class LoginServlet extends HttpServlet {
    
    @EJB
    Users_SessionBean users_SessionBean;
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       PrintWriter out = response.getWriter();
        System.out.println(request.getCharacterEncoding());
//       JSONObject data = new JSONObject(request);
//       
//       Users u = null;
//        try {
//            String user_name = data.getString("user_name");
//            String user_password = data.getString("user_password");
//            System.out.println(user_name + " - " + user_password);
//            u = users_SessionBean.getUserByName_Password(user_name, user_password);
//            System.out.println(u);
//        } catch (Exception e) {
//        }
//         if(u == null){
//          out.print("username or password invalid");
//       } else{
//           response.sendRedirect("/ex3/home.html");
//       }
       
    }
}

