package fourguys.service.exception;

import javax.validation.ValidationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.jboss.logging.Logger;

import fourguys.dto.GenericDTO;
import fourguys.dto.IBaseDTO;
import fourguys.dto.ResultError;

@Provider
public class ValidationExceptionMapper implements ExceptionMapper<ValidationException> {

	@Override
	public Response toResponse(ValidationException cex) {

		ResultError resultError = new ResultError();
		resultError.setErrorMessage("ValidationError Happened - "+cex.getMessage());

		Logger.getLogger(SystemExceptionMapper.class).fatal("ValidationException Happened - "+cex.getMessage(),cex);
		
		IBaseDTO<Object> dto = new GenericDTO<Object>();
		dto.setResultError(resultError);

		return Response.status(Response.Status.BAD_REQUEST).entity(dto).type(MediaType.APPLICATION_JSON_TYPE).build();
	}
}