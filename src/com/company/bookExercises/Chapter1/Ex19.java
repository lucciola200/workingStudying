package com.company.bookExercises.Chapter1;

public class Ex19 {
    public static void main(String[] args) {
        final String LS = System.lineSeparator();
        String txt1 = String.join(LS,
                "When in the chronicle of wasted time",
                "I see descriptions of the fairest wights,",
                "And beauty making beautiful old rhyme",
                "In praise of ladies dead, and lovely knights,",
                "Then, in the blazon of sweet beauty’s best,",
                "Of hand, of foot, of lip, of eye, of brow,",
                "I see their antique pen would have express’d",
                "Even such a beauty as you master now.");

        String txt2 = String.format("%s" + LS + "%s" + LS + "%s" + LS + "%s" + LS + "%s" + LS + "%s" + LS + "%s" + LS + "%s",
                "When in the chronicle of wasted time",
                "I see descriptions of the fairest wights,",
                "And beauty making beautiful old rhyme",
                "In praise of ladies dead, and lovely knights,",
                "Then, in the blazon of sweet beauty’s best,",
                "Of hand, of foot, of lip, of eye, of brow,",
                "I see their antique pen would have express’d",
                "Even such a beauty as you master now.");

        System.out.println(txt1);
        System.out.println();
        System.out.println(txt2);
    }
}
