package br.edu.norvana.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Local {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String codigo;
	private String descricao;
	private Integer empresa;
	private String produto;
	private Float quantidade;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Integer empresa) {
		this.empresa = empresa;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public Float getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Float quantidade) {
		this.quantidade = quantidade;
	}
	

}
