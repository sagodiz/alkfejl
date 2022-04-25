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
 
 ## Help
 JSTL
<%
// valamikor valahol valahogy beállíthatunk attribútumokat.
// ez lehetne <c:set> is, de most nem fontos.
    UserSQLite dao = new UserSQLite();
    request.setAttribute("attribName", dao.findAll());
%>
<!-- Ez egy példa, hogyan kell végigjárni elemeken-->
<c:forEach var="varName" items="${requestScope.attribName}">

  <a href="${pageContext.request.contextPath}/someURI?someParameter=${varName.property}>StgText</a>

  <!-- Ez egy példa, hogyan kell feltételt használni-->
  <c:if test="${varName.isStg() || varName.booleanStuff}">
  
     Stuff
  </c:if>
</c:forEach>

