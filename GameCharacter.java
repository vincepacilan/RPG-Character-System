/**
 * Abstract base class for RPG characters.
 * Represents shared properties and behaviors of all characters.
 */
public abstract class GameCharacter {

    // Encapsulated fields
    private String name;
    private int hp;
    private int attackPower;

    /**
     * Constructor with validation.
     */
    public GameCharacter(String name, int hp, int attackPower) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
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

    // ======================
    // Getters and Setters
    // ======================

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        if (hp < 0) {
            throw new IllegalArgumentException("HP cannot be negative");
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

    // ======================
    // Concrete Method
    // ======================

    /**
     * Restores a fixed amount of HP.
     */
    public void rest() {
        hp += 10;
        System.out.println(name + " rests and recovers 10 HP!");
    }

    // ======================
    // Abstract Methods
    // ======================

    /**
     * Performs an attack action.
     */
    public abstract void attack();

    /**
     * Returns a description of the character class.
     */
    public abstract String describeClass();
}