package com.github.viniciusfcf;

import com.github.viniciusfcf.quarkus.ServicoExternoService;

import io.quarkus.test.Mock;

// @Mock
public class ServicoExternoServiceMock extends ServicoExternoService {
    
    @Override
    public String fazAlgo() {
        return "ServicoExternoServiceMock.fazAlgo()";
    }

}
