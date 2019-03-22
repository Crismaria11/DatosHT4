/**
 * Clase Association. es la información que se guarda en cada nodo de nuestro arbol binario.
 * @author Abril, Cristina
 * @since 23/03/2019
 */
public class Association<K, V> {
    private K englishKey;
    private V spanishValue;

    // Constructor de mi clase
    public Association(K englishKey, V spanishValue) {
        this.englishKey = englishKey;
        this.spanishValue = spanishValue;
    }

    //para obtener la llave de mi diccionario. Palabra en ingles.
    public K getEnglishKey(){
        return englishKey;
    }

    //para obtener el valor de mi llave. Palabra en español.

    public V getSpanishValue() {
        return spanishValue;
    }

    //para mostrar en un string la llave y su respectivo valor. Palabra en ingles traducida al español.
    @Override
    public String toString() {
        return englishKey + " -> " + spanishValue;
    }
}

