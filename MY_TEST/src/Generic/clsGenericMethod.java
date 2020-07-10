package Generic;
/*
    E - Element (used extensively by the Java Collections Framework)
    K - Key
    N - Number
    T - Type
    V - Value
    S,U,V etc. - 2nd, 3rd, 4th types
*/

public class clsGenericMethod {

    public <E> void printArray( E[] inputArray ){
      for(E element : inputArray) {
         System.out.printf("%s ", element);
      }
      System.out.println();
    }
   
   
    public  <T extends Comparable<T>> T maximum(T x, T y, T z) {
      T max = x; 
      
      if(y.compareTo(max) > 0) {
         max = y;
      }
      
      if(z.compareTo(max) > 0) {
         max = z;
      }
      return max;
    }

    
    
    public static void main(String[] args){
        clsGenericMethod genericMethod = new clsGenericMethod();
        System.out.printf("Max of %d, %d and %d is %d\n\n", 3, 4, 5, genericMethod.maximum( 3, 4, 5 ));
        System.out.printf("Max of %.1f,%.1f and %.1f is %.1f\n\n", 6.6, 8.8, 7.7, genericMethod.maximum( 6.6, 8.8, 7.7 ));
        System.out.printf("Max of %s, %s and %s is %s\n","pear", "apple", "orange", genericMethod.maximum("apple", "pear", "orange"));
    }    
    
    
    
}

//printArray({ 1, 2, 3, 4, 5 });
//printArray({ 1.1, 2.2, 3.3, 4.4 });
//printArray({ 'H', 'E', 'L', 'L', 'O' });
//printArray({"Cheese", "Pepperoni", "Black Olives"});

//System.out.printf("Max of %d, %d and %d is %d\n\n", 3, 4, 5, maximum( 3, 4, 5 ));
//System.out.printf("Max of %.1f,%.1f and %.1f is %.1f\n\n", 6.6, 8.8, 7.7, maximum( 6.6, 8.8, 7.7 ));
//System.out.printf("Max of %s, %s and %s is %s\n","pear", "apple", "orange", maximum("pear", "apple", "orange"));
