package net.thecodersbreakfast.guitar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

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
