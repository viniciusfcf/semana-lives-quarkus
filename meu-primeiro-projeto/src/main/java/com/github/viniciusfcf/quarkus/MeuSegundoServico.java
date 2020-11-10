package com.github.viniciusfcf.quarkus;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class MeuSegundoServico {
    
    public void init(@Observes MeuEvento md) {
        System.out.println("MeuSegundoServico.init(MeuDouble)");
    }

}
