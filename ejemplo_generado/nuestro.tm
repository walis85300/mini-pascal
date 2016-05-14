*      Compilacion TINY para el codigo objeto TM
*      Archivo: NOMBRE_ARREGLAR
*      Preludio estandar:
0:       LD       6,0(0)      cargar la maxima direccion desde la localidad 0
1:       ST       0,0(0)      limpio el registro de la localidad 0
*      -> Funcion
*      -> Operacion: mas
*      -> identificador
3:       LD       0,1(5)      cargar valor de identificador: x
*      -> identificador
4:       ST       0,0(6)      op: push en la pila tmp el resultado expresion izquierda
*      -> identificador
5:       LD       0,2(5)      cargar valor de identificador: y
*      -> identificador
6:       LD       1,0(6)      op: pop o cargo de la pila el valor izquierdo en AC1
7:       ADD       0,1,0      op: +
*      <- Operacion: mas
8:       LDA       7,9(5)      returns
9:       LDA       7,0(4)      Salto incodicional a donde fue llamada la funcion
*      -> Procedure
*      -> escribir
*      -> Operacion: por
*      -> identificador
10:       LD       0,3(5)      cargar valor de identificador: z
*      -> identificador
11:       ST       0,0(6)      op: push en la pila tmp el resultado expresion izquierda
*      -> identificador
12:       LD       0,4(5)      cargar valor de identificador: k
*      -> identificador
13:       LD       1,0(6)      op: pop o cargo de la pila el valor izquierdo en AC1
14:       MUL       0,1,0      op: *
*      <- Operacion: por
15:       OUT       0,0,0      escribir: genero la salida de la expresion
*      <- escribir
16:       LDA       7,0(4)      Salto incodicional a donde fue llamado el procedimiento
2:       LDA       7,17(5)      Salto incondicional al main del programa
*      -> constante
17:       LDC       0,2(0)      cargar constante: 2
*      <- constante
18:       ST       0,1(5)      llamado: guarda el valor del argumento
*      -> constante
19:       LDC       0,3(0)      cargar constante: 3
*      <- constante
20:       ST       0,2(5)      llamado: guarda el valor del argumento
*      -> CALLLLL
21:       LDA       4,1(7)      
22:       LDA       7,3(5)      Salto a la primera linea de la funcion
23:       ST       0,3(5)      llamado: guarda el valor del argumento
*      -> constante
24:       LDC       0,4(0)      cargar constante: 4
*      <- constante
25:       ST       0,4(5)      llamado: guarda el valor del argumento
*      -> CALLLLL
26:       LDA       4,1(7)      
27:       LDA       7,10(5)      Salto a la primera linea de la funcion
*      Fin de la ejecucion.
28:       HALT       0,0,0   