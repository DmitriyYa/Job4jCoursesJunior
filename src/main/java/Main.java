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
 * 4. Реализовать сценарий игры в Main.java
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
     * @return команду орков
     */
     static Team createTeamOrgAliance() {
        List<Character> teameList = new ArrayList<>();
        int i = (int) 0 + (int) (Math.random() * 2);
        if (i == 0) {
            teameList.addAll(createDataceOrgs());
            return new Team(teameList, "Орки");
        } else {
            teameList.addAll(createDataceNolivs());
            return new Team(teameList, "Нежить");
        }

    }

    /**
     * выбрать команду людей
     * @return команду людей
     */
     static Team createTeamHumanAliance() {
        List<Character> teameList = new ArrayList<>();
        int i = (int) 0 + (int) (Math.random() * 2);
        if (i == 0) {
            teameList.addAll(createDataceElf());
            return new Team(teameList, "Эльфы");
        } else {
            teameList.addAll(createDataceHuman());
            return new Team(teameList, "Люди");
        }
    }

    //создать отряд Эльфов
     static ArrayList<Character> createDataceElf() {
        ArrayList<Character> listElf = new ArrayList<Character>();
        ElfMag elfMag = new ElfMag();
        listElf.add(elfMag);
        ElfArcher elfArcher1 = new ElfArcher();
        listElf.add(elfArcher1);
        ElfArcher elfArcher2 = new ElfArcher();
        listElf.add(elfArcher2);
        ElfArcher elfArcher3 = new ElfArcher();
        listElf.add(elfArcher3);
        ElfWar elfWar1 = new ElfWar();
        listElf.add(elfWar1);
        ElfWar elfWar2 = new ElfWar();
        listElf.add(elfWar2);
        ElfWar elfWar3 = new ElfWar();
        listElf.add(elfWar3);
        ElfWar elfWar4 = new ElfWar();
        listElf.add(elfWar4);
        return listElf;
    }

    //создать отряд Людей
     static ArrayList<Character> createDataceHuman() {
        ArrayList<Character> listHuman = new ArrayList<Character>();
        HumanMag humanMag = new HumanMag();
        listHuman.add(humanMag);
        HumanArcher humanArcher1 = new HumanArcher();
        listHuman.add(humanArcher1);
        HumanArcher humanArcher2 = new HumanArcher();
        listHuman.add(humanArcher2);
        HumanArcher humanArcher3 = new HumanArcher();
        listHuman.add(humanArcher3);
        HumanWar humanWar1 = new HumanWar();
        listHuman.add(humanWar1);
        HumanWar humanWar2 = new HumanWar();
        listHuman.add(humanWar2);
        HumanWar humanWar3 = new HumanWar();
        listHuman.add(humanWar3);
        HumanWar humanWar4 = new HumanWar();
        listHuman.add(humanWar4);
        return listHuman;
    }

    //создать отряд Орков
     static ArrayList<Character> createDataceOrgs() {
        ArrayList<Character> listOrg = new ArrayList<Character>();
        OrgMag orgMag = new OrgMag();
        listOrg.add(orgMag);
        OrgArcher orgArcher1 = new OrgArcher();
        listOrg.add(orgArcher1);
        OrgArcher orgArcher2 = new OrgArcher();
        listOrg.add(orgArcher2);
        OrgArcher orgArcher3 = new OrgArcher();
        listOrg.add(orgArcher3);
        OrgWar orgWar1 = new OrgWar();
        listOrg.add(orgWar1);
        OrgWar orgWar2 = new OrgWar();
        listOrg.add(orgWar2);
        OrgWar orgWar3 = new OrgWar();
        listOrg.add(orgWar3);
        OrgWar orgWar4 = new OrgWar();
        listOrg.add(orgWar4);
        return listOrg;
    }

    //создать отряд Нежити
     static ArrayList<Character> createDataceNolivs() {
        ArrayList<Character> listNoLivs = new ArrayList<Character>();
        NoLivsMag noLivsMag = new NoLivsMag();
        listNoLivs.add(noLivsMag);
        NoLivsArcher noLivsArcher1 = new NoLivsArcher();
        listNoLivs.add(noLivsArcher1);
        NoLivsArcher noLivsArcher2 = new NoLivsArcher();
        listNoLivs.add(noLivsArcher2);
        NoLivsArcher noLivsArcher3 = new NoLivsArcher();
        listNoLivs.add(noLivsArcher3);
        NoLivsWar noLivsWar1 = new NoLivsWar();
        listNoLivs.add(noLivsWar1);
        NoLivsWar noLivsWar2 = new NoLivsWar();
        listNoLivs.add(noLivsWar2);
        NoLivsWar noLivsWar3 = new NoLivsWar();
        listNoLivs.add(noLivsWar3);
        NoLivsWar noLivsWar4 = new NoLivsWar();
        listNoLivs.add(noLivsWar4);
        return listNoLivs;
    }

}

