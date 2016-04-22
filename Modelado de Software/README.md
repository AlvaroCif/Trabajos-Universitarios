# Proyecto para Modelado de Software.

El proyecto se diferencia en dos principales mitades. Ambas documentadas con su modelado, a su vez, es importante señalar que las dos mitades presentan un modelo Multicapa separado en Presentación, Negocio e Integración.

El modelado fue desarrollado haciendo uso de la herramienta IBM-RSA, pero puede ser observado y modificando utilizando cualquier otra herramienta CASE.

La aplicación se ha desarrollado en Java.

La primera mitad, que engloba las entidades de Cliente, Factura y Producto implementa los patrones DAO, MVC, Controlador de Aplicación, Patrón de Transferencia, Transaction Manager, Servicio de Aplicación.
Esta primera mitad utiliza una concurrencia pesimista, que es gestionada por las operaciones del DAO que realizan un bloqueo.

La segunda mitad, que en este caso usa las entidades restantes, Departamento, Evento y Empleado, mantiene los mismos Patrones en la capa de presentación y de negocio. Dejando la concurrencia al framework de JPA.
En este caso, a diferencia de la primera parte, la concurrencia es optimista y es gestionada por JPA.

La información acerca de las entidades se almacenó en una BBDD online (Existe el riesgo de que con el tiempo esta BBDD deje de estar disponible).
