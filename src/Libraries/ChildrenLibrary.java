package Libraries;

public class ChildrenLibrary extends ChildrenLibraryHall{
    private ChildrenLibraryHall[] hallsArray;
    public ChildrenLibrary(int hallQty, int[] bookHallsQty) {
        if(bookHallsQty.length != hallQty) hallQty = bookHallsQty.length;
        this.hallsArray = new ChildrenLibraryHall[hallQty];
        for (int i = 0; i < hallQty; i++) {
            hallsArray[i] = new ChildrenLibraryHall("Не определено", bookHallsQty[i]);
        }
    }
    public ChildrenLibrary(ChildrenLibraryHall[] hallsArray) {
        this.hallsArray = hallsArray;
    }

    public int getHallsQty() { return hallsArray.length;}

    public int getBooksQty() {
        int booksQty = 0;
        for(int i = 0; i < hallsArray.length; i++) {
            booksQty += hallsArray[i].getBooksQty();
        }
        return booksQty;
    }

    public ChildrenLibraryHall[] getHallsArray() { return hallsArray;}

    public ChildrenLibraryHall getHallIndex(int hallIndex) {
        for(int i = 0; i < hallsArray.length; i++) {
            if(i == hallIndex) return hallsArray[i];
        }
        return null;
    }

    public ChildrenBook getBookIndex(int bookIndex) {
        for(int i = 0; i < hallsArray.length; i++) {
            for (int j = 0; j < hallsArray[i].getBooksQty(); j++) {
                if(bookIndex == 0) return hallsArray[i].bookIndex(j);
                bookIndex--;
            }
        }
        return null;
    }

    public ChildrenBook[] sortedBooks() {
        ChildrenBook[] booksArray = new ChildrenBook[getBooksQty()];
        int n = 0;
        for(int i = 0; i < hallsArray.length; i++) {
            for(int j = 0; j < hallsArray[i].getBooksQty(); j++) {
                booksArray[n] = getBookIndex(n);
                n++;
            }
        }
        boolean isSort;
        do {
            isSort = true;
            for (int i = 0; i < getBooksQty() - 1; i++) {
                if (booksArray[i].getCost() > booksArray[i + 1].getCost()) {
                    isSort = false;
                    ChildrenBook tmpBook = booksArray[i];
                    booksArray[i] = booksArray[i + 1];
                    booksArray[i + 1] = tmpBook;
                }
            }
        }
        while(isSort == false);
        return booksArray;
    }

    public String getHallsNames() {
        String namesAndBooksQty = "";
        for(int i = 0; i < hallsArray.length; i++) {
            namesAndBooksQty += "\nЗал №" + i + ": " + '"' + hallsArray[i].hallName + '"' + ", количество книг -  " + hallsArray[i].getBooksQty();
        }
        return namesAndBooksQty;
    }

    public void changeHall(int hallIndex, ChildrenLibraryHall newHall) {
        for(int i = 0; i < hallsArray.length; i++) {
            if(i == hallIndex) {
                hallsArray[i] = newHall;
                break;
            }
        }
    }

    public void changeBook(int bookIndex, ChildrenBook newBook) {
        for(int i = 0; i < hallsArray.length; i++) {
            for(int j = 0; j < hallsArray[i].getBooksQty(); j++) {
                if(bookIndex == 0)  {
                    hallsArray[i].bookChange(j, newBook);
                    break;
                }
                bookIndex--;
            }
        }
    }

    public void addBook(int bookIndex, ChildrenBook newBook) {
        for(int i = 0; i < hallsArray.length; i++) {
            if(bookIndex > hallsArray[i].getBooksQty()) {
                bookIndex -= hallsArray[i].getBooksQty();
            }
            else {
                hallsArray[i].bookAdd(bookIndex, newBook);
            }
        }
    }

    public void bookErase(int bookIndex) {
        for(int i = 0; i < hallsArray.length; i++) {
            for(int j = 0; j < hallsArray[i].getBooksQty(); j++) {
                if(bookIndex == 0) {
                    ChildrenLibraryHall newHall = new ChildrenLibraryHall(hallsArray[i].hallName, hallsArray[i].getBooksQty() - 1);
                    for(int k = 0, n = 0; k < hallsArray[i].getBooksQty(); k++) {
                        if(k != j) {
                            newHall.bookChange(n, hallsArray[i].bookIndex(k));
                            n++;
                        }
                    }
                    hallsArray[i] = newHall;
                    break;
                }
                bookIndex--;
            }
        }
    }

    public ChildrenBook getBestBook() {
        double max = hallsArray[0].bookIndex(0).getCost();
        ChildrenBook bestBook = hallsArray[0].bookIndex(0);
        for(int i = 0; i < hallsArray.length; i++) {
            for(int j = 0; j < hallsArray[i].getBooksQty(); j++) {
                if(max < hallsArray[i].bookIndex(j).getCost()) {
                    max = hallsArray[i].bookIndex(j).getCost();
                    bestBook = hallsArray[i].bookIndex(j);
                }
            }
        }
        return bestBook;
    }
}
