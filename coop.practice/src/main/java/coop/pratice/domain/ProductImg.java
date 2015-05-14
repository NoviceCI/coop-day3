package coop.pratice.domain;

// Generated May 14, 2015 3:23:04 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ProductImg generated by hbm2java
 */
@Entity
@Table(name = "product_img", schema = "public")
public class ProductImg implements java.io.Serializable {

	private int id;
	private Product product;
	private String path;

	public ProductImg() {
	}

	public ProductImg(int id, Product product) {
		this.id = id;
		this.product = product;
	}

	public ProductImg(int id, Product product, String path) {
		this.id = id;
		this.product = product;
		this.path = path;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", nullable = false)
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Column(name = "path")
	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}