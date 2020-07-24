import Mobs.BatJawn;
import Mobs.BossJackson;
import Mobs.GoblinJawn;
import characters.KnightJackson;

import java.time.*;

import static java.lang.Thread.interrupted;
import static java.lang.Thread.sleep;

@SuppressWarnings("Duplicates")

public class KnightGameMode {

    private static String workingDir = System.getProperty("user.dir");
    private static boolean startingMap = true;
    private static boolean goblinMap = false;
    private static boolean batMap = false;
    private static boolean bossMap = false;
    private static boolean exitMap = false;
    private static boolean wizardDialogue = false;
    private static String stage = "";
    private static String plrChoice = "";
    private static boolean part1 = true;
    private static boolean part2 = false;
    private static boolean part3 = false;
    private static boolean part4 = false;
    //Goblin booleans
    private static boolean goblinOneWin = false;
    private static boolean goblinTwoWin = false;
    private static boolean goblinThreeWin = false;
    private static int goblinwins = 0;
    private static boolean goblinFight = false;
    private static boolean defeatedGoblin = false;
    //Bat booleans
    private static boolean batOneWin = false;
    private static boolean batTwoWin = false;
    private static boolean batThreeWin = false;
    private static boolean batFight = false;
    private static int batWins = 0;
    private static boolean defeatedBat = false;
    //Boss booleans
    private static boolean bossWin = false;
    private static boolean bossFight = false;
    private static int bossWinPoints;
    //Portal room
    private static boolean portal = false;
    private static boolean defeatBoss = false;


    private static boolean gameModeBoolean = true;

