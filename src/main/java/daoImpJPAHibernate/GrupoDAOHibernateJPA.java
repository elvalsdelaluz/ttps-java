package daoImpJPAHibernate;

import dao.GrupoDAO;
import modelos.Grupo;

public class GrupoDAOHibernateJPA extends GenericDAOImplJPA<Grupo> implements GrupoDAO{
    public GrupoDAOHibernateJPA() {
        super(Grupo.class);
    }
}
