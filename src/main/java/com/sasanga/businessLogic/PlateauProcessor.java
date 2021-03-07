package com.sasanga.businessLogic;

import com.sasanga.models.PlateauMaxXandY;

import java.util.Arrays;

public class PlateauProcessor {

    public static PlateauMaxXandY getMaxXandY(String coordinatesStr) {
        int[] arr = Arrays.stream(coordinatesStr.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        return new PlateauMaxXandY(arr[0], arr[1]);
    }
}
