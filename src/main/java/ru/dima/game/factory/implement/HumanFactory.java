package ru.dima.game.factory.implement;

import ru.dima.game.character.implement.HumanArcher;
import ru.dima.game.character.implement.HumanMag;
import ru.dima.game.character.implement.HumanWar;
import ru.dima.game.factory.TeamFactory;

/**
 * Created by Dmitriy.Yakovlev
 * Created: 02.11.17 22:00
 * Copyright © LLP JazzSoft
 *
 * Создаем фабрику Людей
 */
public class HumanFactory extends TeamFactory {
    @Override
    public HumanArcher createArcher() {
        return new HumanArcher();
    }

    @Override
    public HumanMag createMage() {
        return new HumanMag();
    }

    @Override
    public HumanWar createWar() {
        return new HumanWar();
    }
}
