
public class Character {
	private String name;
	private int lifePoints;
	private int arrows;
	private String specialAbility;
	
	public Character() {
		name = "Billy bob";
		lifePoints = 8;
		arrows = 0;
		specialAbility = "";
		
	}
	
	public Character(String n, int life, String special) {
		name = n;
		lifePoints = life;
		specialAbility = special;
	}
	
	public void clearArrows() {
		lifePoints -= arrows;
		arrows = 0;
	}
	
	public void addArrows(int a) {
		arrows += a;
	}
}
