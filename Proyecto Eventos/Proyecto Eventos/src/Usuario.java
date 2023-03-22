public class Usuario {

    public void comprar_boleta(Evento evento) {
        evento.set_aforo((evento.get_aforo()) - 1); //REEMPLAZAR AFORO POR CUPOS
    }
}
