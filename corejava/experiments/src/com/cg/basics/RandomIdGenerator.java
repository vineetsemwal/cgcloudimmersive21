package com.cg.basics;

import java.util.Random;

public class RandomIdGenerator {


    private Random random = new Random(10);

    public String generateId() {
        StringBuffer generated = new StringBuffer();
        for (int i = 0; i < 5; i++) {
            int randomNum = random.nextInt(99);
            generated.append(randomNum);
        }
        String generatedText = generated.toString();
        return generatedText;
    }

}