package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo05 {
	
	public static void main(String[] args) {
		
		// Crea la clase Demo05 en el paquete app, que permita eliminar un usuario,
		//encontrando si existe o no.
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		
		EntityManager em = fabrica.createEntityManager();
		
		Usuario u = em.find(Usuario.class, 50); // si existe el ID -> devuelve el obj
                                               // si no existe -> null
		
		if (u != null) {
			
			em.getTransaction().begin();
		    em.remove(u);
		    em.getTransaction().commit();
		  
		    System.out.println("Se elimino");
		
		}else {
		
		   System.out.println("Codigo no Existe");
		
		}
		
		em.close();
		
	}

}
