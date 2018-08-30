package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteMovimentacoesPorCategoria {

public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();


		Categoria categoria = new Categoria();
		categoria.setId(1);
		
		String jpql = "select m from Movimentacao as m join m.categorias as c where c = :pCategoria";
		
		Query query = em.createQuery(jpql);
		query.setParameter("pCategoria", categoria);
		
		
		
		List<Movimentacao> movimentacoes = query.getResultList();
		
		for (Movimentacao movimentacao : movimentacoes) {
			System.out.println(movimentacao.getId() + " - " + movimentacao.getDescricao() + " - "+movimentacao.getTipo()+" - "+ movimentacao.getValor());
		}
		
		
		em.getTransaction().commit();
		em.close();
	}
}
