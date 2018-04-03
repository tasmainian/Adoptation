package cas.xb3.adoptation.framework;

public class finalPetADT {
	private String primaryBreed;
	private int count;
	
	public finalPetADT(String primaryBreed, int count) {
		this.primaryBreed = primaryBreed;
		this.count = count;
	}
	
	public String getPrimBreed() {
		return this.primaryBreed;
	}
	
	public int getCount() {
		return this.count;
	}
}
