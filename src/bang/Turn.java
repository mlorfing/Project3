
package bang;
import java.util.*;
/**
 *
 * @Main author Hunter King 
 * @author Megan Lorfing
 * @aurthor Sean Criswell
 * @aurthor Seth Michaels
 * @aurthor Christiana Taylor
 * 
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
	
	// int to keep track of the number of indian arrows left
    int arrowPool = 9;
    
    public Turn(ArrayList<Player> lobby, int pos){
        //dice rolls
        int dynCounter=0; 
        String Reroll;
        
        Player turnPlayer = lobby.get(pos);
        
        Dice currDie;
        
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
                        turnPlayer.damage(1);
                    }
                    break;
                case "bull's eye '1'":
                    lobby=attack(diceArray[numDice],lobby,pos);
                    break;
                case "bull's eye '2'":
                    lobby=attack(diceArray[numDice],lobby,pos);
                    break;
                case "beer":
                    lobby=heal(diceArray[numDice],lobby,pos);
                    break;
                case "gatling":
                    // keeping track of the gats is done by each character (part of their class)
                    lobby=attack(diceArray[numDice],lobby,pos);
                    break;
            }
        }
    }
    
    /*
    winCheck
    checks if a players have won
    uses the the roles and everyones death status to see if someone has won
    in: all players
    out: who won. 
    */
    
    public int winCheck(ArrayList<Player> l){
        int sheriffCheck=0;
        int deputyCount=0;
        int outlawCount=0;
        int renegadeCount=0;
        Player currPlayer;
        
        for(int i=0; i<l.size(); i++){
            currPlayer=l.get(i);
            if (!currPlayer.isDead()){
                switch(currPlayer.role){
                    case("Sheriff"):
                        sheriffCheck=1;
                        break;
                    case("Deputy"):
                        deputyCount++;
                        break;
                    case("Outlaw"):
                        outlawCount++;
                        break;
                    case("Renegade"):
                        renegadeCount++;
                        break;
                }
                    
            }
        }
        if(sheriffCheck==0){
            if (outlawCount==0&&deputyCount==0&&renegadeCount==1){
                //renegade wins team 2
                return 2;
            }
            else{
                //outlaws win team 1
                return 1;
            }
            
        }
        else if(outlawCount==0&&renegadeCount==0){
            //Sheriff and Deputy win team 0
            return 0;
        }
        
        return -1;
    }
    
    /*
    attack
    user input to designate who they want to attack based on dice roll
    in: dice type (d), player list (l), index of the player performing the action (p)
    out: updated player list
    */
    // dependent upon single bullet always being on side 2, double bullet always being on side 3 and gatling always being on side 5
    public ArrayList<Player> attack(Dice d, ArrayList<Player> l, int p){
        int option1 = -1;
        int option2 = -1; // integers to hold the options for the player to deal damage to. Gatling gun will not use this
        int choice = -1;
    	switch(d.side) {
        case 2: // If the side of the dice is the single bullet side
        	// assigning the index of the player for the "left" option
        	if(p-1 < 0)  // if needing to go to the end of the lobby to get the next player
        		option1 = l.size() - 1; // get the end of the lobby
        	else
        		option1 = p - 1;
        	
        	if(p+1 == l.size())
        		option2 = 0;
        	else
        		option2 = p + 1;
        	
        	break;
        case 3: // if the side of the dice is the double bullet side
        	if(p == 1) // if two people to the left would need to go the end of the lobby
        		option1 = l.size() - 1;
        	else if(p == 0) // if two people to the left would be the end of the lobby and one farther left
        		option1 = l.size() - 2;
        	else // in the middle of the lobby
        		option1 = p - 2;
        	if(p == l.size() - 2)  // if two people to the right would be the beginning of the lobby
        		option2 = 0;
        	else if(p == l.size() - 1) // if two people to the right would be the beginning of the lobby + 1
        		option2 = 1;
        	else // in the middle of the lobby
        		option2 = p + 2;
        	break;
        case 5: // if the side of the dice is the gatling gun side
        	l.get(p).gatsNeeded--; // decrement the number of gats needed, since the player has chosen to keep the dice
        	
        	if(l.get(p).gatsNeeded == 0) { // if the current player has gotten enough gatling guns
        		for(int i = 0; i < l.size(); i++) { // go through all of the characters
        			if(i != p && !l.get(i).isDead()) { // if the chosen character is not the current player and the chosen character isn't dead
        				l.get(i).damage(1);
        				if(l.get(i).name.equals("El Gringo")) {
        					l.get(p).addArrow(1);
        					arrowPool--;
        				}
        				if(l.get(i).name.equals("Paul Regret"))
        					l.get(i).heal(1);
        			}	
        		}
        		l.get(p).gatsNeeded = 3;
        	}
        	return l;
        } 
    	if(d.side == 2 || d.side == 3) {
	    	while(l.get(option1).isDead()) { // if that character is dead
				if(option1 - 1 < 0) // if needing to go to the end of the lobby to get the next player
	        		option1 = l.size() - 1; // go to the end of the lobby
				option1 -= 1; // decrement the choice
	    	}
	    	while(l.get(option2).isDead()) { // if that character is dead
				if(option2 + 1 == l.size()) // if needing to go to the beginning of the lobby to get the next player
	        		option2 = 0; // go to the beginning of the lobby
				option2 += 1; // imcrement the choice
	    	}
	    	// ask the user to choose who to kill: choice1 or choice2
	    	System.out.println("Do you want to deal one damage to (1)" + l.get(option1).name + " or (2)" + l.get(option2).name);
	    	System.out.println("Enter the number of the player to deal damage to: ");
	    	
	    	Scanner scan = new Scanner(System.in);
	    	choice = scan.nextInt();
	    	
	    	l.get(choice).damage(1); 
    	}
        if(l.get(choice).name.equals("El Gringo")) {
            l.get(p).addArrow(1);
            arrowPool--;
        }
    	return l;
    }
    public ArrayList<Player> heal (Dice d, ArrayList<Player> l, int p){
        int choice; //stores player choise if applicable 
        if (l.get(p).computer){
            l.get(p).selfBeer();
        }
        else{
            //player choice
            System.out.println("chose player to heal");
            for (int i=0; i<l.size(); i++){
                if (l.get(i).isDead()){
                    System.out.print(i);
                    System.out.println(l.get(i).name);
                }
            }
            Scanner scan = new Scanner(System.in);
	    choice = scan.nextInt();
            for (int i=0; i<l.size(); i++){
                if(choice==p) l.get(p).selfBeer();
                else{
                    l.get(choice).health=l.get(choice).health+1;
                }
                
            }
        }
        return l;
    }
    
    public static void main(String args[]) {
        ArrayList<Player> lobby=new ArrayList<>();
        lobby.add(new Player("name",8,"renegade",false));
        Turn neww= new Turn(lobby, 0);
    }
}
