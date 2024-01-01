package Libraries;

public class Main {
    public static void main(String[] args) {
        ChildrenBook book1 = new ChildrenBook("Антуан де Сент-Экзюпери", "Маленький принц", 292.0 , 1943, 6);
        ChildrenBook book2 = new ChildrenBook("Джоан Роулинг", "Гарри Поттер и Узник Азкабана", 785.0 , 1997, 12);
        ChildrenBook book3 = new ChildrenBook("Джеймс Мэтью Барри", "Питер Пэн и Венди", 1941.0 , 1902, 6);
        ChildrenBook[] childrenBooks1 = new ChildrenBook[] {book1, book2, book3};
        ChildrenLibraryHall bookArray1 = new ChildrenLibraryHall("6+", childrenBooks1);
        ChildrenLibraryHall bookArray2 = new ChildrenLibraryHall("0+", 4);
        ChildrenBook book4 = new ChildrenBook("Льюис Кэрролл", "Алиса в стране чудес", 367.0, 1865, 6);
        ChildrenBook book5 = new ChildrenBook( "Джон Р. Р. Толкин", "Хоббит, или Туда и обратно", 1246.0, 1937 , 12);
        ChildrenBook book6 = new ChildrenBook("Алан Милн", "Винни-Пух", 701.0, 1926 , 3);
        ChildrenBook book7 = new ChildrenBook("Ганс Христиан Андерсен", "Сказки", 1028.0, 1839, 6);
        ChildrenBook book8 = new ChildrenBook("Николай Носов", "Незнайка в Солнечном городе", 692.0, 1958, 7);
        ChildrenBook[] childrenBooks2 = new ChildrenBook[] {book4, book5, book6, book7, book8};
        ChildrenLibraryHall bookArray3  = new ChildrenLibraryHall("3+", childrenBooks2);
        ChildrenLibraryHall[] hallArray = new ChildrenLibraryHall[] {bookArray1, bookArray2, bookArray3};
        ChildrenLibrary library = new ChildrenLibrary(hallArray);
        System.out.println("\nИмена залов и количество книг в залах в библиотеке\n" + library.getHallsNames());
        System.out.println("\nКоличество залов в библиотеке - " + library.getHallsQty());
        System.out.println("\nКоличество книг в библиотеке - " + library.getBooksQty());
        ChildrenLibraryHall[] tmpHallArray = library.getHallsArray();
        System.out.println("\nМассив залов библиотеки");
        for(int i = 0; i < tmpHallArray.length; i++) {
            System.out.println("\n\nЗал №" + i);
            for(int j = 0; j < tmpHallArray[i].getBooksQty(); j++) {
                System.out.println(tmpHallArray[i].bookIndex(j));
            }
        }
        int indexHall = 2;
        try {
            ChildrenLibraryHall tmpHall = library.getHallIndex(indexHall);
            System.out.println("\nВернем зал библиотеки под номером " + indexHall);
            for(int i = 0; i < tmpHall.getBooksQty(); i++) {
                System.out.println(tmpHall.bookIndex(i));
            }
        }
        catch (Exception e) {
            System.out.println("\nЗала в библиотеке с таким номером не существует!");
        }
        int indexBook = 8;
        System.out.println("\nКнига под номером " + indexBook + '\n' + library.getBookIndex(indexBook));

        System.out.println("\nОтсортированные по убыванию цены массива книг библиотеки\n");
        ChildrenBook[] booksSortedArray = library.sortedBooks();
        for (int i = 0; i < booksSortedArray.length; i++) {
            System.out.println(booksSortedArray[i].getCost() + " руб.");
        }

        System.out.println("\nНазвания всех залов и количество книг в них\n" + library.getHallsNames());

        ChildrenBook newBook1 = new ChildrenBook("Вениамин Каверин", "Два капитана", 629.0, 1938, 12);
        ChildrenBook newBook2 = new ChildrenBook("Агата Кристи", "Убийство в Восточном экспрессе", 270.0, 1934, 16);
        ChildrenBook[] newChildrenBooks = new ChildrenBook[] {newBook1, newBook2};
        ChildrenLibraryHall newBookArray = new ChildrenLibraryHall("12+", newChildrenBooks);
        System.out.println("\nЗамена зала под номером " + indexHall);
        library.changeHall(indexHall, newBookArray);
        System.out.println("\nМассив залов библиотеки");
        tmpHallArray = library.getHallsArray();
        for(int i = 0; i < tmpHallArray.length; i++) {
            System.out.println("\n\nЗал №" + i);
            for(int j = 0; j < tmpHallArray[i].getBooksQty(); j++) {
                System.out.println(tmpHallArray[i].bookIndex(j));
            }
        }

        ChildrenBook changeBook = new ChildrenBook("Редьярд Киплинг", "Книга джунглей", 1077.0, 1894, 6);
        System.out.println("\nКнига под номером " + indexBook + '\n' + library.getBookIndex(indexBook));
        System.out.println("\nЗаменим книгу под номером " + indexBook + " на книгу:");
        System.out.println(changeBook);
        library.changeBook(indexBook, changeBook);
        System.out.println("\nКнига под номером " + indexBook + '\n'  + library.getBookIndex(indexBook));

        int indexAdd = 9;
        try {
            System.out.println("\nДобавление книги на " + indexAdd + " позицию");
            ChildrenBook addBook = new ChildrenBook("Нина Петрова", "Сказки из Страны Чудес", 350.0, 1975, 4);
            library.addBook(indexAdd, addBook);
            if(library.getBookIndex(indexAdd) == null) throw new Exception();
            System.out.println("\nКнига под номером " + indexAdd + '\n' + library.getBookIndex(indexAdd));
        }
        catch (Exception e) {
            System.out.println("\nДобавление по данному номеру не доступно!");
        }

        int indexDelete = 0;
        System.out.println("\nКнига под номером " + indexDelete + '\n' + library.getBookIndex(indexDelete));
        library.bookErase(indexDelete);
        System.out.println("\nКнига под номером " + indexDelete + " после удаления книги\n" + library.getBookIndex(indexDelete));
        System.out.println("\nМассив залов библиотеки");
        for(int i = 0; i < tmpHallArray.length; i++) {
            System.out.println("\n\nЗал №" + i);
            for(int j = 0; j < tmpHallArray[i].getBooksQty(); j++) {
                System.out.println(tmpHallArray[i].bookIndex(j));
            }
        }

        System.out.println("\nКнига с самой большой ценой:" + library.getBestBook());
    }
}