package me.guillaume.recruitment.tournament.fighter;

import me.guillaume.recruitment.tournament.equipment.Armor;
import me.guillaume.recruitment.tournament.equipment.Equipment;
import me.guillaume.recruitment.tournament.equipment.EquipmentFactory;
import me.guillaume.recruitment.tournament.weapon.Weapon;

import java.util.ArrayList;
import java.util.List;

/**
 * Class responsible to create  a new fighter
 * this component will be used to create Swodrsman and Vinking
 */
public abstract class Fighter<F extends Fighter<F>> {

    private int hitPoint;
    private final Weapon weapon;
    private final List<Equipment> equipments;


    /**
     * Constructor with two dependencies
     *
     * @param hitPoint number of hitpoint
     * @param weapon   the weapon used
     */
    public Fighter(int hitPoint, Weapon weapon) {
        this.hitPoint = hitPoint;
        this.weapon = weapon;
        equipments = new ArrayList<>();
    }


    public final F equip(final String equipment) {
        equipments.add(EquipmentFactory.getEquipment(equipment));

        final F subFighter = (F) this;

        return subFighter;
    }

    /**
     * @return damage
     */
    private final int damage() {
        int damage = weapon.dmg();

        if (equipments.stream()
                .map(Object::getClass)
                .anyMatch(Armor.class::equals)) {
            damage--;
        }

        return damage;
    }


    /**
     * Engage a fight using current fighter
     *
     * @param fighter the fighter how should engage
     */
    public final void engage(final Fighter<?> fighter) {
        while (hitPoint > 0 && fighter.hitPoint > 0) {
            Fighter.engage(this, fighter);
            Fighter.engage(fighter, this);
        }
    }

    /**
     * Engage a fight using fighters in parameter
     *
     * @param a the fighter a
     * @param b the fighter b
     */
    private static void engage(final Fighter<?> a, final Fighter<?> b) {
        int fighter1Damage = a.damage();

        if (fighter1Damage > 0) {
            for (final Equipment fighter2Equipment : b.equipments) {
                fighter1Damage = fighter2Equipment.whenDamageDealt(fighter1Damage, a.weapon.getClass());

                if (fighter1Damage <= 0) {
                    break;
                }
            }

            if (fighter1Damage > 0) {
                b.hitPoint -= fighter1Damage;

                if (b.hitPoint < 0) {
                    b.hitPoint = 0;
                }
            }
        }
    }


    /**
     * @return hitPoint
     */
    public final int hitPoints() {
        return hitPoint;
    }
}
