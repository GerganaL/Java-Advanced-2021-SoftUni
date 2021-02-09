import java.util.Iterator;

public class Library implements Iterable<Book> {

    private class LibraryIterator implements Iterator<Book>{

        private  int index = 0;

        @Override
        public boolean hasNext(){
            return index < books.length;
        }

        @Override
        public Book next(){
            return books[index++];
        }

    }
    public Book[] books;

    public Library(Book... books){
        this.books = books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public Book[] getBooks() {
        return books;
    }

    @Override
    public Iterator<Book> iterator(){
        return  new LibraryIterator();
    }
}
