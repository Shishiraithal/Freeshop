package freeshop.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@javax.persistence.Entity
public class ProductGroup implements Entity {

	private static final long serialVersionUID = 7151718899711158442L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//private Key key;
	private Long id;
	
	private String name;
	
	public ProductGroup() {
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
		ProductGroup other = (ProductGroup) obj;
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
