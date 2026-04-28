/**
 * Abstract base class for RPG characters.
 * Contains common fields and behaviors.
 * Fields: name, hp, attackPower
 * Includes a concrete rest() method and abstract methods attack() and describeClass().
 * All fields are private with getters and setters.
 */
public abstract class GameCharacter {
    private String name;
    private int hp;
    private int attackPower;

    public GameCharacter(String name, int hp, int attackPower) {
        if (hp <= 0) {
            throw new IllegalArgumentException("HP must be greater than 0");
        }
        if (attackPower <= 0) {
            throw new IllegalArgumentException("Attack power must be greater than 0");
        }
        this.name = name;
        this.hp = hp;
        this.attackPower = attackPower;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        if (hp <= 0) {
            throw new IllegalArgumentException("HP must be greater than 0");
        }
        this.hp = hp;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        if (attackPower <= 0) {
            throw new IllegalArgumentException("Attack power must be greater than 0");
        }
        this.attackPower = attackPower;
    }

    /**
     * Restores some HP to the character.
     */
    public void rest() {
        this.hp += 10;
        System.out.println(name + " rests and recovers 10 HP!");
    }

    /**
     * Abstract method for attacking another character.
     */
    public abstract void attack(GameCharacter target);

    /**
     * Abstract method to describe the character's class.
     */
    public abstract String describeClass();
}
