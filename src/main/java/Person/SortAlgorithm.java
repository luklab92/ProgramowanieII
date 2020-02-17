package Person;

import java.util.Comparator;

public class SortAlgorithm implements Comparator<Person> {

    private SortType type;
    public SortAlgorithm(SortType type) {
        this.type = type;
    }

    private int compareInputs;

    private void check(Person p1, Person p2) {
        if (type.equals(SortType.FIRSTNAME)) compareInputs = p1.getFirstName().compareTo(p2.getFirstName());
        else if (type.equals(SortType.LASTNAME)) compareInputs = p1.getLastName().compareTo(p2.getLastName());
        else compareInputs = Integer.compare(p1.getAge(),p2.getAge());
    }

    @Override
    public int compare(Person o1, Person o2) {
        check(o1,o2);
            if (compareInputs > 0) {
                return 1;
            } else return -1;
        }
}
