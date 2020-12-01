/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bang;

/**
 *
 * @author ctaylor
 * @author Megan Lorfing (secondary author)
 */
public class Player {

    String name;
    String displayName;
    int health;
    int maxHealth;
    String role;
    boolean computer;
    public int t_bul;
    public int s_bul;
    public int arrows;
    boolean dynamiteReroll = false;
    int rolls = 3;
    int gatsNeeded = 3;
    int team;
    public boolean shown;
    public boolean known;
    public boolean chiefArrow = false;
    
    // variables to hold the special abilities
    public boolean doubleBeer = false; // special ability for greg digger
    public boolean pedro = false; // special ability for pedro
    public boolean jourdonnais = false; // special ability for jourdonnais
    public boolean JJ = false; // special ability for jesse jones

    CharCards c; //team assign

    public Player(String name, int health, String role, boolean comp) {
        this.name = name;
        this.displayName = name;
        this.health = health;
        this.maxHealth = health;
        this.role = role;
        this.computer = comp;
        this.s_bul = health % 3;
        this.t_bul = (health - this.s_bul) / 3;
        this.arrows = 0;
        this.shown = false;
        if (this.name.equals("Black Jack")) {
            this.dynamiteReroll = true;
        }
        if (this.role.equals("Sheriff") || this.role.equals("Deputy")) {
            this.team = 0;
        } else if (this.role.equals("Outlaw")) {
            this.team = 1;
        } else if (this.role.equals("Renegade")) {
            this.team = 2;
        }
        if(name.equals("Greg Digger"))
        	doubleBeer = true;
        if(name.equals("Pedro Ramirez"))
        	pedro = true;
        if(name.equals("Jourdonnais"))
        	jourdonnais = true;
        if(name.equals("Jesse Jones"))
        	JJ = true;
    }

    public CharCards getCharacter() { //calling characters class from bang.java
        return this.c;
    }
    
    public void bulletUpdate() {
        this.s_bul = this.health % 3;
        this.t_bul = (this.health - this.s_bul) / 3;
    }

    public void addArrow(int number) {
        this.arrows += number;
    }

    public void removeArrow(int number) {
        this.arrows -= number;
    }

    public void arrowReset() {
        this.arrows = 0;
    }

    public void damage(int damage) {
        if (this.health > damage) {
            this.health -= damage;
        } else {
            this.health = 0;
        }
        bulletUpdate();
    }
    
    // function name: clearArrows()
 	// purpose: this function is used when all of the arrows have been taken and the health points need to be distrubted to all players
 	//			It will subtract the number of players in the players hand from their health and reset the number of arrows to 0
 	// input: none
 	// output: none
 	public void clearArrows() {
 		if(jourdonnais && arrows > 1)
 			arrows = 1;
 		health -= arrows;
 		arrows = 0;
 	}

//AI assigning  each character roles according to their abilties


       
   public void setMaxHealth(int maxHealth){
       this.maxHealth = maxHealth;
   }
    
    public void heal(int heal) {
        //if jessie jones then heal points + 1
        if (this.health + heal > this.maxHealth) {
            this.health = this.maxHealth;
        } else {
            this.health += heal;
        }
        bulletUpdate();
    }

    public void revealRole() {
        this.shown = true;
        this.known = true;
    }
    
    public boolean diceChoice()
    {
        
        return true;
    }
    
    // function: isDead
 	// purpose: return if the character's life points have reached zero, meaning they are dead
 	// input: none
 	// output: boolean
 	public boolean isDead() {
 		return health == 0;
 	}
 	
 	// function: Beer
 	// purpose: used when a character rolls a beer and uses it on themselves
 	// input: none
 	// output: none
 	public void selfBeer() {
 		int healthAdded;
 		if(doubleBeer || ( JJ && health <= 4))
 			healthAdded = 2;
 		else
 			healthAdded = 1;
 		if(health + healthAdded > maxHealth)
 			health = maxHealth;
 		else
 			health += healthAdded;
 	}
}

