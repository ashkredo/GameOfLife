# GameOfLife
Gra w życie (Life, The game of life) – jeden z pierwszych i najbardziej znanych przykładów automatu komórkowego, wymyślony w roku 1970 przez brytyjskiego matematyka Johna Conwaya. 

Gra toczy się na nieskończonej planszy (płaszczyźnie) podzielonej na kwadratowe komórki. Każda komórka ma ośmiu „sąsiadów” (tzw. sąsiedztwo Moore’a), czyli komórki przylegające do niej bokami i rogami. 

Każda komórka może znajdować się w jednym z dwóch stanów: może być albo „żywa” (włączona), albo „martwa” (wyłączona). Stany komórek zmieniają się w pewnych jednostkach czasu. 

Stan wszystkich komórek w pewnej jednostce czasu jest używany do obliczenia stanu wszystkich komórek w następnej jednostce.

Po obliczeniu wszystkie komórki zmieniają swój stan dokładnie w tym samym momencie.

Stan komórki zależy tylko od liczby jej żywych sąsiadów.

W grze w życie nie ma graczy w dosłownym tego słowa znaczeniu. 

Udział człowieka sprowadza się jedynie do ustalenia stanu początkowego komórek. 

Reguły gry według Conwaya 

 Martwa komórka, która ma dokładnie 3 żywych sąsiadów, staje się żywa w następnej jednostce czasu (rodzi się) 

 Żywa komórka z 2 albo 3 żywymi sąsiadami pozostaje nadal żywa; przy innej liczbie sąsiadów umiera (z „samotności” albo „zatłoczenia”). 

Reguły, jakim podlega automat opisywane są często skrótowo w następujący sposób: 

 przed ukośnikiem umieszcza się te liczby komórek w sąsiedztwie, dla których żywe komórki przeżywają (dla reguły Conwaya będzie to 23); 

 następnie umieszcza się ukośnik: /; 

 po ukośniku umieszcza się te liczby komórek w sąsiedztwie, dla których martwe komórki ożywają (dla reguły Conwaya będzie to 3); 

Reguły Conwaya można więc zapisać: 23/3, a reguły Trzy Cztery: 34/34. 


Zaimplementowano automat komórkowy  działający na skończonej planszy z cyklicznymi warunkami brzegowymi, z możliwością zadania reguł gry.
