package DataStructure;

import DataStructure.Queue.EmptyQueueException;
import DataStructure.Queue.Node;
import DataStructure.Queue.Queue;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.BeforeEach;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class QueueTest {

    private Queue queue;

    @BeforeEach
    public void init() {
        queue = new Queue();
    }



    @Test
    public void testIfEnqueuMethodThrowsExceptionWhenParameterIsNull() {


        assertThrows(IllegalArgumentException.class, ()->queue.enqueue(null));
    }


    @Test
    public void testIfOneNodeWillAdded() {

        Node node1 = new Node("Test Value1");

        queue.enqueue("Test Value1");

        assertEquals(node1.getValue(), queue.getArrayOfNodes()[0].getValue());
    }


    @Test
    public void testIfFewNodesWillBeAdded() {

        queue.enqueue("Value1");
        queue.enqueue("Value2");
        queue.enqueue("Value3");

        assertEquals(3, queue.getArrayOfNodes().length);
    }


    @Test
    public void testIfPeekMethodShowLastElement() {

        queue.enqueue("Value1");
        queue.enqueue("Value2");
        queue.enqueue("Value3");

        String expectedValue = "Value1";
        String firstNodeActualValue = queue.peek();

        assertEquals(expectedValue, firstNodeActualValue);
    }

    @Test
    public void testIfPeekThrowsEmptyQueueExceptionWhenQueueIsEmpty() {
        assertThrows(EmptyQueueException.class, ()->queue.peek());
    }


    @Test
    public void testIfDequeueMethodReturnFirstNodeValue() {

        queue.enqueue("Value1");
        queue.enqueue("Value2");
        queue.enqueue("Value3");

        String firstExpectedValue = queue.getArrayOfNodes()[0].getValue();
        String actualValue = queue.dequeue();

        assertEquals(firstExpectedValue, actualValue);
    }


    @Test
    public void testIfDequeueMethodRemoveNodeFromQueue() {
        queue.enqueue("Value1");
        queue.enqueue("Value2");
        queue.enqueue("Value3");
        queue.dequeue();

        int expectedSize = 2;
        int actualSize = queue.getArrayOfNodes().length;

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void testIfDequeueThrowsEmptyQueueExceptionWhenQueueIsEmpty() {
        assertThrows(EmptyQueueException.class, ()->queue.dequeue());
    }




}
