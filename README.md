# alkfejl
Alkalmazás fejlesztés gyakorlathoz előre kiadott anyag a gyorsabb haladás érdekében.
## A kiadott anyag
 - model: User
 - dao: interface + implementáció
 - config util
 - kiindulási index.jsp
 
## Feladat
JSP oldalak és Servletek készítése.
Amit pluszban átnézünk az a JSTL.

- Index a login felülettel
- LoginController(servlet) ami beléptet (sessionban) ha jogosultak vagyunk
- A home.jsp listázza ki a felhasználókat (és hogy adminok-e)
 - jstl: <c:foreach>
 - jsp:include, HomeController
 - opcionális: legyen /home a .jsp nélkül is elérhető
- Update (servlet)
 - admin esetében egy form az adatoknak
 - nem admin esetében csak legyen kiírva
 
