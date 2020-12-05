/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bang;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @MainAuthor Sean Criswell
 * @author Christiana Taylor
 * @author Seth Michaels
 * @author Megan Lorfing
 * @author Hunter King
 * 
 */
public class DiceRoll {
    private static String reroll() {
        
        Scanner scan = new Scanner(System.in);
        
        String a = null;
        
        System.out.println ("Would you like to reroll(Y/N)? ");
        a = scan.nextLine();
        
        if (a.equals("Y") || a.equals("y") || a.equals("N") || a.equals("n")){
            
            return a;
            
        }
        
        else {
            System.out.println ("Please choose a correct input.\n");
            reroll();
        }
        
        return a;
    }
    
      private static String saloondice() {
        
        Scanner scan = new Scanner(System.in);
        
        String a = null;
        
        System.out.println ("Would you like to replace a regular dice with Loudmouth or Coward dice?");
        System.out.println ("(1 = Loudmouth, 2 = Coward, 3 = Do not replace) : ");
        a = scan.nextLine();
        
        if (a.equals("1") || a.equals("2") || a.equals("3")){
            
            return a;
            
        }
        
        else {
            System.out.println ("Please choose a correct input.\n");
            saloondice();
        }
        
        return a;

    }
    
      public static boolean undeaddice(int choice) {
          int a = choice;
        if(a == 1){/*
            String sd = saloondice();

            if (sd.equals("3")) {

                System.out.print(whiteDice(randnum()));
                System.out.print(whiteDice(randnum()));
                System.out.print(whiteDice(randnum()));
                System.out.print(blackDice(randnum()));
                System.out.print(blackDice(randnum()));
            }     

            if (sd.equals("2")) {

                System.out.print(loudmouthDice(randnum()));
                System.out.print(whiteDice(randnum()));
                System.out.print(whiteDice(randnum()));
                System.out.print(blackDice(randnum()));
                System.out.print(blackDice(randnum()));
            }  

            if (sd.equals("3")) {

                System.out.print(cowardDice(randnum()));
                System.out.print(whiteDice(randnum()));
                System.out.print(whiteDice(randnum()));
                System.out.print(blackDice(randnum()));
                System.out.print(blackDice(randnum()));
            }*/
        return true;
        }else{/*
            String sd = saloondice();

            if (sd.equals("3")) {

                System.out.print(whiteDice(randnum()));
                System.out.print(whiteDice(randnum()));
                System.out.print(whiteDice(randnum()));
                System.out.print(whiteDice(randnum()));
                System.out.print(whiteDice(randnum()));
            }     

            if (sd.equals("2")) {

                System.out.print(loudmouthDice(randnum()));
                System.out.print(whiteDice(randnum()));
                System.out.print(whiteDice(randnum()));
                System.out.print(whiteDice(randnum()));
                System.out.print(whiteDice(randnum()));
            }  

            if (sd.equals("1")) {

                System.out.print(cowardDice(randnum()));
                System.out.print(whiteDice(randnum()));
                System.out.print(whiteDice(randnum()));
                System.out.print(whiteDice(randnum()));
                System.out.print(whiteDice(randnum()));
            }*/
            return false;
            
        }

    }
    
    
    public static int randnum() {
        
        int num = 0;
        
        Random roll = new Random();
        
        num = roll.nextInt(10000000%6);
        
        return num;
    }
    
    public static String whiteDice(int i) {
        
        int hold = i;
        
        String result = null;
        
        switch (hold) {
            case 0:
                result = "be1";
                break;
            case 1:
                result = "be2";
                break;
            case 2:
                result = "dynamite";
                break;
            case 3:
                result = "Arrow ";
                break;
            case 4:
                result = "Gatling-Gun ";
                break;
            case 5:
                result = "Beer ";
                break;
                       
        }
        
        
        return result;
    }
    
    public static String cowardDice(int i) {
        
        int hold = i;
        
        String result = null;
        
        switch (hold) {
            case 0:
                result = "One ";
                break;
            case 1:
                result = "Two-Beers ";
                break;
            case 2:
                result = "Dynamite ";
                break;
            case 3:
                result = "Arrow ";
                break;
            case 4:
                result = "Broken-Arrow ";
                break;
            case 5:
                result = "Beer ";
                break;
                       
        }
        
        
        return result;
    }
    
    public static String loudmouthDice(int i) {
        
        int hold = i;
        
        String result = null;
        
        switch (hold) {
            case 0:
                result = "Double-One ";
                break;
            case 1:
                result = "Double-Two ";
                break;
            case 2:
                result = "Dynamite ";
                break;
            case 3:
                result = "Arrow ";
                break;
            case 4:
                result = "Gatling-Gun ";
                break;
            case 5:
                result = "Silver-Bullet ";
                break;
                       
        }
        
        
        return result;
    }
    
    public static String blackDice(int i) {
        
        int hold = i;
        
        String result = null;
        
        switch (hold) {
            case 0:
                result = "Duel ";
                break;
            case 1:
                result = "Duel ";
                break;
            case 2:
                result = "Dynamite ";
                break;
            case 3:
                result = "Arrow ";
                break;
            case 4:
                result = "Broken Arrow ";
                break;
            case 5:
                result = "Whiskey Bottle ";
                break;
                       
        }
        
        
        return result;
    }
    
    public static void main(String args[]) {
        

        
        String sd = saloondice();

            if (sd.equals("3")) {

                System.out.print(whiteDice(randnum()));
                System.out.print(whiteDice(randnum()));
                System.out.print(whiteDice(randnum()));
                System.out.print(whiteDice(randnum()));
                System.out.print(whiteDice(randnum()));
            }     

            if (sd.equals("2")) {

                System.out.print(loudmouthDice(randnum()));
                System.out.print(whiteDice(randnum()));
                System.out.print(whiteDice(randnum()));
                System.out.print(whiteDice(randnum()));
                System.out.print(whiteDice(randnum()));
            }  

            if (sd.equals("1")) {

                System.out.print(cowardDice(randnum()));
                System.out.print(whiteDice(randnum()));
                System.out.print(whiteDice(randnum()));
                System.out.print(whiteDice(randnum()));
                System.out.print(whiteDice(randnum()));
            }
           
    }
}
