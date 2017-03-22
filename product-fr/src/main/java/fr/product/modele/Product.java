package fr.product.modele;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Moose 
 * classe representant les produits. 
 * Nous avons utilisé JPA pour faire le Mapping objet relationnel.
 *
 */

@Entity
@Table(name="PRODUCT")
public class Product implements Serializable {
	
	/**
	 * Reference du produit
	 */
	@Id
	@Column(name="REF")
	private String reference;
	
	/**
	 * Designation du Produit
	 */
	@Column(name="PRODUCT_NAME")
	private String productName;
	
	/**
	 * Prix du produit
	 */
	@Column(name="PRODUCT_PRICE")
	private String productPrice;

	public Product() {
		super();
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	

}
