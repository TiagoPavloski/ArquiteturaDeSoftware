package br.edu.norvana.rest;

import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import br.edu.norvana.Facade.Facade;
import br.edu.norvana.business.BusinessException;
import br.edu.norvana.entity.Movimentacao;


@Path("/movimentacaorest")
public class MovimentacaoRest {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void cadastrarMovimentacao(Movimentacao movimentacao) {

		Facade facade = new Facade();

		try {
			facade.salvar(movimentacao);
		} catch (BusinessException e) {
			e.printStackTrace();
		}

	}

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<Movimentacao> listarMovimentacao() {
		return (ArrayList<Movimentacao>) new Facade().listarMovimentacao();

	}

	
	@Path("/excluir")
	@POST
	public void excluirMovimentacao(@QueryParam("id") Long id){
		Facade facade = new Facade();
		
		try {
			facade.excluir(id);
		} catch (BusinessException e) {
			e.printStackTrace();
		}	
				
	}
	
}
