package tutorials;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //System objects
        Scanner in = new Scanner(System.in); //Get input from user
        Random rand = new Random(); //Get random numbers

        //Game variables
        String[] enemies = {"Skeleton", "Zombie", "Warrior", "Assassin"};
        int maxEnemyHealth = 75;
        int enemyAttackDamage = 25;

        //Player variables
        int health = 100;
        int attackDamage = 50;
        int numHealthPotions = 3;
        int healthPotionHealAmount = 30;
        int healthPotionDropChance = 50; //Percentage

        boolean running = true;

        System.out.println("Welcome to the jungle");

        GAME:
        while (running) {
            System.out.println("______________________________________________");
            /* Randomize enemy health, get random name for enemy, print out to user */
            int enemyHealth = rand.nextInt(maxEnemyHealth);
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("\t# " + enemy + " has appeared! #\n");

            while (enemyHealth > 0) {
                System.out.println("\tYour HP: " + health);
                System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink health potion");
                System.out.println("\t3. Run");

                String input = in.nextLine();
                if (input.equals("1")) {
                    int damageDealt = rand.nextInt(attackDamage); //Generate random num between 0 and 50
                    int damageTaken = rand.nextInt(enemyAttackDamage); //Generate random num between 0 and 25

                    enemyHealth -= damageDealt;
                    health -= damageTaken;

                    System.out.println("\t> You strike the " + enemy + " for " + damageDealt + " damage.");
                    System.out.println("\t> You recieve " + damageTaken + " in retaliation!");

                    if (health < 1) {
                        System.out.println("\t> You have taken too much damage, you are too weak to go on!");
                        break;
                    }
                } else if (input.equals("2")) {
                    if (numHealthPotions > 0) {
                        health += healthPotionHealAmount;
                        numHealthPotions--;
                        System.out.println("\t> Yoy drink a health potion, healing yourself for " + healthPotionHealAmount + "."
                                + "\n\t> You now have " + health + "HP."
                                + "\n\t> You have " + numHealthPotions + "health potions left.\n");
                    } else {
                        System.out.println("\t> You have no health potions left! Defeat enemies for a chance to get one");
                    }
                } else if (input.equals("3")) {
                    System.out.println("+tYou run away from the " + enemy + "!");
                    continue GAME;

                } else {
                    System.out.println("\tInvalid command");
                }

            }

            if (health < 1) {
                System.out.println("You limp out of the dungeon, weak from battle.");
                break;
            }

            System.out.println("______________________________________________");
            System.out.println(" # " + enemy + " was defeated! # ");
            System.out.println(" # You have " + health + "HP left. #");
            if (rand.nextInt(100) < healthPotionDropChance) {
                numHealthPotions++;
                System.out.println(" # The " + enemy + " dropped a health potion! # ");
                System.out.println(" # You now have" + numHealthPotions + " health potion(s). # ");
            }
            System.out.println("______________________________________________");
            System.out.println("What would you like to do?");
            System.out.println("1. Continue fighting");
            System.out.println("2. Exit dungeon");

            String input = in.nextLine();

            while (!input.equals("1") && !input.equals("2")) {
                System.out.println("Invalid command!");
                input = in.nextLine();
            }

            if (input.equals("1")) {
                System.out.println("You continue on your adventure!");
            } else if (input.equals("2")) {
                System.out.println("You exit the dungeon, successful from your adventure!");
                break;
            }


        }
        System.out.println("######################");
        System.out.println("# THANKS FOR PLAYING #");
        System.out.println("######################");
    }
}
