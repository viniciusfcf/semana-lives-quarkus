package com.github.viniciusfcf.quarkus;

import io.quarkus.hibernate.orm.rest.data.panache.PanacheRepositoryResource;
import io.quarkus.rest.data.panache.ResourceProperties;

@ResourceProperties(hal = true)
public interface UsuarioPanacheResource extends PanacheRepositoryResource<UsuarioRepository, UsuarioHibernate, Long> {

    
}
