# Automatyczne testy end-to-end (Selenium, Java)

## Wybrane strony/aplikacje

1. **Sauce Demo** — https://www.saucedemo.com
- Krótkie uzasadnienie: aplikacja demo do testów automatycznych, posiada łatwy login i sklep (dodawanie produktów do koszyka).

2. **The Internet (Herokuapp)** — https://the-internet.herokuapp.com/checkboxes
- Krótkie uzasadnienie: zbiór prostych przykładów (checkboxes, formy, authentication) idealny do scenariuszy testowych.

## Scenariusze testowe (opisowe)

### Scenariusz 1 — Sauce Demo: logowanie i dodanie produktu do koszyka

**Cel:** zweryfikować, że użytkownik może się zalogować i dodać produkt do koszyka.

**Kroki:**
1. Otwórz stronę `https://www.saucedemo.com`
2. Wprowadź login `standard_user` i hasło `secret_sauce`
3. Kliknij "Login"
4. Sprawdź, że lista produktów jest wyświetlona
5. Dodaj pierwszy produkt do koszyka (kliknij przycisk `Add to cart` przy pierwszym produkcie)
6. Przejdź do koszyka (ikona koszyka)
7. Sprawdź, że wybrany produkt jest widoczny w koszyku

**Oczekiwany rezultat:** użytkownik zostaje zalogowany, produkt pojawia się w koszyku.

---

### Scenariusz 2 — The Internet: checkboxy — przełączanie stanu

**Cel:** sprawdzić, że checkboxy można zaznaczać i odznaczać oraz że ich stan jest poprawnie zachowywany.

**Kroki:**
1. Otwórz stronę `https://the-internet.herokuapp.com/checkboxes`
2. Znajdź listę checkboxów
3. Zaznacz pierwszy checkbox jeśli nie jest zaznaczony
4. Odznacz drugi checkbox jeśli jest zaznaczony
5. Odśwież stronę (opcjonalne) i sprawdź, że interakcja ma oczekiwany rezultat (w zależności od aplikacji)

**Oczekiwany rezultat:** checkboxy zmieniają stan zgodnie z akcjami testu.

---

## Uruchamianie testów

Wymagania: Java 21, Gradle.

```
./gradlew test -Dbrowser=chrome && ./gradlew test -Dbrowser=firefox
```
