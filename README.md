# Timer-Application
A Timer Application using Swing.

Aplicatia se initializeaza cu un dialog cu doua optiuni: Settings și Close. Cu clic pe Close sau pe X, aplicatia se inchide imediat.
Cu clic pe Settings se deschide prima fereastra, care contine mai multe componente.

După definirea timpului sau in timpul definit, trebuie sa apara a doua fereastra, al carei fundal isi va schimba culoarea.
Culoarea de fundal si viteza de schimbare vor depinde de setarile din prima fereastra.

A doua fereastră trebuie sa se afiseze după expirarea intervalului de timp definit de timer. 
In primul caz (onTime) – in momentul in care se ajunge la ora setata (forma HH:mm:ss), sau in al doilea caz (countdown) – dupa numarul de secunde ales (numarul complet pozitiv).
O optiune o dezactiveaza pe alta.

Butonul "Choose color" prezinta paleta pentru alegerea culorii, unde, dupa alegere, culoarea va fi afisata in label-ul de langa buton.
Acest label prezinta ora curenta (format HH:mm:ss), care se actualizeaza la fiecare secunda.
In a doua fereastra, culoarea aleasa se va schimba in culoarea alba obtinandu-se efectul de „blinking”.

Lista derulanta se foloseste pentru alegerea vitezei de schimbare a culorii in a doua fereastra. Intervalul este intre 1 si 5 secunde.

Butonul "Start Countdown" se foloseste pentru pornirea timerului.
Atunci, toate controalele din prima fereastra devin inactive, in afara de butonul "Stop".
Intreaga aplicatie se inchide daca se selecteaza tasta Close(x) din prima fereastra.

Cu clic pe Stop se opreste timerul, a doua fereastra dispare si controalele din prima fereastra devin accesibile.
