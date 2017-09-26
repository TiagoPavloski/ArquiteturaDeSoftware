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
import br.edu.norvana.entity.Usuario;


@Path("/usuariorest")
public class UsuarioRest {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void cadastrarUsuario(Usuario usuario) {

		Facade facade = new Facade();

		try {
			facade.salvar(usuario);
		} catch (BusinessException e) {
			e.printStackTrace();
		}

	}

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<Usuario> listarUsuario() {
		return (ArrayList<Usuario>) new Facade().listarUsuario();

	}

	
	@Path("/excluir")
	@POST
	public void excluirUsuario(@QueryParam("id") Long id){
		Facade facade = new Facade();
		
		try {
			facade.excluirUsuario(id);
		} catch (BusinessException e) {
			e.printStackTrace();
		}	
				
	}
		
}
