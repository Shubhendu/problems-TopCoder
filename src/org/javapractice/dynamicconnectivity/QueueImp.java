/** Copyright @ Cisco Systems Inc.
 *  Created Jan 21, 2014
 */
package org.javapractice.dynamicconnectivity;

import java.util.Iterator;

/**
 * @author shusingh
 *
 */
public class QueueImp<Item> implements Iterable<Item>{

	private Node<Item> first;
	private Node<Item> last;
	private int N ;
	
	
	
	public class Node<Item>{
		Item item;
		Node<Item> next;
	}
	
	public QueueImp(){
		first = null;
		last = null;
		N=0;
	}

	
	public int size() {		
		return N;
	}

	
	public boolean isEmpty() {		
		return N==0;
	}

	

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	public void enqueue(Item e) {
		Node<Item> oldLast = last;
		last = new Node<Item>();
		last.item = e;
		last.next = null;
		if(isEmpty()){
			first = last;
		}else{
			oldLast.next = last;
		}		
		N++;
				
	}

	
	
	public Item dequeue() {
		if (isEmpty()) return null;
		Node<Item> oldFirst = first;
		first = oldFirst.next;		
		N--;
		if(isEmpty()){
			last = null;
			first = null;
		}
		
		return oldFirst.item;
	}

	
	public Item poll() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Item peek() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args){
		QueueImp queueImp = new QueueImp();
		queueImp.enqueue(20);
		queueImp.enqueue(30);
		queueImp.enqueue(40);
		
		System.out.println(queueImp.size());
		System.out.println(queueImp.dequeue());
		System.out.println(queueImp.dequeue());
		System.out.println(queueImp.size());
		System.out.println(queueImp.dequeue());
	}
	
}
