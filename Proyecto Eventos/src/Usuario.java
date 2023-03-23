import java.util.Scanner;

//INICIALIZAMOS SCANNER PARA PEDIR VALORES
public class Usuario {

    Scanner inserts = new Scanner(System.in);
    public void buy_ticked(Evento evento) {
        evento.set_Boletas_disponibles((evento.get_Boletas_disponibles()) - 1);
    }

    public void fill_form(Evento evento){  //METODO QUE LE PERMITE AL USUARIO LLENAR UN FORMULARIO, SE LLAMA CUANDO EL USUARIO QUIERE COMPRAR UNA BOLETA

        System.out.println("\n Por favor llena estos datos: " );

        System.out.println("\n Codigo del evento: " );
        int codigo = inserts.nextInt();

        String bufer = inserts.nextLine();
        System.out.println("\n Tu nombre: " );
        String  nombre = inserts.nextLine();

        System.out.println("\n Documento de identificación: " );
        int documento = inserts.nextInt();

        System.out.println("\n Edad: " );
        int edad = inserts.nextInt();

        if (verify_age(evento.search_event(codigo), edad)){
            this.buy_ticked(evento.search_event(codigo));
            System.out.println("\n Tu compra ha sido exitosa " );
        }else System.out.println("\n No cumples con el minimo de edad" );
    }

    public boolean verify_age(Evento evento, int edad){
        if (evento.get_Edad_minima() <= edad){
            return  true;
        } else return false;
        }
    }


