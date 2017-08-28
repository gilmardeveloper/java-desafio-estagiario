package com.planner.desafio.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.planner.desafio.model.Cargo;
import com.planner.desafio.model.Funcionario;
import com.planner.desafio.promocao.AplicarPromocao;
import com.planner.desafio.repository.CargoRepository;
import com.planner.desafio.repository.FuncionarioRepository;

/**
 * 
 * Representa um managed bean resolvendo as requisições entre a view e a regra de negócio
 * da aplicação referênte ao aumento de salários por cargo
 * 
 * @author Gilmar
 *
 */
@Named
@ViewScoped
public class PromocaoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CargoRepository cargoRepository;
	
	@Inject
	private FuncionarioRepository funcionarioRepository;
	
	@Inject
	private AplicarPromocao aplicarPromocao;
		
	private Cargo cargo;
	
	private BigDecimal percentualDeAumento;
		
	private List<Funcionario> funcionarios;
	
	/**
	 *  Construtor padrão sem argumentos
	 *   
	 */
	public PromocaoBean() {
	  novo();
	  zerarPercentual();
	}
	
	/**
	 *  Cria uma instância da classe cargo
	 *  
	 */
	public void novo() {
		this.cargo = new Cargo();
	}
	
	/**
	 * Popula o atributo da classe percentualDeAumento com o valor ZERO
	 * 
	 */
	public void zerarPercentual() {
		percentualDeAumento = BigDecimal.ZERO;
	}
	
	/**
	 * Aumenta os salários de todos os objetos da classe (Funcionario) relacionado ao
	 * cargo atual selecionado
	 * 
	 */
	public void aumentarSalarios(){
		calcularSalarios();
		atualizarSalarios();
		atualizarCargo();
		zerarPercentual();
	}
	
	/**
	 * Faz o cálculo de aumento do salário para cada objeto de uma lista de objetos da classe(Funcionario)
	 * 
	 */
	private void calcularSalarios() {
		funcionarios = aplicarPromocao.calcular(getFuncionarios(), getPercentualDeAumento());
	}
	
	/**
	 * Altera no banco cada objeto de uma lista de objetos da classe(Funcionario)
	 * 
	 */
	private void atualizarSalarios(){
	    funcionarioRepository.autualizarSalario(funcionarios);
	}
	
	/**
	 * Atualiza o atributo da classe cargo
	 * 
	 */
	private void atualizarCargo() {
		cargo = cargoRepository.buscarPor(cargo.getId());
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
	 * 
	 * Retorna o objeto cargo
	 * 
	 * @return cargo
	 * 
	 */
	public Cargo getCargo() {
		return cargo;
	}
		
	/**
	 * Retorna uma lista de objetos da classe (Cargo) cadastrados no banco
	 * 
	 * @return cargos lista de objetos da classe (Cargo)
	 * 
	 */
	public List<Cargo> getCargos(){
	    return cargoRepository.listarTodos();
	}
	
	/**
	 * Retorna uma lista de objetos da classe (Funcionario) relacionados a um
	 * cargo específico
	 * 
	 * @return funcionarios lista de objetos da classe (Funcionario)
	 * 
	 */
	public List<Funcionario> getFuncionarios(){
		 return cargo.getFuncionarios();
	}
	
	/**
	 * Retorna o valor do atributo da classe percentualDeAumento
	 * 
	 * @return percentualDeAumento objeto do tipo (BigDecimal)
	 * 
	 */
	public BigDecimal getPercentualDeAumento() {
		return percentualDeAumento;
	}

	/**
	 * Popula o valor do atributo da classe percentualDeAumento
	 * 
	 * @param percentualDeAumento objeto do tipo (BigDecimal)
	 * 
	 */
	public void setPercentualDeAumento(BigDecimal percentualDeAumento) {
		this.percentualDeAumento = percentualDeAumento;
	}

}
