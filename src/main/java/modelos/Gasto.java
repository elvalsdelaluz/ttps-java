package modelos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.crypto.Data;

import jakarta.websocket.Encoder.Text;

@Entity
public class Gasto {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id_gasto;
	private double monto;
	@Temporal(TemporalType.DATE)
	private Date fecha_creacion;
	@Lob
	private String imagen;
	@OneToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	private String forma_division;
	@OneToOne
	@JoinColumn(name = "id_categoria_gasto")
	private CategoriaGasto categoria;
	
	@ManyToOne
	@JoinColumn(name="id_grupo")
	private Grupo grupo;
	
	 @OneToMany(mappedBy="gasto")
	private List<Pago> pagos;
	 
	//CONSTRUCTOR
		public Gasto(double monto, Usuario deudor, String forma_division, Grupo grupo) {
			super();
			this.monto = monto;
			this.fecha_creacion = new java.util.Date();
			this.usuario = deudor;
			this.forma_division = forma_division;
			//this.categoria = categoria;
			this.grupo = grupo;
			this.pagos = new ArrayList<Pago>();
		}
		public Gasto() {}
	
	
	//GETTER AND SETTER
	public Long getId_gasto() {
	    return id_gasto;
	}
	
	public void setId_gasto(Long id_gasto) {
		this.id_gasto = id_gasto;
	}
	
	public List<Pago> getPagos() {
		return pagos;
	}

	
	public Grupo getGrupo() {
		return grupo;
	}
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}
	
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public Date getFecha() {
		return fecha_creacion;
	}
	public void setFecha(Date fecha) {
		this.fecha_creacion = fecha;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario deudor) {
		this.usuario = deudor;
	}
//	public FormaDivision getFormaDivision() {
//		return formaDivision;
//	}
//	public void setFormaDivision(FormaDivision formaDivision) {
//		this.formaDivision = formaDivision;
//	}
	public CategoriaGasto getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaGasto categoria) {
		this.categoria = categoria;
	}
	
	
	

}
