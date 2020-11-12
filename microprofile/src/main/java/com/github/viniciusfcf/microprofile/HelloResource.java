package com.github.viniciusfcf.microprofile;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.quarkus.security.Authenticated;

@Path("/hello")
public class HelloResource {

    @ConfigProperty(name = "cadastro.cidade-padrao", defaultValue = "Recife")
    private String cidadePadrao;

    @Inject
    @RestClient
    PetStoreService petStoreService;

    @Inject
    @RestClient
    HelloService helloService;

    @Inject
    HelloFaultService faultService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Counted
    // @SimplyTimed
    @Timed(name = "helloTime", absolute = true)
    public String hello() {
        return "hello "+cidadePadrao;
    }

    @GET
    @Path("rest-client")
    @Produces(MediaType.TEXT_PLAIN)
    public Response restClient() {
        Ordem ordem = new Ordem();
		return petStoreService.salvarOrdem(ordem);
    }

    //Vou chamar no Browser
    @GET
    @Path("buscar")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response restParaOpentracing1() {
        return helloService.buscarNoBanco();
    }

    @GET
    @Path("buscar-no-banco")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response restParaOpentracing() {
        return Response.ok().build();
        // return helloService.buscarNoBanco();
    }

    @GET
    @Path("fault")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Retry
    @Authenticated
    //@RolesAllowed("**")
    public Response fault() {
        System.out.println("HelloResource.fault()");
        faultService.executeAlgo();
        return Response.ok().build();
    }
}