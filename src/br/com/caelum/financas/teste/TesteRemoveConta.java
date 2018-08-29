package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteRemoveConta {
	
	public static void main(String[] args) {
		
		Conta conta = new Conta(); //estado (Transient) - não tem registro no banco
		conta.setId(1); 
		conta.setTitular("Leonardo");
		conta.setAgencia("123");
		conta.setBanco("Caixa Federal");
		conta.setNumero("456");
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		conta = em.merge(conta); // transforma do estado (Datached) para (Managed) // poderia ser usado o find tambem
		em.remove(conta); //só conseguimos remover quando o estado é (Managed)
		
		conta.setBanco("bradesco"); //estado (Managed) já vai deixar o objeto no banco pronto para um update
		
		em.getTransaction().commit();
		
		em.close(); //tira todos os estados (Managed)
	}
}
