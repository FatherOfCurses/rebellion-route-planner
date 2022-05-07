package org.rebelalliance.flightplanner.utilities;

import com.fasterxml.uuid.Generators;

import java.util.UUID;

public class Helpers {

    public UUID generateUUID(){
        return Generators.randomBasedGenerator().generate();
    }

}
