import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Dmitriy.Yakovlev
 * Created: 28.10.17 12:35
 * Copyright © LLP JazzSoft
 */
public class Team {

    //    название команды
    private String nameTeam;

    // состав команды
    private List<Character> characterList;

    public Team(List<Character> listCharacter, String nameTeam) {
        characterList = listCharacter;
        this.nameTeam=nameTeam;
    }

//  получить название команды
    public String getNameTeam() {
        return nameTeam;
    }
    //    сортировка по улучшению
    private void sortByPriority() {
        characterList.sort(new Comparator<Character>() {
            public int compare(Character o1, Character o2) {
                int result = 0;
                if (o1.isPrivileged() && o2.isPrivileged() || !o1.isPrivileged() && !o2.isPrivileged()) {
                    result = 0;
                } else if (o1.isPrivileged() && !o2.isPrivileged()) {
                    result = 1;
                } else if (!o1.isPrivileged() && o2.isPrivileged()) {
                    result = -1;
                }
                return result;
            }

        });
    }

    //    сделать ход
    public boolean makeMove(Team oponent) {
        sortByPriority();
        for (Character c : getLiveCharacterList()) {
            c.makeMove(this, oponent);
            if (!oponent.isSameOneAlive()) {
                return true;
            }
        }
        return false;
    }

    //    если кто-то жив
    public boolean isSameOneAlive() {
        boolean result = false;
        for (Character aListDetach : characterList) {
            if (aListDetach.isLive()) {
                result = true;
            }
        }
        return result;
    }

    //    список живых персонажей
    public List<Character> getLiveCharacterList() {
        ArrayList<Character> list = new ArrayList<>();
        for (Character c : characterList) {
            if (c.isLive()) {
                list.add(c);
            }
        }
        return list;
    }

    //    получить случайный живой персонаж
    public Character getRandomLiveCharacter() {
        int index = Random.randomInt(0, getLiveCharacterList().size() - 1);
        return getLiveCharacterList().get(index);
    }

}
