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
public class ShadowGimpyTest extends TestCase {
    private Properties properties;

    private ShadowGimpy gimpy;

    public void setUp() {
        properties = new Properties();
        gimpy = new ShadowGimpy();
    }

    public void testGetDistortedImageAppliesShadowToFontAndAddsTwoNoises()
            throws Exception {
        properties.put(Constants.KAPTCHA_BACKGROUND_CLR_FROM, "GREEN");
        properties.put(Constants.KAPTCHA_BACKGROUND_CLR_TO, "YELLOW");
        properties.put(Constants.KAPTCHA_TEXTPRODUCER_FONT_SIZE, "50");
        properties.put(Constants.KAPTCHA_TEXTPRODUCER_FONT_NAMES, "Arial");
        properties.put(Constants.KAPTCHA_TEXTPRODUCER_FONT_COLOR, "BLUE");

        Config config = new Config(properties);

        DefaultWordRenderer renderer = new DefaultWordRenderer();
        DefaultBackground background = new DefaultBackground();

        renderer.setConfig(config);
        background.setConfig(config);
        gimpy.setConfig(config);

        BufferedImage imageWithWord = renderer.renderWord("Clarence BELL", 300,
                80);
        BufferedImage imageWithShadow = gimpy.getDistortedImage(imageWithWord);
        BufferedImage imageWithBackground = background
                .addBackground(imageWithShadow);
        assertNotNull(imageWithBackground);
        TestUtil.writePngImageFile("ShadowGimpy_shadowFontAndTwoNoises",
                imageWithBackground);
    }
}
