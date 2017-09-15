package br.edu.norvana.rest;

import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import br.edu.norvana.Facade.Facade;
import br.edu.norvana.business.BusinessException;
import br.edu.norvana.entity.Empresa;

@Path("/empresarest")
public class EmpresaRest {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void cadastrarempresa(Empresa empresa) {

		Facade facade = new Facade();

		try {
			facade.salvar(empresa);
		} catch (BusinessException e) {
			e.printStackTrace();
		}

	}

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<Empresa> listarempresa() {
		return (ArrayList<Empresa>) new Facade().listarEmpresa();

	}

}
