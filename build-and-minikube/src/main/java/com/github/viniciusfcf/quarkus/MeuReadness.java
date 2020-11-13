package com.github.viniciusfcf.quarkus;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

@Readiness
public class MeuReadness implements HealthCheck {

	@Override
	public HealthCheckResponse call() {
		return HealthCheckResponse.down("Meu Check");
	}
    
}
