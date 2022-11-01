/**
 * ProyectoServiceSkeleton.java
 *
 * <p>This file was auto-generated from WSDL by the Apache Axis2 version: 1.8.2 Built on : Jul 13,
 * 2022 (06:38:03 EDT)
 */
package com.proyecto;

import java.rmi.RemoteException;

//import com.banco.ResponseBancoDocument.ResponseBanco;

/** ProyectoServiceSkeleton java skeleton for the axisService */

import com.proyecto.ResponseProyectoDocument.ResponseProyecto;
import com.proyecto.business.ProyectoBusiness;
import com.springsample.dto.UsuarioDto;

public class ProyectoServiceImpl extends ProyectoServiceSkeleton {

	private ProyectoBusiness proyectoBusiness;

	/**
	 * Auto generated method signature
	 *
	 * @param requestProyecto
	 * @return responseProyecto
	 * @throws RemoteException 
	 */
	public ResponseProyectoDocument proyectoOperation(RequestProyectoDocument requestProyectoDoc) {			
		String responseString = "";
		String responseDisney = "";
		String responseHbo = "";
		
		UsuarioType usuario = requestProyectoDoc.getRequestProyecto();
		UsuarioDto usuarioDto = new UsuarioDto();
		usuarioDto.setNombre(usuario.getNombre());
		usuarioDto.setApellido(usuario.getApellido());
		usuarioDto.setUsername(usuario.getUsername());	
		usuarioDto.setPassword(usuario.getPassword());
		usuarioDto.setDisney(usuario.getDisney());
		usuarioDto.setHboMax(usuario.getHbomax());
		
		ResponseProyectoDocument respDoc = ResponseProyectoDocument.Factory.newInstance();
		ResponseProyecto response = respDoc.addNewResponseProyecto();
		
		//agregamos a la bdd
		proyectoBusiness.AddUser(usuarioDto);
		String responseBanco = proyectoBusiness.Cobro(usuarioDto);
		
				
		//si el cobro es exitoso proseguimos
		if (!responseBanco.equalsIgnoreCase("Cobro Exitoso")) {
			response.setMensaje(responseBanco);
			return respDoc;
		}

		// si llegó con disney y procedemos a llamar al servicio que se encargará de la lógica
		if (usuario.getDisney() == 1) {
			//Pagamos disney
			responseDisney += proyectoBusiness.SubDisney(usuarioDto);
			System.out.println(responseDisney);
		}
		
		// si llegó con disney y procedemos a llamar al servicio que se encargará de la lógica
		if (usuario.getHbomax() == 1) {
			//Pagamos hbo
			responseHbo += proyectoBusiness.SubHbo(usuarioDto);
			System.out.println(responseHbo);
		}
		
		responseString = "Respuesta banco: " + responseBanco + "\n" + 
						"Respuesta disney: " + responseDisney + "\n" +
						"Respuesta hbo: " + responseHbo;
		
		response.setMensaje(responseString);

		return respDoc;
	}

	/**
	 * @param proyectoBusiness the proyectoBusiness to set
	 */
	public void setProyectoBusiness(ProyectoBusiness proyectoBusiness) {
		this.proyectoBusiness = proyectoBusiness;
	}

}
