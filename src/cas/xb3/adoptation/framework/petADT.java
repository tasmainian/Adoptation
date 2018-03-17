package cas.xb3.adoptation.framework;

public class petADT {
	
	// state variables, cannot be final due to client implementation requirements
	private String ID;
	private String sex;
	private String yearsAge;
	private String monthsAge;
	private String primaryBreed;
	private String secondaryBreed;
	private String primaryColour;
	private String secondaryColour;
	private String species;
	private String status;
	
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
		return ID;
	}

	public String getSex() {
		return sex;
	}

	public String getYearsAge() {
		return yearsAge;
	}

	public String getMonthsAge() {
		return monthsAge;
	}

	public String getPrimaryBreed() {
		return primaryBreed;
	}

	public String getSecondaryBreed() {
		return secondaryBreed;
	}

	public String getPrimaryColour() {
		return primaryColour;
	}

	public String getSecondaryColour() {
		return secondaryColour;
	}

	public String getSpecies() {
		return species;
	}

	public String getStatus() {
		return status;
	}
	
	public int compareTo(petADT that){
		return (this.getPrimaryBreed().compareTo(that.getPrimaryBreed());
	}


}
