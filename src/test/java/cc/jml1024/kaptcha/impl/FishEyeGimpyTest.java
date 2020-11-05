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
public class FishEyeGimpyTest extends TestCase {
    private Properties properties;

    private FishEyeGimpy gimpy;

    public void setUp() {
        properties = new Properties();
        gimpy = new FishEyeGimpy();
    }

    public void testGetDistortedImageAppliesShadowToFontAndAddsTwoNoises()
            throws Exception {
        properties.put(Constants.KAPTCHA_BACKGROUND_CLR_FROM, "CYAN");
        properties.put(Constants.KAPTCHA_BACKGROUND_CLR_TO, "BLACK");
        properties.put(Constants.KAPTCHA_TEXTPRODUCER_FONT_SIZE, "50");
        properties.put(Constants.KAPTCHA_TEXTPRODUCER_FONT_NAMES, "Helvetica");
        properties.put(Constants.KAPTCHA_TEXTPRODUCER_FONT_COLOR, "WHITE");

        Config config = new Config(properties);

        DefaultWordRenderer renderer = new DefaultWordRenderer();
        DefaultBackground background = new DefaultBackground();

        renderer.setConfig(config);
        background.setConfig(config);

        BufferedImage imageWithWord = renderer
                .renderWord("Alan SHORE", 300, 80);
        BufferedImage imageWithShadow = gimpy.getDistortedImage(imageWithWord);
        BufferedImage imageWithBackground = background
                .addBackground(imageWithShadow);
        assertNotNull(imageWithBackground);
        TestUtil.writePngImageFile("FishEyeGimpy_fishEyeAndLines",
                imageWithBackground);
    }
}
