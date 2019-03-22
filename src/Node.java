/**
 * @author Abril Palencia y Cristina Bautista
 * @version 22/03/2019
 * La clase nodo, ayuda a implementar un nuevo nodo y buscar entre los nodos
 */
public class Node {

    int value;
    Node left;
    Node right;
    Node root;

    Node(int value) {
        this.value = value;
        right = null;
        left = null;
    }

    private Node addRecursive(Node current, int value){
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            return current;
        }
        return current;
    }

    public void add(int value) {
        root = addRecursive(root, value);
    }

    private boolean containsNodeRecursive(Node current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.value){
            return true;
        }
        return value < current.value
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

}

/*
Baeldung (20 de Diciembre del 2018) Baeldung. Extraido de:
    https://www.baeldung.com/java-binary-tree

 */
