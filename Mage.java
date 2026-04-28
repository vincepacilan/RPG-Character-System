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
    public void attack(GameCharacter target) {
        System.out.println(getName() + " casts a fireball at " + target.getName() + " for " + getAttackPower() + " magic damage!");
    }

    @Override
    public String describeClass() {
        return "Mage - A powerful spellcaster who masters arcane arts to cast devastating spells.";
    }

    @Override
    public void castSpell(String spellName) {
        if (mana >= 10) {
            mana -= 10;
            System.out.println(getName() + " casts " + spellName + "! (Mana: " + mana + ")");
        } else {
            System.out.println(getName() + " does not have enough mana to cast " + spellName + "!");
        }
    }
}