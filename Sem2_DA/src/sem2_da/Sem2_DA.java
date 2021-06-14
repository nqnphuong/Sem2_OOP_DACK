/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sem2_da;

import Controller.DAOScore;
import Model.entity_Score;
import View.maxScore;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.*;
import java.util.Date;
import javax.imageio.ImageIO;
import pkg2dgamesframework.AFrameOnImage;
import pkg2dgamesframework.Animation;
import pkg2dgamesframework.GameScreen;
import pkg2dgamesframework.SoundPlayer;

/**
 *
 * @author ngnha
 */
public class Sem2_DA extends GameScreen {

    private BufferedImage hero, hero1;
    private Animation hero_anim;

    public static float g = 0.15f;

    private Hero Hero;
    private Land land;
    private Sky sky;
    private PlanetGrp planetGrp;

    private int BEGIN_SC = 0;
    private int GAMEPLAY_SC = 1;
    private int GAMEOVER_SC = 2;

    private int CurrentSC = BEGIN_SC;
    private int point = 0;
    private float heart = 100;

    private int endPoint = 0;

    private View.login login;
    public String name;
//    private int maxScore =0;
//    private Date date;

    public Sem2_DA() {
        super(1000, 700); //setsize
        name = login.name;
        setTitle(name);
        try {
            hero = ImageIO.read(new File("Assets/hero.png"));
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Sem2_DA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        hero_anim = new Animation(100);
        AFrameOnImage f;
        f = new AFrameOnImage(0, 0, 60, 70);
        hero_anim.AddFrame(f);
        f = new AFrameOnImage(60, 0, 60, 70);
        hero_anim.AddFrame(f);
        f = new AFrameOnImage(120, 0, 60, 70);
        hero_anim.AddFrame(f);
        f = new AFrameOnImage(240, 0, 60, 70);
        hero_anim.AddFrame(f);

        Hero = new Hero(350, 350, 60, 60);
        land = new Land();
        sky = new Sky();
        planetGrp = new PlanetGrp();
        
        
        System.out.println(name);
        //đặt code trên phần này
        BeginGame(); //khởi chạy thread
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Sem2_DA main = new Sem2_DA();
    }
    
    
    private void resertGame() {
        Hero.setPos(350, 350);
        Hero.setVt(0);
        Hero.setLive(true);
        point = 0;
        heart = 100;
        planetGrp.resetPlanet();
    }

    public void updateScore() {
        LocalTime times = java.time.LocalTime.now();
        LocalDate dates = java.time.LocalDate.now();
        entity_Score score = new entity_Score(getTitle(),endPoint, times, dates);
        DAOScore.Them(score);
        System.out.println(endPoint + " " + times + " " + dates);

    }

    @Override
    public void GAME_UPDATE(long deltaTime) {
        if (CurrentSC == BEGIN_SC) {
            resertGame();
        } else if (CurrentSC == GAMEPLAY_SC) {
            if (Hero.getLive()) {
                hero_anim.Update_Me(deltaTime); //hero ko chet ->bay duoc
            }
            land.update();
            sky.update();

            planetGrp.update();

            if (Hero.getPosY() + Hero.getH() <= land.getYLand()) { // nếu hero chua cham mặt đất
                Hero.update(deltaTime); //rớt xuống
                heart -= 0.1;
            } else {
                heart += 0.3;
            }
            

            for (int i = 0; i < planetGrp.SIZE; i++) {
                if (Hero.getRect().intersects(planetGrp.getPlanet(i).getRect()) || heart <= 0) {
                    //intersects ktra giao nhau, tra kieu bool 
                    //kiem tra chet chua
                    Hero.setLive(false); //hero die
                    CurrentSC = GAMEOVER_SC;
                }
            }

            for (int i = 0; i < planetGrp.SIZE; i++) {
                if (Hero.getPosX() > planetGrp.getPlanet(i).getPosX() && !planetGrp.getPlanet(i).getisIsBehindHero()) {
                    point++;
                    planetGrp.getPlanet(i).setIsBehindHero(true);
                }
            }
            endPoint = point;

        } else if (CurrentSC == GAMEOVER_SC) {

        }
    }

    @Override
    public void GAME_PAINT(Graphics2D g2) {

        sky.Paint(g2);
        land.Paint(g2);
        planetGrp.paint(g2);

        hero_anim.PaintAnims((int) Hero.getPosX(), (int) Hero.getPosY(), hero, g2, 0, 0);

        if (CurrentSC == BEGIN_SC) {
            g2.setColor(Color.WHITE);
            g2.drawString("PRESS SPACE TO BEGIN!", 300, 260);
            g2.drawString("TAKE CARE OF YOUR HEART!", 300, 280);
            g2.drawString("MOVE ON THE GROUND TO RECORD YOUR HEART!", 300, 300);
            g2.drawString("IF HEART RETURNS 0, YOU WILL DIE!", 300, 320);
        }
        if (CurrentSC == GAMEOVER_SC) {
            g2.setColor(Color.WHITE);
            g2.drawString("PRESS SPACE TO BEGIN AGAINT!", 300, 300);
        }

        g2.setColor(Color.WHITE);
        g2.drawString("SCORE " + point, 20, 30);
        g2.drawString("HEART " + heart, 20, 50);

    }

    @Override
    public void KEY_ACTION(KeyEvent e, int Event) {

        if (Event == KEY_PRESSED) {
            if (CurrentSC == BEGIN_SC) {
                CurrentSC = GAMEPLAY_SC;
            } else if (CurrentSC == GAMEPLAY_SC) {
                if (Hero.getLive()) {
                    Hero.fly();
                }
            } else if (CurrentSC == GAMEOVER_SC) {
//                System.out.println(1);
                CurrentSC = BEGIN_SC;
                updateScore();
                new maxScore();
            }
        }
    }
}
