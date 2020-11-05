package cc.jml1024.kaptcha.impl;


import cc.jml1024.kaptcha.NoiseProducer;
import cc.jml1024.kaptcha.util.Configurable;

import java.awt.image.BufferedImage;

/**
 * Imlemention of NoiseProducer that does nothing.
 *
 * @author Yuxing Wang
 */
public class NoNoise extends Configurable implements NoiseProducer {
    /**
     *
     */
    @Override
    public void makeNoise(BufferedImage image, float factorOne,
                          float factorTwo, float factorThree, float factorFour) {
        //Do nothing.
    }
}
