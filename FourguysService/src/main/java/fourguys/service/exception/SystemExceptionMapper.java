package fourguys.service.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.commons.lang.exception.ExceptionUtils;

@Provider
public class SystemExceptionMapper implements ExceptionMapper<Exception>
{

	@Override
	public Response toResponse(Exception exception) 
	{
		StringBuilder sb = new StringBuilder();
		sb.append("SystemException Happened - "+ExceptionUtils.getFullStackTrace(exception));
		
		return Response.status(Response.Status.BAD_REQUEST).entity(sb).type("text/plain").build();
	}

}
