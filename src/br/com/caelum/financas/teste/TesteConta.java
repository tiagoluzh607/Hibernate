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
		
	}

}
