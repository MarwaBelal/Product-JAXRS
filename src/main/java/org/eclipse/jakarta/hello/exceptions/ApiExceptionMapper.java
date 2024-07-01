package org.eclipse.jakarta.hello.exceptions;

import jakarta.ejb.EJBException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ApiExceptionMapper implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception exception) {
        if (exception instanceof EJBException) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Validation error: " + exception.getMessage())
                    .build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Internal server error: " + exception.getMessage())
                    .build();
        }
    }
}