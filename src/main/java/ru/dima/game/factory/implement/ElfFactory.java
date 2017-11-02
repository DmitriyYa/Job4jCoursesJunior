package ru.dima.game.factory.implement;

import ru.dima.game.character.implement.ElfArcher;
import ru.dima.game.character.implement.ElfMag;
import ru.dima.game.character.implement.ElfWar;
import ru.dima.game.factory.TeamFactory;

/**
 * Created by Dmitriy.Yakovlev
 * Created: 02.11.17 19:03
 * Copyright © LLP JazzSoft
 *
 * Создаем фабрику Ельфов
 */
public class ElfFactory extends TeamFactory {
    @Override
    public ElfArcher createArcher() {
        return new ElfArcher();
    }

    @Override
    public ElfMag createMage() {
        return new ElfMag();
    }

    @Override
    public ElfWar createWar() {
        return new ElfWar();
    }
}
