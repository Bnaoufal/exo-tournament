package me.guillaume.recruitment.tournament.fighter;

import me.guillaume.recruitment.tournament.weapon.GreatSword;

/**
 * Component  responsible to create a new Highlander
 */
public final class Highlander extends Fighter<Highlander> {
    public Highlander() {
        super(150, new GreatSword());
    }
}
