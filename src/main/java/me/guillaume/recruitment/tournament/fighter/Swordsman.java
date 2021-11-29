package me.guillaume.recruitment.tournament.fighter;

import me.guillaume.recruitment.tournament.weapon.OneHandSword;

/**
 * Component  responsible to create a new Swordsman
 */
public class Swordsman extends Fighter<Swordsman> {
    public Swordsman() {
        super(100, new OneHandSword());
    }
}
