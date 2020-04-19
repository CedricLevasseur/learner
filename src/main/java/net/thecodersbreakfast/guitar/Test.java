package net.thecodersbreakfast.guitar;

/**
 * @author Olivier Croisier
 */
public class Test {

    public static void main(String[] args) {

Scale scale = Scale.of(Note.C);
System.out.println("Scale of C : " + scale);

Scale mode = Mode.IONIAN.of(scale);
System.out.println("Scale of C in "+Mode.IONIAN+" mode : " + mode);
System.out.println("Scale of C in "+Mode.DORIAN+" mode : " + mode);

Scale chord = Chord.major(mode);
System.out.println("Major chord : " + chord);

Scale chord2 = Chord.minor(mode);
System.out.println("Minor chord : " + chord2);

Guitar.display(chord2, Guitar.STANDART_TUNING, 12);
    }

}
