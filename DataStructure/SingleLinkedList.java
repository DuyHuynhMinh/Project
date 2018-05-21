/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure;

/**
 *
 * @author huydu
 */
public class MyLinkedList<E> {

    
       private int size =0;
       Node<E> last;
       Node<E> first;
        
        public class Node<E> {            
            E item;
            Node<E> next;           
            Node(E e ) {
                item =e;
                next =null;
            }            
        }
        
        public  void add(E e) {            
            Node<E> l = last;            
            Node <E>newNode = new Node(e);
            last = newNode;
            if(l==null) {
                first=newNode;
            } else{
                l.next=newNode;
            }    
            ++size;
        }
        
         public void add(int index, E element) {
             
             Node newNode=new Node(element);
             
             if(index>=size) {
                 add(element);
             } else{             
                Node x = first;
                for(int i = 0; i <index-1; ++i ){
                    x=x.next;
                }
                 newNode.next=x.next;
                x.next=newNode;
                ++size;
             }             
        }
         
         public int size() {
             return size;
         }
        
        public void printList() {
            Node n = first; 
            while(n!=null) {
                System.out.println(n.item + " ") ;
                n=n.next;
            }            
        }     
    
}