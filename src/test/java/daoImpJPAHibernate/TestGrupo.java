package daoImpJPAHibernate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelos.CategoriaGasto;
import modelos.CategoriaGrupo;
import modelos.Gasto;
import modelos.Grupo;
import modelos.Pago;
import modelos.Usuario;

public class TestGrupo {
	private CategoriaGrupo categoria_grupo1;
	private CategoriaGrupo categoria_grupo2;
	private CategoriaGasto categoria_gasto1;
	private Usuario usuario1, usuario2;
	private Gasto gasto1, gasto2, gasto3;
	private Grupo grupo1, grupo2;
	
	private List<Usuario> contactos;
	private List<Usuario> usuarios, usuarios2;
	private List<Gasto> gastos, gastos2;
	private List<Pago> pagos;
	
	private DaoFactory factory;
	
	@BeforeEach
	void setUp() throws Exception {
		//LOS USUARIOS PUEDEN NO TENER ASOCIADO UN GRUPO PERO 
		//UN GRUPO VA A TENER POR LO MENOS UN USUARIO
		this.usuario1 = new Usuario("Bertone", "Rodolfo", "betone@gmail.com","1234FOD");
		this.usuario2 = new Usuario("Molinari", "Lia", "lia@gmail.com","@7273ISO");
		
		//ANTES DE CREAR EL GRUPO TENGO QUE CREAR LA CATEGORIA DE GRUPO
		this.categoria_grupo1 = new CategoriaGrupo("Viaje");
		this.categoria_grupo2 = new CategoriaGrupo("Recital");
		
		//ANTES DE CREAR LOS GASTOS TENGO QUE CREAR EL GRUPO, 
		//NO TIENE SENTIDO TENER UN GASTO QUE NO ESTE ASOCIADO A UN GRUPO
		this.gastos = new ArrayList<Gasto>();
		this.gastos2 = new ArrayList<Gasto>();
		
		//UN GRUPO VA A TENER POR LO MENOS UN USUARIO ASOCIADO (el que crea el grupo)
		this.usuarios = new ArrayList<Usuario> ();
		this.usuarios.add(usuario1);
		this.grupo1 = new Grupo("Catar", usuarios, gastos, categoria_grupo1);
		this.usuarios2 = new ArrayList<Usuario> ();
		this.usuarios2.add(usuario2);
		this.grupo2 = new Grupo("Taylor Swift", usuarios2, gastos2, categoria_grupo2);
		
		//GASTOS
		this.gasto1 = new Gasto(1500,usuario1, "Partes iguales",new CategoriaGasto("Hospedaje"),grupo1);
		this.gasto2 = new Gasto(3000,usuario1, "Partes iguales",new CategoriaGasto("Comida"),grupo1);
		//this.gasto3 = new Gasto(900,usuario2, "Partes iguales",new CategoriaGasto("Cine"),grupo2);
		
		//PA' PODER PERSISTIR EN LA BD
		this.factory = new DaoFactory();
	}
	
	
	@Test
	void testGrupoCreate() {
		//PERSISTO EL GRUPO SIN GASTOS	
		assertEquals(grupo1, this.factory.getGrupoDAO().persistir(grupo1));

		//ACTUALIZO LA LISTA DE GASTOS DEL GRUPO
		this.gastos.add(gasto1);
		this.gastos.add(gasto2);
				
		//RECUPERO AL GRUPO
		assertEquals(this.grupo1.getId_grupo(), this.factory.getGrupoDAO().actualizar(this.grupo1).getId_grupo());
		

	}
	
	@Test
	void testGrupoRead() {
	    this.factory.getGrupoDAO().persistir(grupo2);
	    this.gasto3 = new Gasto(900,usuario2, "Partes iguales",new CategoriaGasto("Cine"),grupo2);
	    this.gastos2.add(gasto3);
	    this.factory.getGrupoDAO().actualizar(this.grupo2);
	    
	    //RECUPERO e IMPRIMO
		List <Gasto> gastos = this.grupo2.getGastos();
		for (Gasto g:gastos) {System.out.println("Gasto : " +g.getMonto());}	
		
//		//RECUPERO y ACTUALIZO
//		Gasto aux = this.factory.getGastoDAO().recuperar(5L);
//		aux.setMonto(5);
//		this.factory.getGastoDAO().actualizar(aux);
		System.out.println("----------------");
		
		this.grupo2.getGastos().get(0).setMonto(5);
		this.factory.getGrupoDAO().actualizar(grupo2);
		
		List <Gasto> gastos2 = this.grupo2.getGastos();
		for (Gasto g:gastos2) {System.out.println("Gasto : " +g.getMonto());}	
	}   
	
	
	
	
	
	
//	//PERSISTO LA CATEGORIA GRUPO //Esto no es necesario con la configuracion Cascade c:
//	this.factory.getCategoriaGrupoDAO().persistir(categoria_grupo1);
	
//	//NO TIENE SENTIDO TENER UN GRUPO SIN USUARIOS, PERSISTO AL USUARIO
//	this.factory.getUsuarioDAO().persistir(usuario1);		
	
	//PERSISTO LOS GASTOS
	////this.factory.getGastoDAO().persistir(gasto1);
	/////this.factory.getGastoDAO().persistir(gasto2);
	////this.factory.getGastoDAO().persistir(gasto3);
		
	
	//Grupo aux_grupo = this.factory.getGrupoDAO().recuperar(this.grupo1.getId_grupo());
	//aux_grupo.setGastos(gastos);
	////this.grupo1.setGastos(gastos);	
	
	
//	Gasto aux = gastos.get(0);
//	aux.setMonto(5);
//	this.factory.getGrupoDAO().actualizar(grupo2);
//	//this.factory.getGastoDAO().actualizar(aux);
//	gastos = this.grupo2.getGastos();
//	for (Gasto g:gastos) {System.out.println("Gasto : " +g.getMonto());}	
	
	
//	    Long idGasto = gasto3.getId_gasto();
//	    System.out.println("hadfkasdf" + idGasto);
//	    System.out.println(this.factory.getGrupoDAO().recuperar(grupo2.getId_grupo())+"HOLAAA");
//	    //System.out.println(this.factory.getGastoDAO().recuperar(idGasto)+"HOLAAA");
//	    this.factory.getGastoDAO().recuperar(idGasto).setMonto(5);;
//	    assertEquals(5, this.factory.getGastoDAO().actualizar(gasto3).getMonto());	    
//		
//	}
//	
	
	
	
//	@Test
//	void testGrupoUpdate() {
//		//ACTUALIZO SU LISTA DE GASTOS
//		this.gastos.add(gasto1);
//		this.gastos.add(gasto2);
//		this.gastos.add(gasto3);
//		
//		//RECUPERO AL GRUPO
//		Grupo aux_grupo = this.factory.getGrupoDAO().recuperar(1L);
//		aux_grupo.setGastos(gastos);
//        assertEquals(aux_grupo.getId_grupo(), this.factory.getGrupoDAO().actualizar(aux_grupo).getId_grupo());
//		
//	}
	
	

}
