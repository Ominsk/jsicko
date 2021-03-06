/*
 * Copyright (C) 2018 Andrea Mocci and CodeLounge https://codelounge.si.usi.ch
 *
 * This file is part of jSicko - Java SImple Contract checKer.
 *
 *  jSicko is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 * jSicko is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with jSicko.  If not, see <https://www.gnu.org/licenses/>.
 *
 */

package ch.usi.si.codelounge.jsicko.tutorials.simple;

import ch.usi.si.codelounge.jsicko.Contract;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MathTest {

    @Test
    public void sqrtWithNegativeArgument() throws Throwable {
        Executable testFixture = () -> Math.sqrt(-1.0);
        assertThrows(Contract.PreconditionViolation.class, testFixture);
    }

    @Test
    public void sqrtWithPositiveArgument() throws Throwable {
        Math.sqrt(4.0);
    }

    @Test
    public void badSqrtReturnsViolation() throws Throwable {
        Executable testFixture = () -> Math.badsqrt(4.0);
        assertThrows(Contract.PostconditionViolation.class, testFixture);
    }

    @Test void arrayMaxTestNullViolatesPrecondition() throws Throwable {
        Executable textFixture = () -> Math.max(null);
        assertThrows(Contract.PreconditionViolation.class, textFixture);
    }

    @Test void arrayMaxTestEmptyViolatesPrecondition() throws Throwable {
        Executable testFixture = () -> Math.max(new int[0]);
        assertThrows(Contract.PreconditionViolation.class, testFixture);
    }

    @Test void arrayMaxTestOneElement() {
        int[] elems = {1};
        var maxElem = Math.max(elems);
        assertEquals(maxElem,1);
    }

    @Test void arrayMaxTestTwoElements() {
        int[] elems = {1,2};
        var maxElem = Math.max(elems);
        assertEquals(maxElem,2);
    }

}
