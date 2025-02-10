public class NonPlayableCharacter extends Character{
    private boolean hostile;
    public NonPlayableCharacter(int life, int strength, int armourclass, int speed, int dexterity, int constitution, int intelligence, int wisdom, int charisma, boolean hostile) {
        super(life, strength, armourclass, speed, dexterity, constitution, intelligence, wisdom, charisma);
        this.hostile = hostile;
    }



}
