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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	@Column(name="dni",unique=true)
	private int dni;
	
	/**
	 * El cascade es ALL para que persista o elimine el domicilio a partir del cliente.
	 */
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_domicilio")
	private Domicilio domicilio;

	/**
	 * La relacion con Cliente ser� bidireccional.
	 */
	@OneToMany(mappedBy="cliente")
	private List<Factura> facturas = new ArrayList<>();
	
	public Cliente() {
		super();
	}

	public Cliente(String nombre, String apellido, int dni) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}
	

	public Cliente(String nombre, String apellido, int dni, Domicilio domicilio) {
		this(nombre,apellido,dni);
		this.domicilio = domicilio;
	}

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}
	
	
}
