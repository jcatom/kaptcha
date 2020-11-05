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
public class DefaultNoiseTest extends TestCase {
    private DefaultNoise noise;

    private Properties properties;

    public void setUp() {
        properties = new Properties();
        noise = new DefaultNoise();
        noise.setConfig(new Config(properties));
    }

    public void testMakeNoiseWithMultipleNoises() throws Exception {
        properties.put(Constants.KAPTCHA_NOISE_COLOR, "GREEN");
        BufferedImage image = TestUtil.createBaseImage();
        noise.makeNoise(image, .1f, .1f, .25f, .25f);
        noise.makeNoise(image, .5f, .5f, .5f, 5f);
        noise.makeNoise(image, 5f, .1f, 8f, .25f);
        TestUtil.writePngImageFile("DefaultNoise_multipleGreenNoisesDrawn",
                image);
    }


    public void testMakeNoiseWithAllFactorsGreaterThan1fDoesntDrawAnything()
            throws Exception {
        properties.put(Constants.KAPTCHA_NOISE_COLOR, "RED");
        BufferedImage image = TestUtil.createBaseImage();
        noise.makeNoise(image, 1.1f, 1.1f, 1.1f, 1.1f);
        TestUtil.writePngImageFile("DefaultNoise_noNoiseDrawn", image);
    }

    public void testMakeNoiseWithNullColorDefaultsToBlackNoises()
            throws Exception {
        BufferedImage image = TestUtil.createBaseImage();
        noise.makeNoise(image, .1f, .1f, .25f, .25f);
        noise.makeNoise(image, .5f, .5f, .5f, 5f);
        noise.makeNoise(image, 5f, .1f, 8f, .25f);
        TestUtil.writePngImageFile("DefaultNoise_multipleBlackNoisesDrawn",
                image);
    }
}
