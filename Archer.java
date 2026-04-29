/**
 * Archer class - a character specialized in ranged attacks.
 */
public class Archer extends GameCharacter {
    private int arrowCount;

    public Archer(String name, int hp, int attackPower, int arrowCount) {
        super(name, hp, attackPower);
        this.arrowCount = arrowCount;
    }

    public int getArrowCount() {
        return arrowCount;
    }

    public void setArrowCount(int arrowCount) {
        this.arrowCount = arrowCount;
    }

    @Override
    public String attack(GameCharacter target) {
        if (arrowCount > 0) {
            arrowCount--;
            return getName() + " shoots an arrow at " + target.getName() + " for " + getAttackPower() + " damage! (Arrows left: " + arrowCount + ")";
        } else {
            return getName() + " has no arrows left to attack!";
        }
    }

    @Override
    public String describeClass() {
        return "Archer - A skilled marksman who attacks from a distance with a bow and arrow.";
    }
}