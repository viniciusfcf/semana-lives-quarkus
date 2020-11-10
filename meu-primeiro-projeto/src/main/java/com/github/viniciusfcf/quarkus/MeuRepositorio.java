package com.github.viniciusfcf.quarkus;

import java.util.Collections;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import io.quarkus.runtime.Startup;
import io.quarkus.runtime.StartupEvent;

@ApplicationScoped
public class MeuRepositorio {

    // public void init(@Observes StartupEvent event) {
    //     System.out.println("MeuRepositorio.init() Sou EAGER");
    // }


    public List<Usuario> buscarUsuarios() {
        Usuario u = new Usuario();
        u.nome = "Vinicius";
		List<Usuario> lista = Collections.singletonList(u);
		return lista;
    }

}
