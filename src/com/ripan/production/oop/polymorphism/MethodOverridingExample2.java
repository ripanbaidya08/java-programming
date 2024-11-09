package com.ripan.production.oop.polymorphism;

class Animal {
    public void eat() {
        System.out.println("Animal is eating...");
    }

    public void sleep() {
        System.out.println("Animal is sleeping...");
    }

    public void breathe() {
        System.out.println("Animal is breathing...");
    }

}
class Tiger extends Animal {

    //informing compiler about overridden method
    @Override public void eat() {
        System.out.println("Tiger hunts and eat...");
    }
}
class Deer extends Animal {
    //informing compiler about overridden method
    @Override public void eat() {
        System.out.println("Deer will graze and eat...");
    }
}

class Monkey extends Animal {
    //informing compiler about overridden method
    @Override public void eat() {
        System.out.println("Monkey steal and eat...");
    }
}

//Helper class
class Forest {
    /*
    RunTime Polymphism[1:M]
                = new Tiger();
    Animal ref  = new Deer();
                = new Monkey();
    */
    public void allowAnimal(Animal ref) {
        ref.eat();

        ref.sleep();
        ref.breathe();
        System.out.println();
    }
}

public class MethodOverridingExample2 {
    public static void main(String[] args) {

        Tiger t = new Tiger();
        Deer d = new Deer();
        Monkey m = new Monkey();
        Forest f = new Forest();
        f.allowAnimal(t);
        f.allowAnimal(d);
        f.allowAnimal(m);

    }
}
