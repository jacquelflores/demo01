package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.Data;

@Data
@Entity
@Table(name = "tb_productos")
public class Productos {

	@Id
	@Column(name = "id_prod")
	private String codigo;

	@Column(name = "des_prod")
	private String descripcion;

	@Column(name = "stk_prod")
	private int stock;

	@Column(name = "pre_prod")
	private double precio;

	@ManyToOne 
	@JoinColumn(name = "idcategoria" , insertable = false , updatable = false)
	private Categorias categorias;

	private int idcategoria; // se graba en la tabla de productos

	@Column(name = "est_prod")
	private int estado;

	@ManyToOne
	@JoinColumn(name = "idprovedor" , insertable = false , updatable = false)
	private Proveedor proveedor;
	
	private int idprovedor; // se graba en la tabla de productos

}
