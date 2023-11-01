package daoImpJPAHibernate;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import java.io.Serializable;
import java.util.List;

import dao.GenericDAO;

public class GenericDAOImplJPA <T> implements GenericDAO <T> {
    protected Class<T> clasePersistente;
    
    //CONSTRUCTOR
	public GenericDAOImplJPA(Class<T> clase) {
	    this.clasePersistente = clase;
	 }
	
	//MÉTODOS	
	private Class getPersistentClass() {
		return this.clasePersistente;
	}
	
	
	@Override
	public T persistir(T entity) {
	   EntityManager em = EMF.getEMF().createEntityManager();
	   EntityTransaction tx = null;
	   try {
	     tx = em.getTransaction();
	     tx.begin();
	     em.persist(entity);
	     tx.commit();
	   }
	   catch (RuntimeException e) {
	     if ( tx != null && tx.isActive() ) tx.rollback();
	     System.out.println("No se pudo persistir la entidad");
	     throw e;
	   }
	   finally {
	      em.close();
	   } return entity;
	}
	
	public T actualizar(T entity) {
	   EntityManager em= EMF.getEMF().createEntityManager();
	   EntityTransaction etx= em.getTransaction();
	   etx.begin();
	   T entityMerged = em.merge(entity);
	   etx.commit();
	   em.close();
	   return entityMerged;
	}
	
//	public T save(T entity) throws Exception {
//		// TODO Auto-generated method stub
//		try {
//			T entityAux = existe(entity);
//			if (entityAux != null){
//				return this.actualizar(entityAux);
//				}
//			else {
//				return this.persistir(entity);
//				}
//			}
//		catch (Exception e) {
//			throw e;
//			}
//	}
	

	
	@Override
	public void borrar(T entity) {
	    EntityManager em = EMF.getEMF().createEntityManager();
	    EntityTransaction tx = null;

	    try {
	        tx = em.getTransaction();
	        tx.begin();

	        // Carga la entidad en el contexto de persistencia si no está en estado "persistent."
	        if (!em.contains(entity)) {
	            entity = em.merge(entity);
	        }

	        em.remove(entity); // Ahora puedes eliminarla

	        tx.commit();
	    } catch (RuntimeException e) {
	        if (tx != null && tx.isActive()) {
	            tx.rollback();
	        }
	        throw e;
	    } finally {
	        em.close();
	    }
	}

	
	@Override
	public T borrar(Long id) {
  	EntityManager em = EMF.getEMF().createEntityManager();
		T entity=(T) em.find(this.getPersistentClass(), id);
		if (entity != null) {
			this.borrar(entity);
			}
		em.close();
		return entity;
	}
	


	public List<T> recuperarTodos(String columnOrder) {
		List<T> resultado = null;
		try {
			Query consulta=EMF.getEMF().createEntityManager().createQuery("select e from "+ getPersistentClass().getSimpleName()+" e order by e."+columnOrder);
			resultado = (List<T>) consulta.getResultList();
		}
		catch (Exception e) {
			throw e;
		}
	return resultado;
	}
	
	
//	@Override
//	public T recuperar(Serializable id) {
//	    EntityManager em = EMF.getEMF().createEntityManager();
//
//	    // Utiliza la consulta JPQL para recuperar la entidad por su ID
//	    String jpql = "SELECT e FROM " + getPersistentClass().getSimpleName() + " e WHERE e.id = :id";
//
//	    // Crea la consulta y establece el parámetro ":id"
//	    Query query = em.createQuery(jpql);
//	    query.setParameter("id", id);
//
//	    // Ejecuta la consulta y obtén el resultado como un objeto de la entidad
//	    T e = (T) query.getSingleResult();
//
//	    em.close();
//
//	    return e;
//	}
	
	//Otra manera de encararlo
	@Override
	public T recuperar(Serializable id) {
		return (T) EMF.getEMF().createEntityManager().find(getPersistentClass(), id);
	}
	
	
	@Override
	public boolean existe(Long id) {
         boolean existe = false;
		 EntityManager em = EMF.getEMF().createEntityManager();

		 // Utiliza la consulta JPQL para recuperar la entidad por su ID
		 String jpql = "SELECT e FROM " + getPersistentClass().getSimpleName() + " e WHERE e.id = :id";

		 // Crea la consulta y establece el parámetro ":id"
		 Query query = em.createQuery(jpql);
		 query.setParameter("id", id);

		 // Ejecuta la consulta y obtén el resultado como un objeto de la entidad
		 T e = (T) query.getSingleResult();
         if (e != null) {
        	 existe = true;
         }
		 em.close();

		 return existe;
	}
	
// // Otra forma de encararlo
//public T existe(T entity)throws NoResultException, NonUniqueResultException{
//		
//		Query q = this.makeQuery(entity);
//			
//		try {
//			@SuppressWarnings("unchecked")
//			T teAux =(T) q.getSingleResult();
//			System.out.println("existe el "+getPersistentClass().toString()+", lo actualizo");
//			
//			return teAux;
//			}
//		catch (NoResultException e) {
//			System.out.println("la consulta no trajo nada, se persiste el "+getPersistentClass().toString());
//			return null;
//		}
//		catch (NonUniqueResultException e1) {
//			System.out.println(entity.toString()+ "existe mas de un "+getPersistentClass().toString()+" activo, no se puede actualizar");
//			throw e1;
//		}
//	
//	}

//	@Override
//	public T recuperar(Serializable id) {
//		EntityManager em = EMF.getEMF().createEntityManager();
//		// Utiliza la consulta JPQL para recuperar el gasto por su ID
//	    String jpql = "SELECT e FROM e "+ getPersistentClass() +" WHERE e.id = :id";
//	    
//	    // Crea la consulta y establece el parámetro ":id"
//	    Query query = em.createQuery(jpql);
//	    query.setParameter("id", id);
//	    
//	    // Ejecuta la consulta y obtén el resultado como un objeto Gasto
//	    T e = (T) query.getSingleResult();
//	    
//	    em.close();
//	    
//		// TODO Auto-generated method stub
//		return e;
//	}

	

     
}
