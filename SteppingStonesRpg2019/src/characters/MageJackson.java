package characters;

public class MageJackson extends Character{
    public MageJackson(){
        name = "Mage Jacskon";

        //Dependent Stats
        level = 1;
        health = 100;
        energy = 25;
        //Independent stats
        agility = 5;
        power = 10;
        defense = 1;
        vitality = 1;
        exp = 10;

    }
    public int getLevel(){return level;}
    public int getHealth(){return health;}
    public int getEnergy(){return energy;}
    public int getAgility(){return agility;}
    public int getStrength(){return power;}
    public int getDefense(){
        return defense;
    }
    public int getVitality(){return vitality;}
    public int getExp(){return exp;}

}
