package com.github.viniciusfcf.quarkus;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class ConsumidorDePrecos {
    
    @Incoming("prices3")
    public void gerarPreco(int preco) {
        System.out.println("ConsumidorDePrecos.gerarPreco() "+preco);
    }
    
}
