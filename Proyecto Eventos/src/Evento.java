import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Evento {

    private static int contador = 0;
    public int Codigo;
    public String Nombre;
    private String Descripcion;

    private String Fecha;
    private String Ubicación;
    public List<Evento> eventos = new ArrayList<>();


    public Evento(String nombre, String descripcion, String ubicacion, String fecha) {

        this.Nombre = nombre;
        this.Descripcion = descripcion;
        this.Ubicación = ubicacion;
        this.Fecha = fecha;
        this.Codigo = this.contador++;
    }

    public void deleteEvent(int codigo) {
        Evento current = null;
        for (Evento event : eventos) { //RECORRE LA LISTA DE EVENTOS (OBJETOS)
            if (codigo == event.Codigo) {// SI EL CODIGO QUE NOS MANDAN COINCIDE CON UN CODIGO DE LA LISTA
                current = event; //ENTONCES EL EVENTO QUE TENGA ESE CODIGO SE GUARDA EN UNA VARIABLE
                System.out.println("Evento eliminado");

            }
        }
        this.eventos.remove(current);//Y AHORA USAMOS LA VARIABLE PARA REMOVER EL EVENTO CON EL METODO REMOVE, ASI COMO IMPERATIVO IMPERATIVO COMO QUE NO

    }

    public void AddEvent(String nombre, String descripcion, String ubicacion, String fecha) {
        this.eventos.add(new Evento(nombre, descripcion, ubicacion, fecha));

    }

    public void print_event(Evento evento) { //METODO PARA IMPRIMIR EVENTOS, YA SEA UNO EN ESPECIFICO, O TODOS LOS QUE ESTAN EN LA LISTA
        if (evento == null) //SI EL PARAMETRO "evento" ES NULO ENTONCES SE IMPRIME TODOS LOS EVENTOS DE LA LISTA
            for (Evento event : eventos)
                System.out.println("\n Código: " + event.Codigo + "\n Nombre: " + event.Nombre + "\n Descripción: " + event.Descripcion + "\n Ubicación: " + event.Ubicación + "\n Fecha: " + event.Fecha + "\n ############");
        if (evento != null){ // //SI EL PARAMETRO "evento" NO ES NULO ENTONCES SE IMPRIME EL EVENTO QUE TENGA EL CODIGO QUE LE MANDARON
            System.out.println("\n Código: " + evento.Codigo + "\n Nombre: " + evento.Nombre + "\n Descripción: " + evento.Descripcion + "\n Ubicación: " + evento.Ubicación + "\n Fecha: " + evento.Fecha + "\n ############");
        }
    }

    public void modifyEvent(int codigo, int opcion, String nuevo_atributo){ //ESTO FUNCIONA PERO ESTA EN CONSTRUCCION, VIA CERRADA
        String atributo;
        Evento event = search_event(codigo);


        if (event == null){

            if (opcion == 1 ) {

                System.out.println("####ANTES####");
                print_event(event);

                event.Nombre = nuevo_atributo;
                System.out.println("####DESPUES####");
                print_event(event);

            }

            if (opcion == 2 ) {


                System.out.println("####ANTES####");
                print_event(event);

                event.Descripcion = nuevo_atributo;
                System.out.println("####DESPUES####");
                print_event(event);
            }

            if (opcion == 3 ) {


                System.out.println("####ANTES####");
                print_event(event);

                event.Ubicación = nuevo_atributo;
                System.out.println("####DESPUES####");
                print_event(event);
            }

            if (opcion == 4 ) {

                System.out.println("####ANTES####");
                print_event(event);

                event.Fecha = nuevo_atributo;
                System.out.println("####DESPUES####");
                print_event(event);
            }
        }


    }

    public Evento search_event(int codigo){ //DEVUELVE EL EVENTO MANDANDOLE SU CODIGO
        for (Evento event: eventos){
            if (event.Codigo == codigo) {
                return event; //RETORNA UN OBJETO
            }
        }
        return null; //SI EL CODIGO NO EXISTE RETORNA NULO, SUPUESTAMENTE
    }

}
