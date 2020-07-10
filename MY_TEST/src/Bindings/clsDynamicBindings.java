package Bindings;

class clsDynamicBindings {
    void eat(){
        System.out.println("Animal is eating");
    }
}

class Dog extends clsDynamicBindings{
    void eat(){
        System.out.println("Dog is eating");
    }
    
    public static void main(String args[]){
     clsDynamicBindings a = new Dog();
     a.eat();
    }
}
