package ru.dima.game.utils;

import org.apache.log4j.Logger;

/**
 * Created by Dmitriy.Yakovlev
 * Created: 02.11.17 18:25
 * Copyright © LLP JazzSoft
 *
 * Логируем действия
 */
public class MyLog {
    public static void readLog(Logger log, int count,Object thisCharacter, Object character,Double attackPower, Boolean isLive){

        StringBuilder logStrBuilder = new StringBuilder();
        logStrBuilder.append("Ход - ");
        logStrBuilder.append(count);
        logStrBuilder.append(", атаковал - ");
        logStrBuilder.append(thisCharacter);
        logStrBuilder.append(", кого - ");
        logStrBuilder.append(character);
        logStrBuilder.append(", нанес урон - ");
        logStrBuilder.append(attackPower);
        if (!isLive) {
            logStrBuilder.append(" он умер!");
        }
        log.info(logStrBuilder);
    }

}
