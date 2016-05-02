package net.lorenscode.financas.teste;

import javax.persistence.EntityManager;

import net.lorenscode.financas.model.Conta;
import net.lorenscode.financas.util.JpaUtil;

public class TestaEstadosJpa {
	
	public static void main(String[] args) {

        EntityManager manager = new JpaUtil().getEntityManager();        

        manager.getTransaction().begin();

        // ID de uma conta que exista no banco de dados, no caso ID: 1
        Conta conta = manager.find(Conta.class, 1);

     // Alterando o titular da conta
        conta.setTitular("Luiz Ferreira");

        System.out.println(conta.getTitular());

        manager.getTransaction().commit();
        manager.close();
    }

}
