package net.lorenscode.financas.teste;

import javax.persistence.EntityManager;

import net.lorenscode.financas.model.Conta;
import net.lorenscode.financas.util.JpaUtil;

public class TesteGerenciamentoJpa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManager manager = new JpaUtil().getEntityManager();
        manager.getTransaction().begin();

        // ID de uma conta que exista no banco de dados, no caso ID: 1
        Conta conta = manager.find(Conta.class, 1);

        // commit antes da alteração
        manager.getTransaction().commit();

        // Alteração do titular da conta
        conta.setTitular("Caelum ensino e inovação");

        manager.getTransaction().begin();
        manager.merge(conta);
        manager.getTransaction().commit();

        
        manager.close();
		

	}

}
