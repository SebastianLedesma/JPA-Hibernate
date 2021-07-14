package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="domicilios")
public class Domicilio implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nombre_calle")
	private String nombreCalle;
	
	@Column(name="numero")
	private int numero;
	
	//Al agregar el OneToOne con mappedBy la relación será bidireccional
	@OneToOne(mappedBy="domicilio")
	private Cliente cliente;

	public Domicilio() {
		super();
	}

	public Domicilio(String nombreCalle, int numero) {
		super();
		this.nombreCalle = nombreCalle;
		this.numero = numero;
	}

	
	public Domicilio(String nombreCalle, int numero, Cliente cliente) {
		this(nombreCalle,numero);
		this.cliente = cliente;
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

	public String getNombreCalle() {
		return nombreCalle;
	}

	public void setNombreCalle(String nombreCalle) {
		this.nombreCalle = nombreCalle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
}
