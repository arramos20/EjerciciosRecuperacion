import java.util.*;

public class WhatsApp {
    List<Mensaje> listaMensajes=new ArrayList<Mensaje>();

    Scanner scan = new Scanner(System.in);

    public WhatsApp(List<Mensaje> listaMensajes) {
        this.listaMensajes = listaMensajes;
    }

    public List<Mensaje> getListaMensajes() {
        return listaMensajes;
    }

    public void setListaMensajes(List<Mensaje> listaMensajes) {
        this.listaMensajes = listaMensajes;
    }

    public String addMessage(){
        int ultimoId;
        if(!listaMensajes.isEmpty()){
            ultimoId=listaMensajes.get(-1).getId()+1;
        } else {
            ultimoId=1;
        }
        System.out.println("Pon el nombre de la persona que va a recibir el mensaje: ");
        String receptor = scan.nextLine();
        scan.close();
        System.out.println("Pon el cuerpo del mensaje: ");
        String cuerpo = scan.nextLine();
        scan.close();

        Mensaje msgNuevo=new Mensaje(ultimoId, receptor, cuerpo);
        listaMensajes.add(msgNuevo);

        return "Mensaje nuevo añadido.";
    }

    public Mensaje searchMsg(){
        Mensaje msgFinal=null;
        System.out.println("Pon el nombre de la persona que ha recibido el mensaje a buscar: ");
        String receptor = scan.nextLine();
        scan.close();
        for (int i = 0; i < listaMensajes.size(); i++) {
            if(listaMensajes.get(i).getContacto()==receptor){
                msgFinal= listaMensajes.get(i);
            }
        }
        if (msgFinal==null){
            System.out.println("No hay ningún mensaje cuyo receptor sea el introducido.");
        }
        return msgFinal;
    }

    public String deleteSearchedMsg(){
        String resultado="El mensaje se ha borrado con éxito.";
        Mensaje msgBuscado=searchMsg();
        listaMensajes.remove(msgBuscado);
        if(msgBuscado==null){
            resultado="No se pudo borrar el mensaje.";
        }
        return resultado;
    }

    public void printMsgList(){
        Mensaje msg;
        Iterator it= listaMensajes.iterator();
        while(it.hasNext()){
            msg= (Mensaje) it.next();
            System.out.println(msg.toString() + "\n");
        }
    }

    public String modifyMsgBody(){
        String resultado="Cuerpo del mensaje modificado con éxito.";
        Mensaje msgFinal=searchMsg();
        System.out.println("El cuerpo del mensaje es:");
        listaMensajes.get(listaMensajes.indexOf(msgFinal)).getCuerpo();
        System.out.println("Introduce lo que quieres escribir en el cuerpo: ");
        String cuerpoNuevo = scan.nextLine();
        scan.close();

        msgFinal.setCuerpo(cuerpoNuevo);

        listaMensajes.set(listaMensajes.indexOf(msgFinal), msgFinal);

        if(msgFinal==null){
            resultado="No se pudo modificar el cuerpo del mensaje.";
        }

        return resultado;
    }

    public String orderListByContact(){
        Collections.sort(listaMensajes, new ContactMsgComparator());
        return "Lista ordenada por los contactos.";
    }

}
