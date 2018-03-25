package others;
import java.util.*;
import java.awt.Point;

/*
 * Imagine we have an image where every pixel is white or black. We’ll represent this image as a simple 2D array (0 = black, 1 = white). The image you get is known to have a single black rectangle on a white background. Write a function that takes in the image and returns the coordinates of the rectangle -- either top-left and bottom-right; or top-left, width, and height.
 */

class FindRectangle {
  
  static class Rectangle
  {
    int x=0,y=0,w=0,h=0;
  }
  // Sample input

  static int[][] image = {
    {1, 1, 1, 1, 1, 1, 1},
    {1, 1, 1, 1, 1, 1, 1},
    {1, 1, 1, 0, 0, 0, 1},
    {1, 0, 1, 0, 0, 0, 1},
    {1, 0, 1, 1, 1, 1, 1},
    {1, 0, 1, 0, 0, 1, 1},
    {1, 1, 1, 0, 0, 1, 1},
    {1, 1, 1, 1, 1, 1, 1},
  };
  
  // 2, 3, 3, 5
  // 3, 1, 5, 1
  // 5, 3, 6, 4
  
  
  // https://docs.oracle.com/javase/7/docs/api/java/awt/Point.html
  static public ArrayList<Rectangle> getRectangle(int[][] img)
  {
    ArrayList<Rectangle> rectList=new ArrayList<Rectangle>();
    HashSet<Point> set=new HashSet<Point>();
    
    for(int i=0;i<img.length;i++)
    {
      Rectangle rect=new Rectangle();
      boolean found=false;
      for(int j=0;j<img[i].length;j++)
      {
        if(img[i][j]==0 && !set.contains(new Point(i,j)))
        {
          rect.x=i;
          rect.y=j;
          rect.w=0;
          rect.h=0;
          
          int originj=j;
          int origini=i;
          
          while(origini+1<img.length && img[origini+1][j]==0)
          {
            rect.h++;
            origini++;
          }
          while(originj+1<img[i].length && img[i][originj+1]==0)
          {
            rect.w++;
            originj++;
          }
          found=true;
          
          j=originj;
        }
      }
     
      for(int k=rect.x;k<=rect.x+rect.h;k++)
      {
        for(int l=rect.y;l<=rect.y+rect.w;l++)
        {
          set.add(new Point(k,l));
        }
      }
      if(found)
        rectList.add(rect);
      
    }
    return rectList;
  }
  
  public static void main(String[] args) {
    
    ArrayList<Rectangle> rectList=getRectangle(image);
    for(Rectangle rect:rectList)
    {
      System.out.print("("+rect.x+","+rect.y+")=>"+(rect.x+rect.h)+","+(rect.y+rect.w));
      
      System.out.println();
    }
  }
    
}

