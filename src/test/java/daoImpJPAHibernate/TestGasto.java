package daoImpJPAHibernate;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.GastoDAO;
import dao.GrupoDAO;
import dao.UsuarioDAO;
import modelos.CategoriaGasto;
import modelos.CategoriaGrupo;
import modelos.Gasto;
import modelos.Grupo;
import modelos.Usuario;


public class TestGasto {
	private GastoDAO gastoCRUD;

	private Usuario usu1, usu2;
	private Grupo grupo1;
	private Gasto gasto1, gasto2;
	private DaoFactory factory;

	
	

	public void inicializar() {
		//creo una fabrica de DAOS
		this.factory = new DaoFactory();
		
		//creo usuarios y los agrego a la BD
		this.usu1 = new Usuario("elvalsdelaluz", "Muñoz Loza", "Mariangeles", "maria@gmail.com", "1234");
		this.factory.getUsuarioDAO().persistir(usu1);
		this.usu2 = new Usuario("rafaga", "Diaz", "Antonio", "anto@gmail.com", "1234");
		this.factory.getUsuarioDAO().persistir(usu2);
		
		//creo una categoria y la persisto en la BD
		CategoriaGrupo cate1 = this.factory.getCategoriaGrupoDAO().persistir(new CategoriaGrupo("Viaje"));
		
		//creo un grupo
		this.grupo1 = new Grupo("Mochileros", cate1);
		this.factory.getGrupoDAO().persistir(grupo1);
		
		//creo el gasto
		this.gasto1 = new Gasto (15,usu1, "Partes iguales", grupo1);
	}
	
	@BeforeEach
	void setUp() throws Exception {
		inicializar();
	}
	

	@Test
	void testGastoDAOCrear() {
		assertEquals(gasto1, this.factory.getGastoDAO().persistir(gasto1));
	}
	
	@Test
	void testGastoDAOModificar() {
		Gasto gasto = this.factory.getGastoDAO().recuperar(5L);
		gasto.setMonto(1100);
		assertEquals(gasto.getMonto(), this.factory.getGastoDAO().actualizar(gasto).getMonto());
	}

//	@Test
//	void testGastoDAOBorrar() {
//		assertTrue(this.factory.getGastoDAO().existe(66L));
//		this.factory.getGastoDAO().borrar(66L);
//		assertFalse(this.factory.getGastoDAO().existe(66L));
//		
//	}
//	
	

}



