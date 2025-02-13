import java.util.ArrayList;

public class PlayableCharacter extends Character{

    public PlayableCharacter(String name, int life, int strength, int armourclass, int speed, int dexterity, int constitution, int intelligence, int wisdom, int charisma, String weapon1, String weapon2) {
         super(name, life, strength, armourclass, speed, dexterity, constitution, intelligence, wisdom, charisma, weapon1, weapon2);

    }

    public NonPlayableCharacter Encounter(ArrayList<NonPlayableCharacter> enemylist){
        NonPlayableCharacter enemy = enemylist.get((int)(Math.random() * (enemylist.size() + 1)));
        System.out.println(String.format("Du begegnest: ", enemy.getName()));

        return enemy;

    }

    public String winnersDance(){
        return "Es wird ein beindruckender Tanz des Sieges Ausgeführt";
    }


}
