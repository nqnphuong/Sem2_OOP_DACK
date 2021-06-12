package sem2_da;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author ngnha
 */
public class Land {

    private BufferedImage landImg;
    private int x1, y1, x2, y2;

    public Land() {
        try {
            landImg = ImageIO.read(new File("Assets/land.png"));
        } catch (IOException ex) {
            Logger.getLogger(Land.class.getName()).log(Level.SEVERE, null, ex);
        }
        // dat toa do cho land
        x1 = 0;
        y1 = 500;
        x2 = x1 + 1167;
        y2 = 500;

    }

    public void update() {
        x1 -= 4;
        x2 -= 4;
        if (x2 < 0) {
            x1 = x2 + 1167;
        }
        if (x1 < 0) {
            x2 = x1 + 1167;
        }
    }

    public void Paint(Graphics2D g2) {
        g2.drawImage(landImg, x1, y1, null);
        g2.drawImage(landImg, x2, y2, null);
    }
    
    public int getYLand(){
        return y1+100;
    }
    
}
