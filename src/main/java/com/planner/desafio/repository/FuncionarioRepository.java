package com.planner.desafio.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.planner.desafio.model.Funcionario;
import com.planner.desafio.util.jpa.Transactional;
import com.planner.desafio.util.jsf.FacesUtil;

/**
 * Implementa a interface de acesso ao banco de dados para transações de dados de objetos da classe
 * (Funcionario).
 * 
 *  
 * @author Gilmar Carlos
 *
 */
public class FuncionarioRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entity;
	
	/**
	 * Responsável por persistir ou atualizar os dados de um objeto. 
	 *  
	 * @param funcionario objeto da classe (Funcionario) com dados para serem persistidos ou atualizados
	 * 
	 */
	@Transactional
	public void salvar(Funcionario funcionario) {

		if (funcionario.getId() == null) {
			entity.persist(funcionario);
			FacesUtil.addInfoMessage("Cadastrado com sucesso!");
		} else {
			entity.merge(funcionario);
			FacesUtil.addInfoMessage("Alterado com sucesso!");
		}
	}
	
	/**
	 * Responsável por remover os dados de um objeto. 
	 *  
	 * @param funcionario objeto da classe (Funcionario) com dados para ser removido
	 * 
	 */
	@Transactional
	public void remover(Funcionario funcionario) {
		try {
			entity.remove(funcionario);
			FacesUtil.addInfoMessage("Removido com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			FacesUtil.addErrorMessage("Não foi possível concluir essa operação");
		}
	}
	
	/**
	 * Responsável por percorrer uma lista de objetos com salários a serem atualizados no banco.
	 *  
	 * @param funcionarios Lista de objetos da classe (Funcionario)
	 * 
	 */
	public void autualizarSalario(List<Funcionario> funcionarios) {
		funcionarios.forEach(funcionario -> atualizar(funcionario));
		FacesUtil.addInfoMessage("Salários foram atualizados!");
	}
	
	/**
	 * Responsável por atualizar um objeto que teve o atributo salário acrescido em seu valor.
	 *  
	 * @param funcionario Objeto da classe (Funcionario)
	 * 
	 */
	private void atualizar(Funcionario funcionario) {
		entity.getTransaction().begin();
		entity.merge(funcionario);
		entity.getTransaction().commit();
	}
	
	/**
	 * Responsável por fazer uma busca e retornar uma lista com todos os objetos.
	 *  
	 * @return List Lista de objetos da classe (Funcionario)
	 * 
	 */
	public List<Funcionario> listarTodos() {
		TypedQuery<Funcionario> query = entity.createQuery("Select f from Funcionario f order by f.nome", Funcionario.class);
		return query.getResultList();
	}

}
