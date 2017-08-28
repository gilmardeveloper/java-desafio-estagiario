package com.planner.desafio.util.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Classe utilitária para postagem de mensagens através do contexto do jsf 
 * 
 * @author Gilmar Carlos
 *
 */
public class FacesUtil {
	
	/**
	 * Simples método estático que retorna o resultado da postagem escrita por (ResponseStateManager) 
	 * 
	 * @return <code>true</code> se a requisição atual contém uma postagem de (ResponseStateManager)
	 */
	public static boolean isPostback() {
		return FacesContext.getCurrentInstance().isPostback();
	}
	
	/**
	 * Simples método estático que retorna o resultado da postagem escrita por (ResponseStateManager) 
	 * 
	 * @return <code>true</code> se a requisição atual não contém uma postagem de (ResponseStateManager)
	 */
	public static boolean isNotPostback() {
		return !isPostback();
	}
	
	/**
	 * Simples método estático que adiciona uma mensagem de erro a resposta no contexto de renderização 
	 * 
	 * @param message Mensagem de erro contendo detalhes da operação
	 * 
	 */
	public static void addErrorMessage(String message) {
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
	}
	
	/**
	 * Simples método estático que adiciona uma mensagem informativa na reposta no contexto de renderização 
	 * 
	 * @param message Mensagem de informação contendo detalhes da operação
	 * 
	 */
	public static void addInfoMessage(String message) {
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
	}
	
}