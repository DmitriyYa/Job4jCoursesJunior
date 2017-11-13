package ru.dima.collections_pro.iterator;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Создать итератор возвращающий только простые числа.
 * Простым является натуральное число больше 1, которое делится без остатка только на 1 и на себя.
 * <p>
 * Итератор должен принимать список произвольных чисел.
 * <p>
 * public PrimeIt(final int[] numbers) {
 * <p>
 * Iterator it = new PrimetIt(new int[] {3, 4, 5, 6, 7});
 * <p>
 * методы
 * <p>
 * it.next() - возвращают только простые числа. В этом примере - это 3, 5 и 7.
 * <p>
 * it.hasNext() - возвращает true, только если в массиве есть простые числа перед указателем.
 */
public class IteratorPrimes implements Iterator {

    /**
     * массив данных
     */
    private final int[] values;

    /**
     * счетчик
     */
    private int index = 0;


    public IteratorPrimes(int[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        for (int i = index; i < values.length; i++) {
            if (isPrime(values[i])) {
                index=i; //1. сделай. чтобы в методе hasNext переводиться указатель на простое число.
                return true;
            }
        }
        return false;
    }

    @Override
    public Object next() {
        if (!hasNext()){
            throw new NoSuchElementException();
        }
        else {
            return values[index++];
        }
    }

    /**
     *
     * @param i число для проверки.
     * @return простое ли число.
     */
    private boolean isPrime(int i) {
        Integer integer = i;
        if (i==1){
            return false;
        }
        BigInteger bigInteger = BigInteger.valueOf(integer);
        return bigInteger.isProbablePrime((int) Math.log(integer));
    }
}
