/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author jairo
 */
public class Estudiante extends Persona {

    private String codigo;
    private String carrera;

    public Estudiante() {
    }

    public Estudiante(String codigo, String carrera, String nombre, String telefono, String correo) {
        super(nombre, telefono, correo);
        this.codigo = codigo;
        this.carrera = carrera;
    }

    /**
     * Get the value of carrera
     *
     * @return the value of carrera
     */
    public String getCarrera() {
        return carrera;
    }

    /**
     * Set the value of carrera
     *
     * @param carrera new value of carrera
     */
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    /**
     * Get the value of codigo
     *
     * @return the value of codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Set the value of codigo
     *
     * @param codigo new value of codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return super.toString() + "," + codigo + "," + carrera;
    }

    public boolean crearArchivoEstudiante(LinkedList<Estudiante> listaEstudiantes) {
        boolean g = false;
        FileWriter flwriter = null;
        try {
            flwriter = new FileWriter("estudiantes.txt");
            BufferedWriter bfwriter = new BufferedWriter(flwriter);

            for (int i = 0; i < listaEstudiantes.size(); i++) {
                //escribe los datos en el archivo
                bfwriter.write(listaEstudiantes.get(i) + "\n");
            }
            bfwriter.close();
            System.out.println("Archivo creado satisfactoriamente..");
            g=true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (flwriter != null) {
                try {//cierra el flujo principal
                    flwriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return g;
    }

    public boolean creacionArchivoXML(LinkedList<Estudiante> listaE) {
        boolean g=false;
        try {
            Element Universidad = new Element("Universidad");
            Document doc = new Document(Universidad);
            for (int i = 0; i <listaE.size(); i++) {
                Element Estudiante = new Element("Estudiante");
                Estudiante.addContent(new Element("Nombre").setText(
                        listaE.get(i).getNombre()));
                 Estudiante.addContent(new Element("Telefono").setText(
                        listaE.get(i).getTelefono()));
                   Estudiante.addContent(new Element("Codigo").setText(
                        listaE.get(i).getCodigo()));
                     Estudiante.addContent(new Element("Carrera").setText(
                        listaE.get(i).getTelefono()));
                     doc.getRootElement().addContent(Estudiante);
                
            }
            XMLOutputter xmlOutput = new XMLOutputter();
            xmlOutput.setFormat(Format.getPrettyFormat());
            xmlOutput.output(doc, new FileWriter("Universidad.xml"));
        }catch (Exception e){
        }
        
        return g;
    }

}
