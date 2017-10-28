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

    private static Team createTeamOrgAliance() {
        List<Character> teameList = new ArrayList<>();
        int i = (int) 0 + (int) (Math.random() * 2);
        if (i == 0) {
            teameList.addAll(createDataceOrgs());
            return new Team(teameList, "Оки");
        } else {
            teameList.addAll(createDataceNolivs());
            return new Team(teameList, "Нежить");
        }

    }

    private static Team createTeamHumanAliance() {
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


//    /**
//     * Выбираем случайные числа из
//     *
//     * @param start начало диапазона
//     * @param end   конец диапазона
//     * @return
//     */
//    private static int rand(int start, int end) {
//        return start + (int) (Math.random() * end);
//
//    }

    //создать отряд Эльфов
    private static ArrayList<Character> createDataceElf() {
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
    private static ArrayList<Character> createDataceHuman() {
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
    private static ArrayList<Character> createDataceOrgs() {
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
    private static ArrayList<Character> createDataceNolivs() {
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

//    //возвращает два отряда, противников.
//    private static List<ArrayList<Character>> selectDetachments() {
//        List<ArrayList<Character>> listResult = new ArrayList<ArrayList<Character>>();
//
//        if (rand(0, 2) == 0) {
//            listResult.add(createDataceElf());
//        } else listResult.add(createDataceHuman());
//
//        if (rand(0, 2) == 0) {
//            listResult.add(createDataceOrgs());
//        } else listResult.add(createDataceNolivs());
//
//        return listResult;
//    }

//    // рубимся
//    private static void fight(List<ArrayList<Character>> listFighters) {
//        // если есть живые в обеих командах продолжаем игру
//        while (isLive(listFighters.get(0)) && isLive(listFighters.get(1))) {
//
//            ArrayList<Character> list;// комманда атакующих
//
//            // выбираем команду атакующих
//            switch (rand(0, 2)) {
//
//                case 0:
//                    list = listFighters.get(0);
//
//                    //сортируем, сначала привелигерованные
//                    list.sort(new Comparator<Character>() {
//                        public int compare(Character o1, Character o2) {
//                            int result = 0;
//                            if (o1.isPrivileged() && o2.isPrivileged() || !o1.isPrivileged() && !o2.isPrivileged()) {
//                                result = 0;
//                            } else if (o1.isPrivileged() && !o2.isPrivileged()) {
//                                result = 1;
//                            } else if (!o1.isPrivileged() && o2.isPrivileged()) {
//                                result = -1;
//                            }
//                            return result;
//                        }
//
//                    });
//
//                    //атакуем по очереди каждым игроком.
//                    for (Character character : list) {
//
//                        //если маг
//                        if (character instanceof AttackMage) {
//                            switch (rand(0, 2)) {
//                                //добавить последнему игроку свое комманды улучшение
//                                case 0:
//                                    if (!list.get(list.size() - 1).isPrivileged()) {
//                                        ((AttackMage) character).giveAnImprovement(list.get(list.size() - 1));
//                                    }
//                                    // атакова любого игрока противника
//                                case 1:
//                                    //получить игрока
//                                    Character c = listFighters.get(1).get(rand(0, listFighters.get(1).size()));
//                                    //атакова
//                                    ((AttackMage) character).magicAttack(c);
//                                    //если умер, удалить из комманды
//                                    if (!c.isLive()) {
//                                        listFighters.get(1).remove(c);
//                                    }
//                            }
//                            coutn++;
//                        }
//
//                        // если стрелок
//                        if (character instanceof AttackArcher) {
//                            //получить игрока
//                            Character c = listFighters.get(1).get(rand(0, listFighters.get(1).size()));
//                            switch (rand(0, 2)) {
//
//                                //Стрелять
//                                case 0:
//                                    //атаковать
//                                    ((AttackArcher) character).shoot(c);
//                                    //если умер, удалить из комманды
//                                    if (!c.isLive()) {
//                                        listFighters.get(1).remove(c);
//                                    }
//
//                                    //Атакавать
//                                case 1:
//                                    //атаковать
//                                    ((AttackArcher) character).attackArcher(c);
//                                    //если умер, удалить из комманды
//                                    if (!c.isLive()) {
//                                        listFighters.get(1).remove(c);
//                                    }
//                            }
//                            coutn++;
//                        }
//
//                        //если воин
//                        if (character instanceof AttackWar) {
//                            //получить игрока
//                            Character c = listFighters.get(1).get(rand(0, listFighters.get(1).size()));
//                            //атакова
//                            ((AttackWar) character).attackWar(c);
//                            //если умер, удалить из комманды
//                            if (!c.isLive()) {
//                                listFighters.get(1).remove(c);
//                            }
//                            coutn++;
//                        }
//                    }
//
//                case 1:
//                    list = listFighters.get(1);
//                    //сортируем, сначала привелигерованные
//                    list.sort(new Comparator<Character>() {
//                        public int compare(Character o1, Character o2) {
//                            int result = 0;
//                            if (o1.isPrivileged() && o2.isPrivileged() || !o1.isPrivileged() && !o2.isPrivileged()) {
//                                result = 0;
//                            } else if (o1.isPrivileged() && !o2.isPrivileged()) {
//                                result = 1;
//                            } else if (!o1.isPrivileged() && o2.isPrivileged()) {
//                                result = -1;
//                            }
//                            return result;
//                        }
//
//                    });
//
//                    //атакуем по очереди каждым игроком.
//                    for (Character character : list) {
//
//                        //если маг
//                        if (character instanceof AttackMage) {
//                            switch (rand(0, 2)) {
//                                //добавить последнему игроку свое комманды улучшение
//                                case 0:
//                                    if (!list.get(list.size() - 1).isPrivileged()) {
//                                        ((AttackMage) character).giveAnImprovement(list.get(list.size() - 1));
//                                    }
//                                    // атакова любого игрока противника
//                                case 1:
//                                    //получить игрока
//                                    Character c = listFighters.get(0).get(rand(0, listFighters.get(0).size()));
//                                    //атакова
//                                    ((AttackMage) character).magicAttack(c);
//                                    //если умер, удалить из комманды
//                                    if (!c.isLive()) {
//                                        listFighters.get(0).remove(c);
//                                    }
//                            }
//                            coutn++;
//                        }
//
//                        // если стрелок
//                        if (character instanceof AttackArcher) {
//                            //получить игрока
//                            Character c = listFighters.get(0).get(rand(0, listFighters.get(0).size()));
//                            switch (rand(0, 2)) {
//
//                                //Стрелять
//                                case 0:
//                                    //атаковать
//                                    ((AttackArcher) character).shoot(c);
//                                    //если умер, удалить из комманды
//                                    if (!c.isLive()) {
//                                        listFighters.get(0).remove(c);
//                                    }
//
//                                    //Атакавать
//                                case 1:
//                                    //атаковать
//                                    ((AttackArcher) character).attackArcher(c);
//                                    //если умер, удалить из комманды
//                                    if (!c.isLive()) {
//                                        listFighters.get(0).remove(c);
//                                    }
//                            }
//                            coutn++;
//                        }
//
//                        //если воин
//                        if (character instanceof AttackWar) {
//                            //получить игрока
//                            Character c = listFighters.get(0).get(rand(0, listFighters.get(0).size()));
//                            //атакова
//                            ((AttackWar) character).attackWar(c);
//                            //если умер, удалить из комманды
//                            if (!c.isLive()) {
//                                listFighters.get(0).remove(c);
//                            }
//                            coutn++;
//                        }
//                    }
//            }
//        }
//
////        ищем победителя
//        for (ArrayList<Character> listCharact : listFighters) {
//            if (isLive(listCharact)) {
//                if (listCharact.get(0) instanceof ElfArcher || listCharact.get(0) instanceof ElfMag || listCharact.get(0) instanceof ElfWar)
//                    System.out.println(" Победили Эльфы");
//
//                if (listCharact.get(0) instanceof HumanArcher || listCharact.get(0) instanceof HumanMag || listCharact.get(0) instanceof HumanWar)
//                    System.out.println(" Победили Люди");
//
//                if (listCharact.get(0) instanceof OrgArcher || listCharact.get(0) instanceof OrgMag || listCharact.get(0) instanceof OrgWar)
//                    System.out.println(" Победили Огки");
//
//                if (listCharact.get(0) instanceof NoLivsArcher || listCharact.get(0) instanceof NoLivsMag || listCharact.get(0) instanceof NoLivsWar)
//                    System.out.println(" Победили Нежить");
//            }
//        }
//    }
//
////    // проверяем, что в отряде остались живые.
////    private static boolean isLive(ArrayList<Character> listDetach) {
////        boolean result = false;
////        for (Character aListDetach : listDetach) {
////            if (aListDetach.isLive()) {
////                result = true;
////            }
////        }
////        return result;
////    }
}

