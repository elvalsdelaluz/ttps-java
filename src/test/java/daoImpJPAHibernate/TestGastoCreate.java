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


public class TestGastoCreate {
	private GastoDAO gastoCRUD;

	private Usuario usu1, usu2;
	private CategoriaGrupo cate1;
	private Grupo grupo1;
	private Gasto gasto1, gasto2;
	private DaoFactory factory;

	
	public void inicializar() {
		//creo usuarios
		this.usu1 = new Usuario("elvalsdelaluz", "Muñoz Loza", "Mariangeles", "maria@gmail.com", "1234");
		this.usu2 = new Usuario("rafaga", "Diaz", "Antonio", "anto@gmail.com", "1234");	
		//creo una categoria
		this.cate1 = new CategoriaGrupo("Viaje");
		//creo un grupo
		this.grupo1 = new Grupo("Mochileros", cate1);
		//creo el gasto
		this.gasto1 = new Gasto (15,usu1, "Partes iguales", grupo1);
	}
	
	@BeforeEach
	void setUp() throws Exception {
		inicializar();
	}
	

	@Test
	void testGastoDAOCrear() {
		//creo una fabrica de DAOS
		this.factory = new DaoFactory();
		//Agrego usuarios a la BD
		this.factory.getUsuarioDAO().persistir(usu1);
		this.factory.getUsuarioDAO().persistir(usu2);
		//Agrego grupo a la BD
		this.factory.getCategoriaGrupoDAO().persistir(cate1);
		this.factory.getGrupoDAO().persistir(grupo1);
		//Agrego gasto a la BD
		assertEquals(gasto1, this.factory.getGastoDAO().persistir(gasto1));
	}
	

}



