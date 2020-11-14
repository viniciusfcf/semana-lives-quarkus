package com.github.viniciusfcf.quarkus;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.jboss.logging.Logger;

import io.quarkus.runtime.StartupEvent;

@Path("/hello")
public class HelloResource {

    private Logger LOGGER = Logger.getLogger(HelloResource.class);

    @Inject
    @Channel("generated-price")
    private Emitter<Integer> emitter;

    void init(@Observes StartupEvent event) {
        LOGGER.info("Iniciando Hello Resource");
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        LOGGER.info("Apresentando Hello");
        LOGGER.infof("Apresentando Hello %s", "Vinicius");
        LOGGER.debug("Apresentando Hello em Debug");

        return "hello";
    }

    @GET
    @Path("amqp")
    @Produces(MediaType.TEXT_PLAIN)
    public String enviarPreco(@QueryParam("preco") Integer preco) {
        emitter.send(preco);
        return "hello "+preco;
    }
}