package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OddNumberExterminator {

    public List<Integer> exterminate(List<Integer> numbers){

        List<Integer> exterminate = new ArrayList<>();

        Iterator<Integer> iter = numbers.listIterator();
        while(iter.hasNext()){
            int temp = iter.next();
            if (temp % 2 == 0){
                exterminate.add(temp);
            }
        }
        return exterminate;
    };
}
