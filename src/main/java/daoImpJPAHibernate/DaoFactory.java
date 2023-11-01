package daoImpJPAHibernate;

import dao.CategoriaGastoDAO;
import dao.CategoriaGrupoDAO;
import dao.GastoDAO;
import dao.GrupoDAO;
import dao.PagoDAO;
import dao.UsuarioDAO;

public class DaoFactory {
	public static UsuarioDAO getUsuarioDAO() {
		 return new UsuarioDAOHibernateJPA();
	}
	
	public static GrupoDAO getGrupoDAO() {
		 return new GrupoDAOHibernateJPA();
	}
	
	public static GastoDAO getGastoDAO() {
		 return new GastoDAOHibernateJPA();
	}
	public static PagoDAO getPagoDAO() {
		 return new PagoDAOHibernateJPA();
	}
	
	public static CategoriaGastoDAO getCategoriaGastoDAO() {
		 return new CategoriaGastoDAOHibernateJPA();
	}
	
	public static CategoriaGrupoDAO getCategoriaGrupoDAO() {
		 return new CategoriaGrupoDAOHibernateJPA();
	}

}
