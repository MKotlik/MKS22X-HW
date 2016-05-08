import java.util.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>> {
    //Instance variables
   private int size;
   private T[] data;
   private boolean = isMax;

   //Constructors
   public MyHeap() {
       size = 0;
       data = null;
       isMax = true;
   }

   public MyHeap(T[] array) {
       size = array.length;
       isMax = true;
       data = array;
       heapify();
   }

   public MyHeap(boolean isMax) {
       size = 0;
       this.isMax = isMax;
       data = null;
   }

   public MyHeap(T[] array, boolean isMax) {
       size = array.length;
       this.isMax = isMax;
       data = array;
       heapify();
   }

   private void pushDown(int k)
   private void pushUp(int k)
   private void heapify()
   public T delete()
   public void add(T x)
   private void doubleSize()
   public String toString()

}
