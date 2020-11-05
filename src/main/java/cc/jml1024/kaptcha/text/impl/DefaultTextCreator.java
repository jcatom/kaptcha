package cc.jml1024.kaptcha.text.impl;

import cc.jml1024.kaptcha.text.TextProducer;
import cc.jml1024.kaptcha.util.Configurable;

import java.util.Random;

/**
 * {@link DefaultTextCreator} creates random text from an array of characters
 * with specified length.
 */
public class DefaultTextCreator extends Configurable implements TextProducer {
    /**
     * @return the random text
     */
    public String getText() {
        int length = getConfig().getTextProducerCharLength();
        char[] chars = getConfig().getTextProducerCharString();
        Random rand = new Random();
        StringBuffer text = new StringBuffer();
        for (int i = 0; i < length; i++) {
            text.append(chars[rand.nextInt(chars.length)]);
        }

        return text.toString();
    }
}
