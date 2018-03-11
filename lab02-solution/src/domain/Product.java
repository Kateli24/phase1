package domain;

import java.math.BigDecimal;

public class Product {

	private String id;
	private String name;
	private String description;
	private String category;
	private BigDecimal listPrice;
	private String uri;

	public Product() {
	}

	public Product(String id, String name, String description, String category, BigDecimal listPrice, String uri) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.category = category;
		this.listPrice = listPrice;
		this.uri = uri;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public BigDecimal getListPrice() {
		return listPrice;
	}

	public void setListPrice(BigDecimal listPrice) {
		this.listPrice = listPrice;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	@Override
	public String toString() {
		return "Product{" + "id=" + id + ", name=" + name + ", description=" + description + ", category=" + category + ", listPrice=" + listPrice + ", uri=" + uri + '}';
	}

}
