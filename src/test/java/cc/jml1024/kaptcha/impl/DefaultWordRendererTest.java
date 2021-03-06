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
public class DefaultWordRendererTest extends TestCase {
    private DefaultWordRenderer renderer;

    private Properties properties;

    public void setUp() {
        properties = new Properties();
        renderer = new DefaultWordRenderer();
        renderer.setConfig(new Config(properties));
    }

    public void testRenderWordGivesImageWithExpectedDimension() {
        properties.put(Constants.KAPTCHA_TEXTPRODUCER_FONT_SIZE, "20");
        properties.put(Constants.KAPTCHA_TEXTPRODUCER_FONT_NAMES, "Arial");
        properties.put(Constants.KAPTCHA_TEXTPRODUCER_FONT_COLOR, "BLUE");
        BufferedImage image = renderer.renderWord("Edwin POOLE", 400, 300);
        assertEquals(400, image.getWidth());
        assertEquals(300, image.getHeight());
    }

    public void testRenderWordWithMultipleFonts() throws Exception {
        properties.put(Constants.KAPTCHA_TEXTPRODUCER_FONT_SIZE, "20");
        properties.put(Constants.KAPTCHA_TEXTPRODUCER_FONT_NAMES,
                "Arial,Helvetica");
        properties.put(Constants.KAPTCHA_TEXTPRODUCER_FONT_COLOR, "RED");
        BufferedImage image = renderer.renderWord("Shirley SCHMIDT", 300, 80);
        TestUtil.writePngImageFile("DefaultWordRenderer_redFontDrawn", image);
    }

    public void testRenderWordWithWidthLessThanFontStartPosDoesntDrawAnyFont()
            throws Exception {
        properties.put(Constants.KAPTCHA_TEXTPRODUCER_FONT_SIZE, "20");
        properties.put(Constants.KAPTCHA_TEXTPRODUCER_FONT_NAMES, "Arial");
        properties.put(Constants.KAPTCHA_TEXTPRODUCER_FONT_COLOR, "GREEN");
        BufferedImage image = renderer.renderWord("Edwin POOLE", 25, 80);
        TestUtil.writePngImageFile("DefaultWordRenderer_noFontDrawn", image);
    }

    public void testRenderWordWithNullFontConfigGivesDefaultFonts()
            throws Exception {
        BufferedImage image = renderer.renderWord("Denny CRANE", 300, 80);
        TestUtil.writePngImageFile("DefaultWordRenderer_defaultBlackFontDrawn",
                image);
    }
}
