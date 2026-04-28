/**
 * Interface for characters that can defend.
 */
public interface Defendable {
    /**
     * Perform a block action.
     */
    void block();

    /**
     * Get the defense rating of the character.
     * @return the defense rating as an int
     */
    int getDefenseRating();
}
