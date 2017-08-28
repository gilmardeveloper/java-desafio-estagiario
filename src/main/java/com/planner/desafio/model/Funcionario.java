package com.planner.desafio.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.planner.desafio.interfaces.Acrescimo;

/**
 * Representa uma classe persistente que implementa uma entidade de negócio da aplicação,
 * seguindo o modelo de programação POJO.
 * 
 * @author Gilmar Carlos
 *
 */
@Entity
@Table(name = "funcionario")
public class Funcionario implements Serializable, Acrescimo{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String matricula;
	
	@OneToOne
	private Cargo cargo;
	
	private BigDecimal salario = BigDecimal.ZERO;
	
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
	 * Responsável por retornar o atributo nome, que representa uma coluna na tabela. 
	 *  
	 * @return nome objeto do tipo (String) que representa uma coluna na tabela.
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Responsável por popular o atributo nome, que representa uma coluna na tabela. 
	 *  
	 * @param nome objeto do tipo (String) que representa uma coluna na tabela.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Responsável por retornar o atributo matricula, que representa uma coluna na tabela. 
	 *  
	 * @return matricula objeto do tipo (String) que representa uma coluna na tabela.
	 */
	public String getMatricula() {
		return matricula;
	}
	
	/**
	 * Responsável por popular o atributo matricula, que representa uma coluna na tabela. 
	 *  
	 * @param matricula objeto do tipo (String) que representa uma coluna na tabela.
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	/**
	 * Responsável por retornar o atributo cargo, que representa a chave estrangeira na tabela e que faz referência
	 * a chave primária na tabela cargo, representada pelo atributo id da classe (Cargo). 
	 *  
	 * @return cargo objeto do tipo (Cargo) que representa uma coluna na tabela.
	 */
	public Cargo getCargo() {
		return cargo;
	}

	/**
	 * Responsável por popular o atributo cargo, que representa a chave estrangeira na tabela e que faz referência
	 * a chave primária na tabela cargo, representada pelo atributo id da classe (Cargo). 
	 *  
	 * @param cargo objeto do tipo (Cargo) que representa uma coluna na tabela.
	 */
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	/**
	 * Responsável por retornar o atributo salario, que representa uma coluna na tabela. 
	 *  
	 * @return salario objeto do tipo (BigDecimal) que representa uma coluna na tabela.
	 */
	public BigDecimal getSalario() {
		return salario;
	}
	
	/**
	 * Responsável por popular o atributo salario, que representa uma coluna na tabela. 
	 *  
	 * @param salario objeto do tipo (BigDecimal) que representa uma coluna na tabela.
	 */
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	
	/**
	 * Responsável por receber um atributo do tipo (BigDecimal), que representa o percentual de aumento
	 * a ser calculado ao atributo salario. 
	 *  
	 * @param percentualDeAumento objeto do tipo (BigDecimal) que representa um percentual de aumento.
	 */
	@Override
	public void recebeAumento(BigDecimal percentualDeAumento) {
		calculaAumento(percentualDeAumento);
	}
	
	/**
	 * Responsável por fazer o cálculo de aumento, e popular o atributo salario com o valor acrescido. 
	 *  
	 * @param percentualDeAumento objeto do tipo (BigDecimal) que representa um percentual de aumento.
	 */
	private void calculaAumento(BigDecimal percentualDeAumento) {
		BigDecimal percentualAumento = percentualDeAumento.divide(new BigDecimal("100"));
		this.salario = salario.add(salario.multiply(percentualAumento));
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
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
		Funcionario other = (Funcionario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}
	
}
