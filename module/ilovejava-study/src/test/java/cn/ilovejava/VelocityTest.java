package cn.ilovejava;

import cn.ilovejava.util.DateTime;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import java.io.File;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by Administrator on 2016/4/12.
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class VelocityTest{
    @Test
    public void testHelloWorld() throws Exception {
        VelocityEngine ve = new VelocityEngine();
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());

        ve.init();

        //String rootPath=this.getClass().getClassLoader().getResource("/").getFile() + "../../src/main/cn/ilovejava/";
        String rootPath = System.getProperty("user.dir").replace("\\","/")+"/src/main/java/cn/ilovejava/";
        String entityPath = rootPath+"entity";

        File entityDe = new File(entityPath);
        File[] entitys = entityDe.listFiles();
        for(File entity:entitys){
            String FileName = entity.getName();
            FileName = FileName.substring(0,FileName.indexOf("."));
            /*if(FileName.indexOf("Base")>=0||FileName.indexOf("User")>=0)
                continue;*/


            Template daoTemplate = ve.getTemplate("DaoModule.vm");
            //Template daoImplTemplate = ve.getTemplate("DaoImplModule.vm");
            Template serviceTemplate = ve.getTemplate("ServiceModule.vm");
            Template controllerTemplate = ve.getTemplate("ControllerModule.vm");

            StringBuilder daoPath = new StringBuilder(rootPath);
            StringBuilder daoImplPath = new StringBuilder(rootPath);
            StringBuilder servicePath = new StringBuilder(rootPath);
            StringBuilder controllerPath = new StringBuilder(rootPath);
            daoPath.append("dao/").append(FileName).append("Repository.java");
            daoImplPath.append("dao/impl/").append(FileName).append("DaoImpl.java");
            servicePath.append("service/").append(FileName).append("Service.java");
            controllerPath.append("controller/").append(FileName).append("Controller.java");

            VelocityContext ctx = new VelocityContext();
            ctx.put("moduleName", FileName);
            ctx.put("lowModuleName", FileName.substring(0,1).toLowerCase()+FileName.substring(1));
            ctx.put("developer", "yeqy");
            ctx.put("now", new DateTime(new Date()).toDateTimeString());

            if(!new File(rootPath+"dao/"+FileName+"Repository.java").exists())
                this.write(daoTemplate, ctx, daoPath.toString());
            //this.write(daoImplTemplate,ctx,daoImplPath.toString());
            if(!new File(rootPath+"service/"+FileName+"Service.java").exists())
                this.write(serviceTemplate,ctx,servicePath.toString());
            if(!new File(rootPath+"controller/"+FileName+"Controller.java").exists())
                this.write(controllerTemplate,ctx,controllerPath.toString());

        }

    }

    private void write(Template template, VelocityContext ctx, String path){
        PrintWriter printWriter = null;

        try {
            printWriter = new PrintWriter(path);
            template.merge(ctx,printWriter);
            printWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            printWriter.close();
        }

    }


}
