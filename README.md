# Conversor de PDF a Wor

Una aplicación de consola simple desarrollada en Java que convierte el texto de archivos PDF a documentos de Microsoft Word (.docx). Este proyecto fue creado para demostrar el uso de patrones de diseño de software en una aplicación funcional.



---

## Características Principales

-   **Extracción de Texto:** Lee un archivo PDF y extrae todo su contenido de texto.
-   **Creación de Documentos Word:** Genera un nuevo archivo `.docx` con el texto extraído.
-   **Estructura Extensible:** Diseñado con el patrón *Template Method* para facilitar la adición de nuevos tipos de conversores en el futuro (ej. PDF a TXT, HTML a Word).

---

##Tecnologías Utilizadas

-   **Lenguaje:** Java 11+
-   **Gestor de Dependencias:** Apache Maven
-   **Librerías:**
    -   **Apache PDFBox:** Para la lectura y extracción de texto de archivos PDF.
    -   **Apache POI:** Para la creación y escritura de archivos de Microsoft Word (`.docx`).
    -   **Log4j2:** Para el sistema de registro de logs.

---

## Patrón de Diseño Implementado

Este proyecto utiliza el **Patrón de Diseño Template Method**.

-   La clase abstracta `ConversorArchivo` define el esqueleto del algoritmo de conversión en el método `convertir()`.
-   La clase concreta `ConversorPdfAWord` implementa los pasos específicos necesarios para leer un PDF y escribir un documento de Word, sin alterar la estructura general del algoritmo.

Esto permite mantener un flujo de trabajo consistente y facilita la extensión del programa para soportar otros formatos de archivo en el futuro.

---

##  Cómo Empezar

### Prerrequisitos

-   Tener instalado Java (JDK 11 o superior).
-   Tener instalado Apache Maven (o usar el que viene integrado en tu IDE).

### Instalación y Ejecución

### 1. Obtener el Código

Primero, clona el repositorio en tu máquina local:
```bash
git clone [https://github.com/ignacio-valdes/java-document-converter.git](https://github.com/ignacio-valdes/java-document-converter.git)
cd java-document-converter
```

### 2. Ejecutar la Aplicación

Tienes dos opciones para ejecutar el proyecto:

#### A) Desde la Línea de Comandos (con Maven)

Esta es la forma universal si no quieres usar un IDE.

1.  **Coloca tu archivo PDF:** Añade un archivo llamado `documento.pdf` en la raíz del proyecto.
2.  **Ejecuta el comando:**
    ```bash
    mvn exec:java -Dexec.mainClass="com.mycompany.templatemethod.TemplateMetod"
    ```

#### B) Desde NetBeans IDE 💻

Esta es la forma más sencilla si usas NetBeans.

1.  **Abre el Proyecto:** En NetBeans, ve a `File > Open Project...` y selecciona la carpeta que clonaste. NetBeans detectará que es un proyecto Maven y descargará automáticamente todas las librerías necesarias.
    

2.  **Coloca tu archivo PDF:** Añade un archivo llamado `documento.pdf` en la raíz del proyecto. La forma más fácil es arrastrarlo y soltarlo sobre el nombre del proyecto en el panel "Projects".

3.  **Ejecuta el archivo principal:** Navega hasta `Source Packages`, encuentra tu clase `TemplateMethod.java`, haz clic derecho sobre ella y selecciona **`Run File`** (o presiona `Shift + F6`).

Al finalizar cualquiera de los dos métodos, se creará un archivo llamado `documento_convertido.docx` en la misma carpeta raíz del proyecto.
