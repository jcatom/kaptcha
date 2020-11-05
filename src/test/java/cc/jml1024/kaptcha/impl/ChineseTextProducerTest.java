package cc.jml1024.kaptcha.impl;

import cc.jml1024.kaptcha.text.impl.ChineseTextProducer;
import junit.framework.TestCase;

/**
 * @author cliffano
 */
public class ChineseTextProducerTest extends TestCase {
    public void testGetTextReturnsTextWithoutAlphabetChars() {
        ChineseTextProducer producer = new ChineseTextProducer();
        String text = producer.getText();
        assertNotNull(text);
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            assertTrue(character < 'A' || character > 'z');
        }
    }
}
