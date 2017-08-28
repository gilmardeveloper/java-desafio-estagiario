package com.planner.desafio.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.planner.desafio.model.Funcionario;
import com.planner.desafio.repository.FuncionarioRepository;

/**
 * 
 * Representa um managed bean resolvendo as requisições entre a view e a classe de entidade
 * (Funcionario).
 * 
 * @author Gilmar
 *
 */
@Named
@ViewScoped
public class FuncionarioBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private Funcionario funcionario;
	
	private List<Funcionario> funcionariosFiltrados;
	
	@Inject
	private FuncionarioRepository funcionarioRepository;

	/**
	 *  Construtor padrão sem argumentos
	 *   
	 */
	public FuncionarioBean() {
		novo();
	}
	
	/**
	 *  Cria uma instância da classe (Funcionario)
	 *  
	 */
	public void novo() {
		this.funcionario = new Funcionario();
	}
	
	/**
	 * 
	 * Altera o valor da instância da classe (Funcionario)
	 * 
	 * @param funcionario objeto da classe (Funcionario)
	 */
	public void alterar(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	/**
	 * Persisti o objeto da classe (Funcionario) no banco, e altera o valor do
	 * objeto com o valor de uma nova instância da classe (Funcionario)
	 * 
	 */
	public void salvar() {
       funcionarioRepository.salvar(funcionario);
       novo();
	}
	
	/**
	 * Remove um registro do banco referente ao objeto passado, e altera o valor do
	 * objeto com o valor de uma nova instância da classe (Funcionario).
	 * 
	 * @param funcionario objeto da classe (Funcionario)
	 */
	public void remover(Funcionario funcionario) {
		funcionarioRepository.remover(funcionario);
		novo();
	}
	
	/**
	 * Retorna o objeto funcionario
	 * 
	 * @return funcionario objeto da classe (Funcionario)
	 */
	public Funcionario getFuncionario() {
		return funcionario;
	}
	
	/**
	 * Retorna uma lista de objetos da classe (Funcionario) cadastrados no banco.
	 * 
	 * @return funcionarios lista de objetos da classe (Funcionario)
	 */
	public List<Funcionario> getFuncionarios(){
		return funcionarioRepository.listarTodos();
	}
	
	/**
	 * Retorna uma lista de objetos filtrados na view
	 * 
	 * @return funcionariosFiltrados lista de objetos da classe (Funcionario)
	 */
	public List<Funcionario> getFuncionariosFiltrados() {
		return funcionariosFiltrados;
	}

	/**
	 * Popula uma lista de objetos filtrados na view
	 * 
	 * @param funcionariosFiltrados lista de objetos da classe (Funcionario)
	 */
	public void setFuncionariosFiltrados(List<Funcionario> funcionariosFiltrados) {
		this.funcionariosFiltrados = funcionariosFiltrados;
	}
	
}
