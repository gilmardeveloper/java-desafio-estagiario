package com.planner.desafio.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.planner.desafio.model.Cargo;
import com.planner.desafio.repository.CargoRepository;

/**
 * 
 * Representa um managed bean resolvendo as requisições entre a view e a classe de entidade
 * (Cargo).
 * 
 * @author Gilmar
 *
 */
@Named
@ViewScoped
public class CargoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CargoRepository cargoRepository;
	
	private Cargo cargo;
	
	private List<Cargo> cargosFiltrados;

	/**
	 *  Construtor padrão sem argumentos
	 *   
	 */
	public CargoBean() {
	  novo();
	}
	
	/**
	 *  Cria uma instância da classe cargo
	 *  
	 */
	public void novo() {
		this.cargo = new Cargo();
	}

	/**
	 * 
	 * Altera o valor da instância da classe (Cargo)
	 * 
	 * @param cargo objeto da classe (Cargo)
	 *  
	 */
	public void alterar(Cargo cargo) {
		this.cargo = cargo;
	}
	
	/**
	 * Persisti o objeto da classe (Cargo) no banco, e altera o valor do
	 * objeto com o valor de uma nova instância da classe (Cargo)
	 * 
	 */
	public void salvar() {
		cargoRepository.salvar(cargo);
		novo();
	}
	
	/**
	 * Remove um registro do banco referente ao objeto passado, e altera o valor do
	 * objeto com o valor de uma nova instância da classe (Cargo).
	 * 
	 * @param cargo objeto da classe (Cargo)
	 * 
	 */
	public void remover(Cargo cargo) {
		cargoRepository.remover(cargo);
		novo();
	}
	
	/**
	 * Popula um valor para o objeto cargo
	 * 
	 * @param cargo objeto da classe (Cargo)
	 * 
	 */
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	
	/**
	 * Retorna o objeto cargo
	 * 
	 * @return cargo objeto da classe (Cargo)
	 */
	public Cargo getCargo() {
		return cargo;
	}
	
	/**
	 * Retorna uma lista de objetos da classe (Cargo) cadastrados no banco.
	 * 
	 * @return cargos lista de obejtos da classe (Cargo)
	 */
	public List<Cargo> getCargos(){
	    return cargoRepository.listarTodos();
	}
	
	/**
	 * Retorna uma lista de objetos filtrados na view
	 * 
	 * @return cargosFiltrados lista de obejtos da classe (Cargo)
	 */
	public List<Cargo> getCargosFiltrados(){
		return cargosFiltrados;
	}
	
	/**
	 * Popula uma lista de objetos filtrados na view
	 * 
	 * @param cargosFiltrados lista de objetos da classe (Cargo)
	 */
	public void setCargosFiltrados(List<Cargo> cargosFiltrados){
		this.cargosFiltrados = cargosFiltrados;
	}
	
}
