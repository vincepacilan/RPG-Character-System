/**
 * Interface for characters that can cast spells.
 */
public interface CasterAbility {
    /**
     * Cast a spell.
     * @param spellName the name of the spell to cast
     */
    String castSpell(String spellName);

    /**
     * Get the mana points of the character.
     * @return the mana points as an int
     */
    int getMana();
}