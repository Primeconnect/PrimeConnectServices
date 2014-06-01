package fourguys.service.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.jboss.logging.Logger;

import fourguys.dto.GenericDTO;
import fourguys.dto.IBaseDTO;
import fourguys.dto.ResultError;

@Provider
public class SystemExceptionMapper implements ExceptionMapper<Exception>
{

	@Override
	public Response toResponse(Exception exception) 
	{
		ResultError resultError = new ResultError();
		resultError.setErrorMessage("SystemException Happened - "+exception.getMessage());
		
		Logger.getLogger(SystemExceptionMapper.class).fatal("SystemException Happened - "+exception.getMessage(),exception);

		IBaseDTO<Object> dto = new GenericDTO<Object>();
		dto.setResultError(resultError);

		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(dto).type(MediaType.APPLICATION_JSON_TYPE).build();
	}

}
