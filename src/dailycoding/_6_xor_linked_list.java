package dailycoding;
/**
 * 
 * Implementation
The basic algorithm for implementation is as follows:

1. Create a new node A , whose pointer pt is null XOR address(B)
2. So on
3. While traversing the doubly linked list, at a time two node objects are required. For example, if you are at node C , you need to know the address of B to calculate the address of D node.

What about Java
This can be easily achieved in all programming languages like C/C++ where pointer manipulation is allowed and end result can be directly accessed as memory address.

How ever in Java, it's a different story. There will be few but very big problems:
1. Garbage Collection - Since the objects are not directly referenced, they can be easily garbage collected, leaving the program in an in-consistent state.
2. The other point against XOR linked list implementation is, with almost infinite memory at disposal (that too increasing) this will not a huge memory save.
3. Plus this will make maintenance more complex and expensive.

Still If you want
sun.misc.unsafe 
Still if you want to implement it in java, here's a class sun.misc.Unsafe which allows doing a lot of unsafe operations like, you can get the address of objects and create your xor-linked list. But as mentioned earlier, your objects can be garbage collected. Also, with the package mentioned as unsafe, this can be removed/ may not be present in various jvm versions.
 * 
 * @author vsidda
 *
 */
public class _6_xor_linked_list {

}
