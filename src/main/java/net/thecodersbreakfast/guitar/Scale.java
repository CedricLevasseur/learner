package net.thecodersbreakfast.guitar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import static net.thecodersbreakfast.guitar.ConsoleColors.*;

/**
 * Une suite ascendante de notes = Gamme
 * @author Olivier Croisier
 */
public class Scale implements Iterable<Note> {

    // Suite des 12 notes a partir de celle-ci
    public static Scale of(Note root) {
        Note[] allNotes = Note.values();
        int rootPos = root.ordinal();
        List<Note> scaleNotes = new ArrayList<Note>();
        for (int i=0; i<Note.NBNOTES; i++) {
          scaleNotes.add(allNotes[ (rootPos+i) % Note.NBNOTES ]);
        }
        return new Scale(scaleNotes);
    }

    private final List<String> degresName = Arrays.asList("Fondamentale","Seconde mineure","Seconde Majeure","Tierce mineure","Tierce Majeure", "Quarte parfaite", "Quinte dimunée","Sixte mineure","Sixte Majeure","Septième mineure","Septième Majeure"); 
    private final List<String> degresNameInt = Arrays.asList("R","b2","M2","b3","M3", "P4", "#4/b5","P5","b6","M6","b7","M7"); 
    private final List<String> degresColors = Arrays.asList(WHITE_BOLD,YELLOW,YELLOW,RED,RED_BOLD,CYAN,RED,BLUE,GREEN,PURPLE,BLUE,BLUE);

    protected List<Note> notes = new ArrayList<Note>();
    
    public Scale() {
    }

    public Scale(Note... notes) {
        this(Arrays.asList(notes));
    }

    public Scale(List<Note> notes) {
        this.notes = new ArrayList<Note>(notes);
    }


    public Note next(Note note) {
        int pos = notes.indexOf(note) ;
        if (pos==-1) return null;
        return notes.get((pos+1) % notes.size());
    }

    public Note previous(Note note) {
        int pos = notes.indexOf(note) ;
        if (pos==-1) return null;
        return notes.get((pos - 1 + notes.size()) % notes.size());
    }

    public Note nth(int nth) {
        return notes.get((nth -1)  % notes.size());
    }
    
    public String getDegreeInt(Note note){
        int deg = notes.indexOf(note);
        return degresColors.get(deg)+degresNameInt.get(deg)+RESET;
    }
    public String getDegree(Note note){
        int deg = notes.indexOf(note);
        return degresColors.get(deg)+degresName.get(deg)+RESET;
    }
    
    public Note[] getNotes() {
        return notes.toArray(new Note[notes.size()]);
    }

    public Iterator<Note> iterator() {
        return notes.iterator();
    }

    @Override
    public String toString() {
        return notes.toString();
    }
}
