Analisis de Extension Libreria (re-entrega):

El fuente tiene definido un Enumerador para MES
Se  le realizó la generación de cobertura de maven, y se observa que tiene muy buena cobertura, de hecho de Cobertura 
de linea tiene 100%. Aunque no se sabe si los tests creados son los adecuados.

Los nombres de los metodos son coherentes y el codigo fuente proporcionado tiene correcta la indentacion.

La solucion consta de 8 clases y un enumerado para mes.
Contiene tambien sus respectivos test. Parece que se utilizo TDD para cumplir con la consigna, lo cual es valorable.
Volviendo al 100% de cobertura de linea, ahora me cierra de que el codigo tiene lo justo y necesario para funcionar
(en lo que refiere a metodos creados).

Analisis del codigo: relacion de clases y sus test
En esta implementacion, una suscripcion es una compra, lo cual es un punto de vista no del todo errado a mi entender.
Lo programa de tal manera de que la compra guarda una coleccion de productos "comprados".
Tambien por herencia, la suscripcion redefine los metodos agregarProducto y getPrecioDeLaCompra. 
En el primer caso, para asegurarse de que al momento de agregarse, solo lo haga cuando el tipo de producto sa tanto 
un Libro como un ArticuloDeLibreria (lo hace mediante el uso de instanceof de java).
En el segundo metodo, el precio de la compra, en ese metodo, hace el uso del atributo de clase de anualidad (como boolean) 
para calcularla, ya que si la suscripcion fue seteada con anualidad, se le realiza el 20% de descuento.

Este parte se nota que es un mal atajo, en clase lo destacamos. Lo voy a cambiar para arreglarlo de otra manera.
Otra cosa mal que tiene es que testea los casos de excepciones de una manera muy generica, 
utiliza @Test(expected = Exception.class).
Aca se mejoraria al menos que espere una RuntimeException (lanzando un mensaje).

En LibreriaTest, y otros tests, hay muchos test de simples getters y setters.

El test libreriaAgregaClienteASuListaDeClientesRegistrados, utiliza una simple llamada a un contains de lista de 
cliente de libreria... podria pasarse de largo esto...
El metodo calcularMontoACobrar de la libreria, recibe el cliente y el mes, pero al margen de que funciona bien, 
no me cierra de porque no le pregunta nunca a la libreria si ese cliente es valido...  o sea, no lo valida, 
cuando tiene un metodo para eso (esClienteRegistrado).

La clase cliente tiene atributo direccion, pero no es importante, ni se usa...
Tambien tiene el meodo eliminarCompra, sin lanzar una RuntimeException.
Este metodo no se pedia en si programarlo, es un valor agregado no del todo mal (bien que lo prueba en ClienteTest).

Los nombres de los tests (viendo todas las clases test), algunos estan mal, se corregiran para que represente mejor su funcionalidad de testeo.
No veo el porque hacer protected a la lista de Productos que tiene la compra.



Modificaciones realizadas para extender el proyecto:

Se corrige el metodo calcularMontoACobrar de la libreria, ahora si valida que el cliente sea valido / registrado. 
Se agregan / modifican tests al respecto.
Se hace private a la lista de Productos que tiene la compra, se corrige el metodo de calcularPrecio de Suscripcion.
Se agregan mas tests, uno es para ver si guarda bien las compras de los clientes en un determinado mes, que diga la cantidad correcta, 
en clientetest.
Se propone eliminar el uso de instanceof, para ello, cada tipo de producto que es apto para suscribirse, recibira ese nuevo comportamiento.
Para ello, se crea una interfaz AptoSuscripcion, la cual su uso, sera dado en las clases Revista y Periodico, que admitiran esa cualidad.
Ademas, en sus constructores, tendran una nueva marca para tal fin (avisar que soportan suscripcion), agregando un nuevo metodo para ello 
en la clase padre Producto (metodo setSoportaSuscripcion).
Esto conlleva, para la mejora, en que la clase Suscripcion tenga una modificacion sustancial, de que al momento de agregarProducto 
ya no use mas el instanceof, sino que pregunte si el producto que se esta agregando SoportaSuscripcion.
Idem modificacion para calcularPrecio de Suscripcion (aunque en este caso se usa apropiadamente el casteo a AptoSuscripcion para 
cuando el producto lo sea).

Agrego la clase Alquiler y hago que herede de Producto, ya que lo considero un nuevo producto que se puede comprar en la libreria.
Luego, genero una nueva herencia, para diferenciar el tipo de libro a alquilar.
Es decir, agrego AlquilerCuatrimestral, AlquilerDiario  y AlquilerMensual ya que para mí "son un" tipo de Alquiler.
Es de destacar que las clases agregadas no estan atadas a solo alquilar libros, ya que esta implementado como que lo que se 
alquila es algun tipo de producto.

Para cada una de las clases hijas de alquileres, se les realiza su correspondiente clase de Test.
Posteriormente, se agregan los nuevos test de alquileres a la clase LIbreriaTest, son: libreriaalquilerSemanal y alquilaCuatrimestre
