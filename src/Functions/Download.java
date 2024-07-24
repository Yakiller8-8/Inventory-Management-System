///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
///**
// *
// * @author yali_il
// */

package Functions;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.io.InputStream;

import javax.swing.JFrame;

public class Download extends JFrame{
    
    // Method to download a PDF file from a URL and save it to the user's home directory
    public void pdfDownload(){
        
        try {
            // Create a URL object with the address of the PDF file to download
            URL url = new URL("https://www.keepandshare.com/doc30/113759/user-guide2-pdf-4-3-meg?da=y");
            
            // Open an input stream to read the data from the URL
            InputStream inputStream  = url.openStream();
            
            // Specify the file name and path to save the downloaded file
            String fileName = "/Downloads/User Guide For Importing.pdf";
            String folderPath = System.getProperty("user.home");
            File file = new File(folderPath + fileName);
            
            // If a file with the same name already exists, append a number to make it unique
            int i = 1;
            while (file.exists()) {
                String[] parts = fileName.split("\\.");
                fileName = parts[0] + "(" + i + ")." + parts[1];
                file = new File(folderPath + fileName);
                i++;
            }
            
            // Create a FileOutputStream object to write the downloaded data to a file
            FileOutputStream fos = new FileOutputStream(file);
            
            // Read the data from the input stream in chunks of 1024 bytes and write it to the output stream
            byte[] bytes = new byte[1024];
            int len;
            while((len = inputStream.read(bytes)) != -1){
                fos.write(bytes, 0 ,len);
            }
            inputStream.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
