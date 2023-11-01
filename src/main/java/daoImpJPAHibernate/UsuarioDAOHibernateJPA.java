package daoImpJPAHibernate;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.UsuarioDAO;
import modelos.Usuario;

public class UsuarioDAOHibernateJPA extends GenericDAOImplJPA<Usuario> implements UsuarioDAO{
    public UsuarioDAOHibernateJPA() {
        super(Usuario.class);
    }

    @Override
    public Usuario recuperarPorEmail(String email) {
        EntityManager entityManager = EMF.getEMF().createEntityManager(); // Obtén un EntityManager

        Query consulta = entityManager.createQuery("FROM Usuario u WHERE u.email = :email"); // Corrige la sintaxis de la consulta
        consulta.setParameter("email", email);

        Usuario resultado = (Usuario) consulta.getSingleResult();
        entityManager.close(); // No olvides cerrar el EntityManager cuando hayas terminado con él

        return resultado;
    }

}
