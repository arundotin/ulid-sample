package com.arun;

import com.github.f4b6a3.ulid.UlidCreator;


import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ULIDMain {

    static void main() {
        List<String> ulids = getUlids(10);

        printUlids("Generated Ulids", ulids);

        Collections.shuffle(ulids);

        printUlids("After Shuffling ..", ulids);

        Collections.sort(ulids);

        printUlids("After Sorting ...",ulids);
    }

    private static void printUlids(String message, List<String> ulids) {
        System.out.println(message);
        System.out.println("---------");
        ulids.forEach(System.out::println);
        System.out.println("---------");
    }


    private static List<String> getUlids(int totalNumberOfUlidsRequired) {


        List<String> ulids = IntStream.range(0, totalNumberOfUlidsRequired)
                .mapToObj(_ -> getUlid())
                .collect(Collectors.toList());

        return ulids;

    }

    private static String getUlid() {
        try {
            // Just to make the timestamp difference visible
            Thread.sleep(10);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return UlidCreator.getUlid().toString();
    }


}