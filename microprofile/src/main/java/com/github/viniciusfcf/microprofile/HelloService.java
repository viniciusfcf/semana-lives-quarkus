package com.github.viniciusfcf.microprofile;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/hello")
@RegisterRestClient(configKey = "hello")
public interface HelloService {
    
    @GET
    @Path("buscar-no-banco")
    public Response buscarNoBanco();
}
