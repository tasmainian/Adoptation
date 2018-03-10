package cas.xb3.adoptation.framework;

public class petADT {
	
	private final String ID;
	private final String sex;
	private final String yearsAge;
	private final String monthsAge;
	private final String primaryBreed;
	private final String secondaryBreed;
	private final String primaryColour;
	private final String secondaryColour;
	private final String species;
	private final String status;
	
	public petADT(String id, String sex, String yearsAge, String monthsAge, String primaryBreed, String secondaryBreed, String primaryColour, String secondaryColour, String species, String status) {
		this.ID = id;
		this.sex = sex;
		this.yearsAge = yearsAge;
		this.monthsAge = monthsAge;
		this.primaryBreed = primaryBreed;
		this.secondaryBreed = secondaryBreed;
		this.primaryColour = primaryColour;
		this.secondaryColour = secondaryColour;
		this.species = species;
		this.status = status;
	}
	public String getID() {
		return this.ID;
	}
	
	public String getGender() {
		return this.sex;
	}
	
	public String getYearsAge() {
		return this.yearsAge;
	}
	
	public String getMonthsAge() {
		return this.monthsAge;
	}
	
	public String getPrimaryBreed() {
		return this.primaryBreed;
	}
	
	public String getSecondaryBreed() {
		return this.secondaryBreed;
	}
	
	public String getPrimaryColour() {
		return this.primaryColour;
	}
	
	public String getSecondaryColour() {
		return this.secondaryColour;
	}
	
	public String getSpecies() {
		return this.species;
	}
	
	public String getStatus() {
		return this.status;
	}

}
