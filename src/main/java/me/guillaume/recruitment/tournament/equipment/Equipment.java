package me.guillaume.recruitment.tournament.equipment;

import me.guillaume.recruitment.tournament.weapon.Weapon;

public abstract class Equipment {

    public abstract int whenDamageDealt(int damage, final Class<? extends Weapon> weaponType);
}
