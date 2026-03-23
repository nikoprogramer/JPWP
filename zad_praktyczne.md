=====================================================================================

1 - (BEZ DOŁĄCZONEGO KODU). Splitter optyczny światłowodowy dzieli moc sygnału wejściowego po równo na wyjścia (tzn. np. splitter 1-to-4 tłumi sygnał 4-krotnie). Napisz (w dowolnym języku programowania) funkcję spełniającą założenia programowania funkcyjnego, która przyjmie na wejście moc wiązki światła i zwróci jej moc po przejsciu przez splitter 1-to-16 jako double. Następnie zapisz tą wartość pod inną zmienną i wyprintuj ją do konsoli.

=====================================================================================

2 - (DO NASZEGO KODU). Napisz filtr, który będzie przepuszczać tylko klientów, który są mężczyznami

Podpowiedź: Każdy rekord posiada pole isMan typu Boolean

=====================================================================================

3 - (DO NASZEGO KODU). Zaimportuj 'import java.time.temporal.ChronoUnit;'. Następnie stwórz funkcje która wypisze (NIE ZWRÓCI!)ile dni temu kazdy z klientów dokonał zamówienia (jakiego interfejsu funkcyjnego uzyjesz?)

Podpowiedź: zaimportowany pakiet dostarcza nam funkcję ChronoUnit.DAYS.between(data_wczesniej, data_pozniej) która zwraca nam różnicę dni pomiędzy datami

=====================================================================================

4a - (DO NASZEGO KODU). Stworz funkcje ktora bedzie przyjmowac mapę [String, Double] z funkcji getMoneySpentMap i modyfikować nam mapę w taki sposób że Double będzie kwotą NETTO 	(dzieli kazdą wartość Double przez 1.23)

Podpowiedź: Funkcja getMoneySpentMap zwraca nam Map(String, Double) gdzie String to ImieNazwisko a Double to kwota BRUTTO

------------------------------------------------------------------------------------

4b - Następnie zrób funkcję która będzie wyświetlać łączny zysk netto od wszystkich klientów(NIE ZWRACAĆ!!!). Wykonaj tę funkcję.

Podpowiedź: Użyj strumienia i mapuj wartości Map na Double w celu zsumowania( Strumień Double'ów posiada metodę .sum() )

	
=====================================================================================
