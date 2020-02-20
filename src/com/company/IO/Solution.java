package com.company.IO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    Map<Library, List<Integer>> m = new HashMap();

    public void addLibrary(Library l, List<Integer> books) {
       m.put(l, books);
    }
    public Map<Library, List<Integer>> getUsedLibraries () {
        return m;
    }

}
