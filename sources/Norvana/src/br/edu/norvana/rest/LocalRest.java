package br.edu.norvana.rest;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



import br.edu.norvana.Facade.Facade;
import br.edu.norvana.business.BusinessException;
import br.edu.norvana.entity.Local;


@Path("/localrest")
public class LocalRest {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void cadastrarLocal(Local local){
		
		Facade facade = new Facade();
		
		try {
			facade.salvar(local);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
			
	}
	
	@SuppressWarnings("unused")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Local> listarLocal(){
		Facade facade = new Facade();
		return (ArrayList<Local>) new Facade().listarLocal();
		
				
	}

}
