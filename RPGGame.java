import java.util.ArrayList;

/**
 * Main class to run the RPG character system.
 */
public class RPGGame {
    public static void main(String[] args) {
        ArrayList<GameCharacter> party = new ArrayList<>();

        // Create characters
        Warrior warrior = new Warrior("Conan", 150, 25, 10);
        Mage mage = new Mage("Gandalf", 80, 30, 100);
        Archer archer = new Archer("Legolas", 100, 20, 50);

        // Add to party
        party.add(warrior);
        party.add(mage);
        party.add(archer);

        // Display party info and demonstrate actions
        System.out.println("\n=== Party Actions ===");
        for (GameCharacter character : party) {
            System.out.println("\n--- " + character.getName() + " ---");
            System.out.println(character.describeClass());
            character.attack(party.get(0)); // Attack first party member as target
            character.rest();

            // Check if character can cast spells
            if (character instanceof CasterAbility) {
                CasterAbility caster = (CasterAbility) character;
                caster.castSpell("Fireball");
                System.out.println("Remaining mana: " + caster.getMana());
            }

            // Check if character can defend
            if (character instanceof Defendable) {
                Defendable defender = (Defendable) character;
                defender.block();
                System.out.println("Defense rating: " + defender.getDefenseRating());
            }
        }

        // Calculate party statistics
        int totalHp = 0;
        int casterCount = 0;
        for (GameCharacter character : party) {
            totalHp += character.getHp();
            if (character instanceof CasterAbility) {
                casterCount++;
            }
        }
        int nonCasterCount = party.size() - casterCount;
        String readiness = totalHp > 200 ? "READY" : "NOT READY";

        // Print party summary
        System.out.println("\n=== Party Summary ===");
        System.out.println("Total party size: " + party.size());
        System.out.println("Total HP: " + totalHp);
        System.out.println("Caster count: " + casterCount);
        System.out.println("Non-caster count: " + nonCasterCount);
        System.out.println("Party readiness: " + readiness);
    }
}