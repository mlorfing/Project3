/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bang;
 import java.util.*;
/**
 *
 * @author ctaylor
 */
public class Bang {

    /**
     * @param args the command line arguments
     */

    public void Start(int choice) {
        // TODO code application logic here
        int players = choice;
        System.out.println("Welcome to the Bang! Game!");
        //System.out.println("Choose the number of players: ");
        System.out.println("You chose "+players+" players.");
        //System.out.println("You chose the character: "+char_sel);
        ArrayList<Roles> role = new ArrayList();
        switch (players){
            case 8:
                role.add(new Roles("Renegade"));
            case 7:
                role.add(new Roles("Deputy"));
            case 6:
                role.add(new Roles("Outlaw"));
            case 5:
                role.add(new Roles("Deputy"));
            case 4:
                role.add(new Roles("Sheriff"));
                role.add(new Roles("Renegade"));
                role.add(new Roles("Outlaw"));
                role.add(new Roles("Outlaw"));
                Collections.shuffle(role);
        }
        

        
        //System.out.println(game.getPlayerCount());
    }
    
    public String getCharSel(int count){
        
        switch(count){
            
            case 1: return "Bart Cassidy";
            case 2: return "Black Jack";
            case 3: return "Calamity Janet";
            case 4: return "El Gringo";
            case 5: return "Jesse Jones";
            case 6: return "Jourdonnais";
            case 7: return "Kit Carlson";
            case 8: return "Lucky Duke";
            case 9: return "Paul Regret";
            case 10: return "Pedro Ramirez";
            case 11: return "Rose Doolan";
            case 12: return "Sid Ketchum";
            case 13: return "Slab the Killer";
            case 14: return "Suzy Lafayette";
            case 15: return "Vulture Sam";
            case 16: return "Willy the Kid";
            default: return "";
        }
    }
    
}
