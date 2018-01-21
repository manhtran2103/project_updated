/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import dao.Users_SessionBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import model.Users;
import org.json.JSONException;
import org.json.JSONObject;
import tools.MD5;


/**
 * REST Web Service
 *
 * @author manhtran
 */
@Path("api")
public class RestResource {

    
   

    @EJB
    private Users_SessionBean users_SessionBean ;

    @Context
    private UriInfo context;
   
    public RestResource() {
        
    }
//
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public Users getJson() {
//      users_SessionBean.insert(new Users(new Date().getTime(), "asas", "asas", "asas"));
//      return users_SessionBean.getUserByName("manh").get(0);
//      
//    }
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {
      return "ok";
    }
    

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("login")
    public String login(String input) throws JSONException {  
            JSONObject data = new JSONObject(input);
            Users user = users_SessionBean.getUserByName_Password(
                    data.getString("user_name"), 
                    MD5.encryption(data.getString("user_password")));
            if(user != null){
                return user.getUserName();
            } else{
                return "user or password invalid";
            }  
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("signup")
    public String signup(String input) throws JSONException {
       JSONObject data = new JSONObject(input);
       String user_name = data.getString("user_name");
       String user_email = data.getString("user_email");
       String user_pass = MD5.encryption(data.getString("user_password"));
       System.out.println(user_name + ", " + user_email + " , " + user_pass);
       if(users_SessionBean.getUserByName(user_name).isEmpty()){
           users_SessionBean.insert(new Users(new Date().getTime(), user_name, user_email, user_pass));
           return "Success"; 
       } else{
           return "User existed";
       }   
    }
    
//    @POST
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("update")
//    public String update(@FormParam("id") long id, @FormParam("user_name") String user_name,
//            @FormParam("user_email") String user_email, @FormParam("user_pass") String user_pass) {
//       usersFacade.edit(new Users(id, user_name, user_email, user_pass));
//       return "done";
//       
//    }
//    
//    @POST
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("remove")
//    public String remove(@FormParam("id") long id, @FormParam("user_name") String user_name,
//            @FormParam("user_email") String user_email, @FormParam("user_pass") String user_pass) {
//       usersFacade.remove(new Users(id, user_name, user_email, user_pass));
//       return "done";
//       
//    }
//    
//   
//    @PUT
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void putJson(String content) {
//    }
//    
//    @POST
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("select_all")
//    public List<Users> getContactFromID() {
//        List<Users> users = usersFacade.findAll();
//        return users;
//                
//                
//    }

    

   
    
}
