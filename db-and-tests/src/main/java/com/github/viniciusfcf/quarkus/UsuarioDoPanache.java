package com.github.viniciusfcf.quarkus;

import java.util.List;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.panache.common.Sort;

@Entity
public class UsuarioDoPanache extends PanacheEntity {
    
    public Integer idade;

    public static List<UsuarioDoPanache> listMaiorIdade() {
        return list("idade > ?1", Sort.ascending("idade"), 0);
    }

}
