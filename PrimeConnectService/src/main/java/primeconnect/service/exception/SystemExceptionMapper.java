package primeconnect.service.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.jboss.logging.Logger;
import org.jboss.resteasy.spi.ApplicationException;

import primeconnect.dto.GenericDTO;
import primeconnect.dto.IBaseDTO;
import primeconnect.dto.ResultError;

@Provider
public class SystemExceptionMapper implements ExceptionMapper<ApplicationException>
{

	@Override
	public Response toResponse(ApplicationException exception) 
	{
		ResultError resultError = new ResultError();
		resultError.setErrorMessage("SystemException Happened - "+exception.getMessage());
		
		Logger.getLogger(SystemExceptionMapper.class).fatal("SystemException Happened - "+exception.getMessage(),exception);

		IBaseDTO<Object> dto = new GenericDTO<Object>();
		dto.setResultError(resultError);

		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(dto).type(MediaType.APPLICATION_JSON_TYPE).build();
	}

}
