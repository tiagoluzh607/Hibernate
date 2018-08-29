package br.com.caelum.financas.teste;

import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPARelacionamento {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		Conta conta = new Conta();
		//conta.setId(1); 
		conta.setTitular("Leonardo");
		conta.setAgencia("123");
		conta.setBanco("Caixa Federal");
		conta.setNumero("456");
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Churrascaria");
		movimentacao.setTipo(TipoMovimentacao.SAIDA);
		movimentacao.setConta(conta);
		
		em.getTransaction().begin();
		
		em.persist(conta);
		em.persist(movimentacao);
		
		
		em.getTransaction().commit();
		em.close();
	}
	
}
