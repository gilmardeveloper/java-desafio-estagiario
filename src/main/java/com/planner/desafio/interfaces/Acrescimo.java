package com.planner.desafio.interfaces;

import java.math.BigDecimal;

/**
 * Interface para classes que implementam aumento de valores baseado em percentual 
 * 
 * @author Gilmar Carlos
 *
 */
public interface Acrescimo {
	
	/**
	 * Método a ser implementado para realizar o cálculo do aumento 
	 * 
	 * @param percentualDeAumento objeto do tipo (BigDecimal) que representa o valor em percentual a ser acrescido
	 */
	void recebeAumento(BigDecimal percentualDeAumento);
	
}
