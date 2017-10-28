import org.apache.log4j.Logger;

/**
 * Created by Dmitriy.Yakovlev
 * Created: 28.10.17 12:52
 * Copyright © LLP JazzSoft
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

    public void runGame() {
        System.out.println("Начинаем игру.");
        log.info("Начинаем игру.");
        while (true) {
            boolean ended = iteration();
            if (ended) {
                System.out.println("ирга закончена.");
                log.info("ирга закончена.");
                if (team1.isSameOneAlive()){
                    System.out.println("Победили - "+team1.getNameTeam());
                    log.info("Победили - "+team1.getNameTeam());
                }
                else {
                    System.out.println("Победили - "+team2.getNameTeam());
                    log.info("Победили - "+team2.getNameTeam());
                }

                return;
            }
        }
    }

    public boolean iteration() {
        int i = 0 + (int) (Math.random() * 2);
        boolean ended;

        if (i == 0) {
            ended = team1.makeMove(team2);
        } else {
            ended = team2.makeMove(team1);
        }
        return ended;
    }
}
