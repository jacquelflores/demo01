package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

import model.Usuario;

public class Login {

	public static void main(String[] args) {

		String usuario;
		String clave;

		usuario = JOptionPane.showInputDialog("Ingrese Usuario : ");

		clave = JOptionPane.showInputDialog("Ingrese Clave : ");

		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");

		EntityManager em = fabrica.createEntityManager();

		TypedQuery<Usuario> consulta = em.createQuery("select u from Usuario u where u.usuario= :xusr and u.clave = :xcla", Usuario.class);

		consulta.setParameter("xusr", usuario);
		
		consulta.setParameter("xcla", clave);

		Usuario u = consulta.getSingleResult();

		try {
			
			System.out.println(u);
			
		} catch (Exception e) {
			
			System.err.println("Usuario no Encontrado");
			
		}
		
		em.close();

	}

}
