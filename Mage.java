/**
 * Mage class - a character that can cast spells.
 */
public class Mage extends GameCharacter implements CasterAbility {
    private int mana;

    public Mage(String name, int hp, int attackPower, int mana) {
        super(name, hp, attackPower);
        this.mana = mana;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    @Override
    public String attack(GameCharacter target) {
        return getName() + " casts a fireball at " + target.getName() + " for " + getAttackPower() + " magic damage!";
    }

    @Override
    public String describeClass() {
        return "Mage - A powerful spellcaster who masters arcane arts to cast devastating spells.";
    }

    @Override
    public String castSpell(String spellName) {
        if (mana >= 10) {
            mana -= 10;
            return getName() + " casts " + spellName + "! (Mana: " + mana + ")";
        } else {
            return getName() + " does not have enough mana to cast " + spellName + "!";
        }
    }
}