package main;


import javax.ws.rs.Path;

import org.apache.olingo.odata2.api.ODataServiceFactory;
import org.apache.olingo.odata2.spring.OlingoRootLocator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Path("/")
public class MyOlingoRootLocator extends OlingoRootLocator {
	private static final Logger LOGGER = LoggerFactory.getLogger(MyOlingoRootLocator.class);
	@Override
	@Autowired
	public void setServiceFactory(ODataServiceFactory serviceFactory) {
		LOGGER.info("Setting Service Factory in RootLocator");
		LOGGER.info("ServiceFactory injected: " + serviceFactory.toString());
		super.setServiceFactory(serviceFactory);
	}
	public MyOlingoRootLocator() {
		super();
		LOGGER.info("RootLocator Constructor");
	}

}
