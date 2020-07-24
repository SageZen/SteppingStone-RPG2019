import characters.AssassinJackson;
import characters.KnightJackson;
import characters.MageJackson;

public class Main {
    private static boolean game = true;
    private static String workingDir = System.getProperty("user.dir");
    private static double playButtonX = 0.5;
    private static double playButtonY = 0.58;
    private static boolean playButton = true;
    private static boolean chooseHero = false;
    private static boolean intoDUngeonAsKnight = false;
    private static boolean intoDUngeonAsMage = false;
    private static boolean intoDUngeonAsAssassin= false;


    public static void main(String[] args) throws InterruptedException {

        PennDraw.setCanvasSize(1280, 720);
        PennDraw.enableAnimation(30);
        KnightJackson knight = new KnightJackson();
        MageJackson mage = new MageJackson();
        AssassinJackson assassin = new AssassinJackson();

        while (game) {

            while (playButton) {
                PennDraw.picture(0.5, 0.5, workingDir + "\\TitleScreen.png", 1280, 720);
                //PennDraw.picture();
                PennDraw.advance();
                if (PennDraw.mousePressed()) {
                    System.out.println("X: " + PennDraw.mouseX() + " " + "Y: " + PennDraw.mouseY());
                    if ((PennDraw.mouseX() >= playButtonX - 0.13 && PennDraw.mouseX() <= playButtonX + 0.13) && (PennDraw.mouseY() >= playButtonY - 0.05 && PennDraw.mouseY() <= playButtonY + 0.05)) {
                        //System.out.println("hi");
                        chooseHero = true;
                        playButton = false;
                    }
                }
            }
            while(chooseHero){
                PennDraw.clear();
                PennDraw.picture(0.5,0.5, workingDir + "\\CharacterSelection2.png");
                PennDraw.advance();
                if (PennDraw.mousePressed()) {
                    System.out.println("X: " + PennDraw.mouseX() + " " + "Y: " + PennDraw.mouseY());

                    if ((PennDraw.mouseX() >= 0.18 - 0.13 && PennDraw.mouseX() <= 0.18 + 0.13) && (PennDraw.mouseY() >= .7 - 0.05 && PennDraw.mouseY() <= .7 + 0.05)) {
                        intoDUngeonAsKnight = true;
                        chooseHero = false;
                    } else if ((PennDraw.mouseX() >= 0.505 - 0.13 && PennDraw.mouseX() <= 0.505 + 0.13) && (PennDraw.mouseY() >= .7 - 0.05 && PennDraw.mouseY() <= .7 + 0.05)) {
                        intoDUngeonAsMage = true;
                        chooseHero = false;
                    }
//                    else if ((PennDraw.mouseX() >= 0.83 - 0.13 && PennDraw.mouseX() <= 0.83 + 0.13) && (PennDraw.mouseY() >= .7 - 0.05 && PennDraw.mouseY() <= .7 + 0.05)) {
//                        System.out.println("hi");
//                        intoDUngeonAsAssassin = true;
//                        chooseHero = false;
//                    }
                }

            }
            if (intoDUngeonAsKnight){
                KnightGameMode.knightGameMode();

            }
            while ((intoDUngeonAsMage)){

                MageGameMode.mageGameMode();
            }
            while ((intoDUngeonAsAssassin)){


            }
        }

    }
}
