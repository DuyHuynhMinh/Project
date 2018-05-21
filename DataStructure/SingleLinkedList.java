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
             } else if(index==0){
                 newNode.next=first;
                 first =newNode;
                 ++size;
             } else{             
                Node<E> x = findNode(index-1);
                newNode.next=x.next;
                x.next=newNode;
                ++size;
             }             
        }
         
         public E get(int index) {               
             return findNode(index).item;             
         }
         
         public void set(int index,E data) {               
             Node<E> x  = findNode(index);
             x.item=data;
         }
         
         public Node<E> findNode(int index) {
             Node<E> x = first;
             for(int i = 0 ; i <index;++i ) {
                 x=x.next;
             }            
             return x;
         }
         
         public int size() {
             return size;
         }
         
         public void delete(int index) {             
             if(index>=size){
                 index =size-1;
             }             
             if(index==0) {
                 first=first.next;                 
             } else{             
                Node x =findNode(index-1);
                Node deletedNode = x.next;
                Node nextNode = deletedNode.next;
                x.next=nextNode;
             }
             --size;             
         }
        
        public void printList() {
            Node n = first; 
            while(n!=null) {
                System.out.println(n.item + " ") ;
                n=n.next;
            }            
        }     
    
}
