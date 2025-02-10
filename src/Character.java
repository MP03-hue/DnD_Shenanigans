import java.util.ArrayList;

public class Character {

    private int life;
    private int strength;
    private int armourclass;
    private int speed;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
    private ArrayList<Weapon> weapons;

    public Character(int life, int strength, int armourclass, int speed, int dexterity, int constitution, int intelligence, int wisdom, int charisma, Weapon weapon1, Weapon weapon2){

        this.life = life;
        this.strength = strength;
        this.armourclass = armourclass;
        this.speed = speed;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.weapons.add(0,weapon1);
        this.weapons.add(1, weapon2);
    }

    public int Roll_Dice(int dice) {
        int diceroll = (int)(Math.random() * (dice + 1));
        return diceroll;
    }

    public void Attack (Character attacker, Character defender, int weapon){
        int attack = Roll_Dice(20) + attacker.strength;
        if (attack > defender.armourclass) {
            defender.life -= Roll_Dice(attacker.weapons.get(weapon).getWeaponDice()) + attacker.weapons.get(weapon).getWeaponDmg();
        }
    }
}
