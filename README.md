# Demo de Automatización - QA Engineer

Este repositorio contiene una demostración práctica de automatización, implementando un framework de pruebas híbrido (UI y API) escalable utilizando **Java, Selenium WebDriver, Cucumber (BDD) y Rest Assured**.

## 🚀 Tecnologías y Herramientas utilizadas

* **Lenguaje:** Java
* **Gestor de dependencias:** Maven
* **UI Testing:** Selenium WebDriver
* **API Testing:** Rest Assured
* **Framework BDD:** Cucumber + JUnit 5 Platform
* **Reportes:** Extent Reports (con capturas de pantalla integradas)
* **Patrón de Diseño:** Page Object Model (POM)

## 📋 Requisitos Previos

Para ejecutar este proyecto, asegúrate de tener instalado:

1. [Java JDK](https://www.oracle.com/java/technologies/downloads/) (Versión 17 o superior configurada en tus variables de entorno).
2. [Apache Maven](https://maven.apache.org/download.cgi).
3. Navegador **Google Chrome** (actualizado a la última versión).
4. Un IDE de tu preferencia (IntelliJ IDEA, Eclipse, VS Code).

## ⚙️ Instalación y Configuración

1. Clona este repositorio en tu máquina local:
   ```bash
   git clone <URL_DE_TU_REPOSITORIO>
   ```
2. Abre el proyecto en tu IDE.
3. Deja que Maven resuelva y descargue todas las dependencias del archivo `pom.xml`.

## ▶️ Ejecución de las Pruebas

El framework permite ejecutar las pruebas de manera global o filtrando por el tipo de prueba mediante *tags* de Cucumber. Abre una terminal en la raíz del proyecto y utiliza los siguientes comandos:

**1. Ejecutar TODAS las pruebas (UI + API):**
```bash
mvn clean test
```

**2. Ejecutar únicamente las pruebas de interfaz gráfica (Sauce Demo):**
```bash
mvn clean test "-Dcucumber.filter.tags=not @api"
```
*(Nota: También puedes filtrar por funcionalidades específicas usando `"-Dcucumber.filter.tags=@login"` o `"-Dcucumber.filter.tags=@carrito"`).*

**3. Ejecutar únicamente la prueba de API (Mercado Libre):**
```bash
mvn clean test "-Dcucumber.filter.tags=@api"
```

## 📊 Reportes y Evidencias

Este framework está configurado para generar un reporte HTML detallado al finalizar cada ejecución.

* El reporte se genera automáticamente en la ruta: `target/Reporte_Automatizacion.html`.
* **Capturas de pantalla:** Si un escenario de Interfaz Gráfica (UI) falla, el framework intercepta el error de manera dinámica en los Hooks y adjunta automáticamente una captura de pantalla del navegador en el reporte HTML.

## 📁 Estructura del Proyecto

* `src/test/resources/features`: Archivos Gherkin (`.feature`) con la redacción de los escenarios (Negocio).
* `src/test/java/base`: Configuración del `WebDriver` (DriverFactory) y clase base para las páginas.
* `src/test/java/page`: Clases que implementan el patrón Page Object Model con los localizadores de la web.
* `src/test/java/steps`: Definición de los pasos (Step Definitions) de Cucumber y los `Hooks`.
* `src/test/java/runners`: Clase `TestRunner` para orquestar la ejecución de Cucumber con JUnit 5.