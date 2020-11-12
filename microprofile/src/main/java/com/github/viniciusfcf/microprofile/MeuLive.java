package com.github.viniciusfcf.microprofile;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

@Liveness
public class MeuLive implements HealthCheck {

	@Override
	public HealthCheckResponse call() {
        return HealthCheckResponse
            .named("Verifica Arquivo tambem").up()
            .withData("nomeArquivo", "/c/d...").build();
	}
    
}
