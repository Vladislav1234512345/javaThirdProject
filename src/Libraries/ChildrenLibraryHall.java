package Libraries;

public class ChildrenLibraryHall extends ChildrenBook{
    protected String hallName;
    protected ChildrenBook[] bookArray;

    public ChildrenLibraryHall() {
        this.hallName = "Не определено";
        this.bookArray = null;
    }
    public ChildrenLibraryHall(String hallName, int quantity) {
        bookArray = new ChildrenBook[quantity];
        this.hallName = hallName;
        for(int i = 0; i < quantity; i++) {
            bookArray[i] = new ChildrenBook();
        }
    }
    public ChildrenLibraryHall(String hallName, ChildrenBook[] bookArray) {
        this.hallName  = hallName;
        this.bookArray = bookArray;
    }
    public int getBooksQty() {
            return bookArray.length;
    }
    public String bookNames() {
        String namesOfBooks = "";
        for(int i = 0; i < bookArray.length; i++) {
            namesOfBooks += bookArray[i].getName() + '\n';
        }
        return namesOfBooks;
    }

    public double generalCost() {
        double resultCost = 0;
        for(int i = 0; i < bookArray.length; i++) {
            resultCost += bookArray[i].getCost();
        }
        return resultCost;
    }
    public ChildrenBook bookIndex(int index) {
        for(int i = 0; i < bookArray.length; i++) {
            if(index == i) {
                return bookArray[i];
            }
        }
        return null;
    }
    public void bookChange(int index, ChildrenBook newBook) {
        for(int i = 0; i < bookArray.length; i++) {
            if(index == i) {
                bookArray[i] = newBook;
                break;
            }
        }
    }
    public void bookErase(int index) {
        ChildrenBook[] tempBookArray = new ChildrenBook[bookArray.length - 1];
        int n = 0;
        for(int i = 0; i < bookArray.length; i++) {
            if(index != i) {
                tempBookArray[n] = bookArray[i];
                n++;
            }
        }
        bookArray = tempBookArray;
    }

    public void bookAdd(int indexBook, ChildrenBook addBook) {
        ChildrenBook[] newBookArray = new ChildrenBook[bookArray.length + 1];
        if(indexBook == bookArray.length) {
            for(int i = 0; i < bookArray.length; i++) {
                newBookArray[i] = bookArray[i];
            }
            newBookArray[bookArray.length] = addBook;
            bookArray = newBookArray;
        }
        else {
            for(int i = 0, j = 0; i < bookArray.length + 1; i++) {
                if(indexBook == i) {
                    newBookArray[i] = addBook;
                }
                else {
                    newBookArray[i] = bookArray[j];
                    j++;
                }
            }
            bookArray = newBookArray;
        }
    }

    public ChildrenBook getBestBook() {
        double max = bookArray[0].getCost();
        ChildrenBook bestBook = bookArray[0];
        for(int i = 0; i < bookArray.length; i++) {
            if(max < bookArray[i].getCost()) {
                max = bookArray[i].getCost();
                bestBook = bookArray[i];
            }
        }
        return bestBook;
    }
}
