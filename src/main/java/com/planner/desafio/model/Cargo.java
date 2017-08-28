package com.planner.desafio.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * Representa uma classe persistente que implementa uma entidade de negócio da aplicação,
 * seguindo o modelo de programação POJO.
 * 
 * @author Gilmar Carlos
 *
 */
@Entity
@Table(name = "cargo")
public class Cargo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long codigo;
	private String descricao;
	
	@OneToMany(mappedBy = "cargo")
	@Cascade(CascadeType.DELETE)
	private List<Funcionario> funcionarios;
	
	/**
	 * Responsável por retornar o atributo id, que representa a chave primária na tabela. 
	 *  
	 * @return id objeto do tipo (Long) que representa uma chave primária
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * Responsável por popular o atributo id, que representa a chave primária na tabela. 
	 *  
	 * @param id objeto do tipo (Long) que representa uma chave primária
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * Responsável por retornar o atributo codigo, que representa uma coluna na tabela. 
	 *  
	 * @return codigo objeto do tipo (Long) que representa uma coluna na tabela.
	 */
	public Long getCodigo() {
		return codigo;
	}
	
	/**
	 * Responsável por popular o atributo codigo, que representa uma coluna na tabela. 
	 *  
	 * @param codigo objeto do tipo (Long) que representa uma coluna na tabela.
	 */
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * Responsável por retornar o atributo descricao, que representa uma coluna na tabela. 
	 *  
	 * @return descricao objeto do tipo (String) que representa uma coluna na tabela.
	 */
	public String getDescricao() {
		return descricao;
	}
	
	/**
	 * Responsável por popular o atributo descricao, que representa uma coluna na tabela. 
	 *  
	 * @param descricao objeto do tipo (String) que representa uma coluna na tabela.
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	/**
	 * Responsável por retornar uma lista de objetos do tipo (Funcionario), relacionados pelo mapeamento
	 * bidirecional com a classe (Cargo). 
	 *  
	 * @return funcionarios objeto do tipo (List) que representa uma coleção de objetos do tipo (Funcionario).
	 */
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	
	/**
	 * Responsável por popular uma lista de objetos do tipo (Funcionario), relacionados pelo mapeamento
	 * bidirecional com a classe (Cargo). 
	 *  
	 * @param funcionarios objeto do tipo (List) que representa uma coleção de objetos do tipo (Funcionario).
	 */
	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cargo other = (Cargo) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
