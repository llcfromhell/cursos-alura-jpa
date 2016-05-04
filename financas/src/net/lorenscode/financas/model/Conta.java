package net.lorenscode.financas.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "SEQ_CONTAS", sequenceName = "SEQ_CONTAS", initialValue = 1)
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_CONTAS")
    private Integer id;
    private String titular;
    private String banco;
    private String agencia;
    private String numero;
    
    @OneToMany(mappedBy="conta", fetch=FetchType.LAZY)
    private List<Movimentacao> movimentacoes;

    
    
    public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}

	public void setMovimentacoes(List<Movimentacao> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
