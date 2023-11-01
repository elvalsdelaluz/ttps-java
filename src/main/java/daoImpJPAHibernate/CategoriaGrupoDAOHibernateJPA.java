package daoImpJPAHibernate;

import dao.CategoriaGrupoDAO;
import modelos.CategoriaGrupo;

public class CategoriaGrupoDAOHibernateJPA extends GenericDAOImplJPA<CategoriaGrupo> implements CategoriaGrupoDAO {
	public CategoriaGrupoDAOHibernateJPA() {
        super(CategoriaGrupo.class);
    }

}
