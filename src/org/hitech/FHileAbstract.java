package org.hitech;

import java.io.File;
import java.util.ArrayList;

public abstract class FHileAbstract {

    protected File file;

    protected String name, pathURL, type;

    protected Long size;

    ArrayList<FHileAbstract> filesInDirectory = new ArrayList<>();
    abstract void open();

    protected void copy(File fileFrom, File fileTo){

    }

    protected void move(File fileFrom, File fileTo){

    }

    protected void delete(){
        file.delete();
    }

    protected void search(File fileName){

    }

    protected void createNew(){

    }
}
