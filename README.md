# appMovil
Cordial saludo

Para poder ejecutar la aplicacion móvil es necesario acceder primero a la aplicación web :

http://testhotels.herokuapp.com/

La carpeta que contiene la aplicación se llama AlmundoAndroid


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
	
	*ListAdapter
	
	Esta es la actividad que se encarga de la configuración y llenado de la lista aquí se agregan los valores que se quieren mostrar en la lista. Está conectada
	con el layout list_item que es el que se muestra en pantalla para cada uno de los valores de la lista. Esta se activa desde la clase MainActivity.
	
	*HotelActivity
	Esta es la actividad que se ejecuta al momento de seleccionar cualquiera de los elementos que se encuetran contenidos en la lista.Esta contiene un mapa
	de google maps y para poder trabajar con este fue necesario crear una llave o api key para poder acceder a los servicios de Google Maps. Para hacer esto
	es necesario ingresar a la página https://console.developers.google.com/apis/ y empezar a buscar los distintos aplicativos relacionados con Google Maps.
	Luego es necesario crear una imagen siguiendo alguno de los formatos descritos en la página https://developers.google.com/maps/documentation/static-maps/intro?hl=es-419
	El valor del nombre del hotel se obtiene de la actividad MainActivity y el resto de valores se obtiene del json que se encuentra en la página http://testhotels.herokuapp.com/application/json/descriptions/descriptions.php
	
	*¿Cómo funciona HotelActivity?

	Esta clase recibe el nombre del hotel y el identificador del hotel. El valor del hotel es mostrado como título pero el id del hotel es usado para consultar 
	dentro de la respuesta de la petición JSON los valores correspondientes a la descripción del Hotel. Estos se agregan en la clase Description y posteriormente
	son cargados en la vista con el layout activity_hotel. Para mostrar el mapa se usó la librería Picasso y para poder acceder a los valores del archivo JSON
	fue necesario hacer uso de la librería volley.

Adicional:
	*La librería Volley se encuentra descargada dentro del proyecto y la librería Picasso se encuentra dentro de las dependencias del archivo gradle.
	*El apk se encuentra en la ruta AppMovil\AlmundoAndroid\app\release
	*Se hizo uso de los archivos de recursos strings y colors para evitar hacer uso de variables dentro del programa.


	





