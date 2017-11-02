package ru.dima.game;

import ru.dima.game.alianse.Team;
import ru.dima.game.character.Character;
import ru.dima.game.factory.TeamFactory;
import ru.dima.game.factory.implement.ElfFactory;
import ru.dima.game.factory.implement.HumanFactory;
import ru.dima.game.factory.implement.NoLivsFactory;
import ru.dima.game.factory.implement.OrgFactory;
import ru.dima.game.gameoneteam.Game;
import ru.dima.game.utils.Random;

import java.util.ArrayList;
import java.util.List;

/**
 * Создать прототип игры-консольного приложения на языке Java.
 * При выполнении задания пользоваться системами контроля версий (GitHub, Bitbucket…).
 * <p>
 * В игре создается отряд определенной расы, состоящий из одного мага, трех лучников и четырех бойцов.
 * Предусмотрено четыре расы: эльфы, люди, орки, нежить. Эльфы и люди играют против орков и нежити.
 * <p>
 * В начале игры случайным образом создаются два враждующих отряда той или иной расы.
 * Все персонажи отряда делятся на две группы: обычные и привилегированные (с улучшенными показателями).
 * Персонаж при наложении на него улучшения перемещается в привилегированную группу.
 * Величина наносимого урона для персонажей привилегированной группы увеличивается в полтора раза.
 * <p>
 * Порядок ходов для рас определяется случайным образом.
 * За один ход каждый персонаж отряда может выполнить действие (действие определяется случайным образом):
 * сначала из привилегированной группы, а если она пуста, тогда из общего списка персонажей отряда рандомно.
 * Персонаж из привилегированной группы после выполнения одного действия перемещается в общую группу.
 * <p>
 * Возможности персонажей:
 * <p>
 * Раса эльфов:
 * маг:
 * наложение улучшения на персонажа своего отряда
 * нанесение урона персонажу противника магией на 10 HP
 * лучник:
 * стрелять из лука (нанесение урона 7 HP)
 * атаковать противника (нанесение урона 3 HP)
 * воин:
 * атаковать мечом (нанесение урона 15 HP)
 * <p>
 * Раса людей:
 * маг:
 * наложение улучшения на персонажа своего отряда.
 * атаковать магией (нанесение урона 4 HP)
 * <p>
 * арбалетчик:
 * стрелять из арбалета (нанесение урона 5 HP)
 * атаковать (нанесение урона 3 HP)
 * воин:
 * атаковать мечом (нанесение урона 18 HP)
 * <p>
 * Раса орков:
 * шаман:
 * наложение улучшения на персонажа своего отряда.
 * наложение проклятия (снятие улучшения с персонажа противника для следующего хода)
 * лучник:
 * стрелять из лука (нанесение урона 3 HP)
 * удар клинком (нанесение урона 2 HP)
 * гоблин:
 * атака дубиной (нанесение урона 20 HP)
 * <p>
 * Раса нежити:
 * некромант:
 * наслать недуг (уменьшение силы урона персонажа противника на 50% на один ход)
 * атака (нанесение урона 5 HP)
 * охотник:
 * стрелять из лука (нанесение урона 4 HP)
 * атаковать (нанесение урона 2 HP)
 * зомби:
 * удар копьем (нанесение урона 18 HP)
 * <p>
 * С начала игры каждый персонаж имеет уровень жизни равный 100 HP.
 * <p>
 * Выводить ход игры в консоль: вести статистику ходов с порядком ходов (кто, кого, нанесенный урон, умер).
 * По завершении игры сохранять лог в файл.
 * <p>
 * 1. Создать абстрактный класс описывающий все пресонажи.
 * 2. Создать классы описывающие персонажы(маг, лучник, воин).
 * 3. Создать интерфейсы поведения персонажей и реализовать их в классах.
 * 4. Реализовать сценарий игры в ru.dima.game.Main.java
 */
public class Main {

    public static void main(String[] args) {

        Team team1 = createTeamHumanAliance();
        Team team2 = createTeamOrgAliance();
        Game game = new Game(team1, team2);
        game.runGame();
    }

    /**
     * выбрать команду из орков
     *
     * @return команду орков
     */
    private static Team createTeamOrgAliance() {
        List<Character> teameList = new ArrayList<>();
        int i = Random.randomInt(0, 2);
        if (i == 0) {
            teameList.addAll(createDatace(new OrgFactory()));
            return new Team(teameList, "Орки");
        } else {
            teameList.addAll(createDatace(new NoLivsFactory()));
            return new Team(teameList, "Нежить");
        }

    }

    /**
     * выбрать команду людей
     *
     * @return команду людей
     */
    private static Team createTeamHumanAliance() {
        List<Character> teameList = new ArrayList<>();
        int i = Random.randomInt(0, 2);
        if (i == 0) {
            teameList.addAll(createDatace(new ElfFactory()));
            return new Team(teameList, "Эльфы");
        } else {
            teameList.addAll(createDatace(new HumanFactory()));
            return new Team(teameList, "Люди");
        }
    }


    //создать отряд
    private static ArrayList<Character> createDatace(TeamFactory teamFactory) {
        ArrayList<Character> list = new ArrayList<Character>();

        list.add(teamFactory.createMage());

        for (int i = 0; i < 3; i++) {
            list.add(teamFactory.createArcher());
        }

        for (int i = 0; i < 4; i++) {
            list.add(teamFactory.createWar());
        }
        return list;
    }

}

