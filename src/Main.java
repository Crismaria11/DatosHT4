import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Clase Main. lee los dos archivos de texto (diccionario y la oración). Interactua con el usuario
 * @author Abril, Cristina
 * @since 22/03/2019
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido a nuestro diccionario");
        System.out.println();
        int cont = 0;
        String palabras;
        String texto;
        String sCadena;
        BinaryTree<Association> dictionary = new BinaryTree<>();

        // Leer el archivo de texto. nuestro diccionario para mostrarlo en la consola.
        try{
            FileReader file = new FileReader("diccionario.txt");
            BufferedReader reader = new BufferedReader(file);
            //separar y colocar las asociaciones en ArrayList
            while((palabras = reader.readLine()) != null) {
                String[] separador = palabras.split("");
                //crear un ArrayList con las palabras de nuestro diccionario.
                ArrayList<String> dicc = new ArrayList<>();
                String p = "";
                //separa hasta encontar un string para colocarlo en ArrayList de mi diccionario.
                for (int i = 0; i < separador.length; i++) {
                    if (separador[i].equals(",") || separador[i].equals(")")) {
                        //encuentra el string y lo agrega al ArrayList
                        dicc.add(p);
                        p = "";
                    }else if (!separador[i].equals("(") && !separador[i].equals(" ") && !separador[i].equals(")") && !separador[i].equals(",")) {
                        p += separador[i];
                    }
                }


                //ordenando el diccionario. armar el arbol binario.
                if(cont == 0){
                    //coloca la primer Association del texto diccionario (primer association de nuestro arrayList) ylo coloca como raiz de nuestro arbol
                    BinaryTree raiz = new BinaryTree(new Association<>(dicc.get(0), dicc.get(1)));
                    dictionary = raiz;
                    System.out.println("raiz de nuestro arbol sin ordenar:");
                    System.out.println(dictionary.val);
                    System.out.println();
                    cont=1;
                }else{
                    int holi = 0;
                    Association<String, String> raiz = new Association<>(dicc.get(0), dicc.get(1));
                    BinaryTree nodo = dictionary;
                    while (holi == 0) {
                        if ((nodo.val.toString().compareTo(raiz.toString())) >= 0) {
                            if (nodo.left.val == null) {
                                nodo.setLeft(new BinaryTree<>(raiz));
                                holi = 1;
                                System.out.println(nodo.val);
                            }else{
                                nodo=nodo.left;
                                System.out.println(nodo.val);
                            }
                        }else{
                            if(nodo.right.val == null) {
                                nodo.setRight(new BinaryTree<>(raiz));
                                holi=1;
                                System.out.println(nodo.val);
                            }else{
                                nodo=nodo.right;
                                System.out.println(nodo.val);
                            }

                        }
                    }
                }
            }
        }catch(Exception e){
            //por si no encuentra el archivo
            e.printStackTrace();
            System.out.println("Error! Archivo de texto no encontrado");
        }

        try {
            FileReader fr = new FileReader("text.txt");
            BufferedReader br = new BufferedReader(fr);
            //separar y colocar las asociaciones en ArrayList
            while ((sCadena = br.readLine()) != null) {
                String[] separate = texto.split("");
                //crear un ArrayList con las palabras de nuestro diccionario.
                ArrayList<String> text = new ArrayList<>();
                String l = "";
                
                for (int j = 0; j < separate.length; j++) {
                    if (separate[j].equals("")) {
                        texto.add(l);
                        l = "";
                        System.out.println(text);
                    }
                }

            }
        } catch (Exception e) {
            //por si no encuentra el archivo
            e.printStackTrace();
            System.out.println("Error! Archivo de texto no encontrado");
        }


        //mostrar nuestro diccionario
        System.out.println();
        System.out.println("Contenido de nuestro diccionario:");
        System.out.println(dictionary.orden(dictionary));
        System.out.println();
        System.out.println("traduccion de su texto.");
        System.out.println();




    }
}

