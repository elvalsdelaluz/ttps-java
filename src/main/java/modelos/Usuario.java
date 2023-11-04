package modelos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Usuario {
	 @Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	 private Long id_usuario;
	 private String usuario;
	 private String apellido;
	 private String nombre;
	 private String email;
	 private String contraseña;
//	 @OneToMany
//	 @JoinColumn(name="usuario_id")
//	 private List<Usuario> contactos;
	 
	 @Temporal(TemporalType.DATE)
	 private Date fecha_creacion;
	 
	 @ManyToMany(mappedBy="miembros")
	 private List<Grupo> grupos; 
	 
	 //CONSTRUCTORES
	
	 public Usuario () {}
	 
	 public Usuario(Long id_usuario, String usuario, String apellido, String nombre, String email, String contraseña,
			Date fecha_creacion, List<Grupo> grupos) {
		super();
		this.id_usuario = id_usuario;
		this.usuario = usuario;
		this.apellido = apellido;
		this.nombre = nombre;
		this.email = email;
		this.contraseña = contraseña;
		this.fecha_creacion = fecha_creacion;
		this.grupos = grupos;
	 }

	//GETTER AND SETTER
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
//	public List<Usuario> getContactos() {
//		return contactos;
//	}
//	public void setContactos(List<Usuario> contactos) {
//		this.contactos = contactos;
//	}
	
	 

}
