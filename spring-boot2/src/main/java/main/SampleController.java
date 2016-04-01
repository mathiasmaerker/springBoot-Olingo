package main;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class SampleController{
	
	private static final Logger log = LoggerFactory.getLogger(SampleController.class);
	
//	@Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		application = application.sources(MyODataServiceFactory.class);
//		application = application.sources(JerseyResourceConfig.class);
//		application = application.sources(MyOlingoRootLocator.class);
//        application = application.sources(SampleController.class);
//        return application;
//    }


    public static void main(String[] args) throws Exception {
    	SpringApplication.run(SampleController.class, args);
    	log.info("I live");
    }
    
//    @Bean
//    public ServletRegistrationBean servletRegistrationBean(){
//    	log.info("CXServlet");
//        return new ServletRegistrationBean(new CXFServlet(),"/api/*");
//    }
}
