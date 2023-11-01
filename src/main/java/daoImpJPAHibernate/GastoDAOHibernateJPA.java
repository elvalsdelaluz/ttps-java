package daoImpJPAHibernate;

import dao.GastoDAO;
import modelos.Gasto;

public class GastoDAOHibernateJPA extends GenericDAOImplJPA<Gasto> implements GastoDAO{
    public GastoDAOHibernateJPA() {
        super(Gasto.class);
    }

}
