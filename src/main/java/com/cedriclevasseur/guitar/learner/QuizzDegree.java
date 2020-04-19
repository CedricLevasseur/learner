package com.cedriclevasseur.guitar.learner;

import net.thecodersbreakfast.guitar.*;

/**
 * @author Cedric
 */
public class QuizzDegree {

    public static void main(String[] args) {

        Scale scale = Scale.of(Note.C);
        System.out.println("Scale of C : " + scale);

        Scale mode = Mode.IONIAN.of(scale);
        System.out.println("Scale of C in " + Mode.IONIAN + " mode : " + mode);

        Scale chord = Chord.major(mode);
        System.out.println("Major chord : " + chord);

        Guitar.display(chord, Guitar.STANDART_TUNING, 12);
    }

}
