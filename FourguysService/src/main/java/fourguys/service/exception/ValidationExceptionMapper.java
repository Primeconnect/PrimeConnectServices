package fourguys.service.exception;

import javax.validation.ValidationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ValidationExceptionMapper implements ExceptionMapper<ValidationException> {

	@Override
    public Response toResponse(ValidationException cex) {
    	StringBuilder sb = new StringBuilder();
		sb.append("ValidationError Happened - "+cex.getSuppressed());
		
		return Response.status(Response.Status.BAD_REQUEST).entity(sb).type("text/plain").build();
    }
}