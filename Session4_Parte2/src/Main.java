//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Pedido {

    int Cantidad = "3";
    double PRECIO = 19,99;
    long identificador = 9000000000;
    final String producto;
    boolean pagado = "false";

    void mostrar() {
        System.out.println(producto + " x " + Cantidad);
    }
}

