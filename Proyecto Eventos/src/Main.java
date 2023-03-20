import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world! veamos tu lista de eventos");
        Evento evento = new Evento(null, null, null, null);

        //INPUTS DE EVENTOS

        evento.AddEvent("Band Cunny", "Banda folclorica de putumayo", "Auditorio 5", "2/03/2024" );
        evento.AddEvent("Sharkira", "Concierto de la famosa cantante chakira", "Auditorio 10", "7/06/2023");

        //FIN DE INPUTS DE PRUEBA

        Scanner inserts = new Scanner (System.in);  //INICIALIZAMOS SCANNER PARA PEDIR VALORES

        System.out.println("\n ####LISTA DE EVENTOS####" + "\n --------------------------------------" );
        evento.print_event(null);


        //##MENU##

        while (true){
            System.out.println("\n ¿Que quieres hacer?" + "\n 1. Añadir un nuevo evento" + "\n 2. Eliminar un evento" + "\n 3. Modificar un evento" + "\n 4. Salir");
            int option1 = inserts.nextInt();

            if (option1 == 1) {
                //AÑADIR UN NUEVO EVENTO

                String bufer = inserts.nextLine();
                System.out.println("\n Nombre: ");

                String nombre = inserts.nextLine();

                System.out.println("\n Descripción: ");
                String descripcion = inserts.nextLine();

                System.out.println("\n Ubicación: ");
                String ubicacion = inserts.nextLine();

                System.out.println("\n Fecha: ");
                String fecha = inserts.nextLine();

                evento.AddEvent(nombre, descripcion, ubicacion, fecha);
                evento.print_event(null);

                //AÑADIR UN NUEVO EVENTO
            }

            if (option1 == 2) {
                //ELIMINAR EVENTO
                System.out.println("\n Inserte el código del evento que deseas eliminar: ");
                int codigo = inserts.nextInt();;
                evento.deleteEvent(codigo);
                evento.print_event(null);
                //FIN DE ELIMINAR EVENTO
            }

            if (option1 == 3) {

                //MENU MODIFICAR EVENTO

                System.out.println("\n Inserte el código del evento que quieres modificar: ");
                int codigo = inserts.nextInt();
                evento.print_event(evento.search_event(codigo));
                System.out.println("\n ¿Qué quieres modificar? ");
                System.out.println("\n 1. Nombre" + "\n 2. Descripción" + "\n 3. Ubicación" + "\n 4. Fecha");
                int option2 = inserts.nextInt();


                if (option2 == 1){
                    System.out.println("\n Nuevo Nombre: ");
                    String bufer = inserts.nextLine();
                    String nuevo_atributo = inserts.nextLine();
                    evento.modifyEvent(codigo, option2, nuevo_atributo);
                }

                if (option2 == 2){
                    System.out.println("\n Nuevo Descripción: ");
                }
                if (option2 == 3){
                    System.out.println("\n Nuevo Ubicación: ");
                }

                if (option2 == 4){
                    System.out.println("\n Nuevo Fecha: ");
                }

                //FIN DEL MENU DE MODIFICAR EVENTO

            }

            if (option1 == 4) {
                break;
            }
        }
    }



    }
