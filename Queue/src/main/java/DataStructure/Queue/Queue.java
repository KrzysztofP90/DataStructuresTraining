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
        if (arrayOfNodes.length == 0) {
            throw new EmptyQueueException();
        }
        return arrayOfNodes[0].getValue();
    }

    public String dequeue() {
        return "";
    }


}
