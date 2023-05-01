public abstract class Attacker extends Unit {
    private int numAttacks;

    public Attacker(char symbol, String name, double health, double healthModifier, double damage,
                    double damageModifier, int luck, int xCor, int yCor, int movement,
                    int movementModifier, String teamColor, int numAttacks){
        super(symbol, name, health, healthModifier, damage, damageModifier, luck,
                xCor, yCor, movement, movementModifier, teamColor);
        this.numAttacks = numAttacks;
    }

    public int getNumAttacks(){return this.numAttacks;}
    public void setNumAttacks(int newNumAttacks){this.numAttacks = newNumAttacks;}
    public boolean validAttackPath(int rowAttacker, int colAttacker, int rowDefender, int colDefender){
        return true;//TK Later
    }

}
