package controller.site;

import com.google.gson.Gson;
import com.sun.org.apache.xerces.internal.xs.StringList;
import controller.BaseRoutes;
import controller.site.api.UsersApi;
import dao.Factory;
import model.Groups;
import model.TrueCyst;
import model.falseCyst;
import spark.ModelAndView;
import utils.*;
import utils.template.VelocityTemplateEngine;

import javax.servlet.MultipartConfigElement;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import static java.lang.String.valueOf;
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
            ArrayList <Double> border = Borders.borders();
            Double [][] mas = modelA1.modelA1(border);
            ArrayList<Double> comparisonOfVariables = CalculationMethodBaies.procent(border,as1,as2,as3,as4,mas);

            if(comparisonOfVariables.get(0)>comparisonOfVariables.get(1)){
                double sum1 = comparisonOfVariables.get(0)/(comparisonOfVariables.get(0)+comparisonOfVariables.get(1));
                model.put("A5","Внутрипротоковая киста");
            }else {
                double sum2 = comparisonOfVariables.get(1)/(comparisonOfVariables.get(0)+comparisonOfVariables.get(1));
                model.put("A5","Внепротоковая киста");
            }

            model.put("A1", as1);
            model.put("A2", as2);
            model.put("A3", as3);
            model.put("A4", as4);

            return new ModelAndView(model, "/public/baies.html");
        }, new VelocityTemplateEngine());

       post(ROOT + "getresult", (request, response) -> {

        request.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement("/temp"));
        try (InputStream is = request.raw().getPart("upload").getInputStream()) {
            File file = StreamUtil.stream2file(is);
            String strFromFile = FileWorker.read(file);
            HashMap<String, Object> model = new HashMap<>();
            Double as1 =  request.session().attribute("one");
            Double as2 =  request.session().attribute("two");
            Double as3 =  request.session().attribute("three");
            Double as4 =  request.session().attribute("four");
            ArrayList <Double> border = Borders.borders();
            Double [][] mas = modelA1.modelA1(border);
            ArrayList<Double> comparisonOfVariables = CalculationMethodBaies.procent(border,as1,as2,as3,as4,mas);

            if(comparisonOfVariables.get(0)>comparisonOfVariables.get(1)){
                double sum1 = comparisonOfVariables.get(0)/(comparisonOfVariables.get(0)+comparisonOfVariables.get(1));
                model.put("A5","Внутрипротоковая киста");
                Factory.getInstance().getGenericRepositoryInterface().addObject(new TrueCyst(strFromFile,as1,as2,as3,as4));
            }else {
                double sum2 = comparisonOfVariables.get(1)/(comparisonOfVariables.get(0)+comparisonOfVariables.get(1));
                model.put("A5","Внепротоковая киста");
                Factory.getInstance().getGenericRepositoryInterface().addObject(new falseCyst(strFromFile,as1,as2,as3,as4));

            }
            System.out.println(strFromFile);


            return new ModelAndView(model, "/public/baies.html");
        }
//            catch (Exception e) {
//                log.log(SEVERE, "Exception: ", e);
//                return e;
//            }

    }, new VelocityTemplateEngine());

        post(ROOT + "getfile", (request, response) -> {

            request.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement("/temp"));
            try (InputStream is = request.raw().getPart("upload").getInputStream()) {
                // Use the input stream to create a file
                HashMap<String, Object> model = new HashMap<>();
                File file = StreamUtil.stream2file(is);
                String strFromFile = FileWorker.read(file);
                Double[][] massive = parseString.read(strFromFile);
                double A2 = calculationA2.calcA2(massive);
                double A1 = calculationA1.calcA1(massive);
                double A3 = calculationA3.calcA3(massive);
                double A4 = calculationA4.calcA4(massive);
                Gson gson = new Gson();

                String json = gson.toJson(massive);
                model.put("mas",json);


                request.session().attribute("one", A1);
                request.session().attribute("two", A2);
                request.session().attribute("three", A3);
                request.session().attribute("four", A4);

                return new ModelAndView(model, "/public/dataDownload.html");
            }
//            catch (Exception e) {
//                log.log(SEVERE, "Exception: ", e);
//                return e;
//            }

        }, new VelocityTemplateEngine());




    }

}
