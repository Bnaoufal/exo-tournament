package me.guillaume.recruitment.tournament.weapon;


/**
 * GreatSword class with 2 hand sword  that cause 12 damages, but can attack only 2 every 3
 */
public final class GreatSword extends Weapon {
    private int damageCounter = -1;

    @Override
    public int dmg() {
        damageCounter++;

        if (damageCounter % 3 <= 1) {
            return 12;
        } else {
            return 0;
        }
    }

}
