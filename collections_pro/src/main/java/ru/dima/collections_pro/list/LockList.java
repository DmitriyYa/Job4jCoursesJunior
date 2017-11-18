package ru.dima.collections_pro.list;

/**
 * 5.3.4. Задан связанный список. Определить цикличность. [#161]
 * <p>
 * Задан связанный список.
 * <p>
 * class Node<T> {
 * T value;
 * Node<T> next;
 * }
 * <p>
 * Node first = new Node(1);
 * Node two = new Node(2);
 * Node third = new Node(3);
 * Node four = new Node(4);
 * <p>
 * first.next = two;
 * two.next = third;
 * third.next = four;
 * four.next = first;
 * <p>
 * Написать алгоритм определяющий, что список содержит замыкания.
 * <p>
 * boolean hasCycle(Node first);
 * <p>
 * Обратите внимание, что список может быть замкнут и в середине.
 * К примеру, 3-й узел будет ссылаться на 2-й узел. Определение зацикленности необходимо реализовать путем прохода по узлам, без использования коллекций.
 */
public class LockList<T> {

    /**
     * @param first первый элемент списка.
     * @return true если есть замыкание.
     */
    public boolean hasCycle(Node first) {

        boolean isTrue = true;
        boolean result=false;
        Node agentA = first;
        Node agentB = agentA.next;

        while (isTrue) {
            agentA = agentA.next;
            while (isTrue) {
                if (agentA == null || agentB == null || agentB.next == null) {
                    return result;
                }
                agentB = agentB.next;
                if (agentA == agentB) {
                    isTrue = false;
                    result=true;
                }
            }
        }
        return result;
    }


    static class Node<T> {

        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }

    }
}
