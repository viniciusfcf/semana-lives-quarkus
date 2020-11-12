package com.github.viniciusfcf.microprofile;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

@Readiness
public class MeuReady implements HealthCheck {

	@Override
	public HealthCheckResponse call() {
        return HealthCheckResponse
            .named("Verifica Arquivo").up()
            .withData("nomeArquivo", "/c/d...").build();
	}
    
}
