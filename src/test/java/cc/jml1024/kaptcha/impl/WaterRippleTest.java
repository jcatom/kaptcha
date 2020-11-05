package cc.jml1024.kaptcha.impl;


import cc.jml1024.kaptcha.Constants;
import cc.jml1024.kaptcha.text.impl.DefaultWordRenderer;
import cc.jml1024.kaptcha.util.Config;
import cc.jml1024.kaptcha.util.TestUtil;
import junit.framework.TestCase;

import java.awt.image.BufferedImage;
import java.util.Properties;

/**
 * @author cliffano
 */
public class WaterRippleTest extends TestCase {
    private Properties properties;

    private WaterRipple gimpy;

    public void setUp() {
        properties = new Properties();
        gimpy = new WaterRipple();
    }

    public void testGetDistortedImageAppliesShadowToFontAndAddsTwoNoises()
            throws Exception {
        properties.put(Constants.KAPTCHA_BACKGROUND_CLR_FROM, "BLUE");
        properties.put(Constants.KAPTCHA_BACKGROUND_CLR_TO, "WHITE");
        properties.put(Constants.KAPTCHA_TEXTPRODUCER_FONT_SIZE, "50");
        properties.put(Constants.KAPTCHA_TEXTPRODUCER_FONT_NAMES, "Helvetica");
        properties.put(Constants.KAPTCHA_TEXTPRODUCER_FONT_COLOR, "RED");
        properties.put(Constants.KAPTCHA_NOISE_COLOR, "CYAN");

        Config configManager = new Config(properties);

        DefaultWordRenderer renderer = new DefaultWordRenderer();
        DefaultBackground background = new DefaultBackground();

        renderer.setConfig(configManager);
        background.setConfig(configManager);
        gimpy.setConfig(configManager);

        BufferedImage imageWithWord = renderer.renderWord("Jerry ESPENSON",
                300, 80);
        BufferedImage imageWithShadow = gimpy.getDistortedImage(imageWithWord);
        BufferedImage imageWithBackground = background
                .addBackground(imageWithShadow);
        assertNotNull(imageWithBackground);
        TestUtil.writePngImageFile("WaterRipple_rippleAndTwoNoises",
                imageWithBackground);
    }
}
