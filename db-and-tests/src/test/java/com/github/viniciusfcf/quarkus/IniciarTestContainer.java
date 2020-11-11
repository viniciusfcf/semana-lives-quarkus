package com.github.viniciusfcf.quarkus;

import java.util.HashMap;
import java.util.Map;

import org.testcontainers.containers.PostgreSQLContainer;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;

public class IniciarTestContainer implements QuarkusTestResourceLifecycleManager {

    private PostgreSQLContainer container = new PostgreSQLContainer<>("postgres:12.2");

	@Override
	public Map<String, String> start() {
        container.start();
        Map<String, String> propriedades = new HashMap<>();
        propriedades.put("quarkus.datasource.jdbc.url", container.getJdbcUrl());
        propriedades.put("quarkus.datasource.username", container.getUsername());
        propriedades.put("quarkus.datasource.password", container.getPassword());
		return propriedades;
	}

	@Override
	public void stop() {
		container.stop();
	}
    
}
