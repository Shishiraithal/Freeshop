package freeshop.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@javax.persistence.Entity
public class Product implements Entity {

	private static final long serialVersionUID = -339162862026907514L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String shortName;
	private String description;
	
	private Double price;
	private Double oldPrice;
	
	/*
	private ProductGroup group;
	
	private ProductAttributes attributes;
	
	private List<Tag> tags;
	*/
	
	public Product() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getOldPrice() {
		return oldPrice;
	}

	public void setOldPrice(Double oldPrice) {
		this.oldPrice = oldPrice;
	}

	/*
	public ProductGroup getGroup() {
		return group;
	}

	public void setGroup(ProductGroup group) {
		this.group = group;
	}
	
	public ProductAttributes getAttributes() {
		return attributes;
	}

	public void setAttributes(ProductAttributes attributes) {
		this.attributes = attributes;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	*/
}
