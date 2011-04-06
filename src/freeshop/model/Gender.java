package freeshop.model;

public enum Gender {

	MALE("M"),
	FEMALE("F");
	
	private String acronym;
	
	Gender(String acronym) {
		this.acronym = acronym;
	}
	
	public String getAcronym() {
		return acronym;
	}
}
