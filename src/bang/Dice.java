/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bang;

import java.util.Random;

/**
 *
 * @author ctaylor
 */
public class Dice {

    String sides[] = new String[6];
    int side;
    int dice;
    boolean canRoll;
    
    public Dice(int dice, int side, String s1, String s2, String s3, 
            String s4, String s5, String s6){
        this.side = side;
        this.dice = dice;
        sides[0] = s1;
        sides[1] = s2;
        sides[2] = s3;
        sides[3] = s4;
        sides[4] = s5;
        sides[5] = s6;
        canRoll = true;
    }
    
    public String keep(){
        return this.sides[this.side];
    }
    
    public String roll(){
        Random rand = new Random();  
        this.side = (rand.nextInt(1000000000)%6);
        return sides[side];
    }
}
