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
- **UFH-02**: Crear pedido (Builder).
- **UFH-03**: Seleccionar tipo de entrega (Decorator).

**Requerimientos No Funcionales**

- **UFH-RNF-01**: El sistema debe Responder en ≤ 1.5s para el 90% de las peticiones (Accesibilidad).

- **UFH-RNF-02**: El sistema debe soportar hasta 300 pedidos simultáneos en horario pico. (Accesibilidad)

### **PUNTO 3 - DIAGRAMA CASOS DE USO**

![alt text](/DOSW-ParcialT1/docs/uml/DiagramasCasoDeUso.drawio.png)

### **PUNTO 4 - ANALISIS DE REQUERIMIENTOS**

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

### **PUNTO 7 - SOLUCIÓN**

## Evidencias

**Acceso a draw.io**

![alt text](/DOSW-ParcialT1/docs/images/HerramientaModelado.png)

**Acceso a Figma**

![alt text](/DOSW-ParcialT1/docs/images/Figma.png)


**Proyecto de Maven Compilado**

![alt text](/DOSW-ParcialT1/docs/images/mavenCompilado.png)