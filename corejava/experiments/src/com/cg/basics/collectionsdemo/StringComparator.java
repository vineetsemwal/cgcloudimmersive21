package com.cg.basics.collectionsdemo;

import java.util.Comparator;

public class StringComparator implements Comparator<String> {
    @Override
    public int compare(String e1, String e2) {
        return e1.compareTo(e2);
    }
}
