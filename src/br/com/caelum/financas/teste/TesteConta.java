package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConta {

	public static void main(String[] args) {
		
		Conta conta = new Conta(); //estado (Transient) - não tem registro no banco
		conta.setTitular("Leonardo");
		conta.setAgencia("123");
		conta.setBanco("Caixa Federal");
		conta.setNumero("456");
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		em.persist(conta); //quando persistido o hibernate já passa a conta para o estado managed (sincronizado com o registro do banco)
		
		
		conta.setBanco("bradesco"); //estado (Managed) já vai deixar o objeto no banco pronto para um update
		
		em.getTransaction().commit();
		
		em.close(); //tira todos os estados (Managed)
		
		
		/* ################################################ Fechamos o entity manager e vamos criar outro ################# */
		
		EntityManager em2 = new JPAUtil().getEntityManager();
		em2.getTransaction().begin();
		
		conta.setTitular("Teste de Merge"); // estado (Datached) pois existe um registro no banco
		
		//Tentando transformar para o estado (Managed)
		
		//em2.persist(conta); //erro pois o persist trabalha com o estado (Transient) e não com o Datached
		em2.merge(conta); //merge tranforma um estado (Datached) em (Managed) buscando pelo id da conta
		
		em2.getTransaction().commit();
		em2.close();
			
	}

}
