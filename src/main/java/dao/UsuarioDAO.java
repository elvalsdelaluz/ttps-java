package dao;

import java.util.List;

import modelos.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario> {
	 //public List<Usuario> recuperarPorRol(Rol rol, String columnOrder); //No tengo roles asi que esto no me sirve
	 public Usuario recuperarPorEmail(String email);

}
