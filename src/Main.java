import java.util.Scanner;

public class Main {
    Character character2;

    public static void main(String[] args) {
        CharakterCreation();

    }


    public static void CharakterCreation(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wähle deinen Charackter");
        System.out.println("Georg, Ralf, Olaf");
        PlayableCharacter character1 = new PlayableCharacter(scanner.nextLine());
        System.out.println("Du hast dich für " + character1.getName() + "entschieden");
    }

    public static void Fight(Character fighter1, Character fighter2){
        if (fighter1.getDexterity > fighter2.getDexterity) {
            if (fighter1 instanceof PlayableCharacter) {
                fighter1.Attack(fighter1, fighter2, WeaponSelection(fighter1));
                fighter2.Attack(fighter2, fighter1, fighter2.weapons.get(0));
            } else {
                fighter1.Attack(fighter1, fighter2, fighter1.weapons.get(0));
                fighter2.Attack(fighter2, fighter1, WeaponSelection(fighter2));
            }
        }else if(fighter1.getDexterity < fighter2.getDexterity){
            if (fighter2 instanceof PlayableCharacter) {
                fighter2.Attack(fighter2, fighter1, WeaponSelection(fighter2));
                fighter1.Attack(fighter1, fighter2, fighter1.weapons.get(0));
            } else {
                fighter2.Attack(fighter2, fighter1, fighter2.weapons.get(0));
                fighter1.Attack(fighter1, fighter2, WeaponSelection(fighter1));
            }
        }else
    }
    public static int WeaponSelection(Character character){
        System.out.println("Mit Welcher Waffe willst du Angreifen? 1 oder 2");
        System.out.println(character.getWeaponNames());
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();

    }
}