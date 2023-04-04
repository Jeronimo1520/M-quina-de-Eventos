import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner inserts = new Scanner(System.in);  //INICIALIZAMOS SCANNER PARA PEDIR VALORES
        Evento evento = new Evento(null, null, null, null, 0, 0);
        Usuario user = new Usuario();
        //INPUTS DE EVENTOS
        evento.AddEvent("Festival Musical Internacional", "Concierto de bandas extranjeras", "Teatro UdeM", "2/03/2024", 16, 30);
        //FIN DE INPUTS DE PRUEBA
        boolean endMenu1 = true;
        while (endMenu1) {
            System.out.println("\n Hola, bienvenido, supongo sabes a que vienes no?");
            System.out.println("\n Quieres iniciar sesión como:" + "\n 1. Administrador" + "\n 2. Usuario" + "\n 3.Salir");
            int option_user = inserts.nextInt();
            switch (option_user) {
                case 1 -> {
                    System.out.println("\n Inserta la contraseña: ");
                    String bufer__ = inserts.nextLine();
                    String contraseña = inserts.nextLine();
                    if (contraseña.equals("EMPERADOR")) {
                        System.out.println("\n ####LISTA DE EVENTOS####" + "\n --------------------------------------");
                        evento.print_event(null);
                        //##MENU##
                        while (true) {
                            System.out.println("\n ¿Que quieres hacer?" + "\n 1. Añadir un nuevo evento" + "\n 2. Eliminar un evento" + "\n 3. Modificar un evento" +" \n 4.Estadisticas" + "\n 5. Salir");
                            int option1 = inserts.nextInt();

                            if (option1 == 1) {
                                //AÑADIR UN NUEVO EVENTO
                                String bufer_ = inserts.nextLine();
                                System.out.println("\n Nombre: ");
                                String nombre = inserts.nextLine();
                                System.out.println("\n Descripción: ");
                                String descripcion = inserts.nextLine();
                                System.out.println("\n Ubicación: ");
                                String ubicacion = inserts.nextLine();
                                System.out.println("\n Fecha: ");
                                String fecha = inserts.nextLine();
                                System.out.println("\n Edad minima: ");
                                int edad_minima = inserts.nextInt();
                                System.out.println("\n Aforo: ");
                                int aforo = inserts.nextInt();
                                evento.AddEvent(nombre, descripcion, ubicacion, fecha, edad_minima, aforo);
                                evento.print_event(null);
                            }
                            if (option1 == 2) {
                                //ELIMINAR EVENTO
                                System.out.println("\n Inserte el código del evento que deseas eliminar: ");
                                int codigo = inserts.nextInt();
                                evento.deleteEvent(codigo);
                                evento.print_event(null);
                                //FIN DE ELIMINAR EVENTO
                            }
                            if (option1 == 3) {
                                //MENU MODIFICAR EVENTO
                                System.out.println("\n Inserte el código del evento que quieres modificar: ");
                                int codigo = inserts.nextInt();
                                evento.print_event(evento.search_event2(codigo));
                                System.out.println("\n ¿Qué quieres modificar? ");
                                System.out.println("\n 1. Nombre" + "\n 2. Descripción" + "\n 3. Ubicación" + "\n 4. Fecha" + "\n 5. Edad minima" + "\n 6. Aforo" + "\n 7. Boletas disponibles");
                                int option2 = inserts.nextInt();
                                String bufer;
                                String nuevo_atributo;
                                int nueva_cifra = 0;
                                switch (option2) {
                                    case 1 -> {
                                        System.out.println("\n Nuevo Nombre: ");
                                        bufer = inserts.nextLine();
                                        nuevo_atributo = inserts.nextLine();
                                        evento.modifyEvent(codigo, option2, nuevo_atributo, 0);
                                    }
                                    case 2 -> {
                                        System.out.println("\n Nueva Descripción: ");
                                        inserts.nextLine();
                                        nuevo_atributo = inserts.nextLine();
                                        evento.modifyEvent(codigo, option2, nuevo_atributo, 0);
                                    }
                                    case 3 -> {
                                        System.out.println("\n Nueva Ubicación: ");
                                        inserts.nextLine();
                                        nuevo_atributo = inserts.nextLine();
                                        evento.modifyEvent(codigo, option2, nuevo_atributo, 0);
                                    }
                                    case 4 -> {
                                        System.out.println("\n Nueva Fecha: ");
                                        inserts.nextLine();
                                        nuevo_atributo = inserts.nextLine();
                                        evento.modifyEvent(codigo, option2, nuevo_atributo, 0);
                                    }
                                    case 5 -> {
                                        System.out.println("\n Nueva Edad minima: ");
                                        inserts.nextLine();
                                        inserts.nextInt();
                                        evento.modifyEvent(codigo, option2, null, nueva_cifra);
                                    }
                                    case 6 -> {
                                        System.out.println("\n Nuevo Aforo: ");
                                        inserts.nextLine();
                                        inserts.nextInt();
                                        evento.modifyEvent(codigo, option2, null, nueva_cifra);
                                    }
                                    case 7 -> {
                                        System.out.println("\n Nuevas Boletas disponibles: ");
                                        inserts.nextLine();
                                        inserts.nextInt();
                                        evento.modifyEvent(codigo, option2, null, nueva_cifra);
                                    }
                                    default -> System.out.println("Eliga una opcion valida");
                                }
                            }
                            if (option1 == 4){
                                eventosMinEdadPermitida();
                                eventosForoMayorA15();
                                System.out.println("Eventos por ubicacion: " + contarEventosPorUbicacion());
                                System.out.println("El promedio de edad minima en los eventos es: " + obtenerPromedioEdadMinima());
                            }
                            if (option1 == 5) {
                                break;
                            }
                        }
                    }
                }
                case 2 -> {
                    while (true) {
                        System.out.println("\n$$$$$$ BOLETERIA $$$$$$");
                        System.out.println("\n Bienvenido Usuario a la boleteria " + "\n 1. Comprar boletas " + "\n 2. Salir");
                        int option_bol = inserts.nextInt();

                        if (option_bol == 1) {
                            System.out.println("\n Tenemos los siguientes eventos disponibles: ");
                            evento.print_event(null);
                            //FORMULARIO
                            user.fill_form(evento);
                            //FIN DEL FORMULARIO
                        }
                        if (option_bol == 2) {
                            break;
                        }
                    }
                }
                case 3 -> endMenu1 = false;
                default -> System.out.println("Ingrese una opcion valida");
            }
        }
    }

    //Estadisticas creadas para poder usar programacion declarativa
    public static void eventosMinEdadPermitida(){ //Metodo que halla los eventos donde los menores de edad puedan entrar
        List<Evento> mins = Evento.eventos.stream().filter(evento -> evento.get_Edad_minima() < 18).toList();
        System.out.println("Eventos donde pueden entrar menores de edad:");
        mins.forEach(evento -> System.out.println("Evento: " + evento.Nombre + " Edad minima: " + evento.Edad_minima));
    }

    public static void eventosForoMayorA15(){
        List<Evento> events = Evento.eventos.stream()
                .filter(evento -> evento.getAforo() > 15)
                .toList();
        System.out.println("Eventos con aforo mayor a 15: ");
        events.forEach(evento -> System.out.println("Evento: " + evento.Nombre + " Aforo: " + evento.Aforo));
    }
    public static Map<String, Long> contarEventosPorUbicacion() {
        return Evento.eventos.stream()
                .collect(Collectors.groupingBy(Evento::getUbicacion, Collectors.counting()));
    }
    public static double obtenerPromedioEdadMinima() {
        return Evento.eventos.stream()
                .mapToInt(Evento::getEdadMinima)
                .average()
                .orElse(Double.NaN);
    }
}