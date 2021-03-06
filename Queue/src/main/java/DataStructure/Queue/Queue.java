package DataStructure.Queue;

public class Queue {

    private Node[] arrayOfNodes;

    public Queue() {
        this.arrayOfNodes = new Node[0];
    }


    public Node[] getArrayOfNodes() {
        return arrayOfNodes;
    }


    public void enqueue (String value) {

        Node newNode = createNode(value);
        Node[] tempArray = arrayOfNodes.clone();
        arrayOfNodes = new Node[tempArray.length + 1];
        int indexOfNode = 0;

        for (Node node : tempArray) {
            arrayOfNodes[indexOfNode] = node;
            indexOfNode++;
        }
        arrayOfNodes[indexOfNode] = newNode;
    }

    private Node createNode(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Don't add null to queue!");
        }
        return new Node(value);
    }


    public String peek() {
        throwExceptionIfQueueIsEmpty();
        return arrayOfNodes[0].getValue();
    }


    public String dequeue() {

        throwExceptionIfQueueIsEmpty();
        String firstValue = arrayOfNodes[0].getValue();
        Node[] tempArray = arrayOfNodes.clone();
        int sizeOfNewArrayOfNodes = tempArray.length - 1;
        arrayOfNodes = new Node[sizeOfNewArrayOfNodes];

        for (int i =1; i < sizeOfNewArrayOfNodes; i++) {
            arrayOfNodes[i] = tempArray[i];
        }
        return firstValue;
    }


    private void throwExceptionIfQueueIsEmpty() {
        if (arrayOfNodes.length == 0) {
            throw new EmptyQueueException();
        }
    }


    public int size() {
        return arrayOfNodes.length;
    }


    public boolean isEmpty() {
        if (arrayOfNodes.length == 0) {
            return true;
        }
        return false;
    }


}
