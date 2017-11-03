package ru.dima.game.character.implement;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Dmitriy.Yakovlev
 * Created: 03.11.17 18:25
 * Copyright © LLP JazzSoft
 */
public class ElfArcherTest {

    @Test
    public void shoot() {
        ElfArcher elfArcher = new ElfArcher();
        OrgArcher orgArcher = new OrgArcher();
        elfArcher.shoot(orgArcher);
        assertEquals(orgArcher.getLiveValue(),93.0);

        ElfArcher elfArcher1=new ElfArcher();
        OrgArcher orgArcher1=new OrgArcher();
        elfArcher1.setPrivileged(true);
        elfArcher1.shoot(orgArcher1);
        assertEquals(orgArcher1.getLiveValue(),89.5);
    }

    @Test
    public void attackArcher() {
        ElfArcher elfArcher = new ElfArcher();
        OrgArcher orgArcher = new OrgArcher();
        elfArcher.attackArcher(orgArcher);
        assertEquals(orgArcher.getLiveValue(),97.0);

        ElfArcher elfArcher1 = new ElfArcher();
        OrgArcher orgArcher1 = new OrgArcher();
        elfArcher1.setPrivileged(true);
        elfArcher1.attackArcher(orgArcher1);
        assertEquals(orgArcher1.getLiveValue(),95.5);
    }

}