package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Usuario;

public class Demo07 {
	
	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		
		EntityManager em = fabrica.createEntityManager();
		
		TypedQuery<Usuario> consulta = em.createQuery("select u from Usuario u where u.tipo = :xtipo" , Usuario.class);
		
		consulta.setParameter("xtipo", 1);
		
		List<Usuario> lstUsuarios = consulta.getResultList();
		
		for (Usuario u : lstUsuarios) {
			
			System.out.println(u);
		}
		
		
		em.close();
	}

}
