package interviews.oktana;


/*A servlet throws a ServletException during the service of a request. What could be a possible reason for this to occur and what should you do to avoid it?

1.The servlet is unable to handle requests temporarily, and the request should be resent
2.The servlet is unable to handle requests permanently, and the request should be sent to another servlet container
X 3.An error occurred during the processing of the request, and the container should clean up the request
4.An error occurred during the processing of the request, and the container should drop the request

Alice is developing a Java EE application using Spring. And the application is secured through Spring Security. Which of the following
AuthenticationProvider should she use while building a connection to the database?
Options:
1.ODBCAuthenticationProvider
2. JDBCAuthenticationProvider
X 3. DaoAuthenticationProvider

What is not an access specifier in Java?
Public
Protected
Private
x Inherited

How do you declare and initialize an array in Java?
x int[] intArray = new int[20];
str[] strArray = {1,2,3};
dec[] decArray = [5, 6, 7];
Array xyz = ['3',5,'6'];

Can you inherith a constructor?
1.yes, always
2.no
x 3.yes if you define how to overload it

Can you instantiate an abstract class?
1.Yes, always
x 2.No
3.Yes if you define the constructor for it

Can you define a nested class in Java?
x 1.Yes -> Static Nested Class, Non-static Nested Class (Inner Class),Local Class, Anonymous Class
2.No
3.Yes, but only if the class is

What is garbage collection in Java?
1.is a collection of objects not used in the class
2.is a memory used by the garbage objects
x 3.is an automatic memory management in Java

When do you use the transient keyword in Java?
1.when you want to transpile a variable
2.when you want to assign a variable for temporary use
x 3.when you don't want to serialize

what is binary search?
a sorting algorithm
a binary representation of a search
x a searching algorithm
a type of multi discretionary search

what kind of algorithm is merge sort?
bubble
x divide and conquer
sequential
a data structure

what is a max heap?
a searching algorithm
x a complete binary tree
a decentralized rutine
a runtime query

what is a race condition in parallel computing?
is the ideal situation for multi processes
is the best way to start the parallel section
x is a problem when developing a parallel solution
is a solution for accessing a shared variable
*/


public class A1 {
  public int x;
  private int y;
  protected int z;

}

