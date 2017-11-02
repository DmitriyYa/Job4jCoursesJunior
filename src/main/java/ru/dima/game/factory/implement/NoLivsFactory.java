package ru.dima.game.factory.implement;

import ru.dima.game.character.implement.NoLivsArcher;
import ru.dima.game.character.implement.NoLivsMag;
import ru.dima.game.character.implement.NoLivsWar;
import ru.dima.game.factory.TeamFactory;

/**
 * Created by Dmitriy.Yakovlev
 * Created: 02.11.17 22:02
 * Copyright © LLP JazzSoft
 *
 * Создаем фабрику Нежити
 */
public class NoLivsFactory extends TeamFactory {
    @Override
    public NoLivsArcher createArcher() {
        return new NoLivsArcher();
    }

    @Override
    public NoLivsMag createMage() {
        return new NoLivsMag();
    }

    @Override
    public NoLivsWar createWar() {
        return new NoLivsWar();
    }
}
