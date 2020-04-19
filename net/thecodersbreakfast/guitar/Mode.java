package net.thecodersbreakfast.guitar;

/**
 * @author Olivier Croisier
 */
public enum Mode {

    IONIAN,
    DORIAN,
    PHRYGIAN,
    LYDIAN,
    MIXOLYDIAN,
    AEOLIAN,
    LOCRIAN;

    private static final int[] STEPS = {2, 2, 1, 2, 2, 2, 1};

    public Scale of(Scale scale) {
        Note[] notes = new Note[STEPS.length];
        int scaleStart = ordinal();
        Note note = scale.nth(1);
        for(int i=0; i< STEPS.length; i++) {
            notes[i] = note;
            int steps = STEPS[(scaleStart+i) % STEPS.length];
            for(int j=0; j<steps; j++) {
                note = note.sharp();
            }            
        }
        return new Scale(notes);
    }

}
