//Basic Java overriding scenarios.
package org.aadi;

class Parent {

    public void abc(){
        System.out.println("Parent method abc()");
     }
     
    public void abc1(){
        System.out.println("Parent method abc1()");
     }
    
}

public class Child extends Parent {
    
    public void abc(){
        System.out.println("Child overridden method abc()");
     }
     
    public void abc2(){
        System.out.println("Child method abc2()");
     }

     public static void main(String []args){
        //Parent p = new Parent();                 
        //p.abc();                       //Parent method abc()
        //p.abc1();                      //Parent method abc1()
        //p.abc2();                      //Error
        
        //Parent p = new Child();             
        //p.abc();                      //Child overridden method abc()
        //p.abc1();                     //Parent method abc1()
        //p.abc2();                     //Error
        
        //Child c = new Child();                
        //c.abc();                      //Child overridden method abc()
        //c.abc1();                     //Parent method abc1()
        //c.abc2();                     //Child method abc2()
     }
    
}
