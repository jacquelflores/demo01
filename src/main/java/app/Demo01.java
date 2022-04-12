package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo01 {
	
	public static void main(String[] args) {
		
		// registrar un nuevo usuario
		
		
		// 1.fabrica de acceso de datos - DAO
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		
		// 2.Manejador de Entidad
		
		EntityManager em = fabrica.createEntityManager();
		
		// 3.Empezar transacción --> registrar,actualizar,eliminar
		
		
		em.getTransaction().begin();
		
		
		// 4. Procesos/Accion
		
		// INSERT INTO 
		
		Usuario u = new Usuario(22, "Rosa", "Flores", "rrosa@gmail.com", "1234",
				"1971/08/03", 1, 1);
		
		em.persist(u);

		
		
		// 5. Confirmar la transacción
		
		em.getTransaction().commit();
		
		
		// 6. Cerrar el manejador 
		
		em.close();
		
		
		
	}

}
