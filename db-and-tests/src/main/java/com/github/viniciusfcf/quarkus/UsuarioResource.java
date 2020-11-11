package com.github.viniciusfcf.quarkus;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.agroal.api.AgroalDataSource;
import io.quarkus.agroal.DataSource;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    @Inject
    AgroalDataSource ds;

    @Inject
    @DataSource("outro")
    AgroalDataSource dsOutro;

    @PersistenceContext
    EntityManager entityManager;

    // @Inject
    // @PersistenceUnit("outro")
    // EntityManager entityManagerOutro;

    @Inject
    UsuarioRepository repository;

    @GET
    @Path("jdbc")
    public List<UsuarioJDBC> buscarUsuarios() throws SQLException {
        PreparedStatement prepareStatement = dsOutro.getConnection().prepareStatement("select u.* from public.usuarios u");

        ResultSet resultSet = prepareStatement.executeQuery();

        List<UsuarioJDBC> usuarios = new ArrayList<>();
		while(resultSet.next()) {
            UsuarioJDBC u = new UsuarioJDBC();
            u.nome = resultSet.getString("nome");
            usuarios.add(u);
        }
        return usuarios;
    }

    @GET
    @Path("hibernate")
    public List<UsuarioJDBC> buscarUsuariosHibernate() throws SQLException {
       return entityManager.createQuery("select u from UsuarioHibernate u").getResultList();
    }

    @GET
    @Path("panache")
    public List<UsuarioDoPanache> buscarUsuariosPanache() throws SQLException {
       return UsuarioDoPanache.listMaiorIdade();
    }

    @GET
    @Path("panache-repository")
    public List<UsuarioHibernate> buscarUsuariosPanache2() throws SQLException {
       return repository.listAll();
    }

}