/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2dgamesframework;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author phamn
 */
public class Animation {
    
    private long beginTime = 0;
    
    private long mesure = 20;
    
    private AFrameOnImage[] frames;
    private int NumOfFrame = 0;
    private int CurrentFrame = 0;
    
    public Animation(long mesure){ //thời gian tồn tại 1 hình
        this.mesure = mesure;
    }
    
    public void Update_Me(long deltaTime){ //mỗi khung hình ml giay
        if(NumOfFrame>0){
            if(deltaTime - beginTime > mesure){
                CurrentFrame++; //sau 1 thời gian-> tang len frame n
//                System.err.println(CurrentFrame+" "+beginTime);
                if(CurrentFrame>=NumOfFrame) // kết thúc
                    CurrentFrame = 0;
                beginTime = deltaTime; 
            }
            
        }
    }
    public void AddFrame(AFrameOnImage sprite){ //update số lượng frame
        AFrameOnImage[] bufferSprites = frames;
        frames = new AFrameOnImage[NumOfFrame+1];
        for(int i = 0;i<NumOfFrame;i++) frames[i] = bufferSprites[i];
        frames[NumOfFrame] = sprite;
        NumOfFrame++;
//        System.out.println(NumOfFrame);
    }
    
    public void PaintAnims(int x, int y, BufferedImage image, Graphics2D g2, int anchor, float rotation){
        //vẽ frame
        frames[CurrentFrame].Paint(x, y, image, g2, anchor, rotation);
    }
}
