package com.springsample.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import com.springsample.dto.UsuarioDto;

/**
 * @author brayg
 */
public class UsuarioDao {
	/**
	 * Template para manejo de BD de Spring.
	 */
    protected JdbcTemplate jdbcTemplate;

    /**
     * Establece el template.
     * @param jdbcTemplate
     */
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Agrega un usuario en la BD.
     * @param usuarioDto Usuario a agregar.
     */
    public void add(UsuarioDto usuarioDto) {
        jdbcTemplate.execute("INSERT INTO users(nombre,apellido,username,password,disney,hbo) "
        		+ "VALUES("
        		+ "'"+ usuarioDto.getNombre() + "', "
        		+ "'"+ usuarioDto.getApellido() + "', "
        		+ "'"+ usuarioDto.getUsername() + "', "
        		+ "'"+ usuarioDto.getPassword() + "', "
        		+ "'"+ usuarioDto.getDisney() + "', "
        		+ "'" + usuarioDto.getHboMax() + "') ");
    }
    
//    /**
//     * Borra un usuario en la BD.
//     * @param usuarioDto Usuario a agregar.
//     */
//    public void delete(UsuarioDto usuarioDto) {
//        jdbcTemplate.execute("DELETE FROM Usuario WHERE login = '" + usuarioDto.getLogin() + "'");
//    }
//    
//    /**
//     * Actualiza un usuario en la BD.
//     * @param usuarioDto Usuario a agregar.
//     */
//    public void update(UsuarioDto usuarioDto) {
//        jdbcTemplate.execute("UPDATE Usuario SET password = '" + usuarioDto.getPassword() + "' WHERE login = '" + usuarioDto.getLogin() + "' ");
//    }
//    
//    /**
//     * Consulta de usuarios
//     * @param usuarioDto Usuario a agregar.
//     */
//
//	public List<UsuarioDto> query(UsuarioDto usuarioDto) {
//    	List<UsuarioDto> list = new ArrayList<>();
//		List<Map<String, Object>> listSpring = jdbcTemplate.queryForList("SELECT id, login, password FROM usuario WHERE login = '" + 
//				usuarioDto.getLogin() +"' ");
//    	
//    	for (Map<String, Object> row : listSpring) {
//    		UsuarioDto usuarioConsultado = new UsuarioDto();
//    		usuarioConsultado.setId((Integer)row.get("id"));
//    		usuarioConsultado.setLogin((String)row.get("login"));
//    		usuarioConsultado.setPassword((String)row.get("password	"));
//    		list.add(usuarioConsultado);
//		}
//    	
//    	return list;
//    }
//    
//    /**
//     * Consulta de usuarios
//     * @param usuarioDto Usuario a agregar.
//     * @return usuarios consultados
//     */
//    @SuppressWarnings("unchecked")
//	public List<UsuarioDto> queryMapper(UsuarioDto usuarioDto) {
//    	return jdbcTemplate.query("SELECT id, login, password FROM usuario WHERE login = '" + usuarioDto.getLogin() +"' ", 
//    			new BeanPropertyRowMapper(UsuarioDto.class));
//    }
    
}
