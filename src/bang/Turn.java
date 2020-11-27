/*
EXTREAMLY BROKEN
ToDo: add layed out methods
    add dice checker 
    add rounds

 */

package bang;

/**
 *
 * @author Hunter King
 */

/*
user: real person
computer: AIs
player: user and computer
*/
public class turn {
    /*
    turn
    handles the players turn
    in: players
    out: updated players
    */
    
    public turn(Player turnPlayer, Player p1){
        //dice rolls
        String indianArrow="indian arrow";
        String dyn= "dynamite"; 
        String be1= "bull's eye '1'";
        String be2= "bull's eye '2'";
        String beer= "beer";
        String gatling= "gatling";
        
        Dice currDie;
        String side;
        
        Dice regDie = new Dice(0,0, "indian arrow","dynamite" ,"bull's eye '1'","bull's eye '2'" , "beer", "gatling");
        
        Dice die1 = regDie;
        Dice die2 = regDie;
        Dice die3 = regDie;
        Dice die4 = regDie;
        Dice die5 = regDie;
        Dice die6 = regDie;
        
        
        
        Dice diceArray[]= {die1, die2, die3, die4, die5, die6};
        
        for(int rolls=0; rolls<turnPlayer.rolls; rolls++){
            for(int numDice=0; numDice<turnPlayer.numDice; numDice++){
                currDie= diceArray[numDice];
                side=currDie.roll();
                System.out.println(side);
                
            }
            
            System.out.println("---------------");
        }
        
        
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
    in: dice type, player list
    out: updated player list
    */
    public void attack(){
        
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
}
