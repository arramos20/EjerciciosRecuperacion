import java.util.Comparator;

public class ContactMsgComparator implements Comparator<Mensaje> {
    @Override
    public int compare(Mensaje o1, Mensaje o2) {
        return o1.getContacto().compareTo(o2.getContacto());
    }
}
