# Homework 1

## Task 1
The Product class contains everything that is asked for in the git page, the variables, constructors, getter, setters etc. And, as asked for, equals is overridden to compare productIds.
I initially didn't know what the hashCode was for, but given that it said it was consistent with overriding equals, I overrid it as well and it now returns the hash code of the productId.

ProductInventory is the same story. Implemented a vector, an add method that checks for duplicates and optionally nulls, removing a product that exists, finding a product by its Id, getting all Products in a certain category, getting all Products below a threshold quantity, the total value of the inventory, updating stock, pritning all the products out in the inventory, getting the total number of products given the size of the inventory, and the capacity of the vector.

## Task 2
The three Order classes are the same story. OrderItem is just like Product: values, constructor, getters, setters, a toString method, and calculating the total cost of the order.

Order itself is the similar to productInventory. I also added three more methods to help with finishing the OrderManager class.

OrderManager is the same story, but since the values are private, I needed getters in Order to access the values in it.

## Task 3
Going back to ProductInventory, the three methods in 3.1 did as was asked.

Enumeration was a little confusing, but since it was similar to the enhanced for loop, I got the hang of it. Of course, I had to Google it's usage.

The VectorComparisonDemo I found was a little tedious to start. I haven't learned how to count time in java, and nanoTime was the best way I found to do it. It's a little less practical, but felt more smooth compared to currentTimeMillis. Of course, I had to convert nanoseconds to milliseconds (multiply by 1.000.00)

## Task 4
The Generic methods were surprisingly simple, which made sense since they were commonly used methods but tweaked to account for generics. Swap was the same thing as swaps made for arrays or arraylists, using a buffer to store one index's data.

The next two were also simple enough to understand, using xextends Comprable so that it only compares comprable data types.

The fourth one I felt more comfortable doing the simpler method. I don't remember doing predicate.

The GenericContainer class is really just the same story with the other classes that had lots of methods. Add, get, remove, all the basic and commonly used methods that interacts with a Vector.

Finally, VectorUtils. I was a little confused since Number wasn't really a thing in java I'm used to, but it made sense, as it accepted pretty much everything that math works with in Java.

## Task 5
The Inventory System is now complete and I have to do is to put it all togetether and demonstrate it through code. I didn't feel like putting in the menu though.
