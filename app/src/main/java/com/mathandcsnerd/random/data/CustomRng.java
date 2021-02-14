package com.mathandcsnerd.random.data;

import java.security.SecureRandom;

import static java.lang.Math.abs;

public class CustomRng {
    private static SecureRandom rng = new SecureRandom();

    public int getNumOutOf(int mod){
        return (abs(rng.nextInt()) % mod)+1;
    }
}
