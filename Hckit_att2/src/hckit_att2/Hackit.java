/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hckit_att2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Hackit {
    
   /* public static void main(String args[])
    {
        List<File> list = (new ListGen(new File("I:/"))).Listing();
        for(File fp : list)
        {
            System.out.println(fp.toString());
        }
    }*/
    
   public String OUT_PUT_ZIP;
   public File SOURCE;
   public List<File> filelist;
   public Hackit(File target)
   {
       OUT_PUT_ZIP="F:/Hack/"+(((new Date()).toString())+".zip").replace(" ","-").replace(":","@");
       SOURCE=target;
       filelist=new ListGen(SOURCE).Listing();
       ZipIt(OUT_PUT_ZIP);
   }
   
   public void ZipIt(String zipFile)
   {
       byte buffer[] = new byte[20000];
       try
       {
            FileOutputStream fos = new FileOutputStream(zipFile);
            ZipOutputStream zos = new ZipOutputStream(fos);
           
            // System.out.println("Output to Zip : " + zipFile);
            for(File file : this.filelist){

            //System.out.println("File Added : " + file);
            ZipEntry ze= new ZipEntry(file.toString());
            zos.putNextEntry(ze);

            FileInputStream in =
                       new FileInputStream(file.toString());
                       System.out.println( file);

            int len;
            while ((len = in.read(buffer)) > 0) {
                zos.write(buffer, 0, len);
            }

            in.close();
        }

        zos.closeEntry();
        //remember close it
        zos.close();

        System.out.println("Done");
           
        }
       catch(Exception e)
       {
           
       }
       
   }
    
    
}
