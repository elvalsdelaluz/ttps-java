package daoImpJPAHibernate;

import dao.PagoDAO;
import modelos.Pago;

public class PagoDAOHibernateJPA  extends GenericDAOImplJPA<Pago> implements PagoDAO{
    public PagoDAOHibernateJPA() {
        super(Pago.class);
    }

}
