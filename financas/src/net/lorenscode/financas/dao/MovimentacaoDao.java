package net.lorenscode.financas.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import net.lorenscode.financas.model.Conta;
import net.lorenscode.financas.model.TipoMovimentacao;

public class MovimentacaoDao {

	private EntityManager em;

	public MovimentacaoDao(EntityManager em) {
		this.em = em;
		// TODO Auto-generated constructor stub
	}

	public Double getMediaDaContaPeloTipoMovimentacao(Conta conta, TipoMovimentacao saida) {
		// TODO Auto-generated method stub
		TypedQuery<Double> q = em.createQuery("select avg(m.valor) from Movimentacao m where m.conta = :pConta "
				+ " and m.tipoMovimentacao = :pTipo", Double.class)
				.setParameter("pConta", conta)
				.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		return q.getSingleResult();
		
	}

	public Double getMediaDaContaPeloTipoMovimentacaoNamed(Conta conta, TipoMovimentacao saida) {
		TypedQuery<Double> q = em.createNamedQuery("getMedia", Double.class)
				.setParameter("pConta", conta)
				.setParameter("pTipo", saida);
		
		return q.getSingleResult();
	}

}
