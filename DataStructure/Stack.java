/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure;

import java.util.LinkedList;

/**
 *
 * @author huydu
 */
public class MyStack<E> {    
    LinkedList<E> ls = new LinkedList();   
    public void push(E item) {
        ls.push(item);
    }    
    public E pop(){
        return ls.pop();
    }    
    public int getSize(){
        return ls.size();
    }    
    public boolean isEmpty() {
        if(ls.isEmpty()) {
            return true;
        }        
        return false;
    }    
}
