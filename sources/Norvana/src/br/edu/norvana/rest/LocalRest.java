package br.edu.norvana.rest;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import br.edu.norvana.Dao.LocalDao;
import br.edu.norvana.business.BusinessException;
import br.edu.norvana.business.BusinessLocal;
import br.edu.norvana.entity.Local;

@Path("/localrest")
public class LocalRest {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void cadastrarLocal(Local local){
		
		BusinessLocal localBusiness = new BusinessLocal();
		
		try{
			localBusiness.salvar(local);
		}catch (BusinessException e){
			e.printStackTrace();
		}
			
	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<Local> listarLocal(){
		return (ArrayList<Local>) new LocalDao().listar();
		
				
	}

}
