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
            case "Javelin":
                this.weaponDice = 6;
                this.weaponDmg = 3;
                this.weaponName = "Javelin";
            case "Dagger":
                this.weaponDice = 4;
                this.weaponDmg = 1;
                this.weaponName = "Dagger";
        }
    }

    public int getWeaponDice() {
        return weaponDice;
    }

    public int getWeaponDmg() {
        return weaponDmg;
    }
}
