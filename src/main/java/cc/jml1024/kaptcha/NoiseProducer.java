package cc.jml1024.kaptcha;

import java.awt.image.BufferedImage;

/**
 * @author {@link NoiseProducer} is responsible for adding noise to an image.
 */
public interface NoiseProducer {
    /**
     * Adds noise to an image. It uses four factor values to determine the noise
     * curve.
     *
     * @param image       the image to add the noise to
     * @param factorOne
     * @param factorTwo
     * @param factorThree
     * @param factorFour
     */
    public void makeNoise(BufferedImage image, float factorOne,
                          float factorTwo, float factorThree, float factorFour);
}
