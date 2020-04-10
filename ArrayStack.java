// Abstracted from University of Washington lecture notes

import java.util.Iterator;

public class ArrayStack<T> implements Stack<T>
{
   private final int DEFAULT_CAPACITY = 10;
   private int top;  
   private transient T[] stack; 

   public ArrayStack() {
      top = 0;
      stack = (T[])(new Object[DEFAULT_CAPACITY]);
   }

   public ArrayStack (int intCap) {
      top = 0;
      stack = (T[])(new Object[intCap]);
   }
   
   public T peek() {
       if (empty()) {
            throw new IndexOutOfBoundsException("Index out of bounds"); 
        }

       return stack[top-1];
   }

   public void push (T element) {
      if (size() == stack.length) {
            expandCapacity();
        }
      stack[top] = element;
      top++;
   }

   public T pop() throws IndexOutOfBoundsException {
      if (empty()) {
            throw new IndexOutOfBoundsException("Index out of bounds"); 
        }
     
      top--;
      T prod = stack[top];
      stack[top] = null; 
 
      return prod;
   }

   private void expandCapacity() {
      T[] larger = (T[])(new Object[stack.length*2]);

      for (int index=0; index < stack.length; index++) {
            larger[index] = stack[index];
        }

      stack = larger;
   }

   public boolean empty() {
	    return (top == 0);
   }
 
   public int size()
   {
	return top;
   }
}