package com.planner.desafio.promocao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.planner.desafio.model.Funcionario;

/**
 * Responsável por promover métodos para auxiliar no cálculo de aumento de salário. 
 * 
 * @author Gilmar Carlos
 *
 */
public class AplicarPromocao implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Responsável por interar uma lista de funcionários e repassar o valor de percentual de aumento,
	 * para cada objeto na interação. 
	 * 
	 * @param funcionarios lista de objetos do tipo (Funcionario)
	 * @param percentualDeAumento valor do tipo (BigDecimal) para ser usado no cálculo
	 * 
	 * @return funcionarios uma lista de objetos do tipo (Funcionario) com salários alterados.
	 * 
	 */
	public List<Funcionario> calcular(List<Funcionario> funcionarios, BigDecimal percentualDeAumento){
     return	funcionarios.stream()
						.peek(funcionario -> funcionario.recebeAumento(percentualDeAumento))
						.collect(Collectors.toList());
 	}
	
}
