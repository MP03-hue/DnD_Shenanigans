import java.util.ArrayList;

public class Character implements IAngreifen {

    private String name;
    private int maxHealth;
    private int currentHealth;
    private int strength;
    private int armourClass;
    private int speed;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
    private ArrayList<Weapon> weapons = new ArrayList<>();

    public Character(String name, int life, int strength, int armourClass, int speed, int dexterity, int constitution, int intelligence, int wisdom, int charisma, String weapon1, String weapon2){
        this.name = name;
        this.maxHealth = life;
        this.currentHealth = life;
        this.strength = strength;
        this.armourClass = armourClass;
        this.speed = speed;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.weapons.add(new Weapon(weapon1));
        this.weapons.add(new Weapon(weapon2));
    }

    public int rollDice(int dice) {
        return (int)(Math.random() * (dice + 1));
    }

    public void attack(Character attacker, Character defender, int weapon){
        int attack = rollDice(20) + attacker.strength;
        if (attack > defender.armourClass) {
            defender.currentHealth = defender.getCurrentHealth() - (rollDice((attacker.weapons.get(weapon - 1)).getWeaponDice()) + attacker.weapons.get(weapon -1).getWeaponDmg());
            System.out.println(attacker.getName() + " hat " + defender.getName() + " getroffen!");
        }
        else {
            System.out.println(attacker.getName() + " hat verfehlt.");
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

    public int getCurrentHealth() {
        return currentHealth;
    }
    public int getMaxHealth(){
        return maxHealth;
    }

    public void setCurrentHealth(int new_health){
        this.currentHealth = new_health;
        if (this.currentHealth > this.maxHealth){
            this.currentHealth = maxHealth;
        }
    }
}
