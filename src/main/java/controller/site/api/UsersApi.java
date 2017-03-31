package controller.site.api;

import controller.BaseRoutes;
import dao.Factory;
import model.Users;
import spark.utils.IOUtils;
import utils.FileWorker;
import utils.StreamUtil;
import utils.parseString;

import javax.servlet.MultipartConfigElement;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.InputStream;

import static java.lang.System.*;
import static java.util.logging.Level.*;
import static spark.Spark.post;

public class UsersApi extends BaseRoutes {

    private static Logger log = Logger.getLogger(UsersApi.class.getName());

    private final String ROOT = "/api/";

    public void routes() {

        post(ROOT + "login", (request, response) -> {
            try {
                String login =request.queryParams("login");
                Users users = new Users(login, request.queryParams("password"));
                String responseV = Factory.getInstance().getUsersDAO().loginUsers(users);
                if(responseV.equals("Error2")||responseV.equals("Error3")){
                    request.session().attribute("username", null);
                    response.redirect("/admin/");
                    return responseV;
                }else{
                    request.session().attribute("username", login);
                    response.redirect("/admin/");
                    return responseV;
                }
            } catch (Exception e) {
                log.log(SEVERE, "Exception: ", e);
                return e;
            }
        });

        post(ROOT + "getfile", (request, response) -> {

            request.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement("/temp"));
            try (InputStream is = request.raw().getPart("upload").getInputStream()) {
                // Use the input stream to create a file

                File file = StreamUtil.stream2file(is);
                String strFromFile = FileWorker.read(file);
                String rep = strFromFile.replace(",",".");

                String[] db = rep.split("(   |\n)");

                int len = ((db.length)/3)-1;
                String [] mas= new String [db.length];
                int k=0;
                for(int i=3;i<mas.length;i++) {


                    if (db[i].length() < 18) {
                        mas[k] = db[i];
                        k++;
                    }

                }

                Double [] mas2= new Double[db.length];
                int j=0;
                for(int i=0;i<mas.length;i++){
                    if(mas[i]!=null){
                        mas2[i] = Double.parseDouble(mas[i]);
                        j++;
                    }


                    System.out.println(mas2[i]);
                }



                return "File uploaded";
            }
            catch (Exception e) {
                log.log(SEVERE, "Exception: ", e);
                return e;
            }

        });


    }
}
