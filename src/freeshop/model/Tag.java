package freeshop.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

@javax.persistence.Entity
public class Tag implements Entity {

	private static final long serialVersionUID = -1311640628257696769L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Key key;
	//private Long id;
	private String name;
	
	public Tag() {
	}
	
	public Tag(String name) {
		this.name = name;
	}

	public Long getId() {
		return (this.key==null) ? null : this.key.getId();
		//return id;
	}

	public void setId(Long id) {
		if( id != null ) {
			this.key = KeyFactory.createKey(getClass().getSimpleName(), id);
		}
		//this.id = id;
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
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
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
		Tag other = (Tag) obj;
		if (getId() == null) {
			if (other.getId() != null) {
				return false;
			}
		} else if (!getId().equals(other.getId())) {
			return false;
		}
		return true;
	}
	
}
