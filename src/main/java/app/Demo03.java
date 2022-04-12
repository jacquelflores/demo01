package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo03 {
	
	public static void main(String[] args) {
		
		// eliminar un usuario 
		
		//1. ingresar al acceso de datos DAO
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		
		// 2. manejamos la entidad 
		
		EntityManager em = fabrica.createEntityManager();
		
		// 3. empezar transicion / eliminar
		
		em.getTransaction().begin();
		
		// 4. Procesos/Accion
		
		// Eliminar Forma 01 delete... where codigo -> borrado fisico
		// Eliminar Forma 02 update estado where codigo ... -> borrado logico(cambiar estado)
		
		Usuario u = new Usuario();
		
		u.setCodigo(50);
		
		em.remove(u); // se necesita pasar un objeto -> buscar y devolver..
		
		//5. confirmar transaccion 
		
		em.getTransaction().commit();
		
		//6. cerrar manejador
		
		em.close();
		
		
		
	}

}
