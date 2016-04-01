package main;
import javax.ws.rs.ApplicationPath;

import org.apache.olingo.odata2.core.rest.ODataExceptionMapperImpl;
import org.apache.olingo.odata2.core.rest.app.ODataApplication.MyProvider;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import main.MyOlingoRootLocator;

@Component
@ApplicationPath("/odata.svc")
@Configuration
public class JerseyResourceConfig extends ResourceConfig {
	private static final Logger LOGGER = LoggerFactory.getLogger(JerseyResourceConfig.class);

	public JerseyResourceConfig() { 
		LOGGER.info("JerseyResourceConfig");
		register(MyOlingoRootLocator.class);
		register(MyProvider.class);
		register(ODataExceptionMapperImpl.class); 
	}

}
