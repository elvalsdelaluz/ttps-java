package daoImpJPAHibernate;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMF {
    private static final EntityManagerFactory em = Persistence.createEntityManagerFactory("miUPCuentasClaras2023");

    public static EntityManagerFactory getEMF() {
        return em;
    }
}
