package com.github.viniciusfcf.quarkus;

import java.util.List;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
// @RestController
// @RequestMapping(path = "hello", produces = "")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Logavel
public class HelloResource {

    @Inject
    MeuServico servico;

    @Inject
    Instance<Double> d;

    @Inject
    @Named("meu-double")
    Object numeroGerado;

    @Inject
    Integer inteiro;

    @Inject
    MeuDouble meuNumeroGerado;

    @Inject
    ConfiguracaoDaAplicacao configuracao;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello "+configuracao.getClass();
    }

    @GET
    @Path("usuarios")
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    public List<Usuario> buscarUsuarios() {
        return servico.buscarUsuarios();
    }

    @GET
    @Path("usuarios/")
    @Produces(MediaType.APPLICATION_JSON_PATCH_JSON)
    public List<Usuario> buscarUsuarioPorId(@PathParam("id") Long id) {
        return servico.buscarUsuarios();
    }

    

}