package br.com.caelum.financas.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Conta {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String titular;
	private String numero;
	private String banco;
	private String agencia;
	//@OneToMany(mappedBy="conta", fetch = FetchType.EAGER) // o fetch EAGER faz com que quando buscada uma conta no banco traga junto na consulta as movimentações usando um join
	@OneToMany(mappedBy="conta") //não é um novo relacionamento e sim apenas a outra parte de um relacionamento que esta na classe movimentacao na propriedade conta
	private List<Movimentacao> movimentacoes;
	
	
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
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
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
	public List<Movimentacao> getMovimentacoes() {
		// TODO Auto-generated method stub
		return this.movimentacoes;
	}
	
	

}
