# alkfejl
Alkalmazás fejlesztés gyakorlathoz előre kiadott anyag a gyorsabb haladás érdekében.
## 5 gyakorlat

### Kapott anyag leírása
Az előző órán elkészítettünk egy bean-t
 - adattagok
 - default konstruktor
 - setter és getter
Ez az amit szeretnénk az adatbázisban letárolni. Ehhez el kell készíteni az adatbázisban való tárolást.
Különféle adatbázisokhoz való csatlakozás miatt kell egy interface amit egy-egy konkrét adatbázis csatlakozáshoz meg kell valósítanunk, pl. SQLite.
Ezután a GUI felületet meghajtó Controller osztállyal kell összekapcsolnunk az adatbázist meghajtó DAO réteget.

Osztályok: 
 - tulajdonságok lekérdezése: hu.alkfejl.util.ConnectionUtil
 - SQL lekérdezések: hu.alkfejl.util.SqlUtil
 - GUI controller: hu.alkfejl.controller.MainWindowController
 - futtatható állomány: hu.alkfejl.App

### Feladatok
A feladat egy Phone bean elkészítése és az ahhoz tartozó SQLite dao implementáció. (Előző órán ez volt + minta található másik beanre)
A Phone tulajdonságait a db alapján kell kideríteni!

Miután a bean és az azt kezelő dao is elkészült egy grafikus felületet kell készíteni
 - menü sáv: a File > Close elem *helyesen* lépjen ki
 - egy táblázat melyben a következő oszlopok vannak
    - név
    - email
    - actions

Név oszlop: A Contact neve
Email oszlop: a Contact email címe
Actions oszlop: oszlop, melyben 2 gomb foglal helyet
 - delete
 - edit

Delete hatására töröljük a Contact-ot az adatbázisból. Figyelmeztessük a felhasználót a tettének következményeire!

Edit hatására hagyjunk TODO warningot.