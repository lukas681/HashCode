package com.hashcode.io;

import com.hashcode.model.DataModel;

public interface Writer {
    /**
     * Used to write the challenges' datamodel to a file
     * @param dm
     */
    void write(DataModel dm);
}
