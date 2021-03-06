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
        System.out.println("Gamme de "+note+" : " + scale);
        Note tierce=scale.nth(5);
        System.out.println("Tierce de "+note+" dans "+scale+" : " + tierce );
        System.out.println(tierce+ " est la "+scale.getDegreeInt(tierce)+ " de "+ note);
        
        Quizz quizz = new Quizz();
        quizz.quizz();
        
        
        Scale mode = Mode.IONIAN.of(scale);
        System.out.println("Gamme de "+note+" en " + Mode.IONIAN + " mode : " + mode);

        Scale chord = Chord.major(mode);
        System.out.println("Major chord : " + chord);

        Guitar.display(chord, Guitar.STANDART_TUNING, 12);
    }

}
