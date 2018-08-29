package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteBuscaConta {

	public static void main(String[] args) {
	
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		//buscando conta do banco de dados
		Conta conta = em.find(Conta.class, 1); //busca por id
		
		
		conta.setTitular("tiago luz"); //Este comando já prepara o objeto para dar um update no banco
		
		System.out.println(conta.getTitular());
		em.getTransaction().commit();
	}
	
}
