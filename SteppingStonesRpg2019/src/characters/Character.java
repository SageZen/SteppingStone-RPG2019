package characters;

public abstract class Character {

    //Character info
    String name = "";

    //Stats
    int level = 1;
    int health = 100;
    int energy = 50;
    int exp = 10;

    int agility = 1;
    int power = 1;
    int defense = 1;
    int vitality = 1;

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