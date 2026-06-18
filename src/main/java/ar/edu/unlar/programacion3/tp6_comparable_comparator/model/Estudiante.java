package ar.edu.unlar.programacion3.tp6_comparable_comparator.model;

public class Estudiante implements Comparable<Estudiante> {

    private String legajo;
    private String nombre;
    private int edad;
    private double promedio;
    private int materiasAprobadas;

    public Estudiante(String legajo, String nombre, int edad, double promedio, int materiasAprobadas) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.edad = edad;
        this.promedio = promedio;
        this.materiasAprobadas = materiasAprobadas;
    }

    public String getLegajo() {
        return legajo;
    }
    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getPromedio() {
        return promedio;
    }
    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public int getMateriasAprobadas() {
        return materiasAprobadas;
    }
    public void setMateriasAprobadas(int materiasAprobadas) {
        this.materiasAprobadas = materiasAprobadas;

    }

    @Override

    public int compareTo(Estudiante otro) {
        return Double.compare(otro.getPromedio(), this.promedio);

    }

    public String toString() {
        return String.format(" %-15s | %-20s | Edad:%d | Promedio:%.2f | Materias:%d",
                legajo, nombre, edad, promedio, materiasAprobadas);
    }


}
