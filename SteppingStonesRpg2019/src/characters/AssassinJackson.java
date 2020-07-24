package characters;

public class AssassinJackson extends Character{
    public AssassinJackson(){
        name = "Assassin Jackson";

        //Dependent Stats
           health = 200;

        //Independent Stats
        power = 50;


    }
    public int getLevel(){return level;}
    public int getHealth(){return health;}
    public int getStamina(){return energy;}
    public int getAgility(){return agility;}
    public int getStrength(){return power;}
    public int getDefense(){
        return defense;
    }
    public int getVitality(){return vitality;}
    public int getExp(){return exp;}
}
