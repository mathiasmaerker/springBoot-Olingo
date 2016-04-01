package main;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.apache.olingo.odata2.api.ODataService;
import org.apache.olingo.odata2.api.ODataServiceFactory;
import org.apache.olingo.odata2.api.edm.provider.EdmProvider;
import org.apache.olingo.odata2.api.exception.ODataException;
import org.apache.olingo.odata2.api.processor.ODataContext;
import org.apache.olingo.odata2.api.processor.ODataSingleProcessor;
import org.apache.olingo.odata2.jpa.processor.api.ODataJPAContext;
import org.apache.olingo.odata2.jpa.processor.core.ODataJPAContextImpl;
import org.apache.olingo.odata2.jpa.processor.core.edm.ODataJPAEdmProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyODataServiceFactory extends ODataServiceFactory {
	public MyODataServiceFactory() {
		super();
		LOGGER.info("OData Factory Contructor");
	}
	private static final Logger LOGGER = LoggerFactory.getLogger(MyODataServiceFactory.class);

	@PersistenceUnit
	private EntityManagerFactory emf;
	
	private ODataJPAContext jpaCtx;
	@Override
	public ODataService createService(ODataContext ctx) throws ODataException {
		LOGGER.info("Creating OData JPA Context");
		LOGGER.info("Odata Context: " + ctx.toString());
		jpaCtx = new ODataJPAContextImpl();
		jpaCtx.setODataContext(ctx);
		LOGGER.info("JPA Context: " + jpaCtx.toString());
		jpaCtx.setEntityManagerFactory(emf);
		jpaCtx.setPersistenceUnitName("default");
		LOGGER.info("Persistence Unit: " + emf.toString());
		EdmProvider edmProvider = new ODataJPAEdmProvider(jpaCtx);
		ODataSingleProcessor singleProcessor = new JpaProcessor(jpaCtx);

		return createODataSingleProcessorService(edmProvider, singleProcessor);
	}

}
