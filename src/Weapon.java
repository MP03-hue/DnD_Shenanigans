public class Weapon {
    private int weaponDmg;
    private int weaponDice;
    private String weaponName;

    Weapon(String weaponType){
        switch (weaponType){
            case "Greataxe":
                this.weaponDice = 12;
                this.weaponDmg = 3;
                this.weaponName = "Greataxe";
                break;
            case "Javelin":
                this.weaponDice = 6;
                this.weaponDmg = 3;
                this.weaponName = "Javelin";
                break;
            case "Dagger":
                this.weaponDice = 4;
                this.weaponDmg = 1;
                this.weaponName = "Dagger";
                break;
            default:
                this.weaponDice = 12;
                this.weaponDmg = 0;
                this.weaponName = "barehanded";
        }
    }

    public int getWeaponDice() {
        return weaponDice;
    }

    public int getWeaponDmg() {
        return weaponDmg;
    }

    public String getWeaponName(){return weaponName;}
}
