package ru.dima.game.gameoneteam;

import org.apache.log4j.Logger;
import ru.dima.game.alianse.Team;
import ru.dima.game.utils.Random;

/**
 * Created by Dmitriy.Yakovlev
 * Created: 28.10.17 12:52
 * Copyright © LLP JazzSoft
 *
 * Игра
 */
public class Game {
    private static final Logger log = Logger.getLogger(Game.class);

    public static int count;
    private Team team1;
    private Team team2;

    public Game(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
    }

    /**
     * Реализация игры
     */
    public void runGame() {
        log.info("Начинаем игру.");
        while (true) {
            boolean ended = iteration();
            if (ended) {
                log.info("ирга закончена.");
                if (team1.isSameOneAlive()){
                    log.info("Победили - "+team1.getNameTeam());
                }
                else {
                    log.info("Победили - "+team2.getNameTeam());
                }

                return;
            }
        }
    }

    private boolean iteration() {
        int i = Random.randomInt(0, 2);
        boolean ended;

        if (i == 0) {
            ended = team1.makeMove(team2);
        } else {
            ended = team2.makeMove(team1);
        }
        return ended;
    }
}
