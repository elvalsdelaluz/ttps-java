package modelos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Grupo {
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id_grupo;
    private String nombre;
    @ManyToMany
    @JoinTable(
        name = "grupo_usuario",
        joinColumns = @JoinColumn(name = "id_grupo"),
        inverseJoinColumns = @JoinColumn(name = "id_usuario")
    )
    private List<Usuario> miembros;
    
    @OneToMany(mappedBy="grupo")
	private List<Gasto> gastos;
    
    @OneToOne
	@JoinColumn(name = "id_categoria_grupo")
	private CategoriaGrupo categoria;
	@Temporal(TemporalType.DATE)
	private Date fecha_creacion;
	
	//CONSTRUCTOR
	public Grupo(String nombre, CategoriaGrupo categoria) {
		super();
		this.nombre = nombre;
		this.miembros = new ArrayList<Usuario>();
		this.gastos = new ArrayList<Gasto>();
		this.categoria = categoria;
		this.fecha_creacion = new java.util.Date();
	}
	public Grupo() {}
	
	//GETTER AND SETTER
	public Long getId_grupo() {
		return id_grupo;
	}
	public void setId_grupo(Long id_grupo) {
		this.id_grupo = id_grupo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Usuario> getMiembros() {
		return miembros;
	}
	public void setMiembros(List<Usuario> miembros) {
		this.miembros = miembros;
	}
	public List<Gasto> getGastos() {
		return gastos;
	}
	public void setGastos(List<Gasto> gastos) {
		this.gastos = gastos;
	}

	public CategoriaGrupo getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaGrupo categoria) {
		this.categoria = categoria;
	}
	
	
	

}