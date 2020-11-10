package com.github.viniciusfcf.quarkus;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

@ApplicationScoped
// @RequestScoped
//@SessionScoped
// @Singleton
// @Dependent
public class MeuServico {
    
    MeuRepositorio repositorio;

    public Event<MeuEvento> e;

    public MeuServico() {
        
    }

    @Inject
    public void init(MeuRepositorio repositorio, Event<MeuEvento> e) {
        System.out.println("MeuServico.init()");
        this.e = e;
        
        this.repositorio = repositorio;
    }

    public List<Usuario> buscarUsuarios() {
        return repositorio.buscarUsuarios();
    }

    @PostConstruct
    public void posConstruct() {
        System.out.println("MeuServico.posConstruct()");
        e.fire(new MeuEvento());
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("MeuServico.preDestroy()");
    }

}
