package controller.site;

import com.sun.org.apache.xerces.internal.xs.StringList;
import controller.BaseRoutes;
import controller.site.api.UsersApi;
import dao.Factory;
import model.Groups;
import spark.ModelAndView;
import utils.*;
import utils.template.VelocityTemplateEngine;

import javax.servlet.MultipartConfigElement;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import static spark.Spark.get;
import static spark.Spark.post;


public class SiteRoutes extends BaseRoutes {
    private static Logger log = Logger.getLogger(SiteRoutes.class.getName());

    private final String ROOT = "/";

    private void initRoutes(){
        new UsersApi();
    }

    @Override
    public void routes() {
        initRoutes();
        get(ROOT, (request, response) -> {
            HashMap<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "/public/index.html");
        }, new VelocityTemplateEngine());

        get(ROOT+"getresult", (request, response) -> {
            HashMap<String, Object> model = new HashMap<>();

           Double as1 =  request.session().attribute("one");
            Double as2 =  request.session().attribute("two");
            Double as3 =  request.session().attribute("three");
            Double as4 =  request.session().attribute("four");

            model.put("A1", as1);
            model.put("A2", as2);
            model.put("A3", as3);
            model.put("A4", as4);

            return new ModelAndView(model, "/public/baies.html");
        }, new VelocityTemplateEngine());

        post(ROOT + "getfile", (request, response) -> {

            request.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement("/temp"));
            try (InputStream is = request.raw().getPart("upload").getInputStream()) {
                // Use the input stream to create a file
                HashMap<String, Object> model = new HashMap<>();
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
                double A1 = calculationA1.calcA1(massive);
                double A3 = calculationA3.calcA3(massive);
                double A4 = calculationA4.calcA4(massive);

                request.session().attribute("one", A1);
                request.session().attribute("two", A2);
                request.session().attribute("three", A3);
                request.session().attribute("four", A4);

//                model.put("A1", A1);
//                model.put("A2", A2);
//                model.put("A3", A3);
//                model.put("A4", A4);

                return new ModelAndView(model, "/public/dataDownload.html");
            }
//            catch (Exception e) {
//                log.log(SEVERE, "Exception: ", e);
//                return e;
//            }

        }, new VelocityTemplateEngine());



    }

}
