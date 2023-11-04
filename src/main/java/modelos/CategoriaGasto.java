package modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import jakarta.websocket.Decoder.Text;

@Entity 
public class CategoriaGasto {
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id_categoria_gasto;
	private String nombre;
	@Lob
	private String imagen;

	//CONSTRUCTOR
	public CategoriaGasto() {}
	
	public CategoriaGasto(Long id_categoria_gasto, String nombre, String imagen) {
		super();
		this.id_categoria_gasto = id_categoria_gasto;
		this.nombre = nombre;
		this.imagen = imagen;
	}

	//GETTER AND SETTER
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	} 
	
	

}
