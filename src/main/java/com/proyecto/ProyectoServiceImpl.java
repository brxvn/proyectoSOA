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
		
		UsuarioType usuario = requestProyectoDoc.getRequestProyecto();
		UsuarioDto usuarioDto = new UsuarioDto();
		usuarioDto.setNombre(usuario.getNombre());
		usuarioDto.setApellido(usuario.getApellido());
		usuarioDto.setUsername(usuario.getUsername());	
		usuarioDto.setPassword(usuario.getPassword());
		
		
		String responseString = proyectoBusiness.AddUser(usuarioDto);


		ResponseProyectoDocument respDoc = ResponseProyectoDocument.Factory.newInstance();
		ResponseProyecto response = respDoc.addNewResponseProyecto();
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
