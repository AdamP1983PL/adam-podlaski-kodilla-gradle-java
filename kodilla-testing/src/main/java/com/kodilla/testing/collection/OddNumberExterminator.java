package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OddNumberExterminator {


    public  List<Integer> exterminate(List<Integer> numbers) {

        List<Integer> exterminate = new ArrayList<>();

        Iterator<Integer> iterator = numbers.listIterator();
        while (iterator.hasNext()) {
            int temp = iterator.next();
            if (temp % 2 == 0){
                exterminate.add(temp);
            }
        }
        return exterminate;
    }
}
