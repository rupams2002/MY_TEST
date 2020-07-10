package hashCode_equals;

import ArrayList.clsArrayList;
import java.util.HashMap;
import java.util.HashSet;

/*
    HashSet is implementation of Set Interface which does not allow duplicate value. The main thing is, 
    objects that are stored in HashSet must override equals() for check for equality and hashCode() 
    methods for no duplicate value are stored in our set.

    Without equals() and hashCode() HashSet will be duplicate, with that no duplicate 

*/

public class clsEmployee {

 String name;
    int age;

    public clsEmployee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof clsEmployee))
            return false;
        clsEmployee employee = (clsEmployee) obj;
        return employee.getAge() == this.getAge()
                && employee.getName() == this.getName();
    }

    // commented    
    @Override
    public int hashCode() {
        int result=17;
        result=31*result+age;
        result=31*result+(name!=null ? name.hashCode():0);
        return result;
    }
     
    
    public static void main(String[] args){
        clsEmployee employee = new clsEmployee("rajeev", 24);
        clsEmployee employee1 = new clsEmployee("rajeev", 25);
        clsEmployee employee2 = new clsEmployee("rajeev", 24);

        HashSet<clsEmployee> hash = new HashSet<clsEmployee>();
        //HashMap<clsEmployee> hash1 = new HashMapt<clsEmployee>();

        hash.add(employee);
        System.out.println(hash.contains(employee2));
        System.out.println("employee.hashCode():  " + hash.hashCode() );
        System.out.println("employee1.hashCode():" + employee1.hashCode());
        System.out.println("employee2.hashCode():" + employee2.hashCode());
        

        hash.add(employee1);
        hash.add(employee2);

        System.out.println("");
        System.out.println("employee.hashCode():  " + hash.hashCode() );
        System.out.println("employee1.hashCode():" + employee1.hashCode());
        System.out.println("employee2.hashCode():" + employee2.hashCode());
        
        System.out.println(hash.size());
        
    }
    
}
