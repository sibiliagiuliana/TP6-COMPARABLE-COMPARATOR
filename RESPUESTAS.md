# RESPUESTAS.md

## Pregunta 1:  ¿Por qué Collections.sort()no compila cuando le pasó una List<Estudiante>? ¿Qué contrato exige Java que nuestra clase no está cumpliendo? --> The method sort(List<T>) in the type Collections is not applicable for the arguments (List<Estudinate>)

## Respuesta: No compila porque exige el tipo generico de la lista extienda 'Comparable<T>, debido a ello Java no sabe como ordenar los objetos 'Estudiante' entre si ya que no se cumple el metodo 'compareTo(T o)', el cual define el criterio de ordenn natural del objeto.

## Pregunta 2: ¿Por qué elige el atributo promedio como orden natural? ¿Qué pasaría si mañana un nuevo requisito pide ordenar por cantidadMateriasAprobadas? ¿Modificarías compareTo? ¿Qué consecuencias tendría?

## Respuesta: Elegimos 'promedio' como orden natural por ser el prinicipal merito de un estudiante a comparar en un contrexto universitario.

## No se podria realizar tal modificacion al metodo para el requisito de la cantidad de materias aprobadas porque 'compareTo' define un unico orden y como consecuencia cambiaria por completo el comportamiento en todo el sistema, violando el principio ABIERTO/CERRADO (OCP).

## Como solucion para multiples criterios se propone utilizar 'comparator'.

## Pregunta 3: Comparable nos ata a un único criterio de ordenamiento. ¿Qué problemas de diseño introduce esto si nuestro sistema necesitara ordenar la misma lista de estudiantes de 4 formas distintas según el contexto? Relacioná tu respuesta con los principios de responsabilidad única (SRP) y abierto/cerrado (OCP).

## Respuesta: Si necesitara ordenar la misma lista de estudiantes de 4 formas distintas segun el contexto 'comparable' no lo permite debido a que: 

## - Nuestra clase principal 'Estudiante' ya tiene como unica responsabilidad representar los datos del alumno y tener que asignarle una segunda responsabilidad (cambiar criterio de orden) implica modificarla aunque no cambien los datos del alumno como tal. Es decir, viola el Principio de Responsabilidad Unica (SRP).

## - Como planteamos el la segunda pregunta, modificarlo cambia el comportamiento en todo el sistema que es lo contrario a lo que propone el principio ABIERTO/CERRADO (OCP).


## Pregunta 4: Explicá con tus palabras qué es un overflow de enteros, por qué el "truco de la resta" lo provoca, qué parte del contrato de Comparator rompe, y por qué Integer.compare()no sufre este problema.

## Respuesta: Un overflow de enteros (desbordamiento) sucede cuando el resultado de una operacion aritmetica supera el rango maximo o minimo que puede representar el dato. Es decir, fuera de ese rango Java no lanza ninguna excepcion ni msj solo da la vuelta y devuelve un numero incorrecto y del signo contratrio al que se espera.

## El truco de la resta lo provoca ya que parece funcionar con valores normales pero en el caso de que fueran mas grandes o negativos, causa el desborde del int y el error es silencioso.

## El contrato de 'comparator' exige que sea antisimetrica,transitiva y consistente, cuando ocurre este desborde viola la antisimetria y por ultimo, integer.compare() no sufre este problema gracias a que utiliza comparaciones relacionales (<, ==) en lugar de operaciones aritmeticas, cumpliendo con todos los casos posibles como integer.MAX_VALUE, integer.MIN_VALUE y valores negativos.

## Pregunta 5: ¿Qué patrón de diseño estás aplicando al usar un Map<String, Comparator<T>>en lugar de un switch? Explicá cómo se relaciona este patrón con el polimorfismo y por qué es preferible a la alternativa procesal.

## Respuesta: Aplicamos el patron de diseño STRATEGY que define una familia de algoritmos, los encapsula en objetos separados e intercambiables y permite seleccionar uno de ellos en tiempo de ejecucion.

## Esta familia de algortimos son nujestros criterios de ordenamiento, donde cada 'comparator<Estudiante>' es una estrategia, el 'map<String, Comparator<Estudiante>> actua como el registro de estrategias disponibles y el metodo ordenar selecciona la estrategia correcta.

## Lo relacionamos con el polimorfismo mediante el mensaje (`sort`) ya que produce comportamientos distintos según el objeto receptor, sin que el código que lo invoca sepa qué estrategia se está ejecutando. 

## Es preferible a la alternativa procesal ya que no viola los principios que nombramos con aterioridad SRP y OCP, el Map al ser declarativo es la forma mas limpia a la hora de implementar STRATEGY por ser consiso, extensible y sin agregar clases adicionales.

