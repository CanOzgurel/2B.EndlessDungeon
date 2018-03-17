package GameManagement;

import javax.sound.sampled.AudioFormat;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class FileManager {


    private ArrayList <Image> scannedImages;
    private ArrayList <String> scannedStrings;
    private ArrayList <Integer> scannedInts;
    private ArrayList <AudioFormat> scannedAudios;
    private File myFile;
    private Scanner scan;

    public FileManager(){
        scannedImages = new ArrayList<>();
        scannedInts  = new ArrayList<>();
        scannedStrings= new ArrayList<>();
        scannedAudios = new ArrayList<>();
    }



}
