import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner inserts = new Scanner (System.in);  //INICIALIZAMOS SCANNER PARA PEDIR VALORES

        System.out.println("\n Hola, bienvenido, supongo sabes a que vienes no?" );
        System.out.println("\n Quieres iniciar sesión como:" + "\n 1. Administrador" + "\n 2. Usuario"  );

        Evento evento = new Evento(null, null, null, null, 0, 0);
        Usuario user = new Usuario();

        //INPUTS DE EVENTOS

        evento.AddEvent("Festival Musical Internacional", "Concierto de bandas extrangeras", "Teatro", "2/03/2024", 16, 30 );
        //evento.AddEvent("Sharkira", "Concierto de la famosa cantante chakira", "Auditorio 10", "7/06/2023");

        //FIN DE INPUTS DE PRUEBA

        int option_user = inserts.nextInt();


        if (option_user == 1) {
            System.out.println("\n Inserta la contraseña: " );
            String bufer__ = inserts.nextLine();
            String contraseña = inserts.nextLine();

            if (contraseña.equals("EMPERADOR") ) {
                System.out.println("\n ####LISTA DE EVENTOS####" + "\n --------------------------------------" );
                evento.print_event(null);


                //##MENU##

                while (true){
                    System.out.println("\n ¿Que quieres hacer?" + "\n 1. Añadir un nuevo evento" + "\n 2. Eliminar un evento" + "\n 3. Modificar un evento" + "\n 4. Salir");
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
                        System.out.println("\n 1. Nombre" + "\n 2. Descripción" + "\n 3. Ubicación" + "\n 4. Fecha"+ "\n 5. Edad minima"+ "\n 6. Aforo"+ "\n 7. Boletas disponibles");
                        int option2 = inserts.nextInt();

                        if (option2 == 1){
                            System.out.println("\n Nuevo Nombre: ");
                            String bufer = inserts.nextLine();
                            String nuevo_atributo = inserts.nextLine();
                            evento.modifyEvent(codigo, option2, nuevo_atributo, 0);
                        }

                        if (option2 == 2){
                            System.out.println("\n Nueva Descripción: ");
                            String bufer = inserts.nextLine();
                            String nuevo_atributo = inserts.nextLine();
                            evento.modifyEvent(codigo, option2, nuevo_atributo, 0);
                        }
                        if (option2 == 3){
                            System.out.println("\n Nueva Ubicación: ");
                            String bufer = inserts.nextLine();
                            String nuevo_atributo = inserts.nextLine();
                            evento.modifyEvent(codigo, option2, nuevo_atributo, 0);
                        }

                        if (option2 == 4){
                            System.out.println("\n Nueva Fecha: ");
                            String bufer = inserts.nextLine();
                            String nuevo_atributo = inserts.nextLine();
                            evento.modifyEvent(codigo, option2, nuevo_atributo, 0);

                        }

                        if (option2 == 5){
                            System.out.println("\n Nueva Edad minima: ");
                            String bufer = inserts.nextLine();
                            int nueva_cifra = inserts.nextInt();
                            evento.modifyEvent(codigo, option2, null, nueva_cifra);

                        }

                        if (option2 == 6){
                            System.out.println("\n Nuevo Aforo: ");
                            String bufer = inserts.nextLine();
                            int nueva_cifra = inserts.nextInt();
                            evento.modifyEvent(codigo, option2, null, nueva_cifra);

                        }

                        if (option2 == 7){
                            System.out.println("\n Nuevas Boletas disponibles: ");
                            String bufer = inserts.nextLine();
                            int nueva_cifra = inserts.nextInt();
                            evento.modifyEvent(codigo, option2, null, nueva_cifra);

                        }


                        //FIN DEL MENU DE MODIFICAR EVENTO

                    }

                    if (option1 == 4) {
                        break;
                    }
                }
            }


        }
        if (option_user == 2){
            while  (true){
                System.out.println("\n$$$$$$ BOLETERIA $$$$$$");
                System.out.println("\n Bienvenido Usuario a la boleteria " + "\n 1. Comprar boletas " + "\n 2. Salir"  );
                int option_bol = inserts.nextInt();

                if (option_bol == 1){
                    System.out.println("\n Tenemos los siguientes eventos disponibles: "  );
                    evento.print_event(null);
                    //FORMULARIO
                    user.fill_form(evento);
                    //FIN DEL FORMULARIO

                }

                if (option_bol == 2){
                    break;
                }
            }
        }
    }
    }
