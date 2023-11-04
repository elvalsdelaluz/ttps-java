package daoImpJPAHibernate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import dao.GastoDAO;
import modelos.CategoriaGrupo;
import modelos.Gasto;
import modelos.Grupo;
import modelos.Usuario;

public class TestGastoCRUD {
	private GastoDAO gastoCRUD;

	private Usuario usu1, usu2, usu4;
	private CategoriaGrupo cate1;
	private Grupo grupo1, grupo2, grupo4, grupo5;
	private Gasto gasto1, gasto2, gasto3, gasto4;
	private DaoFactory factory;
	
	private List<Gasto> gastos;

	
	public void inicializar() {
		//creo usuarios
		this.usu1 = new Usuario("elvalsdelaluz", "Muñoz Loza", "Mariangeles", "maria@gmail.com", "1234");
		this.usu2 = new Usuario("rafaga", "Diaz", "Antonio", "anto@gmail.com", "1234");	
		this.usu4 = new Usuario("gon", "Cellini", "Lara", "lara@gmail.com", "1234");	
		//creo una categoria
		this.cate1 = new CategoriaGrupo("Viaje");
		//creo un grupo
		this.grupo1 = new Grupo("Mochileros", cate1);
		this.grupo2 = new Grupo("Brasil", cate1);
		this.grupo4 = new Grupo("Otro", cate1);
		this.grupo5 = new Grupo("Otro2", cate1);
		//creo el gasto
		this.gasto1 = new Gasto (15,usu1, "Partes iguales", grupo1);
		this.gasto2 = new Gasto (10,usu1, "Partes iguales", grupo1);
		this.gasto3 = new Gasto (1,usu2, "Partes iguales", grupo2);
		this.gasto4 = new Gasto (1,usu4, "Partes iguales", grupo4);
		
		//creo una fabrica de DAO
		this.factory = new DaoFactory();
		
		//lista gastos 
		this.gastos= new ArrayList<Gasto> ();
		this.gastos.add(gasto1);
		this.gastos.add(gasto2);
		this.gastos.add(gasto3);
		
	}
	
	
	
	@BeforeEach
	void setUp() throws Exception {
		inicializar();
	}
	
	@Test
	void testGastoCreate() {
		//Agrego usuarios a la BD
		this.factory.getUsuarioDAO().persistir(usu1);
				
		//Agrego grupo a la BD
		this.factory.getCategoriaGrupoDAO().persistir(cate1);
		this.factory.getGrupoDAO().persistir(grupo1);
				
		//Persisto dos gastos
		assertEquals(gasto1, this.factory.getGastoDAO().persistir(gasto1));
		assertEquals(gasto2, this.factory.getGastoDAO().persistir(gasto2));
	}
	
	
	@Test
	void testGastoUpdate() {
		//Agrego usuarios a la BD
		this.factory.getUsuarioDAO().persistir(usu2);
						
		//Agrego grupo a la BD
		this.factory.getCategoriaGrupoDAO().persistir(cate1);
		this.factory.getGrupoDAO().persistir(grupo2);
		
        //Agrego un gasto
		this.factory.getGastoDAO().persistir(gasto3);
		
		//Recupero el gasto3 y lo modifico
		Gasto gasto = this.factory.getGastoDAO().recuperar(gasto3.getId_gasto());
		gasto.setMonto(1100);
		assertEquals(gasto.getMonto(), this.factory.getGastoDAO().actualizar(gasto).getMonto());
		
		
	}
	
	@Test
	void testGastoDelate() {
		//Agrego usuarios a la BD
		this.factory.getUsuarioDAO().persistir(usu4);
				
		//Agrego grupo a la BD
		this.factory.getCategoriaGrupoDAO().persistir(cate1);
		this.factory.getGrupoDAO().persistir(grupo4);
				
       //Agrego un gasto
		this.factory.getGastoDAO().persistir(gasto4);
		//Elimino un gasto
		assertEquals(gasto4.getId_gasto(), this.factory.getGastoDAO().borrar(gasto4.getId_gasto()).getId_gasto());
				
		
	}
	
	@Test
	void testGrupoListaGastos() {
		//Agrego grupo a la BD
		this.factory.getCategoriaGrupoDAO().persistir(cate1);
		this.factory.getGrupoDAO().persistir(grupo5); 
		//Recupero el grupo5 le agrego gastos
		Grupo grupo = this.factory.getGrupoDAO().recuperar(grupo5.getId_grupo());
		grupo.setGastos(this.gastos);
		this.factory.getGrupoDAO().actualizar(grupo);	
	}
	
	

//	@Test
//	void testGastoCRUD() {
//		//creo una fabrica de DAOS
//		this.factory = new DaoFactory();
//		
//		//Agrego usuarios a la BD
//		this.factory.getUsuarioDAO().persistir(usu1);
//		this.factory.getUsuarioDAO().persistir(usu2);
//		
//		//Agrego grupo a la BD
//		this.factory.getCategoriaGrupoDAO().persistir(cate1);
//		this.factory.getGrupoDAO().persistir(grupo1);
//		
//		//Persisto dos gastos
//		assertEquals(gasto1, this.factory.getGastoDAO().persistir(gasto1));
//		assertEquals(gasto2, this.factory.getGastoDAO().persistir(gasto2));
//		assertEquals(gasto3, this.factory.getGastoDAO().persistir(gasto3));
//		
//		//Recupero el gasto y lo modifico
//		Gasto gasto = this.factory.getGastoDAO().recuperar(gasto1.getId_gasto());
//		gasto.setMonto(1100);
//		assertEquals(gasto.getMonto(), this.factory.getGastoDAO().actualizar(gasto).getMonto());
//		
//		//Elimino un gasto
//		assertEquals(gasto3.getId_gasto(), this.factory.getGastoDAO().borrar(gasto3.getId_gasto()).getId_gasto());
//		
//		//Recupero lista de gastos del grupo 1 e imprimo
//		List <Gasto> gastos = this.factory.getGastoDAO().recuperarTodos("id_gasto");
//		for (Gasto g:gastos) {System.out.println("Gasto : " +g.getMonto());}
//		
//	}

}
