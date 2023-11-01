package daoImpJPAHibernate;

import dao.CategoriaGastoDAO;
import modelos.CategoriaGasto;

public class CategoriaGastoDAOHibernateJPA extends GenericDAOImplJPA<CategoriaGasto> implements CategoriaGastoDAO {
	public CategoriaGastoDAOHibernateJPA() {
        super(CategoriaGasto.class);
    }

}
