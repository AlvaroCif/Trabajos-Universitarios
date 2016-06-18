# Minería de Datos y el Paradigma del Big Data

Aplicación que junta diversas tecnologías para conseguir que dada una operación de suma, resta, multiplicación y división de dos operandos predizca el tiempo necesario para calcular el resultado.

La aplicación se puede dividir en dos grandes secciones separadas.

-Ruby on Rails: Proporciona todo el Front end y Back end necesario para poder ejecutar la app, además de otorgar patrones como el Modelo Vista controlador. Conectada a una BBDD no relacional, MongoDB, encargada de almacenar los resultados de las operaciones (que serán usados para crear un predictor). Todo el contenido de Ruby on Rails se encuentra en el directorio calcular.

-Flask: Se hace uso de Flask para crear un servicio externo a la aplicación donde se aloja el predictor que ha sido entrenado, el entrenamiento se ha realizado en Python, haciendo uso de las librerias sklearn que facilitan la tarea del machine learning. Para este tipo de datos se ha hecho uso del algoritmo RandomForest Regressor, ya que mediante las prácticas mas sencillas de regresión lineal o regresión logística se podia observar que el predictor no se adaptaba correctamente a los datos. La verificación de la corrección del procedimiento se ha efectuado mediante el uso de Cross-Validation, también facilitado por las bibliotecas de sklearn. El entrenamiento y los datos usados se encuentran dentro del directorio entrenamiento, y todo lo relacionado con el servicio externo en el directorio flask.
