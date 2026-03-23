1. Które z poniższych cech są cechami programowania funkcyjnego?
-w programowaniu funkcyjnym patrzymy na program jako na zbiór obiektów, które są od siebie zależne
-zmienne występujące w programie muszą być constant/final
-funkcje wielu zmiennych są pożądane, ponieważ sprawiają, że wykorzystanie tychże funkcji jest łatwiejsze
-funkcje przyjmujące jako argument inne funkcje są jednym z założeń paradygmatu

2. Które funkcje realizują currying?


def add(x):
	return lambda y: x + y



def multiply(x):
	return lambda y: x \* y**



def add_then_more(a, b):
	return lambda x: a + b + x



def make_sentence(a, b):
	return lambda c: a + " " + b + " " + c



3. Kiedy paradygmat FP znajduje swoje zastosowanie?
-program przetwarzający duże strumienie danych w czasie rzeczywistym
-UI design aplikacji webowej w CSS
-skomplikowane i numerycznie wymagające operacje na sygnałach
-duży program, który składa się z wielu bytów współpracujących ze sobą


4. Które funkcje z biblioteki Java.util.functions coś zwracają (mają return)?
-Predicate
-Consumer
-Supplier
-Function

5. Jakie z poniższych języków programowania są skierowane *stricte* pod paradygmat FP?
-Haskell
-Erlang
-Java
-Python