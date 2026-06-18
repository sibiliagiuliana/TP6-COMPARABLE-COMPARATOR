# 🔤 TP6 — Ordenamiento de Objetos: Comparable, Comparator y Polimorfismo en Acción

**Trabajo Práctico N° 6 — Programación III**
Carrera: Ingeniería en Sistemas de Información
---

## 👤 Integrantes

- Hernández Domínguez Tatiana Ayelen - DNI: 45.563.479
- Ochoa Candela Maribel - DNI: 46.401.137
- Sibilia María Giuliana - DNI: 46.723.876

---

## 📋 Descripción del Proyecto

Aplicación desarrollada en Java 21 y Spring Boot que implementa el ordenamiento de objetos mediante las interfaces `Comparable` y `Comparator`. El sistema gestiona una lista de estudiantes universitarios y permite ordenarlos dinámicamente por distintos criterios (promedio, edad, nombre, materias aprobadas o legajo) a través de una API REST, aplicando el patrón de diseño **Strategy** para la selección del comparator en tiempo de ejecución.

---

## 🛠️ Tecnologías Utilizadas

- Lenguaje: Java 21
- Framework: Spring Boot 3.4+
- Gestor de Dependencias: Apache Maven
- API REST
- Postman (para pruebas de endpoints)
- IDE: Visual Studio Code
- Control de versiones: Git y GitHub

---

## ✅ Funcionalidades

### 🎓 Ordenamiento con Comparable
- Implementación del orden natural de `Estudiante` por promedio descendente
- Uso correcto de `Double.compare()` (sin anti-patrón de la resta)

### 🔀 Ordenamiento con Comparator
- Comparator por `cantidadMateriasAprobadas` ascendente (lambda explícita)
- Comparator por `nombre` alfabético (method reference)
- Comparator por `edad` ascendente (method reference)
- Criterios compuestos con `thenComparing()` para desempate
- Orden inverso con `reversed()` sin reescribir lógica

### ⚠️ Anti-patrón de la Resta
- Demostración del bug de overflow con `Integer.MAX_VALUE`
- Corrección con `Integer.compare()` y `Double.compare()`

### 🌐 API REST
- Endpoint parametrizable `GET /api/estudiantes?sortBy=...&order=...`
- Selección dinámica de estrategia de ordenamiento mediante `Map<String, Comparator<T>>`
- Tie-breaker por legajo para orden siempre predecible ante empates
- Manejo de errores con HTTP 400 y respuesta JSON descriptiva

---

## 🌐 Endpoints Principales

### Estudiantes

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `GET` | `/api/estudiantes` | Lista todos los estudiantes ordenados por promedio ASC (default) |
| `GET` | `/api/estudiantes?sortBy=promedio&order=desc` | Ordenados por promedio descendente |
| `GET` | `/api/estudiantes?sortBy=nombre&order=asc` | Ordenados por nombre alfabético |
| `GET` | `/api/estudiantes?sortBy=edad&order=asc` | Ordenados por edad ascendente |
| `GET` | `/api/estudiantes?sortBy=materiasAprobadas&order=desc` | Ordenados por materias descendente |
| `GET` | `/api/estudiantes?sortBy=legajo&order=asc` | Ordenados por legajo ascendente |

### Parámetros aceptados

| Query param | Default | Valores válidos |
|-------------|---------|-----------------|
| `sortBy` | `promedio` | `promedio`, `edad`, `nombre`, `materiasAprobadas`, `legajo` |
| `order` | `asc` | `asc`, `desc` |


## 📁 Estructura del Proyecto

```
src/main/java/ar/edu/unlar/prog3/
├── model/              → entidad de dominio (Estudiante)
├── comparators/        → comparators reutilizables (Ejercicios 4 y 5)
├── repository/         → datos en memoria con @PostConstruct
├── service/            → lógica de negocio y patrón Strategy
├── controller/         → endpoints REST
├── dto/                → objetos de transferencia (ErrorResponse)
├── exception/          → excepción personalizada y handler global
└── pruebas/            → clases main para demostrar ejercicios 1-6
```


