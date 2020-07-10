package Generic;
/*
    E - Element (used extensively by the Java Collections Framework)
    K - Key
    N - Number
    T - Type
    V - Value
    S,U,V etc. - 2nd, 3rd, 4th types
*/

public class clsGenericClass <K, E> {
    private K key;
    private E value;    
    
    public clsGenericClass(){
    }

    public clsGenericClass(K key, E value){
       this.key = key;
       this.value = value;         
    }

    
    public void setKey(K key) { this.key = key; }
    public void setValue(E value) { this.value = value; }
    public K getKey()   { return key; }
    public E getValue() { return value; }    
    
    
    public static void main(String[] args){
        clsGenericClass<Integer, String> test = new clsGenericClass<Integer, String>();
        test.setKey(1);
        test.setValue("Zarif");
        System.out.printf("Key %d and Value %s \n", test.getKey(), test.getValue() );

        clsGenericClass<Float, Integer> test2 = new clsGenericClass<Float, Integer>();
        test2.setKey((float)2.10);
        test2.setValue(100);

        System.out.printf("Key %s and Value %s \n", test2.getKey(), test2.getValue() );
        
    }    
    
}

