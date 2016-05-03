package net.lorenscode.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import net.lorenscode.financas.model.Conta;
import net.lorenscode.financas.model.Movimentacao;
import net.lorenscode.financas.model.TipoMovimentacao;
import net.lorenscode.financas.util.JpaUtil;

public class TesteJpaRelacionamento {

    public static void main(String[] args) {

    	double inicio = System.currentTimeMillis();
    	
        Conta conta = new Conta();
        conta.setTitular("Maria dos Santos");
        conta.setBanco("Caixa");
        conta.setAgencia("043");
        conta.setNumero("54321");
        
        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setData(Calendar.getInstance());
        movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        movimentacao.setDescricao("Pagamento de Luz");
        movimentacao.setValor(new BigDecimal(100.00));
        
        movimentacao.setConta(conta);

        EntityManager em = new JpaUtil().getEntityManager();
        em.getTransaction().begin();

        em.persist(conta);
        em.persist(movimentacao);

        em.getTransaction().commit();
        em.close();
        
        double fim = System.currentTimeMillis();
        System.out.println("Executado em: " + (fim - inicio)/1000 + "s");	
        
    }
}