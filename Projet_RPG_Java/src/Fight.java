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
        while (gameRunning) {
            spawnNewMob();
            System.out.println("A wild " + mob.getName() + " appears!");
            Fight fight = new Fight(player, mob);
            fight.fighting(player, mob);

            // Check if the player won or lost
            if (player.getFullHealth() <= 0) {
                System.out.println("You have been defeated.");
                gameRunning = false;
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
                if (mob != null) {
                    System.out.println(mob.getName() + " has " + mob.getHealth() + "/" + mob.getMaxHealth() + " hp left.");
                }
                turn = false;
            } else {
                mobTurn();
                turn = true;
            }
            if (checkEnd()) {
                end = true;
            }
        }

        // Gains if player wins
        // !turn because turn is set to false after player's turn
        if (!turn && mob.getHealth() <= 0) {
            double levelDiff = (double) mob.getLevel() / player.getLevel();

            // XP Gain function
            double gainedXp = mob.getXp_drop() * Math.pow(levelDiff, 1.1); // x = y * diff^1.1
            int xpGainInt = (int) Math.round(gainedXp);
            int newXp = xpGainInt + player.getXP();
            player.setXP(newXp);
            System.out.println("You gain " + gainedXp + " experience points.");
            System.out.println("You now have " + player.getXP() + " experience points.");
            player.checkLevelUp();

            // Drops
            Inventory drops = mob.getDrop();
            System.err.println("Items dropped:");
            if (drops == null) {
                System.out.println("No items dropped");
            } else {
                drops.displayInventory();
                if (player.getInventory() != null) {
                    player.getInventory().addItems(drops);
                }
            }
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
            default:
                mob = null;
                break;
        }
    }

    public void playerTurn() {
        boolean validInput = false;
        int choice = 0;
        do {
            System.out.println("What do you want to do?");
            System.out.println("1- Attack");
            System.out.println("2- Heal");
            System.out.println("q- Quit");
            String input = scanString.nextLine();
            if (input.equals("q")) {
                System.out.println("Leaving the fight.");
                MenuSystem.displayMenu();
                // TODO: Handle quitting the combat
                return;
            } else {
                try {
                    choice = Integer.parseInt(input);
                    switch (choice) {
                        case 1:
                            player.attack(mob);
                            validInput = true;
                            break;
                        case 2:
                            player.heal("small");
                            validInput = true;
                            break;
                        case 3:
                            player.heal("medium");
                            validInput = true;
                            break;
                        default:
                            System.out.println("Input argument is invalid");
                            break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Hun???");
                }
            }
        } while (!validInput);
    }

    public void mobTurn() {
        if (mob != null) {
            mob.attack(player);
            System.out.println(player.getName() + " has " + player.getFullHealth() + "/" + player.getFullMaxHealth() + " hp left.");
        }
    }

    private boolean checkEnd() {
        return mob.getHealth() <= 0 || player.getFullHealth() <= 0;
    }
}
