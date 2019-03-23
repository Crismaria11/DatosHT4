/**
 * Clase BinaryTree. todas las funciones de nuestro arbol binario. Guarda todos nuestros datos del diccionario. Funciona como una base de datos.
 * @author Abril, Cristina
 * @since 22/03/2019
 */
import java.util.Iterator;

public class BinaryTree<E> {

    protected E val;// value associated with node
    protected BinaryTree<E> parent; // parent of node
    protected BinaryTree<E> left, right; // children of node


    public BinaryTree() {
        // post: constructor that generates an empty node

        val = null;
        parent = null;
        left = right = this;
    }

    public BinaryTree(E value) {
        // post: returns a tree referencing value and two empty subtrees
        val = value;
        right = left = new BinaryTree<E>();
        setLeft(left);
        setRight(right);
    }

    public BinaryTree(E value, BinaryTree<E> left, BinaryTree<E> right) {
        // post: returns a tree referencing value and two subtrees
        val = value;
        if (left == null) {
            left = new BinaryTree<E>();
        }
        setLeft(left);
        if (right == null) {
            right = new BinaryTree<E>();
        }
        setRight(right);
    }

    public BinaryTree<E> left() {
    // post: returns reference to (possibly empty) left subtree
    // post: returns reference to (possibly empty) left subtree
        return left;
    }

    public BinaryTree<E> parent(){
        // post: returns reference to parent node, or null
        return parent;
    }


//agregar nodo
    public void setLeft(BinaryTree<E> newLeft)
    // post: sets left subtree to newLeft
    // re-parents newLeft if not null
    {
        if (isEmpty()) return;
        if (left != null && left.parent() == this) left.setParent(null);
        left = newLeft;
        left.setParent(this);
    }

    //agregar nodo
    public void setRight(BinaryTree<E> newRight)
    // post: sets left subtree to newLeft
    // re-parents newLeft if not null
    {
        if (isEmpty()) return;
        if (right != null && right.parent() == this) right.setParent(null);
        right = newRight;
        right.setParent(this);
    }


    protected void setParent(BinaryTree<E> newParent) {
    // post: re-parents this node to parent reference, or null
        if (!isEmpty()) {parent = newParent;
        }
    }

    private boolean isEmpty() {
// si el arbol binario no tiene nada este retorna todo null.
            return val==null&&left==null && right==null;
    }



    public E value(){
        // post: returns value associated with this node
        return val;
    }

    public void setValue(E value) {
        // post: sets the value associated with this node
        val = value;
    }

    public String orden (BinaryTree raiz){

        return evaluarorden(raiz);
    }

    public String evaluarorden(BinaryTree nodo){
        String pal = "";
        if (nodo.val==null){
            return "";
        }
        pal+= evaluarorden(nodo.left);
        pal+= nodo.val.toString()+"  ;  ";
        pal+=evaluarorden(nodo.right);
        return pal;
    }

    public String revisarSiHayTraduccion(String traduccion) {
        BinaryTree revisarArbol = this;

        if (revisarArbol.val == null) {
            return "*" + traduccion + "*";
        } else if (((Association)revisarArbol.val).getEnglishKey().toString().equals(traduccion)){
            return (String) ((Association)revisarArbol.val).getSpanishValue();
        } else if (((Association)revisarArbol.val).getEnglishKey().toString().compareToIgnoreCase(traduccion) > 0) {
            return revisarArbol.left.revisarSiHayTraduccion(traduccion);
        } else if (((Association)revisarArbol.val).getEnglishKey().toString().compareToIgnoreCase(traduccion) < 0) {
            return revisarArbol.right.revisarSiHayTraduccion(traduccion);
        }
        return null;
    }
}

