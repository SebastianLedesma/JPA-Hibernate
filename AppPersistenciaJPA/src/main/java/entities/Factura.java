package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="facturas")
public class Factura implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="fecha")
	private String fecha;
	
	@Column(name="numero")
	private int numero;
	
	@Column(name="total")
	private double total;
	
	/**
	 * Si borro una factura quiero que el cliente persista en la BD.
	 */
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="fk_cliente")
	private Cliente cliente;
	
	/**
	 * Una factura puede tener muchos detalles.
	 * La relación está definida en la clase DetalleFactura en el atributo factura,por
	 * eso el mappedBy.
	 */
	@OneToMany(mappedBy="factura",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<DetalleFactura> detalles = new ArrayList<>();

	public Factura() {
		super();
	}

	public Factura(String fecha, int numero) {
		super();
		this.fecha = fecha;
		this.numero = numero;
	}

	
	public Factura(String fecha, int numero, Cliente cliente) {
		this(fecha,numero);
		this.cliente = cliente;
	}

	
	public List<DetalleFactura> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleFactura> detalles) {
		this.detalles = detalles;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	
}
