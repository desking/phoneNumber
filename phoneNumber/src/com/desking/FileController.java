package com.desking;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 19.09.2017.
 */
public class FileController {

    private List<String> contentsOfFiles;

    public FileController() {
        contentsOfFiles = new ArrayList<>();
    }

    public List<String> getContentsOfFiles(String path) {
        processFilesFromFolder(new File(path));
        return contentsOfFiles;
    }

    private void processFilesFromFolder(File folder) {
        File[] folderEntries = folder.listFiles();
        if (folderEntries != null) {
            for (File something : folderEntries) {
                if (something.isDirectory()) {
                    processFilesFromFolder(something);
                } else if (isFileExtensionTxt(something)) {
                    readFromFile(something);
                }

        }
        }
    }

    private boolean isFileExtensionTxt(File file) {
        return getFileExtension(file).equals("txt");
    }

    private String getFileExtension(File file) {
        String fileName = file.getName();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        else return "";
    }


    private void readFromFile(File file) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            while (in.ready()) {
                contentsOfFiles.add(in.readLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!!!");
        } catch (IOException e) {
            System.out.println("Problem with the file!!! Check file please!!!");
            e.printStackTrace();
        }
    }

    private void writeToFile(String fileName, String string) {
        try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName, true)))) {
            out.append(string);
            out.append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
