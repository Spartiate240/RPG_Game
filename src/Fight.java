
import java.util.Scanner;
import java.util.Random;
import mobs.*;


public class Fight {
    private Player player;
    static Mob mob;
    static Random random;
    private static Scanner scanString = new Scanner(System.in);


    public Fight(Player player, Mob mob) {
        this.player = player;
        this.mob = mob;
    }


    static void FightLoop(Player player) {
        boolean gameRunning = true;
        Fight.spawnNewMob();
        while (gameRunning) {
            System.out.println("A wild " + mob.getName() + " appears!");
            Fight fight = new Fight(player, mob);
            fight.fighting(player, mob);

            // Check if the player won or lost
            if (player.getHealth() <= 0) {
                System.out.println("You have been defeated.");
                gameRunning = false;
            } else {
                Fight.spawnNewMob();
            }
        }
    }


    public void fighting(Player player, Mob mob) {
        boolean end = false;
        boolean turn = true; // true when player's turn
        // The fight
        while (!end) {
            System.out.println();
            if (turn) {
                playerTurn();
                System.out.println(mob.getName() + " has " + mob.getHealth() + "/" + mob.getMaxHealth() + " hp left.");
                turn = false;
            } else {
                mobTurn();
                turn = true;
            }
            if( checkEnd()) {
                end = true;
            }
        }
        // Gains if player wins
        // !turn because turn is set to false after player's turn
        if(!turn) {
            double level_diff = mob.getLevel()/player.getLevel();

            // XP Gain funciton
            double gained_xp = mob.getXp_drop()*Math.pow(level_diff, 1.1);
            int xp_gain_Int = (int) Math.round(gained_xp);
            int new_xp =  xp_gain_Int + player.getXP();
            player.setXP(new_xp);
            System.out.println("You gain " + gained_xp + " experience points.");
            System.out.println("You now have " + player.getXP() + " experience points.");
            player.checkLevelUp();
            //TODO End of battle things (drops)
        }
    }






    static void spawnNewMob() {
        random = new Random();
        int mobType = random.nextInt(2); 
        switch (mobType) {
            case 0:
                mob = new Spider();
                break;
            case 1:
                mob = new Wolf();
                break;

        }
    }

    public void playerTurn() {
        Scanner scanner = new Scanner(System.in);
        boolean entreevalide = false;
        int s = 0;
        do {
            System.out.println("What do you want to do?");
            System.out.println("1- Attack");
            System.out.println("2- Heal");
            String entreeString = scanString.nextLine();
            if (entreeString.equals("q")) {
                System.out.println("Leaving the fight.");
                // TODO Gestion quitter combat
            } else {
                try {
                    s = Integer.parseInt(entreeString);
                    switch (s) {
                        case 1:
                            player.attack(mob);
                            entreevalide = true; 
                            break;
                        case 2:
                            player.heal("small");
                            entreevalide = true;
                            break;
                        case 3:
                            player.heal("medium");
                            entreevalide = true;
                        default:
                            System.out.println("Input argument is invalid");
                            break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Hun???");
                }
            }
        } while (!entreevalide);
    }


    public void mobTurn() {
        mob.attack(player);
        System.out.println(player.getName() +" has " + player.getHealth() + "/" + player.getMaxHealth() + " left.");

    }

    private boolean checkEnd() {
        if (mob.getHealth() <= 0 || player.getHealth() <= 0) {
            return true;
        } else {
            return false;
        }
    }



}
