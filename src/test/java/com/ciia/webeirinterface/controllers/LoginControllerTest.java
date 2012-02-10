package com.ciia.webeirinterface.controllers;

import java.util.ArrayList;

import junit.framework.TestCase;

import com.ciia.webeirinterface.dao.DirectorioDAO;
import com.ciia.webeirinterface.dao.ImeiDAO;
import com.ciia.webeirinterface.dao.UsuarioDAO;
import com.ciia.webeirinterface.model.db.Empleado;
import com.ciia.webeirinterface.model.db.Imei;
import com.ciia.webeirinterface.model.db.PermisoSistema;
import com.ciia.webeirinterface.model.db.Usuario;
import com.ciia.webeirinterface.mybatis.AccesoIbatis;

public class LoginControllerTest extends TestCase{
	public final void testEjemplo(){
		int num1 = 3; 
        int num2 = 2; 
        int total = 5; 
        int sum = 0; 
        sum = num1 + num2;
        assertEquals(sum, total); 
	}
	
	/*public final void testIbatis () throws Exception{
		AccesoIbatis ibatis = new AccesoIbatis();
		
		try {
			
			ibatis.generarSession();
			ArrayList<Empleado> listEmpleado = (ArrayList<Empleado>)ibatis.getSqlSession().selectList("Empleado.getListaEmpleado");
			
			System.out.println("----------- EMPLEADOS -----------");
			for (Empleado empleado : listEmpleado) {
				System.out.println(empleado.getEmpleadoFE().toString() + " - " + empleado.getNombreCompletoEmpleado()+ ", " + empleado.getEmailEmpleado() + ", " + empleado.getNoSolicitud());
			}
			
			
			
			
			ibatis.getSqlSession().update("Empleado.updateEmpleado", new Empleado(new Integer(1), "EmpleadoFE"));
			Empleado empleado = (Empleado)ibatis.getSqlSession().selectOne("Empleado.getEmpleado", new Empleado(new Integer(1)));
			System.out.println("----------- UPDATE REALIZADO -----------");
			System.out.println("----------- EMPLEADO -----------");
			System.out.println(empleado.getEmpleadoFE().toString() + " - " + empleado.getNombreCompletoEmpleado()+ ", " + empleado.getEmailEmpleado() + ", " + empleado.getNoSolicitud());
			
			Empleado empInsert = new Empleado();
			empInsert.setApellidoMaternoEmpleado("apMat");
			empInsert.setApellidoPaternoEmpleado("apPat");
			empInsert.setEmailEmpleado("email");
			empInsert.setEmpleadoFE("FEclave");
			empInsert.setIdEmpleadoFE(null);
			empInsert.setNombreEmpleado("nomEmp");
			empInsert.setNoSolicitud("SolNo");
			empInsert.setNoSolicitudFE("SolNoFE");
			
			Integer Noempleado = ibatis.getSqlSession().insert("Empleado.insertEmpleado", empInsert);
			ibatis.getSqlSession().commit();
			System.out.println("----------- INSERT REALIZADO -----------");
			System.out.println("----------- EMPLEADO -----------");
			System.out.println(empInsert.getIdEmpleadoFE().toString() + " - " + empInsert.getEmpleadoFE().toString() + " - " + empInsert.getNombreCompletoEmpleado()+ ", " + empInsert.getEmailEmpleado() + ", " + empInsert.getNoSolicitud());
			
			System.out.println("----------- FIN -----------");
			
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("**********  E R R O R  **********");
			System.out.println(e.getMessage());
		}
		finally {
			//ibatis.cerrarSession();
		}
	}*/
	
	public final void testIbatis()throws Exception{
		try{
		
		System.out.println("--------TEST USUARIO-------");
		Usuario usuario = new Usuario();
		UsuarioDAO userLogin = new UsuarioDAO();
		usuario.setNombreUsuario("usuario01");
		usuario.setContrasenia("usuario01");
		
		usuario = userLogin.loginUsuario(usuario);
		System.out.println(usuario.getNombre() + " - " + usuario.getIdUsuario());
		System.out.println(usuario.getCambioContrasenia().toString());
		
		System.out.println("-------- TEST CONTRASENIA -------");
		usuario.setContrasenia("usuario01*");
		userLogin.cambioContrasenia(usuario);
		
		usuario = userLogin.loginUsuario(usuario);
		System.out.println(usuario.getNombre() + " - " + usuario.getCambioContrasenia().toString());
		
		System.out.println("---TEST DIRECTORIO---");
		if(usuario.getDirectorio()!=null) {
			System.out.println(usuario.getDirectorio().getNombre());
			System.out.println(usuario.getDirectorio().getNomenclatura().getDescripcion() + " - " + 
					usuario.getDirectorio().getNomenclatura().getDefinicion());
			System.out.println("---TEST SUBDIRECTORIO---");
			System.out.println(usuario.getDirectorio().getSubdirectorioPadre().get(0).getNombre());
			System.out.println(usuario.getDirectorio().getSubdirectorioPadre().get(0).getNomenclatura().getDescripcion());
			//System.out.println(usuario.getDirectorio().getDirectorioPadre().getNomenclatura().getDefinicion());
		}
		System.out.println("---PERFIL---");
		System.out.println(usuario.getPerfilSistema().getDescripcion());
		for (PermisoSistema permiso : usuario.getPerfilSistema().getPermisoSistema()) {
			System.out.println(permiso.getIdPermisoSistema().toString() + " - " + permiso.getDescripcion());
		}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace(); 
			System.out.println("**********  E R R O R  **********");
			System.out.println(e.getMessage() + " - " + e.getStackTrace());
		}
	}
	
	public final void testImei() throws Exception{
		try {
			ImeiDAO imeiDao = new ImeiDAO();
			Imei imei = imeiDao.consultaPorImei(new Imei("123456786543211"));
			
			System.out.println("-------- TEST IMEI -------");
			System.out.println(imei.getIdImei().toString() + " - " + 
					imei.getImei() + " ... " + 
					imei.getFechaModificacion() + " - " + imei.getFechaRegistro() + " - " +
					imei.getTipoLista().getDescripcion());
			System.out.println("-------- FIN TEST IMEI -------");
		} catch (Exception e) {
			//TODO: handle exception
			e.printStackTrace(); 
			System.out.println("**********  E R R O R  **********");
			System.out.println(e.getMessage() + " - " + e.getStackTrace());
		}
	}
	
	public final void testUsuario() throws Exception {
		try {
			System.out.println("-------- TEST USUARIO INSERT -------");
			UsuarioDAO usuarioDao = new UsuarioDAO();
			Usuario usuario = new Usuario();
			usuario.setNombre("nombreTest");
			usuario.setApellidoMaterno("AMTest");
			usuario.setApellidoPaterno("APTest");
			usuario.setArea("areaTest");
			usuario.setContrasenia("test");
			usuario.setCorreoElectronico("correoTest");
			usuario.setNombreUsuario("test");
			usuario.setActivo(true);
			
			usuario  = usuarioDao.insertarUsuario(usuario);
			
			System.out.println(usuario.getNombre() + " - " + usuario.getIdUsuario());
			System.out.println(usuario.getCambioContrasenia().toString());
			
			System.out.println("-------- FIN TEST IMEI -------");
		} catch (Exception e) {
			//TODO: handle exception
			e.printStackTrace(); 
			System.out.println("**********  E R R O R  **********");
			System.out.println(e.getMessage() + " - " + e.getStackTrace());
		}
	}
}
