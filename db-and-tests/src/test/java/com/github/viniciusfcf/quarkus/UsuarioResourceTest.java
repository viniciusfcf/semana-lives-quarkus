package com.github.viniciusfcf.quarkus;

import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.test.Mock;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import io.quarkus.test.junit.mockito.InjectSpy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import javax.inject.Inject;
import javax.transaction.Transactional;

@QuarkusTest
@TestHTTPEndpoint(UsuarioResource.class)
// @QuarkusTestResource(IniciarTestContainer.class)
public class UsuarioResourceTest {

    @Inject
    UsuarioService service;

    // @InjectSpy
    @InjectMock
    UsuarioService serviceMocked;

    @Inject
    UsuarioRepository repository;

    @BeforeEach
    public void crieMock() {
        // Mockito.when(serviceMocked.fazAlgo()).thenReturn("Ola Joao");
        PanacheMock.mock(UsuarioDoPanache.class);
    }

    // @Test
    // public void testHelloEndpoint() {
    //     service.fazAlgo();
    // }

    // @Test
    // public void testMocado() {
    //     assertEquals("Ola Joao", serviceMocked.fazAlgo());;
    // }

    @Test
    public void testeActiveRecord() {
        Mockito.when(UsuarioDoPanache.listMaiorIdade()).thenReturn(null);

        assertNull(UsuarioDoPanache.listMaiorIdade());

        PanacheMock.verify(UsuarioDoPanache.class).listMaiorIdade();
        PanacheMock.verifyNoMoreInteractions(UsuarioDoPanache.class);
    }

    @Test
    @Transactional
    public void testeSalvarBanco() {
        UsuarioHibernate u = new UsuarioHibernate();
        u.nome = "Vinicius";
		repository.persist(u);
    }

}