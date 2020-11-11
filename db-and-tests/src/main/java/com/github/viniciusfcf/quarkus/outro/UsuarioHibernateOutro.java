package com.github.viniciusfcf.quarkus.outro;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "public", name = "usuarios")
public class UsuarioHibernateOutro {

    @Id
    public String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

    
}
