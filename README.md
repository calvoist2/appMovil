# appMovil
Cordial saludo

Para poder ejecutar la aplicacion móvil es necesario acceder primero a la aplicación web :

http://testhotels.herokuapp.com/


¿Cómo fue construida la aplicación?

La aplicación fue creada haciendo uso de Android Studio 3.0.1. Esta se conecta a una aplicación Web que contiene información en formato JSON de la cual se alimenta
finalmente la aplicación móvil.

Dentro de la carpeta java que se encuentra al interior de la carpeta app estan creadas la carpeta model y controler que corresponden al modelo y controlador de la app

*Caperta Model

Dentro de la carpeta model se encuentran las dos clases que corresponden al modelo, es decir las que corresponden a la base de datos de la aplicación estas son:
	*Description.java
	 En esta clase se contemplan los valores de la tabla description en la base de datos
	*Hotel.java
	 En esta clase se contemplan los valores de la tabla de nombre hotel en la base de datos
*Carpeta controller

Dentro de la capeta controller se encuentran los controladores de la aplicación que en este caso son 3:
	*MainActivity
	Esta es la actividad principal, es decir la que contiene la barra de búsqueda y la lista de hoteles, y esta relacionada con el layout activity_main que
	se encuentra dentro de la carpeta resources.
	
	En el desarrollo de esta parte de la aplicación se hizo uso de dos librerías la primera fue volley(https://github.com/google/volley) que fue usada
	para hacer las distintas peticiones de tipo JSON hechas para obtener la información de las listas.Esta se puede ver reflejada en métodos tales como
	onResponse o onErrorResponse
	

	La segunda fue para hacer más fácil el cargue de imágenes de la lista, su nombre es picasso(http://square.github.io/picasso/) y para hacer uso de esta es
	necesario invocarla en una sola línea:

	Picasso.with(context).load("http://i.imgur.com/DvpvklR.png").into(imageView);

	*¿Cómo funciona MainActivity?
	 Esta clase envía una petición a la página http://testhotels.herokuapp.com/application/json/hotels/hotels.php para obtener la lista de hoteles en formato JSON.
	 Posteriormente recibe los datos y se conecta con la clase Hotel de la carpeta model para almacenar los datos 
	 Después de haber almacenado los datos los envía a la clase ListAdapter.Finalmente se muestra el resultado en el layout activity_main.xml y al seleccionar uno
	 de los items se despelga la actividad HotelActivity.





