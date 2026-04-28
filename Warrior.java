/**
 * Warrior class - a character that can defend.
 */
public class Warrior extends GameCharacter implements Defendable {
    private int armorRating;

    public Warrior(String name, int hp, int attackPower, int armorRating) {
        super(name, hp, attackPower);
        this.armorRating = armorRating;
    }

    public int getArmorRating() {
        return armorRating;
    }

    public void setArmorRating(int armorRating) {
        this.armorRating = armorRating;
    }

    @Override
    public void attack(GameCharacter target) {
        System.out.println(getName() + " attacks " + target.getName() + " with a sword for " + getAttackPower() + " damage!");
    }

    @Override
    public String describeClass() {
        return "Warrior - A sturdy fighter specialized in melee combat with high defense.";
    }

    @Override
    public void block() {
        System.out.println(getName() + " raises their shield to block!");
    }

    @Override
    public int getDefenseRating() {
        return armorRating;
    }
}