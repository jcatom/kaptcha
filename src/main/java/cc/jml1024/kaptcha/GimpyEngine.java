package cc.jml1024.kaptcha;

import java.awt.image.BufferedImage;

/**
 * @author {@link GimpyEngine} is responsible for applying image distortion.
 */
public interface GimpyEngine {
    /**
     * @param baseImage the base image
     * @return the image with distortion applied to the base image
     */
    public BufferedImage getDistortedImage(BufferedImage baseImage);
}
