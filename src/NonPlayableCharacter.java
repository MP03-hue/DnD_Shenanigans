public class NonPlayableCharacter extends Character{

    private boolean hostile;
    public NonPlayableCharacter(String name, int life, int strength, int armourclass, int speed, int dexterity, int constitution, int intelligence, int wisdom, int charisma, boolean hostile, String weapon1, String weapon2) {
        super(name, life, strength, armourclass, speed, dexterity, constitution, intelligence, wisdom, charisma, weapon1, weapon2);
        this.hostile = hostile;
    }

    public String evilLaugh(){
        return "Du hörst die böse Lache von Dr. Doofenshmirtz";
    }

    public boolean isHostile() {
        return hostile;
    }
}
