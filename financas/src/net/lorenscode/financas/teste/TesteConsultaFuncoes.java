package net.lorenscode.financas.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import net.lorenscode.financas.dao.MovimentacaoDao;
import net.lorenscode.financas.model.Conta;
import net.lorenscode.financas.model.TipoMovimentacao;
import net.lorenscode.financas.util.JpaUtil;

public class TesteConsultaFuncoes {
	
	public static void main(String[] args) {
		EntityManager em = new JpaUtil().getEntityManager();
		
		Conta conta = new Conta();
		conta.setId(3);
		
		TypedQuery<Long> query = em.createQuery("select count(m) from Movimentacao m where m.conta = :pConta", Long.class)
				.setParameter("pConta", conta);
		System.out.println(query.getSingleResult());
		
		TypedQuery<BigDecimal> query2 = em.createQuery("select max(m.valor) from Movimentacao m where m.conta = :pConta", BigDecimal.class)
				.setParameter("pConta", conta);
		System.out.println("maior gasto da conta é " + query2.getSingleResult());
		
		Query q1 = em.createQuery("select sum(m.valor) from Movimentacao m where m.conta = :pConta "
				+ " and m.tipoMovimentacao = :pTipo")
				.setParameter("pConta", conta)
				.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		BigDecimal soma = (BigDecimal) q1.getSingleResult();
		
		MovimentacaoDao dao = new MovimentacaoDao(em);
		
		Double media  = dao.getMediaDaContaPeloTipoMovimentacao(conta, TipoMovimentacao.SAIDA);		
		
		Double mediaNamed = dao.getMediaDaContaPeloTipoMovimentacaoNamed(conta, TipoMovimentacao.SAIDA);
		
		System.out.println(mediaNamed);
		
	}

}
