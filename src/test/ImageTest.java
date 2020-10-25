package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Created by Black Mamba on 2020/8/27 20:38
 *
 * @version 1.0
 * @description
 */
class ImageTest {

    @Test
    void test(){
        BufferedImage image = null;

        BufferedImage tankD , tankL , tankR , tankU;
        try {
            image = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertNotNull(image);
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

}