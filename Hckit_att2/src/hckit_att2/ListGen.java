/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hckit_att2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ListGen {
    
    File f;
    List<File> filelist ;
    File fl[];
    public ListGen(File f)
    {
        this.f =f;
        filelist=new ArrayList<File>();
    }
    
    public List<File> Listing()
    {
        foo(f);
        return filelist;
    }
    
    public void foo(File f)
    {
        if(f.isDirectory())
        {
            fl=f.listFiles();
            for(File temp : fl)
            {
               foo(temp); 
            }
        }
        else 
          filelist.add(f);
    }
    
    
    
}
