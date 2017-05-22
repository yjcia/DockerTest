package com.eddc.docker;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String tempFilePath = "/home/yanjun/docker/" + System.currentTimeMillis() + ".png";
        try {
            
            String goodsUrl = "https://www.amazon.de/dp/B0076ZTAKS";
            Desktop.getDesktop().browse(
                    new URL(goodsUrl).toURI());
            Robot robot = new Robot();
            robot.delay(3000);
            Dimension d = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
            int width = (int) d.getWidth();
            int height = (int) d.getHeight();
            // 最大化浏览器
            robot.keyRelease(KeyEvent.VK_F11);
            robot.delay(10000);
            Image image = robot.createScreenCapture(new Rectangle(50, 0, width,
                    height));
            BufferedImage bi = new BufferedImage(width, height,
                    BufferedImage.TYPE_INT_RGB);
            Graphics g = bi.createGraphics();
            g.drawImage(image, 0, -90, width, height, null);
            // 保存图片
            ImageIO.write(bi, "jpg", new File(tempFilePath));
            Runtime.getRuntime().exec("pkill -９ firefox");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (AWTException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
