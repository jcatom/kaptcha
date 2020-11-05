package cc.jml1024.kaptcha.impl;

import cc.jml1024.kaptcha.text.impl.FiveLetterFirstNameTextCreator;
import junit.framework.TestCase;

/**
 * @author cliffano
 */
public class FiveLetterFirstNameTextCreatorTest extends TestCase {
    public void testGetTextGivesTextWithFiveLetters() {
        FiveLetterFirstNameTextCreator creator = new FiveLetterFirstNameTextCreator();
        assertEquals(5, creator.getText().length());
    }
}
