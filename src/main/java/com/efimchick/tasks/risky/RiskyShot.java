package com.efimchick.tasks.risky;

import com.efimchick.tasks.risky.util.RussianRoulette;

public class RiskyShot {

    final int input;
    final RussianRoulette roulette;


    public RiskyShot(final int input,
                     final RussianRoulette roulette) {
        this.input = input;
        this.roulette = roulette;
    }

    public void handleShot() /*You may not add "throws" here*/ {
        // handle method call
        //roulette.shot(input);
    }
}
