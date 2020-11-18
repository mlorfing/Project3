/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bang;

/**
 *
 * @author ctaylor
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
        if (this.name.equals("Lucky Duke")) {
            this.rolls = 4;
        }
        if (this.name.equals("Willy The Kid")) {
            this.gatsNeeded = 2;
        }
        if (this.role.equals("Sheriff") || this.role.equals("Deputy")) {
            this.team = 0;
        } else if (this.role.equals("Outlaw")) {
            this.team = 1;
        } else if (this.role.equals("Renegade")) {
            this.team = 2;
        }
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
    
}

