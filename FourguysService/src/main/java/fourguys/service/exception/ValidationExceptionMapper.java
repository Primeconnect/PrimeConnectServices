package fourguys.service.exception;

import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.jboss.logging.Logger;
import org.jboss.resteasy.api.validation.ResteasyConstraintViolation;
import org.jboss.resteasy.api.validation.ResteasyViolationException;

import fourguys.dto.GenericDTO;
import fourguys.dto.IBaseDTO;
import fourguys.dto.ResultError;

@Provider
public class ValidationExceptionMapper implements ExceptionMapper<ResteasyViolationException> 
{

	@Override
	public Response toResponse(ResteasyViolationException cex) {

		ResultError resultError = new ResultError();
		
		List<ResteasyConstraintViolation> exList = cex.getViolations();
		StringBuilder sb = new StringBuilder("ValidationError Happened - ");
		for( ResteasyConstraintViolation ex : exList )
		{
			sb.append(","+ex.getPath()+" - "+ex.getMessage());
		}
		resultError.setErrorMessage(sb.toString());
		
		Logger.getLogger(SystemExceptionMapper.class).fatal("ValidationException Happened - "+cex.getClass()+" - "+cex.getMessage(),cex);
		
		IBaseDTO<Object> dto = new GenericDTO<Object>();
		dto.setResultError(resultError);

		return Response.status(Response.Status.BAD_REQUEST).entity(dto).type(MediaType.APPLICATION_JSON_TYPE).build();
	}
}