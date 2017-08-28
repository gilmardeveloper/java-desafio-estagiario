package com.planner.desafio.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.planner.desafio.model.Cargo;
import com.planner.desafio.util.jpa.Transactional;
import com.planner.desafio.util.jsf.FacesUtil;

/**
 * Implementa a interface de acesso ao banco de dados para transações de dados de objetos da classe
 * (Cargo).
 * 
 *  
 * @author Gilmar Carlos
 *
 */
public class CargoRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entity;
	
	/**
	 * Responsável por persistir ou atualizar os dados de um objeto. 
	 *  
	 * @param cargo objeto da classe (Cargo) com dados para serem persistidos ou atualizados
	 * 
	 */
	@Transactional
	public void salvar(Cargo cargo) {

		if (cargo.getId() == null) {
			entity.persist(cargo);
			FacesUtil.addInfoMessage("Cadastrado com sucesso!");
		} else {
			entity.merge(cargo);
			FacesUtil.addInfoMessage("Alterado com sucesso!");
		}
	}
	
	/**
	 * Responsável por remover os dados de um objeto. 
	 *  
	 * @param cargo objeto da classe (Cargo) com dados para ser removido
	 * 
	 */
	@Transactional
	public void remover(Cargo cargo) {
		try {
			entity.remove(cargo);
			FacesUtil.addInfoMessage("Removido com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			FacesUtil.addErrorMessage("Não foi possível concluir essa operação");
		}
	}
	
	/**
	 * Responsável por fazer uma busca e retornar uma lista com todos os objetos.
	 *  
	 * @return List Lista de objetos da classe (Cargo)
	 * 
	 */
	public List<Cargo> listarTodos() {
		TypedQuery<Cargo> query = entity.createQuery("Select c from Cargo c order by c.codigo", Cargo.class);
		return query.getResultList();
	}

	/**
	 * Responsável por fazer a busca por id e retornar o objeto resultante da busca. 
	 *  
	 * @param id objeto do tipo (Long) que representa a chave primária de um objeto
	 * @return cargo retorna o objeto resultante do processo de busca
	 */
	public Cargo buscarPor(Long id) {
		return entity.find(Cargo.class, id);
	}

}
