package nl.tudelft.jpacman.sprite;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * A simple test class for the player
 *
 * @author Ethan Hunt
 */
public class SpriteTest {

    final private SpriteStore spritestore = new SpriteStore();
    // attempt to load the pacman sprite
    final private Sprite sprite;

    {
        try {
            sprite = spritestore.loadSprite("/sprite/pacman.png");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testGetSpriteWidth() {
        assertThat(sprite.getWidth()).isEqualTo(64);
    }

    @Test
    public void testGetSpriteHeight() {
        assertThat(sprite.getHeight()).isEqualTo(64);
    }

}
