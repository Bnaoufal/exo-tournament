package me.guillaume.recruitment.tournament.equipment;

import me.guillaume.recruitment.tournament.weapon.OneHandAxe;
import me.guillaume.recruitment.tournament.weapon.Weapon;

/**
 * Buckler class cancel all the damages of a blow one time out of two
 * and  is destroyed after blocking 3 blow from an axe
 */
public final class Buckler extends Equipment {
    private int dealt = 0;
    private int dealtWithAxe = 0;

    @Override
    public int whenDamageDealt(int damage, Class<? extends Weapon> weaponType) {
        if (dealtWithAxe < 3) {
            if (dealt++ % 2 == 0) {
                if (OneHandAxe.class == weaponType) {
                    dealtWithAxe++;
                }
                return 0;
            } else {
                return damage;
            }
        } else {
            return damage;
        }
    }

}
