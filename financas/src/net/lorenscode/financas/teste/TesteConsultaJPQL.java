package net.lorenscode.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import net.lorenscode.financas.model.Conta;
import net.lorenscode.financas.model.Movimentacao;
import net.lorenscode.financas.model.TipoMovimentacao;
import net.lorenscode.financas.util.JpaUtil;

public class TesteConsultaJPQL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				EntityManager em = new JpaUtil().getEntityManager();
				
				Conta conta = new Conta();
				conta.setId(1);
				
				Query query = em.createQuery("select m from Movimentacao m where m.conta = ?1 and m.tipoMovimentacao = ?2");
				
				query.setParameter(1, conta);
				query.setParameter(2, TipoMovimentacao.SAIDA);
				
				List<Movimentacao> lista = query.getResultList();
				
				for (Movimentacao m : lista) {
					System.out.println(m.getDescricao());
					System.out.println(m.getValor());
				}

	}

}
