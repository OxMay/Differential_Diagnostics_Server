package controller.site.admin;

import com.google.gson.Gson;
import controller.BaseRoutes;
import controller.site.admin.api.*;
import dao.Factory;
import model.*;
import spark.ModelAndView;
import utils.*;
import utils.template.VelocityTemplateEngine;

import javax.servlet.MultipartConfigElement;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

import static spark.Spark.*;

public class AdministrationRoutes extends BaseRoutes {

    private static Logger log = Logger.getLogger(AdministrationRoutes.class.getName());

    private final String ROOT = "/admin/";

    private void initRoutes(){
    }

    @Override
    public void routes() {
        initRoutes();

        before("/admin/*", (request, response) -> {
            if(request.session().attribute("username") == null) {
                response.redirect("/authorization");
            }else{
                if(!request.session().attribute("username").equals("admin")){
                    response.redirect("/authorization");
                }
            }
        });

        get(ROOT, (request, response) -> {
            return new ModelAndView(new HashMap<>(), "/public/admin/index.html");
        }, new VelocityTemplateEngine());


        get(ROOT + "graphicsOfModes", (request, response) -> {
            return new ModelAndView(new HashMap<>(), "/public/admin/graphics.html");
        }, new VelocityTemplateEngine());

        get(ROOT + "graphicsOfDilutions", (request, response) -> {
            return new ModelAndView(new HashMap<>(), "/public/admin/graphics2.html");
        }, new VelocityTemplateEngine());

        get(ROOT + "exampleOfTheBayesMethod", (request, response) -> {
            return new ModelAndView(new HashMap<>(), "/public/admin/Primer.html");
        }, new VelocityTemplateEngine());

        get(ROOT + "dataDownload", (request, response) -> {
            return new ModelAndView(new HashMap<>(), "/public/admin/dataDownload.html");
        }, new VelocityTemplateEngine());

        get(ROOT + "diagnosticModel", (request, response) -> {
            return new ModelAndView(new HashMap<>(), "/public/admin/diagnostic_model.html");
        }, new VelocityTemplateEngine());

        get(ROOT + "posterioriProbabilities", (request, response) -> {
            return new ModelAndView(new HashMap<>(), "/public/admin/posteriori_probabilities.html");
        }, new VelocityTemplateEngine());

        get(ROOT + "posterioriProbabilities2", (request, response) -> {
            return new ModelAndView(new HashMap<>(), "/public/admin/posteriori_probabilities2.html");
        }, new VelocityTemplateEngine());

        get(ROOT + "BayesMethodCalculation", (request, response) -> {
            return new ModelAndView(new HashMap<>(), "/public/admin/baies.html");
        }, new VelocityTemplateEngine());

        get(ROOT+"getresult", (request, response) -> {
            HashMap<String, Object> model = new HashMap<>();
            Double as1 =  request.session().attribute("one");
            Double as2 =  request.session().attribute("two");
            Double as3 =  request.session().attribute("three");
            Double as4 =  request.session().attribute("four");
            ArrayList<Double> border = Borders.borders();
            Double [][] mas = ModelA1.modelA1(border);
            ArrayList<Double> comparisonOfVariables = CalculationMethodBaies.procent(border,as1,as2,as3,as4,mas);

            if(comparisonOfVariables.get(0)>comparisonOfVariables.get(1)){
                double sum1 = comparisonOfVariables.get(0)/(comparisonOfVariables.get(0)+comparisonOfVariables.get(1));
                model.put("A5","Внутрипротоковая киста");
                model.put("inside",sum1*100);
            }else {
                double sum2 = comparisonOfVariables.get(1)/(comparisonOfVariables.get(0)+comparisonOfVariables.get(1));
                model.put("A5","Внепротоковая киста");
                model.put("inside",sum2*100);
            }
            model.put("A1", as1);
            model.put("A2", as2);
            model.put("A3", as3);
            model.put("A4", as4);
            return new ModelAndView(model, "/public/admin/baies.html");
        }, new VelocityTemplateEngine());

        get(ROOT+"getfile", (request, response) -> {
            HashMap<String, Object> model = new HashMap<>();
            model.put("get", "Файл загружен");
            return new ModelAndView(model, "/public/admin/dataDownload.html");
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
                Double [][] mas = ModelA1.modelA1(border);
                ArrayList<Double> comparisonOfVariables = CalculationMethodBaies.procent(border,as1,as2,as3,as4,mas);
                if(comparisonOfVariables.get(0)>comparisonOfVariables.get(1)){
                    double sum1 = comparisonOfVariables.get(0)/(comparisonOfVariables.get(0)+comparisonOfVariables.get(1));
                    model.put("A5","Внутрипротоковая киста");
                    model.put("inside",sum1*100);
                    Factory.getInstance().getGenericRepositoryInterface().addObject(new TrueCyst(strFromFile,as1,as2,as3,as4));
                }else {
                    double sum2 = comparisonOfVariables.get(1)/(comparisonOfVariables.get(0)+comparisonOfVariables.get(1));
                    model.put("A5","Внепротоковая киста");
                    model.put("inside",sum2*100);
                    Factory.getInstance().getGenericRepositoryInterface().addObject(new falseCyst(strFromFile,as1,as2,as3,as4));
                }
                model.put("A1", as1);
                model.put("A2", as2);
                model.put("A3", as3);
                model.put("A4", as4);
                return new ModelAndView(model, "/public/admin/baies.html");
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
                Double[][] massive = ParseString.read(strFromFile);
                Double A2 = CalculationA2.calcA2(massive);
                Double A1 = CalculationA1.calcA1(massive);
                Double A3 = CalculationA3.calcA3(massive);
                Double A4 = CalculationA4.calcA4(massive);
                Gson gson = new Gson();
                String json = gson.toJson(massive);
                model.put("mas",json);
                model.put("get","Файл загружен");
                request.session().attribute("one", A1);
                request.session().attribute("two", A2);
                request.session().attribute("three", A3);
                request.session().attribute("four", A4);
                return new ModelAndView(model, "/public/admin/dataDownload.html");
            }
//            catch (Exception e) {
//                log.log(SEVERE, "Exception: ", e);
//                return e;
//            }
        }, new VelocityTemplateEngine());



    }
}