    public static void knightGameMode() throws InterruptedException {

        KnightJackson jackson = new KnightJackson();
        int knightHp = jackson.getHealth();

        GoblinJawn goblin = new GoblinJawn();
        int goblinHp = goblin.getHealth();

        BatJawn bat = new BatJawn();
        int batHp = bat.getHealth();

        BossJackson boss = new BossJackson();
        int bossHp = boss.getHealth();

        double jacksonX = 0.2;
        double jacksonY = 0.6;
        PennDraw.enableAnimation(999999999);

        int choice = 2;

        while (gameModeBoolean) {

            while (startingMap) {
                stage = "\\startingMaprpg.png";
                PennDraw.clear();
                PennDraw.picture(0.5, 0.5, workingDir + stage);
                PennDraw.picture(jacksonX, jacksonY, workingDir + "\\KnightJackson.png", 150, 150);
                PennDraw.advance();


                if (PennDraw.mousePressed()) {
                    System.out.println("X: " + PennDraw.mouseX() + " " + "Y: " + PennDraw.mouseY());
                }
                if (jacksonX > .98) {
                    jacksonX = .05;
                    jacksonY = .387;
                    goblinMap = true;
                    startingMap = false;
                }
                if (jacksonX > .664 && jacksonY < .5) {
                    jacksonY = .5;
                }
                if (jacksonX > .664 && jacksonY > .75) {
                    jacksonY = .73;
                }
                if (jacksonY > 0.85) {
                    jacksonY = .849;
                } else if (jacksonY < .23) {
                    jacksonY = .23;
                }
                if (jacksonX < .105) {
                    jacksonX = .105;
                } else if (jacksonX > 0.6 && (jacksonY > .76 || jacksonY < .445)) {
                    jacksonX = .6;
                }

                if (PennDraw.hasNextKeyTyped()) {
                    char key = PennDraw.nextKeyTyped();

                    if (key == 'a') {
                        jacksonX -= 0.015;
                        makeMap(stage);
                        PennDraw.picture(jacksonX, jacksonY, workingDir + "\\KnightJackson.png", 150, 150);
                        PennDraw.advance();
                    }
                    if (key == 'd') {
                        jacksonX += 0.015;
                        makeMap(stage);
                        PennDraw.picture(jacksonX, jacksonY, workingDir + "\\KnightJackson.png", 150, 150);
                        PennDraw.advance();
                    }
                    if (key == 'w') {
                        jacksonY += 0.015;
                        makeMap(stage);
                        PennDraw.picture(jacksonX, jacksonY, workingDir + "\\KnightJackson.png", 150, 150);
                        PennDraw.advance();
                    }
                    if (key == 's') {
                        jacksonY -= 0.015;
                        makeMap(stage);
                        PennDraw.picture(jacksonX, jacksonY, workingDir + "\\KnightJackson.png", 150, 150);
                        PennDraw.advance();
                    }
                    if (((jacksonX > 0.45 && jacksonX < .63) && (jacksonY > .42 && jacksonY < .73)) && (startingMap && key == ' ')) {
                        wizardDialogue = true;
                        startingMap = false;
                    }
                }
            }

            while (goblinMap) {

                stage = "\\GoblinMap.png";


                PennDraw.clear();
                PennDraw.picture(0.5, 0.5, workingDir + stage);
                PennDraw.picture(jacksonX, jacksonY, workingDir + "\\KnightJackson.png", 150, 150);
                PennDraw.advance();

                if (PennDraw.mousePressed()) {
                    System.out.println("X: " + PennDraw.mouseX() + " " + "Y: " + PennDraw.mouseY());
                }

                if (PennDraw.hasNextKeyTyped()) {
                    char key = PennDraw.nextKeyTyped();


                    if (goblinOneWin && goblinTwoWin && goblinThreeWin) {
                        if (jacksonX > .988) {
                            jacksonX = .036;
                            jacksonY = .42;
                            goblinMap = false;
                            batMap = true;
                        }
                    }

                        if (jacksonX > .999 && jacksonX > .987 &&(!(goblinOneWin && goblinTwoWin && goblinThreeWin))) {
                        jacksonX = .985;
                    }

                    if (jacksonX < .05 && goblinMap) {
                        jacksonX = .88;
                        jacksonY = .59;
                        startingMap = true;
                        goblinMap = false;
                        batMap = false;
                    }

                    if (jacksonX > .8 && jacksonY > .55) {
                        jacksonY = .55;
                    }
                    if (jacksonX > .8 && jacksonY < .3) {
                        jacksonY = .3;
                    }

                    if ((jacksonX > 0.75 && jacksonX < .8) && (jacksonY > .57 || jacksonY < .26)) {
                        jacksonX = .75;

                    }


                    if (jacksonX < 0.178 && jacksonY < .285) {
                        jacksonY = .285;
                    }
                    if (jacksonX < .178 && jacksonY > .548)
                        jacksonY = .548;

                    if (jacksonY > .85) {
                        jacksonY = .85;
                    }
                    if (jacksonY < .2)
                        jacksonY = .199;

                    if ((jacksonX < .214 && jacksonX > .178) && (jacksonY > .55 || jacksonY < .26)) {
                        jacksonX = .217;
                    }

                    if ((jacksonX > 0.37 && jacksonX < 0.63) && jacksonY < 0.7) {
                        if (jacksonX > .37 && jacksonX < .59) {
                            jacksonX = .37;
                        } else if (jacksonX < .63) {
                            jacksonX = .63;
                        }
                    }


                    if (key == 'a') {
                        jacksonX -= 0.015;
                        makeMap(stage);
                        PennDraw.picture(jacksonX, jacksonY, workingDir + "\\KnightJackson.png", 150, 150);
                        PennDraw.advance();
                    }

                    if (key == 'd') {
                        jacksonX += 0.015;
                        makeMap(stage);
                        PennDraw.picture(jacksonX, jacksonY, workingDir + "\\KnightJackson.png", 150, 150);
                        PennDraw.advance();
                    }
                    if (key == 'w') {
                        jacksonY += 0.015;
                        makeMap(stage);
                        PennDraw.picture(jacksonX, jacksonY, workingDir + "\\KnightJackson.png", 150, 150);
                        PennDraw.advance();
                    }
                    if (key == 's') {
                        jacksonY -= 0.015;
                        makeMap(stage);
                        PennDraw.picture(jacksonX, jacksonY, workingDir + "\\KnightJackson.png", 150, 150);
                        PennDraw.advance();
                    }

                    //Encountering goblins
                    if (((jacksonX > .25 && jacksonX < .34) && (jacksonY > .31 && jacksonY < .54)) && (goblinMap && key == ' ') && (goblinOneWin == false)) {
                        goblinFight = true;
                        goblinMap = false;
                    }
                    if (((jacksonX > .42 && jacksonX < .54) && (jacksonY > .62 && jacksonY < .83)) && (goblinMap && key == ' ') && (goblinTwoWin == false && goblinOneWin)) {
                        goblinFight = true;
                        goblinMap = false;
                    }
                    if (((jacksonX > .61 && jacksonX < .73) && (jacksonY > .34 && jacksonY < .56)) && (goblinMap && key == ' ') && (goblinThreeWin == false) && (goblinOneWin && goblinTwoWin)) {
                        goblinFight = true;
                        goblinMap = false;
                    }

                }
            }
            while (batMap) {

                stage = "\\BatMap.png";


                PennDraw.clear();
                PennDraw.picture(0.5, 0.5, workingDir + stage);
                PennDraw.picture(jacksonX, jacksonY, workingDir + "\\KnightJackson.png", 150, 150);
                PennDraw.advance();

                if (PennDraw.mousePressed()) {
                    System.out.println("X: " + PennDraw.mouseX() + " " + "Y: " + PennDraw.mouseY());
                }

                if (PennDraw.hasNextKeyTyped()) {
                    char key = PennDraw.nextKeyTyped();


                    if (batOneWin && batTwoWin && batThreeWin) {
                        if (jacksonX > .988) {
                            jacksonX = .036;
                            jacksonY = .42;
                            bossMap = true;
                            batMap = false;
                        }
                    }

                    if(jacksonX > .988&&(!(batOneWin && batTwoWin && batThreeWin))){
                    jacksonX = .988;
                    }
                    if (jacksonX < .05 && (batMap)) {
                        jacksonX = .88;
                        jacksonY = .45;
                        goblinMap = true;
                        startingMap = false;
                        batMap = false;
                    }
                    // restrictions Inside the smalller pathways
                    if (jacksonX < .16 && jacksonY > .58) {
                        jacksonY = .58;
                    }
                    if (jacksonX < .16 && jacksonY < .31) {
                        jacksonY = .31;
                    }

                    if (jacksonX > .78 && jacksonY > .58) {
                        jacksonY = .58;
                    }
                    if (jacksonX > .78 && jacksonY < .32) {
                        jacksonY = .31;
                    }

                    //Highest and losest in Y direction
                    if (jacksonY < .161) {
                        jacksonY = .161;
                    }
                    if (jacksonY > .73) {
                        jacksonY = .73;
                    }

                    //High and lowest in X direction
                    if ((jacksonX > 0.19 && jacksonX < .22) && (jacksonY > .59 || jacksonY < .29)) {
                        jacksonX = .22;
                    }

                    if ((jacksonX > 0.77 && jacksonX < .78) && (jacksonY > .59 || jacksonY < .29)) {
                        jacksonX = .77;
                    }


                    if (key == 'a') {
                        jacksonX -= 0.015;
                        makeMap(stage);
                        PennDraw.picture(jacksonX, jacksonY, workingDir + "\\KnightJackson.png", 150, 150);
                        PennDraw.advance();
                    }

                    if (key == 'd') {
                        jacksonX += 0.015;
                        makeMap(stage);
                        PennDraw.picture(jacksonX, jacksonY, workingDir + "\\KnightJackson.png", 150, 150);
                        PennDraw.advance();
                    }
                    if (key == 'w') {
                        jacksonY += 0.015;
                        makeMap(stage);
                        PennDraw.picture(jacksonX, jacksonY, workingDir + "\\KnightJackson.png", 150, 150);
                        PennDraw.advance();
                    }
                    if (key == 's') {
                        jacksonY -= 0.015;
                        makeMap(stage);
                        PennDraw.picture(jacksonX, jacksonY, workingDir + "\\KnightJackson.png", 150, 150);
                        PennDraw.advance();
                    }

                    //Encountering bats
                    if (((jacksonX > .26 && jacksonX < .45) && (jacksonY > .32 && jacksonY < .62)) && (batMap && key == ' ') && (batOneWin == false)) {
                        System.out.println("Hi");
                        batFight = true;
                        batMap = false;
                    }
                    if (((jacksonX > .56 && jacksonX < .75) && (jacksonY > .48 && jacksonY < .76)) && (batMap && key == ' ') && (batTwoWin == false && batOneWin)) {
                        batFight = true;
                        batMap = false;
                    }
                    if (((jacksonX > .56 && jacksonX < .75) && (jacksonY > .13 && jacksonY < .39)) && (batMap && key == ' ') && (batThreeWin == false) && (batTwoWin && batOneWin)) {
                        batFight = true;
                        batMap = false;
                    }

                }
            }
            while (bossMap) {
                stage = "\\FinalBossRoom.png";


                PennDraw.clear();
                PennDraw.picture(0.5, 0.5, workingDir + stage);
                PennDraw.picture(jacksonX, jacksonY, workingDir + "\\KnightJackson.png", 150, 150);
                PennDraw.advance();

                if (PennDraw.mousePressed()) {
                    System.out.println("X: " + PennDraw.mouseX() + " " + "Y: " + PennDraw.mouseY());
                }

                if (PennDraw.hasNextKeyTyped()) {
                    char key = PennDraw.nextKeyTyped();

                    if (bossWin) {
                        if (jacksonX > .988) {
                            jacksonX = .036;
                            jacksonY = .5;
                            exitMap = true;
                            bossMap = false;

                        }
                    } else {
                        jacksonX = .989;

                    }
                    if (jacksonX < .05 && (bossMap)) {
                        jacksonX = .88;
                        jacksonY = .5;
                        batMap = true;
                        goblinMap = false;
                        startingMap = false;
                        bossMap = false;
                    }
                    // restrictions Inside the smalller pathways
                    if (jacksonX < .16 && jacksonY > .58) {
                        jacksonY = .58;
                    }
                    if (jacksonX < .16 && jacksonY < .31) {
                        jacksonY = .31;
                    }

                    if (jacksonX > .78 && jacksonY > .58) {
                        jacksonY = .58;
                    }
                    if (jacksonX > .78 && jacksonY < .32) {
                        jacksonY = .31;
                    }

                    //Highest and losest in Y direction
                    if (jacksonY < .161) {
                        jacksonY = .161;
                    }
                    if (jacksonY > .73) {
                        jacksonY = .73;
                    }

                    //High and lowest in X direction
                    if ((jacksonX > 0.19 && jacksonX < .22) && (jacksonY > .59 || jacksonY < .29)) {
                        jacksonX = .22;
                    }

                    if ((jacksonX > 0.77 && jacksonX < .78) && (jacksonY > .59 || jacksonY < .29)) {
                        jacksonX = .77;
                    }


                    if (key == 'a') {
                        jacksonX -= 0.015;
                        makeMap(stage);
                        PennDraw.picture(jacksonX, jacksonY, workingDir + "\\KnightJackson.png", 150, 150);
                        PennDraw.advance();
                    }

                    if (key == 'd') {
                        jacksonX += 0.015;
                        makeMap(stage);
                        PennDraw.picture(jacksonX, jacksonY, workingDir + "\\KnightJackson.png", 150, 150);
                        PennDraw.advance();
                    }
                    if (key == 'w') {
                        jacksonY += 0.015;
                        makeMap(stage);
                        PennDraw.picture(jacksonX, jacksonY, workingDir + "\\KnightJackson.png", 150, 150);
                        PennDraw.advance();
                    }
                    if (key == 's') {
                        jacksonY -= 0.015;
                        makeMap(stage);
                        PennDraw.picture(jacksonX, jacksonY, workingDir + "\\KnightJackson.png", 150, 150);
                        PennDraw.advance();
                    }

                    //Encountering the boss
                    if ((jacksonX > .58 && jacksonX < 74) && (jacksonY > .24 && jacksonY < .65) && (bossMap && key == ' ') && (bossWin == false)) {
                        bossFight = true;
                        bossMap = false;
                    }
                }
            }
            while (exitMap) {

                stage = "\\exitROom.png";

                PennDraw.clear();
                PennDraw.picture(0.5, 0.5, workingDir + stage);
                PennDraw.picture(jacksonX, jacksonY, workingDir + "\\KnightJackson.png", 150, 150);
                PennDraw.advance();

                if (PennDraw.mousePressed()) {
                    System.out.println("X: " + PennDraw.mouseX() + " " + "Y: " + PennDraw.mouseY());
                }

                if (PennDraw.hasNextKeyTyped()) {
                    char key = PennDraw.nextKeyTyped();


                    if (jacksonX < .05 && (exitMap)) {
                        jacksonX = .88;
                        jacksonY = .5;
                        bossMap = true;
                        exitMap = false;
                        batMap = false;
                        goblinMap = false;
                        startingMap = false;
                    }

                    // restrictions Inside the smalller pathways
                    if (jacksonX < .44 && jacksonY > .608) {
                        jacksonY = .608;
                    }
                    if (jacksonX < .44 && jacksonY < .33) {
                        jacksonY = .33;
                    }

                    //Highest and losest in Y direction
                    if (jacksonY < .176) {
                        jacksonY = .176;
                    }
                    if (jacksonY > .78) {
                        jacksonY = .78;
                    }

                    //High and lowest in X direction
                    if ((jacksonX > 0.45 && jacksonX < .45) && (jacksonY > .626 || jacksonY < .33)) {
                        jacksonX = .45;
                    }

                    if (jacksonX > .84) {
                        jacksonX = .84;
                    }


                    if (key == 'a') {
                        jacksonX -= 0.015;
                        makeMap(stage);
                        PennDraw.picture(jacksonX, jacksonY, workingDir + "\\KnightJackson.png", 150, 150);
                        PennDraw.advance();
                    }

                    if (key == 'd') {
                        jacksonX += 0.015;
                        makeMap(stage);
                        PennDraw.picture(jacksonX, jacksonY, workingDir + "\\KnightJackson.png", 150, 150);
                        PennDraw.advance();
                    }
                    if (key == 'w') {
                        jacksonY += 0.015;
                        makeMap(stage);
                        PennDraw.picture(jacksonX, jacksonY, workingDir + "\\KnightJackson.png", 150, 150);
                        PennDraw.advance();
                    }
                    if (key == 's') {
                        jacksonY -= 0.015;
                        makeMap(stage);
                        PennDraw.picture(jacksonX, jacksonY, workingDir + "\\KnightJackson.png", 150, 150);
                        PennDraw.advance();
                    }

                    if (((jacksonX > .59 && jacksonX < .75) && (jacksonY < 66 && jacksonY > .33)) && (exitMap && key == ' ')) {
                        youWin();
                        gameModeBoolean = false;
                        break;
                    }
                }
            }
            while (wizardDialogue) {

                if (part1) {
                    makeMap("//WizardConvoP1.png");

                    if (PennDraw.hasNextKeyTyped()) {
                        char key = PennDraw.nextKeyTyped();
                        if (key == ' ') {
                            part2 = true;
                            part1 = false;
                            System.out.println("bye");
                        }
                    }
                }
                if (part2) {
                    makeMap("//WizardConvoP2.png");

                    if (PennDraw.hasNextKeyTyped()) {
                        char key = PennDraw.nextKeyTyped();
                        if (key == ' ') {
                            part3 = true;
                            part2 = false;
                        }
                    }
                }
                if (part3) {
                    makeMap("//WizardConvoP3.png");
                    if (PennDraw.hasNextKeyTyped()) {
                        char key = PennDraw.nextKeyTyped();
                        if (key == ' ') {
                            part4 = true;
                            part3 = false;
                        }
                    }
                }
                if (part4) {
                    makeMap("//WizarConvoP4.png");
                    if (PennDraw.hasNextKeyTyped()) {
                        char key = PennDraw.nextKeyTyped();
                        if (key == ' ') {
                            startingMap = true;
                            part1 = true;
                            part4 = false;
                            wizardDialogue = false;

                        }
                    }
                }
            }
            while (goblinFight) {

                boolean wrath = false;
                boolean start = true;
                PennDraw.clear();
                PennDraw.picture(0.5, .5, workingDir + "\\KnightGoblinFight2.png");
                PennDraw.picture(0.143, .69, workingDir + "\\KnightJackson.png", 250, 250);
                PennDraw.advance();
                int turn = 1;
                knightHp = 300;
                goblinHp = 200;

                while (start) {

                    if (goblinHp <= 0) {
                        PennDraw.setFontSize(64);
                        PennDraw.setFontBold();
                        PennDraw.text(0.5, 0.5, "YOU WON");
                        PennDraw.advance();
                        sleep(1500);
                        defeatedGoblin = true;
                        break;
                    } else if (knightHp <= 0) {
                        PennDraw.setFontSize(64);
                        PennDraw.setFontBold();
                        PennDraw.text(0.5, 0.5, "YOU LOST");
                        PennDraw.advance();
                        sleep(1500);
                        goblinMap = true;
                        goblinFight = false;
                        defeatedGoblin = false;
                        start = false;
                    }
                    PennDraw.setFontSize(36);
                    PennDraw.text(.175, .4, "Knight Health: " + knightHp);
                    PennDraw.text(.79, .4, "Goblin Health: " + goblinHp);
                    PennDraw.advance();

                    if (turn % 2 == 1) {
                        if (PennDraw.hasNextKeyTyped()) {
                            char key = PennDraw.nextKeyTyped();

                            if (key == '1') {
                                double chance = Math.random() * 10;
                                if (chance > 3) {
                                    for (double i = 0; i <= .6; i += 0.025) {
                                        PennDraw.clear();
                                        PennDraw.picture(0.5, .5, workingDir + "\\KnightGoblinFight2.png");
                                        PennDraw.picture(0.143 + i, .69, workingDir + "\\KnightJackson.png", 250, 250);
                                        if (i > .525) {
                                            PennDraw.picture(.8, .65, workingDir + "\\SwordStrike.png", 200, 250);
                                        }
                                        PennDraw.advance();
                                        sleep(43);
                                    }
                                    sleep(250);
                                    PennDraw.picture(.8, .65, workingDir + "\\SwordStrike.png", 200, 250);
                                    if (wrath) {
                                        goblinHp -= 60;
                                    } else {
                                        goblinHp -= 200;
                                    }
                                    turn++;
                                    continue;
                                } else {
                                    PennDraw.setFontSize(128);
                                    PennDraw.text(.5, .5, "MISSED");
                                    PennDraw.advance();
                                    turn++;
                                    continue;
                                }

                            }
                            if (key == '2') {
                                double chance = Math.random() * 10;
                                if (chance > 0) {
                                    for (double i = 0; i <= .6; i += 0.025) {
                                        PennDraw.clear();
                                        PennDraw.picture(0.5, .5, workingDir + "\\KnightGoblinFight2.png");
                                        PennDraw.picture(0.143 + i, .69, workingDir + "\\ShieldBash.png", 400, 350);
                                        //if (i > .525) {
                                        //PennDraw.picture(.8, .65, workingDir + "\\SwordStrike.png", 200, 250);
                                        //}
                                        PennDraw.advance();
                                        sleep(43);
                                    }
                                    if (wrath) {
                                        goblinHp -= 50;
                                        knightHp += 25;
                                    } else {
                                        goblinHp -= 25;
                                        knightHp += 25;
                                    }
                                    turn++;
                                    continue;
                                } else {
                                    PennDraw.setFontSize(128);
                                    PennDraw.text(.5, .5, "MISSED");
                                    PennDraw.advance();
                                    turn++;
                                    continue;
                                }

                            }

                            if (key == '3') {
                                if (knightHp <= 150) {
                                    for (double i = 0; i <= .6; i += 0.05) {
                                        PennDraw.clear();
                                        PennDraw.picture(0.5, .5, workingDir + "\\KnightGoblinFight2.png");
                                        PennDraw.picture(0.16, .8, workingDir + "\\Wrath1.png", 500, 450);
                                        PennDraw.advance();
                                        sleep(22);
                                        PennDraw.picture(0.16, .8, workingDir + "\\Wrath2png.png", 500, 450);
                                        PennDraw.advance();
                                        sleep(22);
                                    }
                                    wrath = true;
                                    turn++;
                                    continue;
                                } else {
                                    PennDraw.setFontSize(64);
                                    PennDraw.text(.5, .5, "MUST BE AT HALF HP");
                                    PennDraw.advance();
                                    turn++;
                                    continue;
                                }
                            }
                            if (key == '4') {
                                if (turn > 8 || wrath) {
                                    for (double i = 0; i <= .555; i += 0.075) {
                                        PennDraw.clear();
                                        PennDraw.picture(0.5, .5, workingDir + "\\KnightGoblinFight2.png");

                                        PennDraw.picture(0.16 + i, .8, workingDir + "\\Wrath1.png", 500, 450);
                                        PennDraw.advance();
                                        sleep(50);
                                        PennDraw.picture(0.16 + i, .8, workingDir + "\\Wrath2png.png", 500, 450);
                                        PennDraw.advance();
                                        if (i >= .5) {
                                            PennDraw.picture(.8, .65, workingDir + "\\SwordStrike.png", 200, 250);
                                            sleep(100);
                                            PennDraw.advance();
                                            PennDraw.picture(.8, .65, workingDir + "\\SwordStrike.png", 200, 250, 30);
                                            sleep(100);
                                            PennDraw.advance();
                                            PennDraw.picture(.8, .65, workingDir + "\\SwordStrike.png", 200, 250, 90);
                                            sleep(100);
                                            PennDraw.advance();
                                            PennDraw.picture(.8, .65, workingDir + "\\SwordStrike.png", 200, 250, 330);
                                            sleep(100);
                                            PennDraw.advance();
                                            PennDraw.picture(.8, .65, workingDir + "\\SwordStrike.png", 200, 250, 270);
                                            sleep(100);
                                            PennDraw.advance();
                                        }
                                        sleep(35);
                                        PennDraw.advance();
                                    }
                                    goblinHp -= 110;
                                    turn++;
                                    continue;
                                } else {
                                    PennDraw.setFontSize(64);
                                    PennDraw.text(.5, .5, "WRATH MUST BE USED ");
                                    PennDraw.advance();
                                    turn++;
                                    continue;
                                }
                            }
                        }
                    } else if (turn % 2 == 0) {
                        double goblinAttk = Math.random() * 10;

                        if (goblinAttk > 4) {
                            sleep(300);
                            makeMap("\\GoblinStrike1.png");
                            sleep(100);
                            makeMap("\\GoblinStrike2.png");
                            sleep(1000);
                            makeMap("\\GoblinStrike1.png");
                            knightHp -= getRandomIntegerBetweenRange(35, 55);
                            turn++;
                            continue;
                        } else {
                            sleep(400);
                            makeMap("\\GoblinStrike1.png");
                            PennDraw.setFontSize(128);
                            PennDraw.text(.5, .5, "MISSED");
                            PennDraw.advance();
                            sleep(1000);
                            makeMap("\\GoblinStrike1.png");
                            PennDraw.advance();
                            turn++;
                            continue;
                        }
                    }
                }
                if (defeatedGoblin == true) {
                    goblinwins++;
                }
                if (goblinwins == 1) {
                    goblinOneWin = true;
                } else if (goblinwins == 2) {
                    goblinTwoWin = true;
                } else if (goblinwins >= 3) {
                    goblinThreeWin = true;
                }
                goblinMap = true;
                goblinFight = false;

            }
            /////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////

            while (batFight) {

                boolean wrath = false;
                boolean start = true;
                PennDraw.clear();
                PennDraw.picture(0.5, .5, workingDir + "\\BatBattle.png");
                PennDraw.picture(0.143, .69, workingDir + "\\KnightJackson.png", 250, 250);
                PennDraw.advance();
                int turn = 1;
                knightHp = 400;
                batHp = 300;

                while (start) {

                    if (batHp <= 0) {
                        PennDraw.setFontSize(64);
                        PennDraw.setFontBold();
                        PennDraw.text(0.5, 0.5, "YOU WON");
                        PennDraw.advance();
                        sleep(1500);
                        defeatedBat = true;
                        break;
                    } else if (knightHp <= 0) {
                        PennDraw.setFontSize(64);
                        PennDraw.setFontBold();
                        PennDraw.text(0.5, 0.5, "YOU LOST");
                        PennDraw.advance();
                        sleep(1500);
                        batMap = true;
                        batFight = false;
                        defeatedBat = false;
                        start = false;
                    }
                    PennDraw.setFontSize(36);
                    PennDraw.text(.175, .4, "Knight Health: " + knightHp);
                    PennDraw.text(.79, .4, "Bat Health: " + batHp);
                    PennDraw.advance();

                    if (turn % 2 == 1) {
                        if (PennDraw.hasNextKeyTyped()) {
                            char key = PennDraw.nextKeyTyped();

                            if (key == '1') {
                                double chance = Math.random() * 10;
                                if (chance > 3) {
                                    for (double i = 0; i <= .6; i += 0.025) {
                                        PennDraw.clear();
                                        PennDraw.picture(0.5, .5, workingDir + "\\BatBattle.png");
                                        PennDraw.picture(0.143 + i, .69, workingDir + "\\KnightJackson.png", 250, 250);
                                        if (i > .525) {
                                            PennDraw.picture(.8, .65, workingDir + "\\SwordStrike.png", 200, 250);
                                        }
                                        PennDraw.advance();
                                        sleep(43);
                                    }
                                    sleep(250);
                                    PennDraw.picture(.8, .65, workingDir + "\\SwordStrike.png", 200, 250);
                                    if (wrath) {
                                        batHp -= getRandomIntegerBetweenRange(80, 120);
                                    } else {
                                        batHp -= getRandomIntegerBetweenRange(40, 60);
                                    }
                                    turn++;
                                    continue;
                                } else {
                                    PennDraw.setFontSize(128);
                                    PennDraw.text(.5, .5, "MISSED");
                                    PennDraw.advance();
                                    turn++;
                                    continue;
                                }

                            }
                            if (key == '2') {
                                double chance = Math.random() * 10;
                                if (chance > 0) {
                                    for (double i = 0; i <= .6; i += 0.025) {
                                        PennDraw.clear();
                                        PennDraw.picture(0.5, .5, workingDir + "\\BatBattle.png");
                                        PennDraw.picture(0.143 + i, .69, workingDir + "\\ShieldBash.png", 400, 350);
                                        //if (i > .525) {
                                        //PennDraw.picture(.8, .65, workingDir + "\\SwordStrike.png", 200, 250);
                                        //}
                                        PennDraw.advance();
                                        sleep(43);
                                    }
                                    if (wrath) {
                                        batHp -= getRandomIntegerBetweenRange(60, 100);
                                        knightHp += getRandomIntegerBetweenRange(60, 100);
                                    } else {
                                        batHp -= getRandomIntegerBetweenRange(30, 50);
                                        knightHp += getRandomIntegerBetweenRange(30, 50);
                                    }
                                    turn++;
                                    continue;
                                } else {
                                    PennDraw.setFontSize(128);
                                    PennDraw.text(.5, .5, "MISSED");
                                    sleep(500);
                                    PennDraw.advance();
                                    turn++;
                                    continue;
                                }

                            }

                            if (key == '3') {
                                if (knightHp <= 200) {
                                    for (double i = 0; i <= .6; i += 0.05) {
                                        PennDraw.clear();
                                        PennDraw.picture(0.5, .5, workingDir + "\\BatBattle.png");
                                        PennDraw.picture(0.16, .8, workingDir + "\\Wrath1.png", 500, 450);
                                        PennDraw.advance();
                                        sleep(22);
                                        PennDraw.picture(0.16, .8, workingDir + "\\Wrath2png.png", 500, 450);
                                        PennDraw.advance();
                                        sleep(22);
                                    }
                                    wrath = true;
                                    turn++;
                                    continue;
                                } else {
                                    PennDraw.setFontSize(64);
                                    PennDraw.text(.5, .5, "MUST BE AT HALF HP");
                                    PennDraw.advance();
                                    turn++;
                                    continue;
                                }
                            }
                            if (key == '4') {
                                if (wrath || turn >= 10) {
                                    for (double i = 0; i <= .555; i += 0.075) {
                                        PennDraw.clear();
                                        PennDraw.picture(0.5, .5, workingDir + "\\BatBattle.png");

                                        PennDraw.picture(0.16 + i, .8, workingDir + "\\Wrath1.png", 500, 450);
                                        PennDraw.advance();
                                        sleep(50);
                                        PennDraw.picture(0.16 + i, .8, workingDir + "\\Wrath2png.png", 500, 450);
                                        PennDraw.advance();
                                        if (i >= .5) {
                                            PennDraw.picture(.8, .65, workingDir + "\\SwordStrike.png", 200, 250);
                                            sleep(100);
                                            PennDraw.advance();
                                            PennDraw.picture(.8, .65, workingDir + "\\SwordStrike.png", 200, 250, 30);
                                            sleep(100);
                                            PennDraw.advance();
                                            PennDraw.picture(.8, .65, workingDir + "\\SwordStrike.png", 200, 250, 90);
                                            sleep(100);
                                            PennDraw.advance();
                                            PennDraw.picture(.8, .65, workingDir + "\\SwordStrike.png", 200, 250, 330);
                                            sleep(100);
                                            PennDraw.advance();
                                            PennDraw.picture(.8, .65, workingDir + "\\SwordStrike.png", 200, 250, 270);
                                            sleep(100);
                                            PennDraw.advance();
                                        }
                                        sleep(35);
                                        PennDraw.advance();
                                    }
                                    batHp -= 200;
                                    turn++;
                                    continue;
                                } else {
                                    PennDraw.setFontSize(64);
                                    PennDraw.text(.5, .5, "REQUIREMENTS NOT MET");
                                    PennDraw.advance();
                                    turn++;
                                    continue;
                                }
                            }
                        }
                    } else if (turn % 2 == 0) {
                        double batAttk = Math.random() * 10;

                        if (batAttk > 0) {
                            sleep(300);

                            sonicAttack();

                            makeMap("\\BatBattle.png");
                            PennDraw.advance();
                            PennDraw.picture(0.143, .69, workingDir + "\\KnightJackson.png", 250, 250);
                            PennDraw.advance();
                            knightHp -= getRandomIntegerBetweenRange(55, 100);
                            turn++;
                            continue;
                        } else {
                            sleep(400);
                            PennDraw.picture(0.143, .69, workingDir + "\\KnightJackson.png", 250, 250);
                            makeMap("\\BatBattle.png");
                            PennDraw.setFontSize(128);
                            PennDraw.text(.5, .5, "MISSED");
                            PennDraw.advance();
                            sleep(1000);
                            PennDraw.picture(0.143, .69, workingDir + "\\KnightJackson.png", 250, 250);
                            makeMap("\\BatBattle.png");
                            PennDraw.advance();
                            turn++;
                            continue;
                        }
                    }
                }
                if (defeatedBat == true) {
                    batWins++;
                }
                if (batWins == 1) {
                    batOneWin = true;
                } else if (batWins == 2) {
                    batTwoWin = true;
                } else if (batWins >= 3) {
                    batThreeWin = true;
                }
                batMap = true;
                batFight = false;

            }

            /////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////

            while (bossFight) {

                boolean wrath = false;
                boolean start = true;
                PennDraw.clear();
                PennDraw.picture(0.5, .5, workingDir + "\\BossBattle.png");
                PennDraw.picture(0.143, .69, workingDir + "\\KnightJackson.png", 250, 250);
                PennDraw.advance();
                int turn = 1;
                knightHp = 500;
                bossHp = 750;

                while (start) {

                    if (bossHp <= 0) {
                        PennDraw.setFontSize(64);
                        PennDraw.setFontBold();
                        PennDraw.text(0.5, 0.5, "YOU WON");
                        PennDraw.advance();
                        sleep(1500);
                        defeatBoss = true;
                        break;
                    } else if (knightHp <= 0) {
                        PennDraw.setFontSize(64);
                        PennDraw.setFontBold();
                        PennDraw.text(0.5, 0.5, "YOU LOST");
                        PennDraw.advance();
                        sleep(1500);
                        bossMap = true;
                        bossFight = false;
                        defeatBoss = false;
                        start = false;
                    }
                    PennDraw.setFontSize(36);
                    PennDraw.text(.175, .28, "Knight Health: " + knightHp);
                    PennDraw.text(.79, .28, "Boss Health: " + bossHp);
                    PennDraw.advance();

                    if (turn % 2 == 1) {
                        if (PennDraw.hasNextKeyTyped()) {
                            char key = PennDraw.nextKeyTyped();

                            if (key == '1') {
                                double chance = Math.random() * 10;
                                if (chance > 3) {
                                    for (double i = 0; i <= .6; i += 0.025) {
                                        PennDraw.clear();
                                        PennDraw.picture(0.5, .5, workingDir + "\\BossBattle.png");
                                        PennDraw.picture(0.143 + i, .69, workingDir + "\\KnightJackson.png", 250, 250);
                                        if (i > .525) {
                                            PennDraw.picture(.8, .65, workingDir + "\\SwordStrike.png", 200, 250);
                                        }
                                        PennDraw.advance();
                                        sleep(43);
                                    }
                                    sleep(250);
                                    PennDraw.picture(.8, .65, workingDir + "\\SwordStrike.png", 200, 250);
                                    if (wrath) {
                                        batHp -= getRandomIntegerBetweenRange(110, 150);
                                    } else {
                                        bossHp -= getRandomIntegerBetweenRange(55, 75);
                                    }
                                    turn++;
                                    continue;
                                } else {
                                    PennDraw.setFontSize(128);
                                    PennDraw.text(.5, .5, "MISSED");
                                    PennDraw.advance();
                                    turn++;
                                    continue;
                                }

                            }
                            if (key == '2') {
                                double chance = Math.random() * 10;
                                if (chance > 0) {
                                    for (double i = 0; i <= .6; i += 0.025) {
                                        PennDraw.clear();
                                        PennDraw.picture(0.5, .5, workingDir + "\\BossBattle.png");
                                        PennDraw.picture(0.143 + i, .69, workingDir + "\\ShieldBash.png", 400, 350);
                                        //if (i > .525) {
                                        //PennDraw.picture(.8, .65, workingDir + "\\SwordStrike.png", 200, 250);
                                        //}
                                        PennDraw.advance();
                                        sleep(43);
                                    }
                                    if (wrath) {
                                        bossHp -= getRandomIntegerBetweenRange(90, 120);
                                        knightHp += getRandomIntegerBetweenRange(90, 120);
                                    } else {
                                        bossHp -= getRandomIntegerBetweenRange(45, 60);
                                        knightHp += getRandomIntegerBetweenRange(45, 60);
                                    }
                                    turn++;
                                    continue;
                                } else {
                                    PennDraw.setFontSize(128);
                                    PennDraw.text(.5, .5, "MISSED");
                                    sleep(500);
                                    PennDraw.advance();
                                    turn++;
                                    continue;
                                }

                            }

                            if (key == '3') {
                                if (knightHp <= 200) {
                                    for (double i = 0; i <= .6; i += 0.05) {
                                        PennDraw.clear();
                                        PennDraw.picture(0.5, .5, workingDir + "\\BossBattle.png");
                                        PennDraw.picture(0.16, .8, workingDir + "\\Wrath1.png", 500, 450);
                                        PennDraw.advance();
                                        sleep(22);
                                        PennDraw.picture(0.16, .8, workingDir + "\\Wrath2png.png", 500, 450);
                                        PennDraw.advance();
                                        sleep(22);
                                    }
                                    wrath = true;
                                    knightHp += getRandomIntegerBetweenRange(50, 60);
                                    turn++;
                                    continue;
                                } else {
                                    PennDraw.setFontSize(64);
                                    PennDraw.text(.5, .5, "MUST BE AT HALF HP");
                                    PennDraw.advance();
                                    turn++;
                                    continue;
                                }
                            }
                            if (key == '4') {
                                if (wrath || turn > 12) {
                                    for (double i = 0; i <= .555; i += 0.075) {
                                        PennDraw.clear();
                                        PennDraw.picture(0.5, .5, workingDir + "\\BossBattle.png");

                                        PennDraw.picture(0.16 + i, .8, workingDir + "\\Wrath1.png", 500, 450);
                                        PennDraw.advance();
                                        sleep(50);
                                        PennDraw.picture(0.16 + i, .8, workingDir + "\\Wrath2png.png", 500, 450);
                                        PennDraw.advance();
                                        if (i >= .5) {
                                            PennDraw.picture(.8, .65, workingDir + "\\SwordStrike.png", 200, 250);
                                            sleep(100);
                                            PennDraw.advance();
                                            PennDraw.picture(.8, .65, workingDir + "\\SwordStrike.png", 200, 250, 30);
                                            sleep(100);
                                            PennDraw.advance();
                                            PennDraw.picture(.8, .65, workingDir + "\\SwordStrike.png", 200, 250, 90);
                                            sleep(100);
                                            PennDraw.advance();
                                            PennDraw.picture(.8, .65, workingDir + "\\SwordStrike.png", 200, 250, 330);
                                            sleep(100);
                                            PennDraw.advance();
                                            PennDraw.picture(.8, .65, workingDir + "\\SwordStrike.png", 200, 250, 270);
                                            sleep(100);
                                            PennDraw.advance();
                                        }
                                        sleep(35);
                                        PennDraw.advance();
                                    }
                                    bossHp -= getRandomIntegerBetweenRange(300, 350);
                                    turn++;
                                    continue;
                                } else {
                                    PennDraw.setFontSize(64);
                                    PennDraw.text(.5, .5, "REQUIREMENTS NOT MET");
                                    PennDraw.advance();
                                    turn++;
                                    continue;
                                }
                            }
                        }
                    } else if (turn % 2 == 0) {
                        int bossAttk = (int) getRandomIntegerBetweenRange(0, 30);

                        if (bossAttk > 22) {
                            sleep(300);

                            bossSlash();
                            makeMap("\\BossBattle.png");
                            PennDraw.advance();

                            PennDraw.picture(0.143, .69, workingDir + "\\KnightJackson.png", 250, 250);
                            PennDraw.advance();
                            knightHp -= getRandomIntegerBetweenRange(75, 100);
                            turn++;
                            continue;
                        } else if (bossAttk > 5) {
                            bossSwordBarrage();

                            makeMap("\\BossBattle.png");
                            PennDraw.advance();

                            PennDraw.picture(0.143, .69, workingDir + "\\KnightJackson.png", 250, 250);
                            PennDraw.advance();

                            knightHp -= getRandomIntegerBetweenRange(50, 75);
                            turn++;

                        } else {
                            sleep(400);
                            PennDraw.picture(0.143, .69, workingDir + "\\KnightJackson.png", 250, 250);
                            makeMap("\\BossBattle.png");
                            PennDraw.picture(0.143, .69, workingDir + "\\KnightJackson.png", 250, 250);
                            PennDraw.setFontSize(128);
                            PennDraw.text(.5, .5, "MISSED");
                            PennDraw.advance();
                            sleep(1000);
                            PennDraw.picture(0.143, .69, workingDir + "\\KnightJackson.png", 250, 250);
                            makeMap("\\BossBattle.png");
                            PennDraw.picture(0.143, .69, workingDir + "\\KnightJackson.png", 250, 250);
                            PennDraw.advance();
                            turn++;
                            continue;
                        }
                    }
                }
                if (defeatBoss == true) {
                    bossWinPoints++;
                }

                if (bossWinPoints == 1) {
                    bossWin = true;
                }

                bossMap = true;
                bossFight = false;

            }

        }
    }

