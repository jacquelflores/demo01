package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo02 {
	
	public static void main(String[] args) {
		
		// Actualizar los datos de un usuario
		
		// 1.fabrica de acceso de datos - DAO
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		
		// 2.Manejador de Entidad
		
		EntityManager em = fabrica.createEntityManager();
		
		// 3.Empezar transacción --> actualizar
		
		em.getTransaction().begin();
		
		// 4. Procesos/Accion
		
		// ACTUALIZAR
		
		Usuario u = new Usuario(50, "Alex", "Flores", "aalex@gmail.com", "5555",
				"1971/05/24", 1, 1);
		
		em.merge(u); // Si existe el codigo -> Actualiza / Sino existe -> Lo Crea 
		
		
		// 5. Confirmar la transacción
		
		em.getTransaction().commit();
		
		// 6. Cerrar el manejador 
		
		em.close();
		
	}

}
