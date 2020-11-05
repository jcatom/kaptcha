package cc.jml1024.kaptcha.impl;


import cc.jml1024.kaptcha.Constants;
import cc.jml1024.kaptcha.util.Config;
import cc.jml1024.kaptcha.util.TestUtil;
import junit.framework.TestCase;

import java.util.Properties;

/**
 * @author cliffano
 */
public class DefaultKaptchaTest extends TestCase {
    private DefaultKaptcha kaptcha;

    private Properties properties;

    public void setUp() {
        kaptcha = new DefaultKaptcha();
        properties = new Properties();
        kaptcha.setConfig(new Config(properties));
    }

    public void testCreateImageWithDefaultImpls() throws Exception {
        TestUtil.writePngImageFile("DefaultKaptcha_defaultImpls", kaptcha
                .createImage(kaptcha.createText()));
    }

    public void testCreateImageWithConfiguredImpls() throws Exception {
        properties.put(Constants.KAPTCHA_BORDER, "no");
        properties.put(Constants.KAPTCHA_BACKGROUND_CLR_FROM, "GREEN");
        properties.put(Constants.KAPTCHA_BACKGROUND_CLR_TO, "MAGENTA");
        properties.put(Constants.KAPTCHA_TEXTPRODUCER_FONT_SIZE, "40");
        properties.put(Constants.KAPTCHA_TEXTPRODUCER_FONT_NAMES, "Arial");
        properties.put(Constants.KAPTCHA_TEXTPRODUCER_FONT_COLOR, "BLUE");
        properties.put(Constants.KAPTCHA_NOISE_COLOR, "RED");
        properties.put(Constants.KAPTCHA_OBSCURIFICATOR_IMPL,
                "cc.jml1024.kaptcha.impl.ShadowGimpy");
        properties.put(Constants.KAPTCHA_WORDRENDERER_IMPL,
                "cc.jml1024.kaptcha.text.impl.DefaultWordRenderer");
        properties.put(Constants.KAPTCHA_TEXTPRODUCER_IMPL,
                "cc.jml1024.kaptcha.text.impl.ChineseTextProducer");
        TestUtil.writePngImageFile("DefaultKaptcha_configuredImpls", kaptcha
                .createImage("Fleet Street"));
    }

    public void testCreateImageWithChineseText() throws Exception {
        properties.put(Constants.KAPTCHA_TEXTPRODUCER_IMPL,
                "cc.jml1024.kaptcha.text.impl.ChineseTextProducer");
        String text = kaptcha.createText();
        TestUtil.writePngImageFile("DefaultKaptcha_chineseText", kaptcha
                .createImage(text));
    }
}
