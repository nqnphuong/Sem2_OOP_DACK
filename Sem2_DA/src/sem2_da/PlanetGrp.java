/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sem2_da;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import pkg2dgamesframework.QueueList;

/**
 *
 * @author ngnha
 */
public class PlanetGrp {

    private QueueList<Planet> planet; //hàng đợi
    private BufferedImage planetImg1, planetImg2, planetImg3, planetImg4, planetImg5, planetImg6;
    private ArrayList<Integer> numbers;
    public static int SIZE = 6;
    private int topPlanetY = -200;
    private int bottomPlanetY = 300;

    public Planet getPlanet(int i) {
        return planet.get(i);
    }

    public int getRandomY() {
        Random random = new Random();
        int a;
        a = random.nextInt(10);

        return a * 50;
    }

    public void random() {
        numbers = new ArrayList<Integer>();
        Random randomGenerator = new Random();
        while (numbers.size() < 6) {
            int ran = randomGenerator.nextInt(6);
            if (!numbers.contains(ran)) {
                numbers.add(ran);
            }
        }
    }

    public PlanetGrp() {
        /**
         * Thông số img: 1 (253,300) 2 (253,280) 3 (253,246) 4 (253,238) 5
         * (300,298) 6 (300, 308) - da fix bang nhau
         */
        try {
            planetImg1 = ImageIO.read(new File("Assets/p7.png"));
            planetImg2 = ImageIO.read(new File("Assets/p2.png"));
            planetImg3 = ImageIO.read(new File("Assets/p3.png"));
            planetImg4 = ImageIO.read(new File("Assets/p4.png"));
            planetImg5 = ImageIO.read(new File("Assets/p5.png"));
            planetImg6 = ImageIO.read(new File("Assets/p6.png"));
        } catch (IOException ex) {
            Logger.getLogger(PlanetGrp.class.getName()).log(Level.SEVERE, null, ex);
        }

        planet = new QueueList<Planet>();
        Planet p;

        for (int i = 0; i < SIZE / 2; i++) {

            int deltaY = getRandomY();

            p = new Planet(900 + i * 700, bottomPlanetY + deltaY, 300, 300);
            planet.push(p);

            p = new Planet(700 + i * 700, topPlanetY + deltaY, 300, 300);
            planet.push(p);
        }
        random();
    }

    public void resetPlanet() {
        planet = new QueueList<Planet>();
        Planet p;

        for (int i = 0; i < SIZE / 2; i++) {

            int deltaY = getRandomY();

            p = new Planet(1300 + i * 700, bottomPlanetY + deltaY, 300, 300);
            planet.push(p);

            p = new Planet(1500 + i * 700, topPlanetY + deltaY, 300, 300);
            planet.push(p);
        }
    }

    public void update() {
        for (int i = 0; i < SIZE; i++) {
            planet.get(i).update();
        }
        if (planet.get(0).getPosX() < -300) {

            int deltaY = getRandomY();

            Planet p;
            p = planet.pop();
            p.setPosX(planet.get(4).getPosX() + 700);
            p.setPosY(bottomPlanetY + deltaY);
            p.setIsBehindHero(false);
            planet.push(p);

            p = planet.pop();
            p.setPosX(planet.get(4).getPosX());
            p.setPosY(topPlanetY + deltaY);
            p.setIsBehindHero(false);
            planet.push(p);
        }
    }

    public void paint(Graphics2D g2) {
        for (int i = 0; i < SIZE; i++) {
//            System.out.println(numbers.get(i));
//            if (i % 2 == 0) {
                if (numbers.get(i) == 0) {
                    g2.drawImage(planetImg1, (int) planet.get(i).getPosX(), (int) planet.get(i).getPosY(), null);
//                    System.out.println("yes");
                } else if (numbers.get(i) == 1) {
                    g2.drawImage(planetImg2, (int) planet.get(i).getPosX(), (int) planet.get(i).getPosY(), null);
//                    System.out.println("yes");
                } else if (numbers.get(i) == 2) {
                    g2.drawImage(planetImg3, (int) planet.get(i).getPosX(), (int) planet.get(i).getPosY(), null);
//                    System.out.println("yes");
                }
//            } else {
                if (numbers.get(i) == 3) {
                    g2.drawImage(planetImg4, (int) planet.get(i).getPosX(), (int) planet.get(i).getPosY(), null);
//                    System.out.println("yes");
                } else if (numbers.get(i) == 4) {
                    g2.drawImage(planetImg5, (int) planet.get(i).getPosX(), (int) planet.get(i).getPosY(), null);
//                    System.out.println("yes");
                } else if (numbers.get(i) == 5) {
                    g2.drawImage(planetImg6, (int) planet.get(i).getPosX(), (int) planet.get(i).getPosY(), null);
//                    System.out.println("yes");
                }
//            }
//            System.out.println("stop");
        }
    }

}
