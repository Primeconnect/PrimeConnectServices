package fourguys.service.exception;

import javax.validation.ValidationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.commons.lang.exception.ExceptionUtils;

@Provider
public class ValidationExceptionMapper implements ExceptionMapper<ValidationException> {

	@Override
    public Response toResponse(ValidationException cex) {
    	StringBuilder sb = new StringBuilder();
		sb.append("ValidationError Happened - "+ExceptionUtils.getFullStackTrace(cex));
		
		return Response.status(Response.Status.BAD_REQUEST).entity(sb).type("text/plain").build();
    }
}