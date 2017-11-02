package ru.dima.game.factory.implement;

import ru.dima.game.character.implement.OrgArcher;
import ru.dima.game.character.implement.OrgMag;
import ru.dima.game.character.implement.OrgWar;
import ru.dima.game.factory.TeamFactory;

/**
 * Created by Dmitriy.Yakovlev
 * Created: 02.11.17 22:01
 * Copyright © LLP JazzSoft
 *
 * Создаем фабрику Орков
 */
public class OrgFactory extends TeamFactory {
    @Override
    public OrgArcher createArcher() {
        return new OrgArcher();
    }

    @Override
    public OrgMag createMage() {
        return new OrgMag();
    }

    @Override
    public OrgWar createWar() {
        return new OrgWar();
    }
}
