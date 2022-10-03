package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileReader {
    private final Profile profile = new Profile();
    public Profile getDataFromFile(File file) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file.getAbsolutePath());
            int c;
            StringBuilder k = new StringBuilder();
            while ((c = fileInputStream.read()) != -1){
                k.append((char) c);
            }
            String[] profileList = k.toString().split("[ ,\\n]");
            profile.setName(profileList[1]);
            profile.setAge(Integer.valueOf(profileList[3]));
            profile.setEmail(profileList[5]);
            profile.setPhone(Long.valueOf(profileList[7]));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return profile;
    }
}
