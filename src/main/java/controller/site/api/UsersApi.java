package controller.site.api;

import controller.BaseRoutes;
import dao.Factory;
import model.Users;
import spark.utils.IOUtils;
import utils.*;

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
               Double[][] massive = parseString.read(strFromFile);
//                int max_index = (int) maximum.max(massive);
//                double firstPoint = massive[max_index][1];
//                double secondPoint = massive[max_index][0];
//                int start_index = (int) start.start(massive);
//                double thirdPoint = massive[start_index][1];
//                double fourthPoint =massive[start_index][0];
//                double nullPoint = massive[0][1];
//                System.out.println("Max_V : " + firstPoint + "  Max_T : " + secondPoint);
//                System.out.println("Start_V : " + thirdPoint + "  Start_T : " + fourthPoint);
//                System.out.println("null_V : " + nullPoint);
                double A2 = calculationA2.calcA2(massive);
                System.out.println(A2);



                return "File uploaded";
            }
            catch (Exception e) {
                log.log(SEVERE, "Exception: ", e);
                return e;
            }

        });


    }
}
