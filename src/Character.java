public class Character {

    int life;
    int strength;
    int armourclass;
    int speed;
    int dexterity;
    int constitution;
    int intelligence;
    int wisdom;
    int charisma;
    int weapon;

    public Character(int life, int strength, int armourclass, int speed, int dexterity, int constitution, int intelligence, int wisdom, int charisma, int weapon){

        this.life = life;
        this.strength = strength;
        this.armourclass = armourclass;
        this.speed = speed;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
    }

    public int Roll_Dice(int dice) {
        int diceroll = (int)(Math.random() * (dice + 1));
        return diceroll;
    }

    public void Attack (Character attacker, Character defender){
        int attack = Roll_Dice(20) + attacker.strength;
        if (attack > defender.armourclass) {
            defender.life -= (int)(Math.random() * (attacker.weapon + 1));
        }
    }



}
