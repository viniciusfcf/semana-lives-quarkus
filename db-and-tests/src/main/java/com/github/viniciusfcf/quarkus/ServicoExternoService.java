package com.github.viniciusfcf.quarkus;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ServicoExternoService {

    public String fazAlgo() {
        return "ServicoExternoService.fazAlgo()";
    }

}
