package net.lorenscode.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import net.lorenscode.financas.model.Conta;
import net.lorenscode.financas.model.Movimentacao;
import net.lorenscode.financas.util.JpaUtil;

public class TesteMovimentacaoConta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManager em = new JpaUtil().getEntityManager();
		//Conta conta = em.find(Conta.class, 1);
		//System.out.println(conta.getMovimentacoes().size());
		
		//Movimentacao movimentacao = em.find(Movimentacao.class, 1);
		//System.out.println(movimentacao.getConta().getTitular());
		
		
		Query q = em.createQuery("select c from Conta c join fetch c.movimentacoes");
		List<Conta> contas = q.getResultList();
		
		em.close();
		
		
		for (Conta conta2 : contas) {
			
			System.out.println(conta2.getMovimentacoes().size());
			
		}
		
		

	}

}