    public static void makeMap(String map) {
        PennDraw.clear();
        PennDraw.picture(0.5, 0.5, workingDir + map);
        PennDraw.advance();
    }

    public static void makeJackson(String person, double x, double y, double width, double height) {
        PennDraw.clear();
        PennDraw.picture(x, y, workingDir + person, width, height);
    }

    public static double getRandomIntegerBetweenRange(double min, double max) {
        double x = (int) (Math.random() * ((max - min) + 1)) + min;
        return x;
    }

    public static void sonicAttack() throws InterruptedException {
        while (true) {

            PennDraw.picture(0.143, .69, workingDir + "\\KnightJackson.png", 250, 250);
            PennDraw.advance();
            PennDraw.picture(0.5, 0.5, workingDir + "\\KnightSkills.png");
            PennDraw.advance();
            PennDraw.picture(0.5, 0.5, workingDir + "\\BatEchoP1.png");
            sleep(120);
            PennDraw.advance();
            PennDraw.picture(0.143, .69, workingDir + "\\KnightJackson.png", 250, 250);
            PennDraw.advance();
            PennDraw.picture(0.5, 0.5, workingDir + "\\KnightSkills.png");
            PennDraw.advance();
            PennDraw.picture(0.5, 0.5, workingDir + "\\BatEchoP2.png");
            sleep(120);
            PennDraw.picture(0.143, .69, workingDir + "\\KnightJackson.png", 250, 250);
            PennDraw.advance();
            PennDraw.picture(0.5, 0.5, workingDir + "\\KnightSkills.png");
            PennDraw.advance();
            PennDraw.picture(0.5, 0.5, workingDir + "\\BatEchoP3.png");
            sleep(120);
            PennDraw.picture(0.143, .69, workingDir + "\\KnightJackson.png", 250, 250);
            PennDraw.advance();
            PennDraw.advance();
            PennDraw.picture(0.5, 0.5, workingDir + "\\KnightSkills.png");
            PennDraw.advance();
            PennDraw.picture(0.5, 0.5, workingDir + "\\BatEchoP4.png");
            sleep(120);
            PennDraw.picture(0.143, .69, workingDir + "\\KnightJackson.png", 250, 250);
            PennDraw.advance();
            PennDraw.advance();
            PennDraw.picture(0.5, 0.5, workingDir + "\\KnightSkills.png");
            PennDraw.advance();
            PennDraw.picture(0.5, 0.5, workingDir + "\\BatEchoP5.png");
            sleep(120);
            PennDraw.picture(0.143, .69, workingDir + "\\KnightJackson.png", 250, 250);
            PennDraw.advance();
            PennDraw.advance();
            PennDraw.picture(0.5, 0.5, workingDir + "\\KnightSkills.png");
            PennDraw.advance();
            PennDraw.picture(0.5, 0.5, workingDir + "\\BatEchoP6.png");
            sleep(120);
            PennDraw.picture(0.143, .69, workingDir + "\\KnightJackson.png", 250, 250);
            PennDraw.advance();
            PennDraw.advance();
            PennDraw.picture(0.5, 0.5, workingDir + "\\KnightSkills.png");
            PennDraw.advance();
            PennDraw.picture(0.5, 0.5, workingDir + "\\BatEchoP7.png");
            sleep(120);
            PennDraw.advance();
            break;
        }
    }

