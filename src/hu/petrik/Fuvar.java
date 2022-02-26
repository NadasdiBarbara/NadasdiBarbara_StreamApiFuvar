package hu.petrik;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Fuvar {

    private int id, idotartam;
    private LocalDateTime indulasIdopontja;
    private double tavolsag, viteldij, borravalo;
    private boolean fizetesiMod;

    public Fuvar(String sor) {
        String[] data = sor.split(";");
        this.id = Integer.parseInt(data[0]);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.indulasIdopontja = LocalDateTime.parse(data[1], formatter);
        this.idotartam = Integer.parseInt(data[2]);
        this.tavolsag = Double.parseDouble(data[3].replace(',','.'));
        this.viteldij =Double.parseDouble(data[4].replace(',','.'));
        this.borravalo = Double.parseDouble(data[5].replace(',','.'));
        this.fizetesiMod = Objects.equals(data[6],"bankkártya");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdotartam() {
        return idotartam;
    }

    public void setIdotartam(int idotartam) {
        this.idotartam = idotartam;
    }

    public LocalDateTime getIndulasIdopontja() {
        return indulasIdopontja;
    }

    public void setIndulasIdopontja(LocalDateTime indulasIdopontja) {
        this.indulasIdopontja = indulasIdopontja;
    }

    public double getTavolsag() {
        return tavolsag;
    }

    public void setTavolsag(double tavolsag) {
        this.tavolsag = tavolsag;
    }

    public double getViteldij() {
        return viteldij;
    }

    public void setViteldij(double viteldij) {
        this.viteldij = viteldij;
    }

    public double getBorravalo() {
        return borravalo;
    }

    public void setBorravalo(double borravalo) {
        this.borravalo = borravalo;
    }

    public boolean isFizetesiMod() {
        return fizetesiMod;
    }

    public void setFizetesiMod(boolean fizetesiMod) {
        this.fizetesiMod = fizetesiMod;
    }

    public double teljesBevetel(){
        return this.borravalo + this.viteldij;
    }

    public double tavolsagKM(){
        return this.tavolsag *1.6;
    }

    public double bokezuseg(){
        return this.borravalo / this.getViteldij();
    }
    @Override
    public String toString() {
        return "\n"+id+ " - "+ indulasIdopontja+ " - " + idotartam+ " - " + tavolsag+ " - "+ viteldij+ " - "+ borravalo+ " - "+ fizetesiMod;
    }
}
