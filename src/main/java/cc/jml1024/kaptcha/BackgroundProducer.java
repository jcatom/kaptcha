package cc.jml1024.kaptcha;

import java.awt.image.BufferedImage;

/**
 * @author {@link BackgroundProducer} is responsible for adding background to an image.
 */
public interface BackgroundProducer {
    public abstract BufferedImage addBackground(BufferedImage image);
}
