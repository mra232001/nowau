package com.efimchick.tasks.risky;

import com.efimchick.tasks.risky.util.RussianRoulette;

import java.io.FileNotFoundException;
import java.io.IOException;

public class RiskyShot {

    final int input;
    final RussianRoulette roulette;


    public RiskyShot(final int input,
                     final RussianRoulette roulette) {
        this.input = input;
        this.roulette = roulette;
    }

    public void handleShot()/*You may not add "throws" here*/ {
        // handle method call
        try {
            roulette.shot(input);
        } catch (Exception e) {
            if(e instanceof IOException){
                throw new IllegalArgumentException("File is error", e);
            }
            else if(e instanceof  FileNotFoundException){
                throw new IllegalArgumentException("File is missing", e);
            }
            else if((e instanceof ArithmeticException) || (e instanceof  NumberFormatException)){
                new RiskyShot(input + 1, roulette);
                new RiskyShot(input + 2, roulette);
            }
            else if(e instanceof UnsupportedOperationException){

            }
            else{
                throw new RuntimeException();
            }
        }

    }
}
