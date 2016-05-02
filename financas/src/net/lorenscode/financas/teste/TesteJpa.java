package net.lorenscode.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import net.lorenscode.financas.model.Conta;
import net.lorenscode.financas.util.JpaUtil;

public class TesteJpa {

    public static void main(String[] args) {

    	double inicio = System.currentTimeMillis();
    	
        Conta conta = new Conta();
        conta.setTitular("Maria dos Santos");
        conta.setBanco("Caixa");
        conta.setAgencia("043");
        conta.setNumero("54321");

        EntityManager em = new JpaUtil().getEntityManager();
        em.getTransaction().begin();

        em.persist(conta);

        em.getTransaction().commit();
        em.close();
        
        double fim = System.currentTimeMillis();
        System.out.println("Executado em: " + (fim - inicio)/1000 + "s");	
        
    }
}