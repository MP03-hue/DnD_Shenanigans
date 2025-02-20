public enum Weapons {
    Gr ("Greataxe", 12),
    Ja ("Javelin", 6),
    Da ("Dagger", 4);

    private String label;
    private int  dice;

    private Weapons(String label, int dice){
        this.label = label;
        this.dice = dice;
    }
}
