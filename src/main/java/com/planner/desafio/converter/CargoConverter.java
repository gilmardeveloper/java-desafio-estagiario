package com.planner.desafio.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;

import com.planner.desafio.model.Cargo;
import com.planner.desafio.util.jpa.EntityFactory;

/**
 * Responsável por realizar conversões bidirecionais de um objeto da classe (Cargo) em um atributo id do tipo (String) 
 * 
 * @author Gilmar Carlos
 *
 */
@FacesConverter("cargoConverter")
public class CargoConverter implements Converter {

	/**
	 *  Retorna um objeto da classe (Cargo) relacionado a um id específico.
	 *  
	 *  @param context instância de (FacesContext)
	 *  @param component instância de (UIComponent)
	 *  @param valor id no tipo (String)
	 *  
	 *   @return object instância da classe (Cargo)
	 */
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String valor) {
		Long id = Long.valueOf(valor);
		EntityManager em = new EntityFactory().createEntityManager();
		return em.find(Cargo.class, id);
	}
	
	/**
	 *  Retorna um id de tipo (String) relacionado a um objeto da classe (Cargo)
	 *  
	 *  @param context instância de (FacesContext)
	 *  @param component instância de (UIComponent)
	 *  @param object instância de (Cargo)
	 *  
	 *   @return id valor em String
	 */
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object object) {
		
		if (object != null) {
			return  ((Cargo) object).getId().toString();
		}
		return "";
	}

}
