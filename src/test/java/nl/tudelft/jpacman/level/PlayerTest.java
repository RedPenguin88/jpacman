package nl.tudelft.jpacman.level;

import static org.assertj.core.api.Assertions.assertThat;
import nl.tudelft.jpacman.sprite.PacManSprites;
import nl.tudelft.jpacman.board.Direction;

import nl.tudelft.jpacman.sprite.Sprite;
import org.junit.jupiter.api.Test;

/**
 * A simple test class for the player
 *
 * @author Ethan Hunt
 */
public class PlayerTest {
    /**
     * Save the instances here per John Businge's recommendation
     */
    private static final PacManSprites SPRITE_STORE = new PacManSprites();
    private final PlayerFactory Factory = new PlayerFactory(SPRITE_STORE);
    private final Player ThePlayer = Factory.createPacMan();

    /**
     * Is the player alive?
     */
    @Test
    void testIsAlive() {
        assertThat(ThePlayer.isAlive()).isEqualTo(true);
    }

    /**
     * Test that pacman is displaying the correct sprite depending on direction
     */
    @Test
    void testPlayerGetSprite() {
        Direction playerDirection = ThePlayer.getDirection();
        Sprite expectedSprite = SPRITE_STORE.getPacmanSprites().get(playerDirection);
        assertThat(ThePlayer.getSprite()).isEqualTo(expectedSprite);

        // For full coverage, we test when not alive as well
        ThePlayer.setAlive(false);

        assertThat(ThePlayer.getSprite()).isEqualTo(SPRITE_STORE.getPacManDeathAnimation());
    }
}
