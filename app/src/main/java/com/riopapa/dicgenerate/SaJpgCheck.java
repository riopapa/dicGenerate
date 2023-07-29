package com.riopapa.dicgenerate;

import android.util.Log;

import java.io.File;
import java.util.Arrays;

public class SaJpgCheck {

    /*
    *   verify dict text against dict_img folder
     */
    File[] dicList, jpgList;
    String[] dictNames, jpgNames;
    boolean [] jpgUsed;

    void check(File dicFolder, File jpgFolder) {

        dicList = dicFolder.listFiles((dir, name) ->
                (name.endsWith("txt")));

        dictNames = new String[dicList.length];
        for (int i = 0; i < dicList.length; i++) {
            String dic = dicList[i].getName();
            dictNames[i] = dic.substring(0, dic.length()-4);
        }
        Arrays.sort(dictNames);

        jpgList = jpgFolder.listFiles();

        jpgNames = new String[jpgList.length];
        for (int i = 0; i < jpgList.length; i++) {
            jpgNames[i] = jpgList[i].getName();
        }
        Arrays.sort(jpgNames);
        jpgUsed = new boolean[jpgNames.length];
        FileRead fileRead = new FileRead(dicFolder);
        for (String dN : dictNames) {
            String [] lines = fileRead.readBibleFile(dN+".txt", true);
            if (lines.length > 6)
                Log.w("dn",dN+" "+lines.length);

//            for (String ln: lines) {
//                if (ln.contains("@")) {
//                    if (!ln.startsWith("@")) {
//                        Log.e("@ err "+dN, "@ err "+ln);
//                    } else {
//                        if (ln.contains(".gf"))
//                            Log.w(dN,ln);
//                        int idx = Arrays.binarySearch(jpgNames, ln.substring(1));
//                        if (idx < 0) {
//                            Log.w("NotFnd", dN + " " + ln);
//                        } else {
//                            jpgUsed[idx] = true;
//                        }
//                    }
//                }
//            }
        }
//        for (int i = 0; i < jpgUsed.length; i++) {
//            if (!jpgUsed[i])
//                Log.w("jpg","Only "+jpgNames[i]);
//        }



    }

}
//        dicList = dicFolder.listFiles((dir, name) ->
//                (name.endsWith("txt")));