package com.github.viniciusfcf.quarkus;

import java.util.concurrent.ThreadLocalRandom;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.inject.Singleton;

import io.quarkus.arc.DefaultBean;
import io.quarkus.arc.profile.UnlessBuildProfile;
import io.quarkus.arc.properties.IfBuildProperty;

public class Factory {
    
    @Produces
    public Integer inteiro = 1;

    @Produces
    @Named("meu-double")
    public Double gerarNumero() {
        return ThreadLocalRandom.current().nextDouble();
    }

    @Produces
    @RequestScoped
    public MeuDouble gerarNumero2() {
        MeuDouble md = new MeuDouble();
        md.numero =  ThreadLocalRandom.current().nextDouble();
        return md;
    }

    @DefaultBean
    @Singleton
    public ConfiguracaoDaAplicacao create() {
        return new ConfiguracaoDaAplicacao();
    }

    // @IfBuildProfile("test")
    @UnlessBuildProfile("test")
    //@IfBuildProperty(name = "minha.propriedade", stringValue = "oi")
    @Produces
    @Singleton
    public ConfiguracaoDaAplicacao createConfiguracao() {
        return new ConfiguracaoDaAplicacao();
    }

}
