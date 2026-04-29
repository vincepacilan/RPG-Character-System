import java.util.ArrayList;

/**
 * Main class to run the RPG character system.
 */
public class RPGGame {
    public static void main(String[] args) {
        ArrayList<GameCharacter> party = new ArrayList<>();

        // Create characters
        Warrior warrior = new Warrior("Suho", 150, 25, 10);
        Mage mage = new Mage("Jinwo", 80, 30, 100);
        Archer archer = new Archer("Logan", 100, 20, 50);

        // Add to party
        party.add(warrior);
        party.add(mage);
        party.add(archer);

        // Display party info and demonstrate actions
        String[] nameHeaders = {"Name", "Class"};
        String[] actionHeaders = {"Attack Action"};
        String[] restHeaders = {"Rest"};
        String[] specialHeaders = {"Special Ability"};

        java.util.List<String[]> nameRows = new java.util.ArrayList<>();
        java.util.List<String[]> actionRows = new java.util.ArrayList<>();
        java.util.List<String[]> restRows = new java.util.ArrayList<>();
        java.util.List<String[]> specialRows = new java.util.ArrayList<>();

        for (GameCharacter character : party) {
            GameCharacter target = character;
            for (GameCharacter other : party) {
                if (other != character) {
                    target = other;
                    break;
                }
            }
            String attackMsg = character.attack(target);
            String restMsg = character.rest();

            String specialMsg = "N/A";
            if (character instanceof CasterAbility) {
                CasterAbility caster = (CasterAbility) character;
                specialMsg = caster.castSpell("Fireball");
            } else if (character instanceof Defendable) {
                Defendable defender = (Defendable) character;
                specialMsg = defender.block() + " (Defense: " + defender.getDefenseRating() + ")";
            }

            nameRows.add(new String[] {
                character.getName(),
                character.getClass().getSimpleName()
            });
            actionRows.add(new String[] {attackMsg});
            restRows.add(new String[] {restMsg});
            specialRows.add(new String[] {specialMsg});
        }

        printTable(nameHeaders, nameRows);
        System.out.println();
        printTable(actionHeaders, actionRows);
        System.out.println();
        printTable(restHeaders, restRows);
        System.out.println();
        printTable(specialHeaders, specialRows);
        System.out.println();

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

        String[] summaryHeaders = {"Summary", "Value"};
        java.util.List<String[]> summaryRows = new java.util.ArrayList<>();
        summaryRows.add(new String[] {"Total party size", String.valueOf(party.size())});
        summaryRows.add(new String[] {"Total HP", String.valueOf(totalHp)});
        summaryRows.add(new String[] {"Caster count", String.valueOf(casterCount)});
        summaryRows.add(new String[] {"Non-caster count", String.valueOf(nonCasterCount)});
        summaryRows.add(new String[] {"Party readiness", readiness});

        printTable(summaryHeaders, summaryRows);
    }

    private static void printTable(String[] headers, java.util.List<String[]> rows) {
        int columns = headers.length;
        int[] widths = new int[columns];

        for (int i = 0; i < columns; i++) {
            widths[i] = headers[i].length();
        }

        for (String[] row : rows) {
            for (int i = 0; i < columns; i++) {
                if (row[i] != null && row[i].length() > widths[i]) {
                    widths[i] = row[i].length();
                }
            }
        }

        StringBuilder border = new StringBuilder("+");
        for (int width : widths) {
            border.append("-").append("-".repeat(width)).append("-+");
        }

        StringBuilder formatBuilder = new StringBuilder();
        for (int width : widths) {
            formatBuilder.append("| %-" ).append(width).append("s ");
        }
        formatBuilder.append("|\n");

        String borderLine = border.toString();
        String rowFormat = formatBuilder.toString();

        System.out.println(borderLine);
        System.out.printf(rowFormat, (Object[]) headers);
        System.out.println(borderLine);
        for (String[] row : rows) {
            System.out.printf(rowFormat, (Object[]) row);
        }
        System.out.println(borderLine);
    }
}