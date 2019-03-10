package com.hashcode.io;

import com.hashcode.model.DataModel;

public interface Loader {
    /**
     * Loads competition data from file
     * @param filename
     * @param delim
     * @return
     */
    DataModel loadData(String filename, String delim);
}