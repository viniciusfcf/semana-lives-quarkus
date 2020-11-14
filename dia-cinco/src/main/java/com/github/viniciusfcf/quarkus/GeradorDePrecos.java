package com.github.viniciusfcf.quarkus;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Outgoing;

import io.smallrye.mutiny.Multi;

@ApplicationScoped
public class GeradorDePrecos {
    
    @Outgoing("generated-price")
    public Multi<Integer> gerarPreco() {
        System.out.println("GeradorDePrecos.gerarPreco()-----------------");
        //Na minha maquina nao funcionou
        // return Multi.createFrom()
        //     .ticks().every(Duration.ofSeconds(5))
        //     .map(tick ->  {
        //         int inteiro = ThreadLocalRandom.current().nextInt();
        //         System.out.println("GeradorDePrecos.gerarPreco() "+inteiro);   
        //         return inteiro;
        //     });
        return Multi.createFrom().items(1, 2, 3, 4, 5, 6);
    }
    
}
