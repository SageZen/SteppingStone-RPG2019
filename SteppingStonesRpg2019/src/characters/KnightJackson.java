package characters;

public class KnightJackson extends Character {
    public KnightJackson() {
        name = "Knight Jackson";

        //Dependent Stats
        health = 500;
        //Independent Stats
        power = 25;

    }
    public int getHealth(){return health;}
}
