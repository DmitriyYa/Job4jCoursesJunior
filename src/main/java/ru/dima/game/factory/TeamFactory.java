package ru.dima.game.factory;

import ru.dima.game.character.Character;

/**
 * Created by Dmitriy.Yakovlev
 * Created: 02.11.17 18:58
 * Copyright © LLP JazzSoft
 *
 * Абстрактная фабрика
 */
public abstract class TeamFactory {

    public abstract Character createArcher();

    public abstract Character createMage();

    public abstract Character createWar();
}
