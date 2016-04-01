package main;
import org.apache.olingo.odata2.api.exception.ODataException;
import org.apache.olingo.odata2.api.processor.ODataResponse;
import org.apache.olingo.odata2.api.uri.info.GetMetadataUriInfo;
import org.apache.olingo.odata2.jpa.processor.api.ODataJPAContext;
import org.apache.olingo.odata2.jpa.processor.api.ODataJPAProcessor;


public class JpaProcessor extends ODataJPAProcessor {

	public JpaProcessor(ODataJPAContext oDataJPAContext) {
		super(oDataJPAContext);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ODataResponse readMetadata(GetMetadataUriInfo uriInfo,
			String contentType) throws ODataException {
		return super.readMetadata(uriInfo, contentType);
	}

}
