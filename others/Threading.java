/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package others;

/**
 *
 * @author rujuraj
 */
public class Threading implements Runnable{
    int i=0;
    public Thread t1,t2;
    public void callthread()
    {
        try {
             t1=new Thread(this);
             t2=new Thread(this);
            t1.start();
            t2.start();
            
        } catch (Exception e) {
        }
    }
    public static void main(String[] args) {
        
        Threading threading=new Threading();
        threading.callthread();
    }

    @Override
    public void run() {
        synchronized(this)
                {
                    if(i%2==0)
                    {
                
                        System.out.println("hello");
                        
                    }
                    else
                    {
                        System.out.println("world");
                    }
                    i=i+1;
                }
        if(i<Integer.MAX_VALUE)
        {
        t1.run();
        t2.run();
        }
    }
}
