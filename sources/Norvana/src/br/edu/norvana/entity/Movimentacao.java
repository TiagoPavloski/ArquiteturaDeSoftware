package br.edu.norvana.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Movimentacao{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@ManyToOne
	private Produto produto;
	private int localAnterior;
	private int localAtual;
	@ManyToOne
	private Empresa empresa;
	private Date data;
	private String justificativa;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public int getLocalAnterior() {
		return localAnterior;
	}
	public void setLocalAnterior(int localAnterior) {
		this.localAnterior = localAnterior;
	}
	public int getLocalAtual() {
		return localAtual;
	}
	public void setLocalAtual(int localAtual) {
		this.localAtual = localAtual;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getJustificativa() {
		return justificativa;
	}
	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

}
