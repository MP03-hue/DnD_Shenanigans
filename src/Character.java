import java.util.ArrayList;

public class Character implements IAngreifen {

    private String name;
    private int max_health;
    private int current_health;
    private int strength;
    private int armourclass;
    private int speed;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
    private ArrayList<Weapon> weapons = new ArrayList<>();

    public Character(String name, int life, int strength, int armourclass, int speed, int dexterity, int constitution, int intelligence, int wisdom, int charisma, String weapon1, String weapon2){

        this.name = name;
        this.max_health = life;
        this.current_health = life;
        this.strength = strength;
        this.armourclass = armourclass;
        this.speed = speed;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.weapons.add(new Weapon(weapon1));
        this.weapons.add(new Weapon(weapon2));
    }

    public int Roll_Dice(int dice) {
        return (int)(Math.random() * (dice + 1));
    }

    public void Attack (Character attacker, Character defender, int weapon){
        int attack = Roll_Dice(20) + attacker.strength;
        if (attack > defender.armourclass) {
            defender.current_health = defender.getCurrent_health() - (Roll_Dice((attacker.weapons.get(weapon - 1)).getWeaponDice()) + attacker.weapons.get(weapon -1).getWeaponDmg());
            System.out.println(attacker.getName() + " hat " + defender.getName() + " getroffen!");
        }
        else {
            System.out.println("Verfehlt!");
        }
    }

    public String getWeaponNames() {
        return this.getWeapon(0).getWeaponName() + " oder " +  this.getWeapon(1).getWeaponName();
    }

    public String getName() {
        return name;
    }

    public int getDexterity() {
        return dexterity;
    }

    public Weapon getWeapon(int index) {
        return this.weapons.get(index);
    }

    public int getCurrent_health() {
        return current_health;
    }
    public int getMax_health(){
        return max_health;
    }

    public void setCurrent_health(int new_health){
        this.current_health = new_health;
    }
}
