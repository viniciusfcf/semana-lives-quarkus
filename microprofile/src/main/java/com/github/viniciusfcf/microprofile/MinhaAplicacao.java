package com.github.viniciusfcf.microprofile;

import javax.ws.rs.core.Application;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;

@OpenAPIDefinition(info = 
    @Info(title = "Aprendendo MicroProfile", version = "0.1")
    )
public class MinhaAplicacao extends Application {
    
}
