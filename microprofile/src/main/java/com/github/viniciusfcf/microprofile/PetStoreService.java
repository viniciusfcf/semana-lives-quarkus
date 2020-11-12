package com.github.viniciusfcf.microprofile;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("v2")
@RegisterRestClient(configKey = "petstore")
public interface PetStoreService {
    
    @POST
    @Path("store/order")
    public Response salvarOrdem(Ordem ordem);
}
