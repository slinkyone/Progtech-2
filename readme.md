# Feladat:

Készítsünk programot, amellyel egy könyvtár nyilvántartását valósíthatjuk meg az alábbi funkciókkal:
-	A programban megtekinthetőek a tagok adatai (név, cím, könyvtárjegy szám), valamint a könyvek adatai (szerző, cím, ISBN szám, kiadás éve, összes példányszám, szabad példányszám).
-	Lehetőségünk van új tag felvitelére a név és cím megadásával. A könyvtárjegy száma automatikusan generálódik. A tag módosítható, illetve törölhető is, amennyiben nincs kint lévő kölcsönzése (a könyvtárjegy száma nem módosítható).
- Tag, illetve könyv kijelölésével vihetünk fel új kölcsönzést. Csak akkor lehet kölcsönözni, ha még van szabad példány, és egy tag egyszerre csak négy könyvet kölcsönözhet. A kölcsönzés dátumát automatikusan rögzítjük.
-	A kikölcsönzött könyveket lehessen visszahozni. A vissza hozatal dátumát automatikusan rögzítjük.

Az adatbázis az alábbi adatokat tárolja (ezek még nem feltétlenül a fizikai adattáblák):
-	tagok (név, cím, könyvtárjegy szám)
-	könyvek (szerző, cím, ISBN szám, kiadás éve, példányszám)
-	kölcsönzések (tag, könyv, kölcsönzés dátuma, visszahozás dátuma)
