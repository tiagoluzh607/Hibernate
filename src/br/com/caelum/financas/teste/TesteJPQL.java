package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPQL {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		
		String jpql = "select m from Movimentacao as m where m.conta.id = 2";
		
		Query query = em.createQuery(jpql);
		
		List<Movimentacao> movimentacoes = query.getResultList();
		
		for (Movimentacao movimentacao : movimentacoes) {
			System.out.println(movimentacao.getId() + " - " + movimentacao.getDescricao() + " - " + movimentacao.getValor());
		}
		
		
		em.getTransaction().commit();
		em.close();
	}
}
