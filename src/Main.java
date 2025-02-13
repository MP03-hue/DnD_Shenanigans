import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        CharakterCreation();

    }


    public static void CharakterCreation(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wähle deinen Charakter");
        System.out.println("Georg, Ralf, Olaf");
        PlayableCharacter playercharacter ;
        switch (scanner.nextLine()){
            case "Olaf":
                playercharacter = new PlayableCharacter("Olaf", 12, 3, 17, 30, -1, 2, 0, 1, 2, "Greataxe", "Javelin");
                break;
            default:
                playercharacter = new PlayableCharacter("Unbenannt", 0,0,0,0,0,0,0,0,0,"Dagger","Dagger");
        }


        System.out.println("Du hast dich für " + playercharacter.getName() + " entschieden");
    }

    public static void Fight(Character fighter1, Character fighter2){
        if (fighter1.getDexterity() > fighter2.getDexterity()) {
            if (fighter1 instanceof PlayableCharacter) {
                fighter1.Attack(fighter1, fighter2, WeaponSelection(fighter1));
                fighter2.Attack(fighter2, fighter1, 1);
            } else {
                fighter1.Attack(fighter1, fighter2, 1);
                fighter2.Attack(fighter2, fighter1, WeaponSelection(fighter2));
            }
        }else if(fighter1.getDexterity() < fighter2.getDexterity()){
            if (fighter2 instanceof PlayableCharacter) {
                fighter2.Attack(fighter2, fighter1, WeaponSelection(fighter2));
                fighter1.Attack(fighter1, fighter2, 1);
            } else {
                fighter2.Attack(fighter2, fighter1, 1);
                fighter1.Attack(fighter1, fighter2, WeaponSelection(fighter1));
            }
        }
    }
    public static int WeaponSelection(Character character){
        System.out.println("Mit Welcher Waffe willst du Angreifen? 1 oder 2");
        System.out.println(character.getWeaponNames());
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();

    }
}