package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class FileReader {
    private Map lineMap = new HashMap();
    private Profile profile = new Profile();
    public Profile getDataFromFile(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file.getAbsolutePath());
            int c;
            String k = "";
            while ((c = fileInputStream.read()) != -1){
                k += (String.valueOf((char) c));
            }
            String[] profileList = k.split("[ ,\\n]");
            profile.setName(profileList[1]);
            profile.setAge(Integer.valueOf(profileList[3]));
            profile.setEmail(profileList[5]);
            profile.setPhone(Long.valueOf(profileList[7]));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return profile;
    }
}
