package cc.jml1024.kaptcha.impl;


import cc.jml1024.kaptcha.Constants;
import cc.jml1024.kaptcha.util.Config;
import cc.jml1024.kaptcha.util.TestUtil;
import junit.framework.TestCase;

import java.awt.image.BufferedImage;
import java.util.Properties;

/**
 * @author cliffano
 */
public class DefaultBackgroundTest extends TestCase {
    private DefaultBackground background;

    private Properties properties;

    public void setUp() {
        properties = new Properties();
        background = new DefaultBackground();
        background.setConfig(new Config(properties));
    }

    public void testAddBackgroundWithDifferentColorFromAndToGivesDiagonalGradientBackgroundWithSpecifiedColors()
            throws Exception {
        properties.put(Constants.KAPTCHA_BACKGROUND_CLR_FROM, "GREEN");
        properties.put(Constants.KAPTCHA_BACKGROUND_CLR_TO, "MAGENTA");
        BufferedImage baseImage = TestUtil.createBaseImage();
        BufferedImage imageWithBackground = background.addBackground(baseImage);
        TestUtil.writePngImageFile(
                "DefaultBackground_gradientBackgroundGreenMagenta",
                imageWithBackground);
    }

    public void testAddBackgroundWithSameColorFromAndToGivesFlatBackgroundColor()
            throws Exception {
        properties.put(Constants.KAPTCHA_BACKGROUND_CLR_FROM, "YELLOW");
        properties.put(Constants.KAPTCHA_BACKGROUND_CLR_TO, "YELLOW");
        BufferedImage baseImage = TestUtil.createBaseImage();
        BufferedImage imageWithBackground = background.addBackground(baseImage);
        TestUtil.writePngImageFile("DefaultBackground_flatBackgroundYellow",
                imageWithBackground);
    }

    public void testAddBackgroundWithNullColorFromAndToGivesDiagonalBackgroundColorWithDefaultLightGrayAndWhite()
            throws Exception {
        BufferedImage baseImage = TestUtil.createBaseImage();
        BufferedImage imageWithBackground = background.addBackground(baseImage);
        TestUtil.writePngImageFile(
                "DefaultBackground_gradientBackgroundLightGrayWhite",
                imageWithBackground);
    }
}
