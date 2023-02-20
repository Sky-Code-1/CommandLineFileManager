package org.hitech;

import java.io.File;

public class FHolder extends FHileAbstract{
    public FHolder(File file){
        this.file = file;
    }
    public FHileAbstract fHile;
    @Override
    void open() {
        filesInDirectory.clear();
        String[] fileNames = file.list();
        int i = 0;
        System.out.printf("%5s", "Index");
        System.out.printf("%30s", "Name");
        System.out.printf("%30s","Type");
        System.out.printf("%30s", "Path");
        System.out.println();
        System.out.println("======================================================================================================================");
        for(String fileName: fileNames){
            i++;
            File newFile = new File(file.getPath() + "\\" + fileName);
            if(newFile.isDirectory()) {
                fHile = new FHolder(newFile);
                fHile.name = fileName;
                fHile.type = "folder";
                filesInDirectory.add(fHile);
                fHile.pathURL = newFile.getPath();
            }
            else {
                fHile = new FHile(newFile);
                filesInDirectory.add(fHile);
                fHile.name = fileName;
                fHile.type = "file";
                fHile.pathURL = newFile.getPath();
            }
            System.out.printf("%5d", i);
            System.out.printf("%30s",fHile.name);
            System.out.printf("%30s", fHile.type);
            System.out.printf("%30s",fHile.pathURL);
            System.out.println();
        }
        System.out.println();
    }
}
