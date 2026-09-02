# DOSW_Parcial_T1_JuanGarzon

**Nombre completo:** Juan Manuel Garzon Viracacha

**Grupo DOSW:** 1

**Numero Enunciado:** 3 - Sistema de pedidos de comida para la cafetería universitaria

**Calificación sobre 4.5, por no subir en prerequisitos**

## Desarollo


### **PUNTO 1 - DIAGRAMA DE CONTEXTO**

![alt text](/DOSW-ParcialT1/docs/images/DiagramaContexto.drawio.png)

**Usuarios:**
- **Cliente:** Usuario principal, que puede ser estudiante o docente, el cual realiza los pedidos de comida.

- **Cocinero:** Personal de comida encargado de llevar a cabo el pedido realizado.

- **Delivery:** Personal encargado de llevar los pedidos que tengan preferencias de entrega iguales a "Entrega Salon".

**Sistemas externos:**

- **AWS Mongo Atlas:** Encargado del almacenamiento de la información de los pedidos.

- **AWS S3 Buckets:** Encargado de reportes de ventas diarias.

### **PUNTO 2 - REQUERIMIENTOS**

**Requerimientos Funcionales:**
- **UFH-01**: Registrar usuario.

El cliente debe poder crear una cuenta con su correo institucional para acceder al sistema.

- **UFH-02**: Crear pedido (Builder).

El cliente debe poder armar un pedido seleccionando productos y agregando extras.

- **UFH-03**: Seleccionar tipo de entrega (Decorator).

El cliente debe poder elegir entre Consumo Local, Para Llevar o Entrega en Salon, con sus respectivos costos y reglas.

**Requerimientos No Funcionales**

- **UFH-RNF-01**: El sistema debe Responder en ≤ 1.5s para el 90% de las peticiones (Accesibilidad).

- **UFH-RNF-02**: El sistema debe soportar hasta 300 pedidos simultáneos en horario pico. (Accesibilidad)

### **PUNTO 3 - DIAGRAMA CASOS DE USO**

![alt text](/DOSW-ParcialT1/docs/uml/DiagramasCasoDeUso.drawio.png)

### **PUNTO 4 - ANALISIS DE REQUERIMIENTOS**

Pantallas generadas:

![alt text](/DOSW-ParcialT1/docs/images/UFH-RF-01.png)

![alt text](/DOSW-ParcialT1/docs/images/UFH-02.pdf)

### **PUNTO 5 - DESCOMPOSICION DE TAREAS**

***Epica:*** UFH-EPIC-01
Aplicación Web Cafetería Escuela Colombiana de Ingeniería.

**Feature:** FEAT-01
Crear pedido.

**Historia de usuario:**
Como: Cliente
Quiero: Crear pedido
Para: Pedir la comida que quiero

**Tareas:**
- TASK-01: Crear entidad de Usuario en AWS Mongo Atlas.
- TASK-02: Crear entidad de Pedido en AWS Mongo Atlas.
- TASK-03: Relacionar entidad Usuario y Pedido.
- TASK-04: Conectar con AWS S3 Buckets, para generar reportes.

### **PUNTO 6 - PATRONES DE DISEÑO**

- **Builder (Creacional):** Un pedido puede tener múltiples productos, cada uno con una lista variable de extras, y además un tipo de entrega. Construir este objeto mediante un constructor tradicional con muchos parámetros opcionales sería poco manejable y propenso a errores. El Builder permite construir el pedido paso a paso, añadiendo productos y extras de forma clara y manteniendo la inmutabilidad una vez construido

**Principios SOLID**

Single Responsibility (SRP): La clase Pedido solo representa el objeto final; la lógica de construcción está separada en PedidoBuilder.

Open/Closed (OCP): Se pueden añadir nuevos pasos de construcción (p. ej., aplicar descuentos) sin modificar Pedido ni el cliente, solo extendiendo el Builder.

Dependency Inversion (DIP): El Builder depende de abstracciones (Producto, Extra) y no de implementaciones concretas.

- **Decorator (Estructural):** El costo de entrega varía según la modalidad elegida (Consumo Local: $0, Para Llevar: $300, Entrega en Salón: $1000) y además la entrega en salón tiene reglas adicionales (bloque y salón). El Decorator permite añadir dinámicamente el costo de entrega y las reglas asociadas a un pedido sin modificar la clase Pedido ni sus subclases. Esto mantiene el diseño flexible y extensible ante nuevos tipos de entrega en el futuro.

**Principios SOLID**

Open/Closed (OCP): Se pueden agregar nuevos tipos de entrega creando nuevos decoradores (por ejemplo, EntregaDomicilio) sin alterar el código existente.

Liskov Substitution (LSP): Los decoradores son intercambiables con el componente original (Pedido), ya que implementan la misma interfaz IPedido (o extienden Pedido).

Single Responsibility (SRP): Cada decorador se encarga de una única responsabilidad (calcular el costo adicional y las reglas de esa entrega).

### **PUNTO 7 - SOLUCIÓN**

![alt text](/DOSW-ParcialT1/docs/images/Compilado.png)

## Evidencias

**Acceso a draw.io**

![alt text](/DOSW-ParcialT1/docs/images/HerramientaModelado.png)

**Acceso a Figma**

![alt text](/DOSW-ParcialT1/docs/images/Figma.png)


**Proyecto de Maven Compilado**

![alt text](/DOSW-ParcialT1/docs/images/mavenCompilado.png)