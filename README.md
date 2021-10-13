# ChallengeSupervielle
Challenge Supervielle

Perdón pero GitHub no me deja subir tamaños de archivos que superen los 25Mb

El ejecutable se crea mediante el comando

mvn clean package

Por defecto lo deje en JAR, no cree 2 perfiles.
En todo caso se cambia en el PON el tag <packaging>jar/war</packaging>

para probar los recursos pueden hacerlo mediante el comenado 

mvnw.cmd spring-boot:run (Si estan desde un SO Windows)

Por defecto esta seteado el puerto 8090 en el application.properties.

Una vez que levanta el servicio esta disponible la url
http://ip:puerto/swagger-ui.html para ver los recursos y la estructura requerida por cada uno.

En el projecto verán que hay una carpeta Key donde hay un archivo PersonaKey para realizar una clave compuesta, pero al momento de realizar los recursos de relaciones no se si esta mal el enunciado o incompleto que dice solo id1, y utilice finalmente e DNI de la persona como clave.
Deje el desarrollo asi para en caso de tener que usarse clave compuesta esto sirva para la solucion descomentando en PersonaModel el //@IdClass(PersonaKey.class)

Saludos!
