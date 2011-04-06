package freeshop.model;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@javax.persistence.Entity
public class Product implements Entity {

	private static final long serialVersionUID = -339162862026907514L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//private Key key;
	private Long id;
	
	private String name;
	private String shortName;
	private String description;
	
	private Double price;
	private Double oldPrice;
	
	private boolean active;
	private int quantity;
	
	private String brand;
	private String size;
	private String color;
	private String author;
	private String isbn;
	private Double weight;
	private String dimensions;
	
	private Integer numberOfImages;
	
	//private Long idGroup;
	//@ManyToOne(cascade=CascadeType.MERGE)
	@Transient
	private ProductGroup group;
	
	private List<String> tags;
	
	/*
	private ProductAttributes attributes;
	
	private List<Tag> tags;
	*/

	public Product() {
	}

	public Long getId() {
		//return (this.key==null) ? null : this.key.getId();
		return id;
	}

	public void setId(Long id) {
		if( id != null ) {
			//this.key = KeyFactory.createKey(getClass().getSimpleName(), id);
		}
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
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ProductGroup getGroup() {
		return group;
	}

	public void setGroup(ProductGroup group) {
		this.group = group;
	}

	@Basic
	public Long getIdGroup() {
		return (group==null) ? null : group.getId();
		//this.idGroup = idGroup;
	}

	public void setIdGroup(Long id) {
		this.group = new ProductGroup();
		this.group.setId(id);
		//return idGroup;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getDimensions() {
		return dimensions;
	}

	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}
	
	public Integer getNumberOfImages() {
		return numberOfImages;
	}

	public void setNumberOfImages(Integer numberOfImages) {
		this.numberOfImages = numberOfImages;
	}
	
	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	/*
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

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}
}
