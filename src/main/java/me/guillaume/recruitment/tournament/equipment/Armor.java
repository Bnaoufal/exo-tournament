package me.guillaume.recruitment.tournament.equipment;

import me.guillaume.recruitment.tournament.weapon.Weapon;

/**
 * Armor class reduce all received damages by 3 & reduce delivered damages by one
 */
public final class Armor extends Equipment {

    @Override
    public int whenDamageDealt(int damage, Class<? extends Weapon> weaponType) {
        return damage - 3;
    }

}
