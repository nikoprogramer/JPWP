package proj;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.function.*;
import java.util.stream.*;


public class Main {
    //Record - Specjalny modyfikator - pola obiektów są final więc idealnie do FP
    public static record Product(String name, double price) {};
    public static record Order(Map<Product,Double> products, LocalDate date) {};
    public static record Client(String name, String surname, int age, Order order, Boolean isMan) {};
   
    //Filtry
    public static Predicate<Client> olderThanFilter(int minAge){
        return c -> c.age()>=minAge;
    }
    public static Predicate<Client> hasProductFilter(String product){
        return c -> c.order().products.keySet().stream().anyMatch(p -> p.name().equals(product));
    }
    public static Predicate<Client> spentMoreThanFilter(Double cost){
        return c -> getMoneySpent().apply(c)>cost;
    }

    //Funkcje
    public static Function<Client,String> getClientName(){
        return c -> c.name() + " " + c.surname();
    }
    public static Function<List<Client>,List<Client>> getFilteredClients(Predicate<Client> filter){
        return list -> list.stream().filter(filter).collect(Collectors.toUnmodifiableList());
        //ALTERNATYWA:
        //return list -> list.stream().filter(filter).toList;
    }
    public static Function<Client,Double> getMoneySpent(){
        return c -> c.order().products().entrySet().stream().mapToDouble(p -> p.getKey().price() * p.getValue()).sum();
    }
    public static Function<List<Client>,Map<String,Double>> getMoneySpentMap(){
        return map -> map.stream().collect(Collectors.toUnmodifiableMap(getClientName(), getMoneySpent()));
    }

    //Consumer  
    public static Consumer<List<Client>> printClientsNames(){
        return list -> list.forEach(c -> System.out.println(" - " + getClientName().apply(c)));
    }
    public static Consumer<Map<String,Double>> printMoneySpendingsMap(){
        return  map -> map.forEach((name,spent) -> System.out.println(name + " | " + spent));
    }

    public static void main(String[] args){

        //Inicjalizacja niemutowalnej listy produktów
        List<Product> products = List.of(
            new Product("Orange", 9.3),
            new Product("Apple", 7.5),
            new Product("Banana", 11.4)
        );

        //Inicjalizacja niemutowalnej listy zakupów
        List<Order> orders = List.of(
            new Order(
                Map.of(products.get(0), 4.5, products.get(1), 3.2),
                LocalDate.parse("2026-02-22")),
            new Order(
                Map.of(products.get(1), 20.2),
                LocalDate.parse("2026-03-01")),
            new Order(
                Map.of(products.get(2), 11.6),
                LocalDate.parse("2025-02-16"))                
        );

        //Inicjalizacja niemutowalnej listy klientów
        List<Client> clients = List.of(
            new Client("Adam", "Katowski", 30, orders.get(0), true),
            new Client("Kacper", "Liczak",17, orders.get(1), true),
            new Client("Ola", "Kowalska",20, orders.get(2), false)
        );


        //Lista Nazwisk ludzi dorosłych
        System.out.println("Nazwiska dorosłych:");
        final List<Client> names = getFilteredClients(olderThanFilter(18)).apply(clients);
        printClientsNames().accept(names);
        //Lub jednym ciągiem funkcji jak poniżej
        //printClientsNames().accept(getFilteredClients(olderThanFilter(18)).apply(clients));
        //

        //mapa klientów i zarobek brutto na kazdym
        System.out.println("--------------------------------\n BRUTTO:");
        printMoneySpendingsMap().accept(getMoneySpentMap().apply(clients));
        //

        //Lista klientów którzy kupili jabłka
        System.out.println("--------------------------------\nKupili jabłka:");
        final List<Client> boughtApples = getFilteredClients(hasProductFilter("Apple")).apply(clients);
        printClientsNames().accept(boughtApples);

        //Na podstawie poprzedniej listy lista klientów którzy zakupili jabłka i wydali ponad 100 BRUTTO
        System.out.println("--------------------------------\n Kupili jabłka i wydali ponad 100.0:");
        printMoneySpendingsMap().accept(getMoneySpentMap().apply(getFilteredClients(spentMoreThanFilter(100.0)).apply(boughtApples)));
        //

        //Łączenie warunków - klienci którzy kupili banany i mają >= 20 lat
        System.out.println("--------------------------------\n Kupili banany i mają >= 20 lat:");
        printClientsNames().accept(getFilteredClients(olderThanFilter(20).and(hasProductFilter("Banana"))).apply(clients));
        //
    }
}
