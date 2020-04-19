package net.thecodersbreakfast.guitar;

/**
 * @author Olivier Croisier
 */
public enum Mode {

    IONIAN,  // Mode Majeur
    DORIAN,
    PHRYGIAN,
    LYDIAN,
    MIXOLYDIAN,
    AEOLIAN,
    LOCRIAN;

    private static final int[] IONAN_STEPS = {2, 2, 1, 2, 2, 2, 1};
    private static final int[] DORIAN_STEPS = {2, 1, 2, 2, 2, 1, 2};
    
    private static final int[][] ALL_STEPS =  new int [7][];
    
    private void init_all_steps(){
        ALL_STEPS[0] = IONAN_STEPS;
        ALL_STEPS[1] = DORIAN_STEPS;
    }
    
    public Scale of(Scale scale) {
        init_all_steps();
        int[] STEPS=ALL_STEPS[this.ordinal()];
        return of(scale, STEPS);
    }
    
    
    public Scale of(Scale scale, int[] STEPS) {
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
