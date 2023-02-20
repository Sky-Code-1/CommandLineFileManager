package org.hitech;

import java.io.File;

public class FHile extends FHileAbstract{
    public FHile(File file){
        this.file = file;
    }

    @Override
    void open() {
        System.out.println("Sorry can't open now!");
        int j = 0;
        for(int i = this.pathURL.length()-1; i > 0; i--){
            if(pathURL.charAt(i) == '\\'){
                j = i;
            }
            pathURL = pathURL.substring(0,j);
            System.out.println(pathURL);
        }
        return;
    }
}
