import static java.lang.Thread.sleep;

public class test {
    private static String workingDir = System.getProperty("user.dir");

    public static void main(String args[]) throws InterruptedException {
        PennDraw.enableAnimation(999999999);
        PennDraw.setCanvasSize(1280, 720);
        while (true) {

            for(double i = 0; i < .48; i+=.05){
                PennDraw.picture(0.5, 0.5, workingDir + "\\BossBattle.png");
                PennDraw.picture(0.195 , .65, workingDir + "\\KnightJackson.png", 250, 250);
                PennDraw.picture(0.78 -i, .65, workingDir + "\\BossSlash.png", 400, 400);
                PennDraw.advance();
                sleep(43);
                if(i >= .40){
                    PennDraw.picture(0.5, 0.5, workingDir + "\\BossBattle.png");
                    PennDraw.picture(0.195 , .65, workingDir + "\\KnightJackson.png", 250, 250);
                    PennDraw.picture(.23,.65,workingDir+"\\purpleBoom.png");
                    PennDraw.advance();
                    break;
                }
            }
            break;


        }
    }
}
