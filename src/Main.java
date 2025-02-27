import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Erstellung von Non-Playable-Charaktern
        ArrayList<NonPlayableCharacter> enemylist = getNonPlayableCharacters();

        PlayableCharacter playercharacter = characterCreation();

        for (int i = 0; i < enemylist.size(); i++) {
            NonPlayableCharacter enemy = playercharacter.encounter(enemylist);
            if (enemy.isHostile()) {
                fight(playercharacter, enemy);
                if (playercharacter.getCurrentHealth() > 0){
                    System.out.println("Herzlichen Gückwunsch, du hast " + enemy.getName() + " besiegt.");
                }
                else {
                    System.out.println("Oh nein, du wurdest besiegt. GAME OVER");
                    break;
                }
            }
            else{
                System.out.println(enemy.getName() + " winkt dir freundlich zu und geht weiter.");
            }
            enemy.setCurrentHealth(enemy.getMaxHealth());
            playercharacter.healing(playercharacter);
        }

    }

    private static ArrayList<NonPlayableCharacter> getNonPlayableCharacters() {
        ArrayList<NonPlayableCharacter> enemylist = new ArrayList<>();
        NonPlayableCharacter enemy1 = new NonPlayableCharacter("Goblin", 15, 3, 11, 25, 3, -1, 0, 1, 1, true, "Javelin", "default");
        NonPlayableCharacter enemy2 = new NonPlayableCharacter("Merchant", 10, -1, 10, 25, 2, 0, 2, 3, 1, false, "default", "default");
        NonPlayableCharacter enemy3 = new NonPlayableCharacter("Bugbear", 16, 2, 13, 25, 3, 2, -1, 1, 0, true, "Javelin", "default");
        enemylist.add(enemy1);
        enemylist.add(enemy2);
        enemylist.add(enemy3);
        return enemylist;
    }


    public static PlayableCharacter characterCreation(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wähle deinen Charakter:");
        System.out.println("Georg, Ralf, Olaf");
        PlayableCharacter playercharacter = switch (scanner.nextLine()) {
            case "Olaf" -> new PlayableCharacter("Olaf", 12, 3, 17, 30, -1, 2, 0, 1, 2, "Greataxe", "Javelin");
            case "Ralf" -> new PlayableCharacter("Ralf", 13, 1, 14, 30, 0, -1, 1, 3, 1, "Javelin", "Dagger");
            case "Georg" -> new PlayableCharacter("Georg", 8, 1, 15, 25, -1, 2, 3, 2, 1, "Greataxe", "Javelin");
            default -> new PlayableCharacter("Unbenannt", 0, 0, 0, 0, 0, 0, 0, 0, 0, "Dagger", "Dagger");
        };
        System.out.println("Du hast dich für " + playercharacter.getName() + " entschieden");
        return playercharacter;
    }

    public static void fight(Character fighter1, Character fighter2){
        while (fighter1.getCurrentHealth() >0 && fighter2.getCurrentHealth() > 0){
            if (fighter1.getDexterity() > fighter2.getDexterity()) {
                if (fighter1 instanceof PlayableCharacter) {
                    fighter1.attack(fighter1, fighter2, weaponSelection(fighter1));
                    fighter2.attack(fighter2, fighter1, 1);
                } else {
                    fighter1.attack(fighter1, fighter2, 1);
                    fighter2.attack(fighter2, fighter1, weaponSelection(fighter2));
                }
            }else if(fighter1.getDexterity() < fighter2.getDexterity()){
                if (fighter2 instanceof PlayableCharacter) {
                    fighter2.attack(fighter2, fighter1, weaponSelection(fighter2));
                    fighter1.attack(fighter1, fighter2, 1);
                } else {
                    fighter2.attack(fighter2, fighter1, 1);
                    fighter1.attack(fighter1, fighter2, weaponSelection(fighter1));
                }
            }
            System.out.println(fighter1.getName() + " hat " + fighter1.getCurrentHealth() +" Leben");
            System.out.println(fighter2.getName() +" hat " + fighter2.getCurrentHealth() + " Leben");
        }
    }

    public static int weaponSelection(Character character){
        System.out.println("Mit Welcher Waffe willst du Angreifen? [1] oder [2]");
        int selection = 0;
        boolean repeat = true;
        while (repeat) {
            try {
                System.out.println(character.getWeaponNames());
                Scanner scanner = new Scanner(System.in);
                selection = scanner.nextInt();
                if (selection >= 1 && selection <= 2) {
                    repeat = false;
                }
                else {
                    System.out.println("Bitte [1] oder [2] eingeben.");
                }
            } catch (Exception e) {
                System.out.println("Bitte [1] oder [2] eingeben.");
            }
        }
        return selection;
    }
}