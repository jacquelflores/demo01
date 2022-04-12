package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo04 {
	
	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		
		EntityManager em = fabrica.createEntityManager();
		
		// Eliminar Forma 01 delete... where codigo -> borrado fisico
		// Eliminar Forma 02 update estado where codigo ... -> borrado logico(cambiar estado)
			
		Usuario u = em.find(Usuario.class, 50); // si existe el ID -> devuelve el obj
		                                        // si no existe -> null
		
		if (u != null) 
			
			System.out.println(u);
			
			else
			
			System.out.println("Codigo no Existe");
		
		em.close();
		
	}

}
