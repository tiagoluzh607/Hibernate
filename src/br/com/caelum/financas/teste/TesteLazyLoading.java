package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteLazyLoading {

	
	
	public static void main(String[] args) {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
		
		
        String jpql = "select distinct c from Conta as c left join fetch c.movimentacoes"; //com join Fetch ele já vai trazer na primeira consulta as movimentacoes, eliminando o lazy loading
        
        Query query = em.createQuery(jpql);
        List<Conta> todasAsContas = query.getResultList();
        
        for (Conta conta : todasAsContas) {
			System.out.println("Titular: "+ conta.getTitular());
			System.out.println("Movimentacoes: "+ conta.getMovimentacoes());
		}
       
        
        
		
		em.getTransaction().commit();
		em.close();
	}
}
