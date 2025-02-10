public class NonPlayableCharacter extends Character{
    private boolean hostile;
    public NonPlayableCharacter(int life, int strength, int armourclass, int speed, int dexterity, int constitution, int intelligence, int wisdom, int charisma, boolean hostile, Weapon weapon1, Weapon weapon2) {
        super(life, strength, armourclass, speed, dexterity, constitution, intelligence, wisdom, charisma, weapon1, weapon2);
        this.hostile = hostile;
    }



}
