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

    public void handleShot() throws IOException/*You may not add "throws" here*/ {
        // handle method call
        try {
            roulette.shot(input);
        } catch(FileNotFoundException e){
            throw new IllegalArgumentException ("File is missing", e);
        } catch(IOException e){
                throw new IllegalArgumentException ("File error", e);
            } catch(ArithmeticException e){
                new RiskyShot(input + 1, roulette);
            }
            catch(NumberFormatException e){
                new RiskyShot(input + 2, roulette);
            }

            catch(UnsupportedOperationException e){

            }
            catch(Exception e){
                throw new RuntimeException(e);
            }

    }
}
