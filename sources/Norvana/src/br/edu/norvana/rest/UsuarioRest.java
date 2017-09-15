package br.edu.norvana.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import br.edu.norvana.Dao.LocalDao;
import br.edu.norvana.Facade.Facade;
import br.edu.norvana.business.BusinessException;
import br.edu.norvana.entity.Produto;

@Path("/usuariorest")
public class UsuarioRest {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void cadastrarProduto(Produto produto){
		
		Facade facade = new Facade();
		
		try {
			facade.salvar(produto);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
			
	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<Produto> listarProduto(){
		return (ArrayList<Produto>) new Facade().listarProduto();
		
				
	}

}
