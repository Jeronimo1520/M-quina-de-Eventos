import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Evento {

    private static int contador = 0;
    public int Codigo;
    public String Nombre;
    public String Descripcion;

    public String Fecha;
    public String Ubicación;

    public int Edad_minima;

    public int Aforo;

    public int Boletas_disponibles;

    public static List<Evento> eventos = new ArrayList<>();


    public Evento(String nombre, String descripcion, String ubicacion, String fecha, int edad_minima, int aforo) {

        this.Nombre = nombre;
        this.Descripcion = descripcion;
        this.Ubicación = ubicacion;
        this.Fecha = fecha;
        this.Codigo = this.contador++;
        this.Edad_minima = edad_minima;
        this.Aforo = aforo;
        this.Boletas_disponibles = aforo;
    }

    public int get_Boletas_disponibles() {return this.Boletas_disponibles;}
    public int getEdadMinima(){
        return this.Edad_minima;
    }
    public int getAforo(){
        return this.Aforo;
    }

    public String getUbicacion(){
        return this.Ubicación;
    }
    public int get_Edad_minima(){return this.Edad_minima;}

    public void set_Boletas_disponibles(int nuevo_valor){
        this.Boletas_disponibles = nuevo_valor;
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
    public void AddEvent(String nombre, String descripcion, String ubicacion, String fecha, int edad_minima, int aforo) {
        this.eventos.add(new Evento(nombre, descripcion, ubicacion, fecha, edad_minima, aforo));
    }
    public void print_event(Evento evento) { //METODO PARA IMPRIMIR EVENTOS, YA SEA UNO EN ESPECIFICO, O TODOS LOS QUE ESTAN EN LA LISTA
        if (evento == null) //SI EL PARAMETRO "evento" ES NULO ENTONCES SE IMPRIME TODOS LOS EVENTOS DE LA LISTA
            eventos.forEach(evento1 ->
                    System.out.println("\n Código: " + evento1.Codigo +
                            "\n Nombre: " + evento1.Nombre +
                            "\n Descripción: " + evento1.Descripcion +
                            "\n Ubicación: " + evento1.Ubicación +
                            "\n Fecha: " + evento1.Fecha + "\n Edad Minima: " +
                            evento1.Edad_minima + "\n Aforo: " +
                            evento1.Aforo + "\n Boletas disonibles: " +
                            evento1.Boletas_disponibles + "\n ############"));
        if (evento != null){ // //SI EL PARAMETRO "evento" NO ES NULO ENTONCES SE IMPRIME EL EVENTO QUE TENGA EL CODIGO QUE LE MANDARON
            System.out.println("\n Código: " + evento.Codigo + "\n Nombre: " + evento.Nombre + "\n Descripción: " + evento.Descripcion + "\n Ubicación: " + evento.Ubicación + "\n Fecha: " + evento.Fecha + "\n Edad Minima: " + evento.Edad_minima + "\n Aforo: " + evento.Aforo+ "\n Boletas disponibles: " + evento.Boletas_disponibles + "\n ############");
        }
    }
    public void modifyEvent(int codigo, int opcion, String nuevo_atributo, int nueva_cifra){ //ESTO FUNCIONA PERO ESTA EN CONSTRUCCION, VIA CERRADA
        String atributo;
        Evento event = search_event2(codigo);
        if (event != null){
            switch (opcion) {
                case 1 -> {
                    System.out.println("####ANTES####");
                    print_event(event);
                    event.Nombre = nuevo_atributo;
                    System.out.println("####DESPUES####");
                    print_event(event);
                }
                case 2 -> {
                    System.out.println("####ANTES####");
                    print_event(event);
                    event.Descripcion = nuevo_atributo;
                    System.out.println("####DESPUES####");
                    print_event(event);
                }
                case 3 -> {
                    System.out.println("####ANTES####");
                    print_event(event);
                    event.Ubicación = nuevo_atributo;
                    System.out.println("####DESPUES####");
                    print_event(event);
                }
                case 4 -> {
                    System.out.println("####ANTES####");
                    print_event(event);
                    event.Fecha = nuevo_atributo;
                    System.out.println("####DESPUES####");
                    print_event(event);
                }
                case 5 -> {
                    System.out.println("####ANTES####");
                    print_event(event);
                    event.Edad_minima = nueva_cifra;
                    System.out.println("####DESPUES####");
                    print_event(event);
                }
                case 6 -> {
                    System.out.println("####ANTES####");
                    print_event(event);
                    event.Aforo = nueva_cifra;
                    System.out.println("####DESPUES####");
                    print_event(event);
                }
                case 7 -> {
                    System.out.println("####ANTES####");
                    print_event(event);
                    event.Boletas_disponibles = nueva_cifra;
                    System.out.println("####DESPUES####");
                    print_event(event);
                }
            }
        }
    }
    //Metodo de buscar evento cambiado a declarativo
    public Evento search_event2(int codigo){ //DEVUELVE EL EVENTO MANDANDOLE SU CODIGO
       Optional<Evento> event = eventos.stream().filter(evento -> evento.Codigo == codigo).findAny();
        return event.orElseThrow();
    }
}