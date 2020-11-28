/*
 * @author Megan Lorfing
 * 
 * CS 2365-001
 * Project 3
 * 
 */

public class Character {
	// -------------------- INFO about the player -------------------
	private String name; // string used to hold the name of the character
	private int lifePoints; // int to hold the current health of the character
	private int maxHealth; // int to hold the max health of the character
	private int[] specialAbility = {0,0,0,0,0,0,0,0,0,0,0,0}; // int (0 for no, 1 for yes) to hold whose special ability is activated
	private String role; // string used to hold the role of the character

	// ------------------------------ Info about the characters hand
	private int arrows; // int to hold the number of arrows in the players hand
	private boolean chiefArrow = false; // boolean to tell if the player has the chief's arrow
	public boolean shown; // boolean to know if the player has shown their role to others
	public boolean known; // boolean to know if the player is known to other players
	
	// -------------------------INFO abut the characters role
	private int team; // 0 is for sherrif or deputy, 1 for outlaw, 2 for renegade
	
	// ------------------------INFO about dice things
	public int gatsNeeded = 3; // number of gatlings still needed to use the gatling gun
	public int rolls = 3; //
	
	
	// default constructor for the character class
	public Character() {
		name = "Black Jack";
		lifePoints = 8;
		arrows = 0;
		specialAbility[0] = 1;
		
	}
	
	
	// Constructor for character class
	// input: int representing the character that has been chosen
	// output: 
	public Character(int player) {
		specialAbility[player] = 1; 
		arrows = 0;
		switch(player) {
		case 0:
			name = "Black Jack";
			lifePoints = 8;
			maxHealth = 8;
			break;
		case 1:
			name = "El Gringo";
			lifePoints = 7;
			maxHealth = 7;
			break;
		case 2:
			name = "Jesse Jones";
			lifePoints = 9;
			maxHealth = 9;
			break;
		case 3:
			name = "Jourdonnais";
			lifePoints = 7;
			maxHealth = 7;
			break;
		case 4:
			name = "Paul Regret";
			lifePoints = 9;
			maxHealth = 9;
			break;
		case 5:
			name = "Pedro Ramirez";
			lifePoints = 8;
			maxHealth = 8;
			break;
		case 6:
			name = "Suzy Lafayette";
			lifePoints = 8;
			maxHealth = 8;
			break;
		case 7:
			name = "Vulture Sam";
			lifePoints = 9;
			maxHealth = 9;
			break;
		case 8:
			name = "Jose Delgado";
			lifePoints = 7;
			maxHealth = 7;
			break;
		case 9:
			name = "Tequila Joe";
			lifePoints = 7;
			maxHealth = 7;
			break;
		case 10:
			name = "Belle Star";
			lifePoints = 8;
			maxHealth = 8;
			break;
		case 11:
			name = "Greg Digger";
			lifePoints = 7;
			maxHealth = 7;
			break;
		}
	}
	
	// function name: clearArrows()
	// purpose: this function is used when all of the arrows have been taken and the health points need to be distrubted to all players
	//			It will subtract the number of players in the players hand from their health and reset the number of arrows to 0
	// input: none
	// output: none
	public void clearArrows() {
		if(specialAbility[3] == 1 && arrows > 1)
			arrows = 1;
		lifePoints -= arrows;
		arrows = 0;
	}

	// function name: addArrows
	// purpose: increases the number of arrows in the characters hand
	// input: int a for the number of arrows to add
	// output:	none
	public void addArrows(int a) {
		arrows += a;
	}

	// function name: removeArrows
	// purpose: to remove a number of arrows in the characters hand
	// input: int a for the number of arrows to remove
	// output:	none
	public void removeArrows(int a) {
		arrows -= a;
	}
	
	// function name: chief
	// purpose: function used to change the status of the chief arrow, can be used to give the character the chief arrow or take it away
	// input: boolean for the status of the arrow in the players hand
	// output:	none
	
