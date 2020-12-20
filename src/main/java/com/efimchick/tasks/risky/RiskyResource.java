package com.efimchick.tasks.risky;

import com.efimchick.tasks.risky.util.CarelessResourceConsumer;

import java.io.Closeable;
import java.io.IOException;

public class RiskyResource {

    final int input;
    final CarelessResourceConsumer careless;
    final Closeable resource;

    public RiskyResource(final int input,
                         final CarelessResourceConsumer careless,
                         final Closeable resource) {
        this.input = input;
        this.careless = careless;
        this.resource = resource;
    }

    public void handleCarelessConsuming()  /*You may not add "throws" here*/  {
        // handle method call
        try {
            careless.consume(input, resource);
        } catch (Exception e) {
            try {
                resource.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        try {
            resource.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
