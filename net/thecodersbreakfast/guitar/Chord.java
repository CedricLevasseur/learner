package net.thecodersbreakfast.guitar;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Olivier Croisier
 */
public class Chord {

    public static Scale major(Scale scale) {
        Builder builder = new Builder()
                .add(scale.nth(1))
                .add(scale.nth(3))
                .add(scale.nth(5));
        return builder.build();
    }

    public static Scale maj7(Scale scale) {
        Builder builder = new Builder()
                .add(scale.nth(1))
                .add(scale.nth(3))
                .add(scale.nth(5))
                .add(scale.nth(7));
        return builder.build();
    }

    public static Scale maj9(Scale scale) {
        Builder builder = new Builder()
                .add(scale.nth(1))
                .add(scale.nth(3))
                .add(scale.nth(5))
                .add(scale.nth(7))
                .add(scale.nth(9));
        return builder.build();
    }

    public static Scale majAdd9(Scale scale) {
        Builder builder = new Builder()
                .add(scale.nth(1))
                .add(scale.nth(3))
                .add(scale.nth(5))
                .add(scale.nth(9));
        return builder.build();
    }

    public static Scale maj7b5(Scale scale) {
        Builder builder = new Builder()
                .add(scale.nth(1))
                .add(scale.nth(3))
                .add(scale.nth(5).flat())
                .add(scale.nth(7));
        return builder.build();
    }

    public static Scale dom7(Scale scale) {
        Builder builder = new Builder()
                .add(scale.nth(1))
                .add(scale.nth(3))
                .add(scale.nth(5))
                .add(scale.nth(7).flat());
        return builder.build();
    }

    public static Scale dom9(Scale scale) {
        Builder builder = new Builder()
                .add(scale.nth(1))
                .add(scale.nth(3))
                .add(scale.nth(5))
                .add(scale.nth(7).flat())
                .add(scale.nth(9));
        return builder.build();
    }

    public static Scale minor(Scale scale) {
        Builder builder = new Builder()
                .add(scale.nth(1))
                .add(scale.nth(3).flat())
                .add(scale.nth(5));
        return builder.build();
    }

    public static Scale min7(Scale scale) {
        Builder builder = new Builder()
                .add(scale.nth(1))
                .add(scale.nth(3).flat())
                .add(scale.nth(5))
                .add(scale.nth(7).flat());
        return builder.build();
    }

    public static Scale min9(Scale scale) {
        Builder builder = new Builder()
                .add(scale.nth(1))
                .add(scale.nth(3).flat())
                .add(scale.nth(5))
                .add(scale.nth(7).flat())
                .add(scale.nth(9));
        return builder.build();
    }

    public static Scale minAdd9(Scale scale) {
        Builder builder = new Builder()
                .add(scale.nth(1))
                .add(scale.nth(3).flat())
                .add(scale.nth(5))
                .add(scale.nth(9));
        return builder.build();
    }

    public static Scale minMaj7(Scale scale) {
        Builder builder = new Builder()
                .add(scale.nth(1))
                .add(scale.nth(3).flat())
                .add(scale.nth(5))
                .add(scale.nth(7));
        return builder.build();
    }

    public static Scale minMaj9(Scale scale) {
        Builder builder = new Builder()
                .add(scale.nth(1))
                .add(scale.nth(3).flat())
                .add(scale.nth(5))
                .add(scale.nth(7))
                .add(scale.nth(9));
        return builder.build();
    }

    public static Scale min7b5(Scale scale) {
        Builder builder = new Builder()
                .add(scale.nth(1))
                .add(scale.nth(3).flat())
                .add(scale.nth(5).flat())
                .add(scale.nth(7).flat());
        return builder.build();
    }


    public static class Builder {

        private List<Note> notes = new ArrayList<Note>();


        private Builder add(Note note) {
            notes.add(note);
            return this;
        }

        private Builder flat(int nth) {
            int index = (nth - 1) / 2;
            notes.set(index, notes.get(index).flat());
            return this;
        }

        private Builder sharp(int nth) {
            int index = (nth - 1) / 2;
            notes.set(index, notes.get(index).sharp());
            return this;
        }

        public Scale build() {
            return new Scale(notes);
        }
    }


}
