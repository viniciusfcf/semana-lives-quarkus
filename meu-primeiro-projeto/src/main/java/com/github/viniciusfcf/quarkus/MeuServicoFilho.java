package com.github.viniciusfcf.quarkus;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

@AnotacaoServicoEspecifico
@ApplicationScoped
public class MeuServicoFilho extends MeuServico {
    
    public void init(@Observes MeuDouble md) {
        System.out.println("MeuServicoFilho.init(MeuDouble)");
    }

    @PostConstruct
    public void posConstruct() {
        System.out.println("MeuServicoFilho.posConstruct()");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("MeuServicoFilho.preDestroy()");
    }

}
