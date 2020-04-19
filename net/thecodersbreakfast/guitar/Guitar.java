package net.thecodersbreakfast.guitar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Olivier Croisier
 */
public final class Guitar {

    public static final Scale STANDART_TUNING = new Scale(Note.E, Note.A, Note.D, Note.G, Note.B, Note.E);

    public static final int NB_FRETS = 21;

    private Guitar() {
    }


    public static void display(Scale scale) {
        display(scale, STANDART_TUNING, NB_FRETS);
    }

    public static void display(Scale scale, Scale tuning, int nbFrets) {

        Note[] notes = scale.getNotes();
        Arrays.sort(notes);

        // Display fret numbers
        for(int i=0; i<=nbFrets; i++) {
            if (i==3 || i==5 || i==7 || i==9 || i==12 || i==15 || i==17 || i==19 || i== NB_FRETS) {
                System.out.printf("   %-2d  ",i);
            } else {
                System.out.print("       ");                
            }
        }
        System.out.println();

        // Reverse the strings to print them bottom-up
        List<Note> tuningNotes = new ArrayList<Note>(Arrays.asList(tuning.getNotes()));
        Collections.reverse(tuningNotes);

        // Display notes on the neck
        for(Note rootNote : tuningNotes) {
            for(int i=0; i<=nbFrets; i++) {

                Note n = rootNote.nth(i);
                if ( Arrays.binarySearch(notes, n) >= 0) {
                    System.out.printf("--%-2s--|", n);
                } else {
                    System.out.print("------|");
                }

                if (i==0) {
                    System.out.print("|");
                }

            }
            System.out.println();
        }

    }

}
