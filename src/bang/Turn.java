/*
EXTREAMLY BROKEN
ToDo: add layed out methods
    add dice checker 
    add rounds

 */

package bang;
import java.util.*;
/**
 *
 * @author Hunter King 
 */

/*
user: real person
computer: AIs
player: user and computer
*/
public class Turn {
    /*
    turn
    handles the players turn
    in: players
    out: updated players
    */
    
    public Turn(Character turnPlayer, Character p1){
        //dice rolls
        String indianArrow="indian arrow";
        int dynCounter=0; 
        String be1= "bull's eye '1'";
        String be2= "bull's eye '2'";
        String beer= "beer";
        String gatling= "gatling";
        String Reroll;
        
        Dice currDie;
        String side;
        
        Dice regDie = new Dice(0,0, "indian arrow","dynamite" ,"bull's eye '1'","bull's eye '2'" , "beer", "gatling");
        
        Dice die1 = new Dice(0,0, "indian arrow","dynamite" 
                             ,"bull's eye '1'","bull's eye '2'" , "beer", "gatling");
        Dice die2 = new Dice(0,0, "indian arrow","dynamite" 
                             ,"bull's eye '1'","bull's eye '2'" , "beer", "gatling");
        Dice die3 = new Dice(0,0, "indian arrow","dynamite" 
                             ,"bull's eye '1'","bull's eye '2'" , "beer", "gatling");
        Dice die4 = new Dice(0,0, "indian arrow","dynamite" 
                             ,"bull's eye '1'","bull's eye '2'" , "beer", "gatling");
        Dice die5 = new Dice(0,0, "indian arrow","dynamite" 
                             ,"bull's eye '1'","bull's eye '2'" , "beer", "gatling");
        Dice die6 = new Dice(0,0, "indian arrow","dynamite" 
                             ,"bull's eye '1'","bull's eye '2'" , "beer", "gatling");
        
        Dice diceArray[]= {die1, die2, die3, die4, die5, die6};
        
        for(int rolls=0; rolls<turnPlayer.rolls; rolls++){
            for(int numDice=0; numDice<turnPlayer.numDice; numDice++){
                currDie= diceArray[numDice];
                if (!currDie.keep().equals("dynamite")){
                    currDie.roll();
                } 
            }  
            //Testing
            for(int numDice=0; numDice<turnPlayer.numDice; numDice++){
                currDie= diceArray[numDice];
                System.out.println(currDie.keep());
            }  
            //test end
            System.out.println(rolls);
            Reroll=null;
            while (Reroll==null&&rolls+1<turnPlayer.rolls){
                //user input for Rerolls Yes/ No
                System.out.println("do you wish to reroll? {y/n}");
                Scanner scan= new Scanner(System.in);
                Reroll = scan.nextLine();
                

                switch (Reroll.toLowerCase()) {
                    case "y":
                        break;
                    case "n":
                        rolls=turnPlayer.rolls;
                        break;
                    default:
                        System.out.println("please enter a valid answer {y/n}.");
                        break;
                }
            }
        }
        
        for(int numDice=0; numDice<turnPlayer.numDice; numDice++){
            switch (diceArray[numDice].keep()){
                case "indian arrow":
                    break;
                case "dynamite":
                    dynCounter++;
                    if (dynCounter<=3){
                        //deal dynamite damage to player
                        
                    }
                    break;
                case "bull's eye '1'":
                    
                    break;
                case "bull's eye '2'":
                    
                    break;
                case "beer":
                    
                    break;
                case "gatling":
                    
                    break;
                
                
            }
        }
    }
    /*
    Creates the lobby of players
    takes user input
    outputs the lobby of players 
    */
    public ArrayList<Player> createLobby(){
        
        ArrayList<Player> Lobby=new ArrayList<>();
        
        
        
        return Lobby;
    }
    
    
    
    /* 
    dynamite 
    changes a die to an unueseable state and how many dice dynamite there are
    deals damage if 3 or more dunamite.
    in: diceArray
    out: diceArray
    */
    
    public void dynamite(Dice die1){
        
    }
    /*
    winCheck
    checks if a players have won
    uses the the roles and everyones death status to see if someone has won
    in: all players
    out: who won. 
    */
    
    public void winCheck(){
        
    }
    
   /*
    attack
    user input to designate who they want to attack based on dice roll
    in: dice type (d), player list (l), index of the player performing the action (p)
    out: updated player list
    */
    public ArrayList<Character> attack(Dice d, ArrayList<Character> l, int p){
        int choice1, choice2; // integers to hold the options for the player to deal damage to. I
    	switch(d.side) {
        case 2: // If the side of the dice is the single bullet side
        	if(p-1 < 0) {
        		choice1 = l.size() - 1;
        		while(l.get(choice1).isDead()) {
        			if(choice1 - 1 < 0)
                		choice1 = l.size() - 1;
        			choice1 -= 1;
        		}
        	} else {
        		choice1 = p - 1;
        		while(l.get(choice1).isDead()) {
        			if(choice1 - 1 < 0)
        				choice1 = l.size() - 1;
        			choice1 -= 1;
        		}
        	}
        	if(p+1 == l.size()) {
        		choice2 = 0;
        		while(l.get(choice1).isDead()) {
        			if(choice1 - 1 < 0)
                		choice1 = l.size() - 1;
        			choice1 -= 1;
        		}
        	} else {
        		choice1 = p - 1;
        		while(l.get(choice1).isDead()) {
        			if(choice1 - 1 < 0)
        				choice 1 = l.size() - 1;
        			choice1 -= 1;
        		}
        	}
        	// ask for user input of who to kill: choice1 or choice2
        	
        	break;
        case 3: // if the side of the dice is the double bullet side
        	if(p-2 < 0) {
        		choice1 = l.size() - 1;
        		while(l.get(choice1).isDead()) {
        			if(choice1 - 1 < 0)
                		choice1 = l.size() - 1;
        			choice1 -= 1;
        		}
        	} else {
        		choice1 = p - 1;
        		while(l.get(choice1).isDead()) {
        			if(choice1 - 1 < 0)
        				choice1 = l.size() - 1;
        			choice1 -= 1;
        		}
        	}        	
        	break;
        case 5: // if the side of the dice is the gatling gun side
        	break;
        }
    	
    	
    	return l;
    }
    /*
    arrowCheck
    checks to see if all arrows have be drawn and will deal appropriate 
    damage if all are drawn 
    in: arrowCounter, player list
    out: updated player list
    */
    public void arrowCheck(){
        
    }
    public static void main(String args[]) {
        Character p1= new Character(0);
        Character p2= new Character(0);
        Turn neww= new Turn(p1, p2);
    }
}
