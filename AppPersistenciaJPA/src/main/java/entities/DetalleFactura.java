package entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="detalle_factura")
public class DetalleFactura implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="cantidad")
	private int cantidad;
	
	@Column(name="subtotal")
	private double subtotal;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="fk_articulo")
	private Articulo articulo;
	
	/**
	 * Muchos detalles pueden ser de una factura.
	 * Si borro el detalle quiero que persista la factura.
	 * DetalleFactura será el dueño de la relación,tendra la fk.Es bidireccional.
	 */
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="fk_factura")
	private Factura factura;

	public DetalleFactura() {
		super();
	}

	public DetalleFactura(int cantidad, double subtotal) {
		super();
		this.cantidad = cantidad;
		this.subtotal = subtotal;
	}

	
	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
	
}
