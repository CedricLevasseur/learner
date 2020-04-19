package net.thecodersbreakfast.guitar;

/**
 * @author Olivier Croisier
 */
public enum Note {

    A, A$,
    B,
    C, C$,
    D, D$,
    E,
    F, F$,
    G, G$;

    public static final int NBNOTES = 12;


    public Note sharp() {
        return values()[(ordinal() + 1) % NBNOTES];
    }

    public Note flat() {
        return values()[(ordinal() - 1 + NBNOTES) % NBNOTES];
    }

    public Note nth(int nth) {
          return values()[(ordinal() + nth) % NBNOTES];
      }

    public int intervals(Note end) {
        return (end.ordinal() - ordinal() + NBNOTES) % NBNOTES;
    }


    @Override
    public String toString() {
        return name().replace('$','#');
    }

    public static Note readFromString( String str){
        return Note.valueOf(str.replace('#','$'));
    }
}
