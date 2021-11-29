package me.guillaume.recruitment.tournament.fighter;

import me.guillaume.recruitment.tournament.weapon.OneHandAxe;

/**
 * Component  responsible to create a new viking
 */
public class Viking extends Fighter<Viking> {
    public Viking() {
        super(120, new OneHandAxe());
    }
}
