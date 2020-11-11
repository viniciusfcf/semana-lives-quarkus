package com.github.viniciusfcf.quarkus;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class UsuarioService {
    
    @Inject
    ServicoExternoService servicoExterno;

    public String fazAlgo() {
        return servicoExterno.fazAlgo();
    }

}
