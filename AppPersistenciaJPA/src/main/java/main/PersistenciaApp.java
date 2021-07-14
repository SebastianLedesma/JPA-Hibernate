package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Articulo;
import entities.Categoria;
import entities.Cliente;
import entities.DetalleFactura;
import entities.Domicilio;
import entities.Factura;

public class PersistenciaApp {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EjemploPersistenciaPU");
		
		EntityManager em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			
			Factura factura = new Factura("13/04/2021",13013);
			
			Domicilio domicilio = new Domicilio("Montevideo",305);
			Cliente cliente = new Cliente("Débora","Torres",35000111);
			cliente.setDomicilio(domicilio);
			domicilio.setCliente(cliente);
			
			factura.setCliente(cliente);
			
			Categoria perecederos = new Categoria("perecederos");
			Categoria lacteos = new Categoria("lacteos");
			Categoria limpieza = new Categoria("limpieza");
			
			Articulo art1 = new Articulo(200,"Yogurt Ser Frutilla",80);
			Articulo art2 = new Articulo(300,"Detergente Magistral",90);
			
			art1.getCategorias().add(perecederos);
			art1.getCategorias().add(lacteos);
			lacteos.getArticulos().add(art1);
			perecederos.getArticulos().add(art1);
			
			art2.getCategorias().add(limpieza);
			limpieza.getArticulos().add(art2);
			
			DetalleFactura detalle1 = new DetalleFactura();
			detalle1.setArticulo(art1);
			detalle1.setCantidad(2);
			detalle1.setSubtotal(160);
			
			art1.getDetalles().add(detalle1);
			factura.getDetalles().add(detalle1);
			detalle1.setFactura(factura);
			
			DetalleFactura detalle2 = new DetalleFactura();
			detalle2.setArticulo(art2);
			detalle2.setCantidad(1);
			detalle2.setSubtotal(90);
			
			art2.getDetalles().add(detalle2);
			factura.getDetalles().add(detalle2);
			detalle2.setFactura(factura);
			
			factura.setTotal(250);
			
			em.persist(factura);
			
			em.flush();
			em.getTransaction().commit();
		}catch(Exception ex) {
			em.getTransaction().rollback();
		}
		
		em.close();
		emf.close();
	}

}
