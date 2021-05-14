package com.cg.basics.collectionsdemo;

import java.util.Comparator;

public class DescendingNameComparator implements Comparator<String> {

    @Override
    public int compare(String e1, String e2) {
        return e2.compareTo(e1);
    }
}
