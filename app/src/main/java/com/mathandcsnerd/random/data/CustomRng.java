/* Copyright 2021 Matthew Macallister
 *
 * This file is part of MACSN Simple Rng App.
 *
 * MACSN Simple Rng App is free software: you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * MACSN Simple Rng App is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with MACSN Simple Rng App.  If not, see
 * <https://www.gnu.org/licenses/>.
 */

package com.mathandcsnerd.random.data;

import java.security.SecureRandom;

import static java.lang.Math.abs;

public class CustomRng {
    private static SecureRandom rng = new SecureRandom();

    public int getNumOutOf(int mod){
        return (abs(rng.nextInt()) % mod)+1;
    }
}