	public void chief(boolean t) {
		chiefArrow = t;
	}
	
	// function name: heal
	// purpose: used to increase the health of the character
	// input: int h, the number of points to heal by
	// output: none
	public void heal(int h) {
		if(lifePoints + h > maxHealth)
			lifePoints = maxHealth;
		else 
			lifePoints += h;
	}
	
	// function name: damage()
	// purpose: used to decrease the health of the character
	// input: int d
	// output:
	public void damage(int d) {
		if(lifePoints - d <= 0) {
			lifePoints = 0;
			showRole();
		} else {
			lifePoints -= d;
		}
		if(specialAbility[5] == 1) {
			if(arrows > 0)
				arrows--;
		}
	}
	
	// function name:
	// purpose:
	// input: 
	// output:
	public void showRole() {
		shown = true;
		known = true;
	}
	
	// function name: resetRolls
	// purpose: used to reset the number of rolls the character has for the next round
	// input: none
	// output: none
	public void resetRolls() {
		rolls = 3;
	}
	
	// function: Beer
	// purpose: used when a character rolls a beer and uses it on themselves
	// input: none
	// output: none
	public void selfBeer() {
		int healthAdded;
		if(specialAbility[11] == 1 || (specialAbility[2] == 1 && lifePoints <= 4))
			healthAdded = 2;
		else
			healthAdded = 1;
		if(lifePoints + healthAdded > maxHealth)
			lifePoints = maxHealth;
		else
			lifePoints += healthAdded;
	}
	
	// function: setRole
	// purpose: used to set the role of the character at the beginning of the game
	// input: int that is their role and similar to the team they are on
	// output: none
	public void setRole(int r) {
		switch(r) {
			case 0:
				role = "Sherrif";
				team = 1;
				break;
			case 1:
				role = "Outlaw";
				team = 2; 
				break;
			case 2:
				role = "Renegade";
				team = 3;
				break;
			case 3:
				role = "Debuty";
				team = 4;
				break;
		}
	}
}

/* Character/Life Point/Special Ability:
 * 	0
 * 		Black Jack
 * 		8
 * 		Dynamit reroll if reroll num is < 3
 * 	1
 * 		El Gringo
 * 		7
 * 		When life point decrease by another player, they take an arrow (dealt with outside character)
 * 	2
 * 		Jesse Jones
 * 		9
 * 		If you have four life points or less, you gain two if you beer for yourself (IMPLEMENTED IN THE CLASS (selfBeer))
 * 	3
 * 		Jourdonnais
 * 		7
 * 		Don't loose more than one life point to indians (IMPLEMENTED IN THE CLASS (clearArrows))
 * 	4
 * 		Paul Regret
 * 		9
 * 		Gatling gun doesn't harm (maybe dealt with outside character)
 * 	5
 * 		Pedro Ramirez
 * 		8
 * 		Each time you lose a life point, you may discard one of your arrows (IMPLEMENTED IN THE CLASS (damage))
 * 	6
 * 		Suzy Lafayette
 * 		8
 * 		If you don't roll one-shot or two-shot, gain two life points (handled outside)
 * 	7
 * 		Vulture Sam
 * 		9
 * 		Each time another player is eliminated, you gain two life points
 * 	8
 * 		Jose Delgado
 * 		7
 * 		+ 1 dice, if you use loudmouth (outside)
 * 	9
 * 		Tequila Joe
 * 		7
 * 		+ 1 dice, if you use the coward dice (outside)
 * 	10
 * 		Belle Star
 * 		8
 * 		Can change up to three dynamites to gatling guns (outside)
 * 	11
 * 		Greg Digger
 * 		7
 * 		Use each beer rolled twice (IMPLEMENTED IN THE CLASS (selfBeer))
 * 
 */

// Note on terminology: Players are the group, the human running the program is the user and the AI are called computers















