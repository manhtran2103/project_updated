/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import dao.Like_SessionBean;
import dao.Media_SessionBean;
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
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import model.LikeUsers;
import model.Media;
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
    @EJB
    private Media_SessionBean media_SessionBean;
    @EJB
    private Like_SessionBean like_SessionBean;

    @Context
    private UriInfo context;
   
    public RestResource() {
        
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
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("media")
    public List<Media> getListMedia(){
       return media_SessionBean.getListMedia();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("user")
    public String getUserName(String input) throws JSONException{
        JSONObject data = new JSONObject(input);
        System.out.println(data.getString("user_id"));
        long user_id = Long.parseLong(data.getString("user_id"));
        return users_SessionBean.getUserById(user_id).getUserName(); 
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/media/{id}")
    public Media getMediaById(@PathParam("id") long id){
       return media_SessionBean.getMediaById(id);
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("like")
    public String likeFunction(String input) throws JSONException{
       JSONObject data = new JSONObject(input);
       String user_name = data.getString("user_name");
       long media_id = Long.parseLong(data.getString("media_id"));
       long user_id = users_SessionBean.getUserByName(user_name).get(0).getUserId();
       System.out.println(media_id + ", " + user_id);
       like_SessionBean.insert(new LikeUsers(user_id, media_id));
       return "success";
    }
 
}
