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
	private String breedGroup;
	private int count;
	
	public petADT(String id, String sex, String yearsAge, String monthsAge, String primaryBreed, String secondaryBreed, String primaryColour, String secondaryColour, String species, String status, String breedGroup) {
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
		this.breedGroup = breedGroup;
	}

	public String getID() {
		return this.ID;
	}

	public String getSex() {
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
	
	public int compareTo(petADT that){
		return (this.getPrimaryBreed().compareTo(that.getPrimaryBreed()));
	}
	
	public String getBreedGroup() {
		return this.breedGroup;
	}
	
	public int getCount() {
		return this.count;
	}
	
	public void setCount(int c) {
		this.count = c;
	}


}
