package br.edu.norvana.test;

import java.util.List;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.edu.norvana.Facade.Facade;
import br.edu.norvana.business.BusinessException;
import br.edu.norvana.entity.Movimentacao;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovimentacaoTest {
	
	public List<Movimentacao> movimentacoes;
	Facade facade = new Facade();
	
	@Test
	public void cadastrarMovimentacao(){
		
		Movimentacao m = new Movimentacao();
		m.setId(null);
		m.setJustificativa("a");
				
		Facade facade = new Facade();
		
		try {
			facade.salvar(m);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
		Assert.assertEquals(true,m.getId() != null);
	}

	@Test
	public void listarMovimentacao(){
		Facade facade = new Facade();
		
		movimentacoes = facade.listarMovimentacao();
		
		Assert.assertEquals(true,movimentacoes.size() > 0);
		
	}
	
	@Test
	public void zeditarMovimentacao(){
		movimentacoes  = facade.listarMovimentacao();
		Movimentacao m = movimentacoes.get(0);
		
		m.setJustificativa("q");
		
		Facade facade = new Facade();
		
		try {
			facade.salvar(m);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
		Assert.assertEquals(true,m.getJustificativa().equals("q"));
		
	}
	
	@Test
	public void zzexcluirMovimentacao(){
		movimentacoes = facade.listarMovimentacao();
		int i = movimentacoes.size();
		Movimentacao m = movimentacoes.get(0);
		
		Facade facade = new Facade();
		
		try {
			facade.excluirMovimentacao(m.getId());
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
		movimentacoes = facade.listarMovimentacao();
		
		Assert.assertEquals(true,movimentacoes.size() < i);
		
	}

}
