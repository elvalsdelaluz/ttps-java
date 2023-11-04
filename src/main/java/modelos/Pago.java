package modelos;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Pago {
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id_pago;
	private double monto;
	
	@ManyToOne
	@JoinColumn(name="id_gasto")
	private Gasto gasto;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	@Temporal(TemporalType.DATE)
	private Date fecha_creacion;
	
	//CONSTRUCTOR
	
	public Pago() {}
	
	 
	public Pago(Long id_pago, double monto, Gasto gasto, Usuario usuario) {
		super();
		this.id_pago = id_pago;
		this.monto = monto;
		this.gasto = gasto;
		this.usuario = usuario;
		this.fecha_creacion = new java.util.Date();;
	}


	//GETTER AND SETTER
	public Long getId() {
		return id_pago;
	}
	
	public void setId(Long id) {
		this.id_pago = id;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario deudor) {
		this.usuario = deudor;
	}


	public Long getId_pago() {
		return id_pago;
	}


	public void setId_pago(Long id_pago) {
		this.id_pago = id_pago;
	}


	public Gasto getGasto() {
		return gasto;
	}


	public void setGasto(Gasto gasto) {
		this.gasto = gasto;
	}


	public Date getFecha_creacion() {
		return fecha_creacion;
	}


	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	 
	

}
