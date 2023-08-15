# G5_alura_hibernate_persistence

Recuento de la clase hibérnate-jpa abstracción de proyecto, realizando siguientes modificaciones 
- Google Guice para inyección de dependencias simple porque se repite mucho la instancia del entitymanager
- Se realiza la persistencia a datos usando mariaDb(fork de MySQL), esto con el fin de persistir los datos en la base de datos y 
  establecer un stack de java(correto o temurin jdk-jre)
- Se trabaja en este proyecto java-17 versión estable
- Para la parte de relatos se usa los récord(Disponible desde java 16+) 
