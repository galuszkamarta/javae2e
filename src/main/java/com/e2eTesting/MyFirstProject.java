package com.e2eTesting;

public class MyFirstProject {

  public static void main(String[] args) {

    hello("Marta");
    hello("user");
    hello("word");
    calculator();
// funkcja - jakiś nazwany fragment kodu, nie kazda f. jest metodą
    // metoda- f. zwiazana, albo kojazona z jakims obiektem, kazda metoda jest funkcja
    Square s = new Square(5);
    System.out.println("powierzchnia kwadratu o boko " + s.l + " = " + s.area());

    Rectangle r = new Rectangle(4, 6);
    System.out.println("powierzchnia protokąta o bokach " + r.a + " i " + r.b + " = " + r.area());

    Point p = new Point (2,-1);
    System.out.println("Współrzędne punktu =" + p.x + "," +p.y );


    double x1 = 1;
    double y1 = 2;
    double x2 = 4;
    double y2 = 2;

  }

public static void hello(String somebody){
  System.out.println("Hello, " + somebody + "!");
}


  public static void calculator() {
// wyrazenia i wartosci
    System.out.println(2 + 2);
    System.out.println(2 * 2);
    System.out.println(2 / 2);
    System.out.println(2 - 2);
    // liczby calkowite i zmienno przecinkowe
    System.out.println(1 / 2);
    System.out.println(1.0 / 2);
    System.out.println(1 / 2.0);
    System.out.println(2 / 2.0);
// kontakenacja - laczenie ze soba wyrazen (np tekst) w jedno
    System.out.println("2" + "2");
    System.out.println("2" + 2);
    System.out.println(2 + "2");

    System.out.println(2 + 2 * 2);
    System.out.println((2 + 2) * 2);

    System.out.println("2 + 2 = " + 2 + 2);
    System.out.println("2 + 2 = " + (2 + 2));


// Zmienne i wartości w j. programowania
    /* Wartość (value) -  (w danym konkretym przykladzie
    to wyrazenie ktore jest gdzies przechowywane w pamieci komputera) to kawaleczek danych, ktory jest przechowywany
    w pamieci komputera z ktorego w tej albo innej chwili, w czase dzialania programu skorzystac. mamy 2 typy wartosci:
    Literalne wartosci- w przebiegu programu sa zapisane wyraznie, sa znane w momencie napisania programu
    wyliczane wartosci - wartosci, te ktore powstaja w momencie obliczenia danego wyrazenia.

    *Zmienna (variable) - to identyfikator albo nazwa ktora odnosi sie do pewnej wartosci. To synonim dla pewnej wartosci,
    * ktora jest przecowywana w pamieci komputera i kiedy powstaje potrzeba, aby wykorzystac ta wartoc to wtedy zamiast
    * niej, w formule wstawiamy nazwe zmiennej, ktora na ta wartosc sie powoluje
    * - kiedy dana wartosc jest wykorzystywana kilka razy,
    * - przechowywanie jakis posednich wynikow (obliczanie w kilku dzialaniach),
    * */

    // typy wartości-
    /* typ zmiennej: int (integer) - l. całkowita
    double - liczba o podwojnej precyzji (zapis liczby zmiennoprzecinkowej)
    jezyk z silnym typowaniem,
     */

    int l = 6;
    int s = l * l;
    System.out.println("płaszczyzna kwadratu o boku " + l + " = " + s);


  }

}
