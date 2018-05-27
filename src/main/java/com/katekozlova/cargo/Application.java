package com.katekozlova.cargo;

import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class Application {

    static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws Exception {
        logger.info("server is starting");
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8000);
        tomcat.getConnector();
        tomcat.setBaseDir(System.getProperty("java.io.tmpdir"));
        tomcat.addWebapp("", new File("src/main/webapp").getAbsolutePath());
        tomcat.start();
        logger.info("server started");
        tomcat.getServer().await();
    }
}