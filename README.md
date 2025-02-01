#!/bin/bash

# Sprawdzenie liczby parametrów
if [ "$#" -ne 3 ]; then
    echo "Użycie: $0 <link_do_repo> <liczba_całkowita> <Master|Test>"
    exit 1
fi

# Przypisanie parametrów
git_repo=$1
num=$2
branch=$3

# Sprawdzenie, czy drugi parametr to liczba
if ! [[ "$num" =~ ^[0-9]+$ ]]; then
    echo "Drugi parametr musi być liczbą całkowitą"
    exit 1
fi

# Klonowanie repozytorium
git clone "$git_repo" "s32160-repo"
cd "s32160-repo" || exit 1

echo "s32160" > ReadMe.md
date >> ReadMe.md

git add ReadMe.md
git commit -m "Dodanie ReadMe.md z numerem indeksu i datą"

# Tworzenie struktury katalogów
mkdir -p Zadanie/{Master,Test} Dokumenty/Tekstowe Dokumenty/Word Dokumenty/Obrazy

touch Dokumenty/Tekstowe/plik.txt Dokumenty/Word/plik.txt Dokumenty/Obrazy/plik.txt

git add .
git commit -m "Dodanie struktury katalogów"

# Tworzenie pliku x.txt w odpowiednim katalogu
echo "Sklep Produkt Cena" > "Zadanie/$branch/x.txt"
echo -e "Biedronka Kawa 25zl\nAuchan Woda 2zl\nLidl Chleb 6zl\nBiedronka Jajka 12zl\nAuchan Kurczak 24zl\nLidl Mleko 4zl\nBiedronka Ser 10zl\nAuchan Ziemniaki 7zl\nLidl Czekolada 5zl\nBiedronka Pomidory 11zl\nAuchan Makaron 6zl\nLidl Banany 6zl\nBiedronka Jogurt 5zl\nAuchan Cebula 4zl\nLidl Maslo 8zl\nBiedronka Szynka 15zl\nAuchan Ryz 9zl\nLidl Sok 7zl\nBiedronka Cukier 5zl\nAuchan Papier 14zl" >> "Zadanie/$branch/x.txt"

git add .
git commit -m "Dodanie pliku x.txt z produktami"

# Tworzenie gałęzi Zestawienie
git checkout -b Zestawienie

# Przenoszenie pliku i zmiana nazwy
mv "Zadanie/$branch/x.txt" Dokumenty/Tekstowe/Produkty.txt

git add .
git commit -m "Przeniesienie pliku x.txt do Dokumenty/Tekstowe jako Produkty.txt"

# Rozdzielenie produktów do osobnych plików
for sklep in Biedronka Auchan Lidl; do
    grep "^$sklep" Dokumenty/Tekstowe/Produkty.txt > "Zadanie/$branch/$sklep.txt"
    sed -i '1i Sklep Produkt Cena' "Zadanie/$branch/$sklep.txt"
    git add "Zadanie/$branch/$sklep.txt"
done

git commit -m "Podział produktów na pliki sklepowe"

# Tworzenie pliku Wybrane.txt
tail -n +2 Dokumenty/Tekstowe/Produkty.txt | head -n "$num" > "Zadanie/$branch/Wybrane.txt"
sed -i '1i Sklep Produkt Cena' "Zadanie/$branch/Wybrane.txt"

git add .
git commit -m "Dodanie pliku Wybrane.txt z wybranymi produktami"

# Powrót na główną gałąź i scalanie
git checkout master
git merge Zestawienie

git checkout -b Cofanie
git reset --soft HEAD~3
git commit -m "Cofnięcie do struktury katalogów"

# Tworzenie pliku Zepsuty.txt
git checkout master
mkdir -p Poprawa
echo "To jest zepsuty plik" > Poprawa/Zepsuty.txt
echo "Poprawa/Zepsuty.txt" > .gitignore

git add .gitignore
git commit -m "Dodanie .gitignore dla Zepsuty.txt"

# Wypchnięcie wszystkiego
git push origin master Zestawienie Cofanie
