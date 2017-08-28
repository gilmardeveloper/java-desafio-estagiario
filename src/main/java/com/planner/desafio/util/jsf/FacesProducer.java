package com.planner.desafio.util.jsf;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 * Serve de referência para o CDI produzir instâncias das classes abstratas (FacesContext) e (ExternalContext)
 * 
 * @author Gilmar Carlos
 *
 */
public class FacesProducer {
	
	
	/**
	 * Factory method usado pelo CDI para criação de objetos do tipo (FacesContext) 
	 * 
	 * @return facesContext instância da classe abstrata FacesContext
	 */
	@Produces
	@RequestScoped
	public FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}
	

	/**
	 * Factory method usado pelo CDI para criação de objetos do tipo (ExternalContext) 
	 * 
	 * @return externalContext instância da classe abstrata ExternalContext
	 */
	@Produces
	@RequestScoped
	public ExternalContext getExternalContext() {
		return getFacesContext().getExternalContext();
	}
	
}
