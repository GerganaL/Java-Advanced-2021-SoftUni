import java.util.Comparator;

public class BookComparator implements Comparator<Book> {
    @Override
    public int compare(Book first, Book second) {
       /* int result = f.getTitle().compareTo(s.getTitle());
        return  result != 0 ? result: Integer.compare(f.getYear(),s.getYear());*/
        int compareResult =
                first.getTitle().compareTo(second.getTitle());

        if (compareResult == 0) {
            compareResult = Integer.compare(first.getYear(), second.getYear());
        }

        return compareResult;

    }
}
