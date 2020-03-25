# Practica_EPED_2019_2020
Practica obligatoria de Estrategias de Programación y Estructuras de Datos de 2020.

1. Presentación del problema

  El conocido concurso “Cifras y Letras” propone a sus participantes dos tipos de pruebas: una
  prueba de cifras en la que deben aproximarse lo más posible a un número objetivo utilizando
  operaciones básicas sobre una serie de números y una prueba de letras, en la que deben encontrar la
  palabra (válida) más larga que se pueda formar con un grupo de letras determinado.
  En esta práctica vamos a crear un programa que resuelve esta prueba de forma automática.
  Concretamente el programa recibirá una serie de letras y nos devolverá todas las palabras válidas
  que se puedan construir con ellas. Para comprobar si una palabra es válida o no, es imprescindible
  el uso de un diccionario.
  
  Para ello, se proporcionará un fichero con el diccionario en forma de lista de 79517 palabras
  pertenecientes al Diccionario de la RAE para que los estudiantes puedan probar su programa. Para
  evitar problemas debidos a la codificación de caracteres, se han borrado todas las palabras que
  contienen la ñ y se han eliminado los acentos gráficos.
  
  La práctica se dividirá en dos fases diferentes:
  
    1. Creación del diccionario: se cargará un fichero de texto que contiene las palabras que
    vamos a considerar válidas (una palabra por línea) y se insertará cada una de ellas en una
    estructura de diccionario sobre la cual se consultarán las posibles palabras.
    2. Búsqueda de palabras: una vez se disponga del diccionario, el programa cargará un
    segundo fichero de búsquedas a realizar, cada una de las cuales consistirá en una secuencia
    de letras a analizar y un tamaño de palabra (que podrá ser un número o bien ALL para que el
    programa considere todos los posibles tamaños de palabra presentes en el diccionario). El
    programa devolverá todas las posibles palabras válidas que se puedan construir a partir de
    esas letras (y del tamaño adecuado), ordenadas alfabéticamente y agrupadas por tamaño de
    mayor a menor.
    
  La única restricción que se plantea es que no se permite el uso de iteradores, por lo que cualquier
  acceso a las estructuras de datos deberá hacerse prescindiendo de ellos.
  
  
2. Enunciado de la práctica

  La práctica consiste en elaborar un programa en Java, utilizando los Tipos de Datos programados
  por el Equipo Docente, que resuelva el problema propuesto. Los estudiantes dispondrán de una serie
  de clases ya programadas (total o parcialmente) y deberán completar el programa de forma que
  pueda realizar correctamente la tarea que se ha indicado.
  
