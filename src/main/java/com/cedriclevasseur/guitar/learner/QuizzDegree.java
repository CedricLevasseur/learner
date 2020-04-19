package com.cedriclevasseur.guitar.learner;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import net.thecodersbreakfast.guitar.*;

/**
 * @author Cedric
 */
public class QuizzDegree {

    public static void main(String[] args) {
        Note note = null;
        String noteStr = null;
        while (note == null) {

            try {
                System.out.println("Reading a note (" + Arrays.asList(Note.values()) + ")");
                Scanner s = new Scanner(System.in);
                noteStr = s.nextLine();
                note = Note.readFromString(noteStr);
                
            } catch (java.lang.IllegalArgumentException iae) {
                note=null;
                System.out.println("There's no note named "+noteStr+" in "+Arrays.asList(Note.values()));
            }

        }

        Scale scale = Scale.of(note);
        System.out.println("Scale of "+note+" : " + scale);

        Scale mode = Mode.IONIAN.of(scale);
        System.out.println("Scale of "+note+" in " + Mode.IONIAN + " mode : " + mode);

        Scale chord = Chord.major(mode);
        System.out.println("Major chord : " + chord);

        Guitar.display(chord, Guitar.STANDART_TUNING, 12);
    }

}
