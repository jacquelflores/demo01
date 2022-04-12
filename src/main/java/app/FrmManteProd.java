package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Categorias;
import model.Productos;
import model.Proveedor;
import model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

public class FrmManteProd extends JFrame {

	private JPanel contentPane;

	private JTextArea txtSalida;
	private JTextField txtCódigo;
	JComboBox cboCategorias;
	JComboBox cboProvedor;
	private JTextField txtDescripcion;
	private JTextField txtStock;
	private JTextField txtPrecio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmManteProd frame = new FrmManteProd();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmManteProd() {
		setTitle("Mantenimiento de Productos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrar();
			}
		});
		btnNewButton.setBounds(324, 29, 89, 23);
		contentPane.add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 171, 414, 143);
		contentPane.add(scrollPane);

		txtSalida = new JTextArea();
		scrollPane.setViewportView(txtSalida);

		JButton btnListado = new JButton("Listado");
		btnListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listado();
			}
		});
		btnListado.setBounds(177, 322, 89, 23);
		contentPane.add(btnListado);

		txtCódigo = new JTextField();
		txtCódigo.setBounds(122, 11, 86, 20);
		contentPane.add(txtCódigo);
		txtCódigo.setColumns(10);

		JLabel lblCodigo = new JLabel("Id. Producto :");
		lblCodigo.setBounds(10, 14, 102, 14);
		contentPane.add(lblCodigo);

		cboCategorias = new JComboBox();
		cboCategorias.setBounds(122, 70, 86, 22);
		contentPane.add(cboCategorias);

		JLabel lblCategora = new JLabel("Categor\u00EDa");
		lblCategora.setBounds(10, 74, 102, 14);
		contentPane.add(lblCategora);

		JLabel lblNomProducto = new JLabel("Nom. Producto :");
		lblNomProducto.setBounds(10, 45, 102, 14);
		contentPane.add(lblNomProducto);

		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(122, 42, 144, 20);
		contentPane.add(txtDescripcion);

		JLabel lblStock = new JLabel("Stock:");
		lblStock.setBounds(10, 106, 102, 14);
		contentPane.add(lblStock);

		txtStock = new JTextField();
		txtStock.setColumns(10);
		txtStock.setBounds(122, 103, 77, 20);
		contentPane.add(txtStock);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(10, 134, 102, 14);
		contentPane.add(lblPrecio);

		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(122, 131, 77, 20);
		contentPane.add(txtPrecio);

		JLabel lblProvedor = new JLabel("Proveedor:");
		lblProvedor.setBounds(210, 103, 102, 14);
		contentPane.add(lblProvedor);

		cboProvedor = new JComboBox();
		cboProvedor.setBounds(280, 103, 86, 22);
		contentPane.add(cboProvedor);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				buscarProducto();

			}

		});

		btnBuscar.setBounds(324, 63, 89, 23);
		contentPane.add(btnBuscar);

		llenaCombo();
	}

	// LISTADO DE LA TABLA CATEGORIAS

	void llenaCombo() {

		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");

		EntityManager em = fabrica.createEntityManager();

		TypedQuery<Categorias> consulta = em.createQuery("Select c from Categorias c ", Categorias.class);

		List<Categorias> lstCategorias = consulta.getResultList();

		cboCategorias.addItem("seleccionar...");

		for (Categorias c : lstCategorias) {

			cboCategorias.addItem(c.getDescripcion());

			// System.out.println(c.getDescripcion());
		}

		// LISTADO PARA COMBO PROVEEDOR
		//

		TypedQuery<Proveedor> consulta2 = em.createQuery("Select p from Proveedor p ", Proveedor.class);

		List<Proveedor> lstProveedor = consulta2.getResultList();

		cboProvedor.addItem("seleccionar...");

		for (Proveedor p : lstProveedor) {
			cboProvedor.addItem(p.getNombre_rs());

			// System.out.println(p.getNombre_rs());
		}

		em.close();

	}

	// LISTADO DE PRODUCTOS

	void listado() {

		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");

		EntityManager em = fabrica.createEntityManager();

		TypedQuery<Productos> consulta = em.createQuery("Select p from Productos p ", Productos.class);

		List<Productos> lstProductos = consulta.getResultList();

		txtSalida.setText("");

		for (Productos p : lstProductos) {

			txtSalida.append("Codigo.... : " + p.getCodigo() + "\n");
			txtSalida.append("Nombre del Producto ... : " + p.getDescripcion() + "\n");
			txtSalida.append("Precio... : " + p.getPrecio() + "\n");
			txtSalida.append("Stock....: " + p.getStock() + "\n");
			txtSalida.append("Categoria.... : " + p.getIdcategoria() + "\n");
			txtSalida.append("Nombre de la Categoria.... : " + p.getCategorias().getDescripcion() + "\n");
			txtSalida.append("Proveedor... : " + p.getIdprovedor() + "\n");
			txtSalida.append("Nombre del Proveedor : " + p.getProveedor().getNombre_rs() + "\n");
			txtSalida.append("********************************************\n");
		}

	}

	// BUSCAR

	void buscarProducto() {

		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");

		EntityManager em = fabrica.createEntityManager();

		Productos p = em.find(Productos.class, txtCódigo.getText());

		if (p != null) {
		
			txtDescripcion.setText(p.getDescripcion());
			
		}else

			txtSalida.append("Codigo no Existe");

		em.close();

	}

	// REGISTRAR UN PRODUCTO

	void registrar() {

		String idprod = txtCódigo.getText();

		String descripcion = txtDescripcion.getText();

		int stock = Integer.parseInt(txtStock.getText());

		double precio = Double.parseDouble(txtPrecio.getText());

		int categoria = cboCategorias.getSelectedIndex();

		int estado = 1; // VALOR POR DEFAULT

		int proveedor = cboProvedor.getSelectedIndex();

		Productos p = new Productos();

		p.setCodigo(idprod);

		p.setDescripcion(descripcion);

		p.setStock(stock);

		p.setPrecio(precio);

		p.setIdcategoria(categoria);

		p.setIdprovedor(proveedor);

		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");

		EntityManager em = fabrica.createEntityManager();

		em.getTransaction().begin();

		em.persist(p);

		em.getTransaction().commit();

		em.close();

		JOptionPane.showMessageDialog(this, "Producto Registrado");

	}
}
