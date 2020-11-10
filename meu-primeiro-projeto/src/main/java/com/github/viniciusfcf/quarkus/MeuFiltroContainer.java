package com.github.viniciusfcf.quarkus;

import java.io.IOException;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.ws.rs.Priorities;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;

import io.vertx.core.http.HttpServerRequest;

@Provider
@Priority(1)
public class MeuFiltroContainer implements ContainerRequestFilter {

    @Context
    UriInfo uriInfo;

    @Context
    HttpServerRequest request;
    
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
        System.out.println("MeuFiltroContainer.filter()");
	}
    
}
