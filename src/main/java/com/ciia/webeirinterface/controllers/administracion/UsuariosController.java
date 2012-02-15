package com.ciia.webeirinterface.controllers.administracion;

import com.ciia.webeirinterface.controllers.applicationConstants.ConstantesWeb;
import com.ciia.webeirinterface.model.db.Usuario;
import com.ciia.webeirinterface.model.json.ListaGridJson;
import com.ciia.webeirinterface.model.json.PaginaGrid;
import com.ciia.webeirinterface.model.json.RespuestaEditJson;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/usuario/")
public class UsuariosController {
	
	private final String tilesAsignado = "usuarioTiles";
	private final String tilesSiguiente = "principalTiles";
	
    @RequestMapping(value="usuarios.htm",method = RequestMethod.GET)
	public String initForm(ModelMap model) {
		return this.tilesAsignado;
	}
	

	@RequestMapping(value="obtenUsuarios.htm",method = RequestMethod.GET)
	 public @ResponseBody PaginaGrid<Usuario> listBooks(
      @RequestParam(value = "page", required = false, defaultValue = "1") int page,
      @RequestParam(value = "max", required = false, defaultValue = "20") int max) {
		List<Usuario> usuarios=new ArrayList<Usuario>();
		
		usuarios.add(new Usuario(1, "Débora", "Melo", "Alegria", "lalala", "leelle", "agluno@domain.com", "Otra"));
		usuarios.add(new Usuario(2, "Nombre", "Jejej", "Alegria", "lalal0", "leelle", "agluno@domain.com", "Otra"));
		usuarios.add(new Usuario(3, "Otro", "Asl", "Alegria", "lalale", "leelle", "agluno@domain.com", "Otra"));
		usuarios.add(new Usuario(4, "Lelo", "Lero", "Alegria", "lalali", "leelle", "agluno@domain.com", "Otra"));
		usuarios.add(new Usuario(5, "Lalo", "aalala", "Alegria", "lalalu", "leelle", "agluno@domain.com", "Otra"));
		
		return new PaginaGrid(usuarios, page, usuarios.size(), max);
	}
	
	@RequestMapping(value="editaUsuario.htm",method = {RequestMethod.PUT, RequestMethod.POST})
	public @ResponseBody RespuestaEditJson editaUsuario(@RequestBody Usuario usuario) {
		
		RespuestaEditJson respuesta=new RespuestaEditJson();
		System.out.println("******************************************");
		System.out.println((usuario!=null?usuario+" "+usuario.getNombreCompleto():"No llegó D:"));
		
		respuesta.setMessage("Operación realizada");
		respuesta.setStatus(ConstantesWeb.CONST_JSON_RESPONSE_STATUS_SUCCESS);
		return respuesta;
	}
	
	@RequestMapping(value="eliminaUsuario.htm",method = RequestMethod.POST)
	public @ResponseBody RespuestaEditJson eliminaUsuario(@RequestParam(value = "id", required = true) int id) {
		
		RespuestaEditJson respuesta=new RespuestaEditJson();
		System.out.println("******************************************");
		System.out.println(id+"    lalala");
		
		respuesta.setMessage("Operación realizada");
		respuesta.setStatus(ConstantesWeb.CONST_JSON_RESPONSE_STATUS_SUCCESS);
		return respuesta;
	}
	
}