    public static void bossSwordBarrage() throws InterruptedException {
        PennDraw.clear();
        sleep(500);
        makeMap("\\BossBattle.png");
        PennDraw.picture(0.195, .65, workingDir + "\\KnightJackson.png", 250, 250);
        PennDraw.advance();
        sleep(750);
        makeMap("\\BossSlashBarage2.png");
        sleep(750);
        makeMap("\\BossBattle.png");
        PennDraw.picture(0.195, .65, workingDir + "\\KnightJackson.png", 250, 250);
        PennDraw.advance();
    }

    public static void bossSlash() throws InterruptedException {
        for (double i = 0; i < .48; i += .05) {
            PennDraw.picture(0.5, 0.5, workingDir + "\\BossBattle.png");
            PennDraw.picture(0.195, .65, workingDir + "\\KnightJackson.png", 250, 250);
            PennDraw.picture(0.78 - i, .65, workingDir + "\\BossSlash.png", 400, 400);
            PennDraw.advance();
            sleep(43);
            if (i >= .40) {
                PennDraw.picture(0.5, 0.5, workingDir + "\\BossBattle.png");
                PennDraw.picture(0.195, .65, workingDir + "\\KnightJackson.png", 250, 250);
                PennDraw.picture(.23, .65, workingDir + "\\purpleBoom.png");
                PennDraw.advance();
                sleep(500);
                break;
            }
        }
    }
    public static void youWin(){
        PennDraw.clear();
        PennDraw.picture(.5,.5,workingDir+"\\wormholejawn.jpg",1280,720);
        PennDraw.advance();
        PennDraw.setFontBold();
        PennDraw.setFontSize(64);
        PennDraw.text(.5,.5,"You won");
        PennDraw.advance();
    }
}