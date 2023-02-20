package org.hitech;

import java.io.File;
import java.util.Scanner;

public class FHileApplication {
       static FHileAbstract holder;

       static File homePath = new File("c:\\");

        public static void main(String[] args) {
                Scanner stdin = new Scanner(System.in);
                holder = new FHolder(homePath);
                holder.open();
                int userReply = 0;
                do{
                    String oldPath = holder.file.getPath();
                    System.out.println("Specify what you would love to do by choosing from any of the options below");
                    System.out.println("1. open a directory or file in this directory");
                    System.out.println("2. copy a directory or file in this directory");
                    System.out.println("3. duplicate a directory or file in this directory");
                    System.out.println("4. exit the program");
                    System.out.println("5. go to the previous directory");
                    System.out.println("6. delete a file");
                    System.out.println("7. create a new file or folder");
                    System.out.println("8. move up one directory");
                    userReply = stdin.nextInt();
                    if(userReply == 1){
                        System.out.println("choose a file or directory from the list to open between the range of 1-"+holder.filesInDirectory.size());
                        int choosenDirectory = stdin.nextInt();
                                while(choosenDirectory > holder.filesInDirectory.size() || choosenDirectory < 1){
                                    System.out.println("Choose a valid index in the listed directory above");
                                    System.out.println("Your choice should be between 1 and " + holder.filesInDirectory.size());
                                    choosenDirectory = stdin.nextInt();
                                }
                        FHileAbstract fHileAbstract = holder.filesInDirectory.get(choosenDirectory-1);
                                if(fHileAbstract.file.isDirectory()) {
                                    holder = fHileAbstract;
                                    holder.open();
                                }
                                else
                                    System.out.println("cannot open this file at the moment");
                    }
                    else if (userReply == 4) {
                        System.out.println("Closing the program");
                        break;
                    }
                    else if(userReply == 6){
                        System.out.println("choose a file or directory to be deleted from the list between the range of 1-"+holder.filesInDirectory.size());
                        int choosenDirectory = stdin.nextInt();
                        while(choosenDirectory > holder.filesInDirectory.size() || choosenDirectory < 1){
                            System.out.println("Choose a valid index in the listed directory above");
                            System.out.println("Your choice should be between 1 and " + holder.filesInDirectory.size());
                            choosenDirectory = stdin.nextInt();
                        }
                        System.out.println("CODE RED:: Are you want to continue with this action?");
                        System.out.println("Type y and yes to delete the file and no or n to abort");
                        String userResponse = stdin.next();
                        if(userResponse.equalsIgnoreCase("yes")||userResponse.equalsIgnoreCase("y"))
                        {
                            holder = holder.filesInDirectory.get(choosenDirectory-1);
                            holder.delete();
                            holder = new FHolder(new File(oldPath));
                            holder.open();
                            System.out.println("Old path : " + oldPath);
                            continue;
                        }
                    }
                }while(true);
        }

}
