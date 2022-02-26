package hu.petrik;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Fuvarok {
    private List<Fuvar> fuvarList;

    public Fuvarok(String fileName){
        fuvarList = new ArrayList<>();
        try {
            FileReader fr= new FileReader(fileName);
            BufferedReader br= new BufferedReader(fr);
            br.readLine();
            String sor = br.readLine();
            while (sor != null){
                fuvarList.add(new Fuvar(sor));
                sor= br.readLine();
            }
            br.close();
            fr.close();
        }catch (IOException e){
            System.out.println(e);
        }
        //System.out.println(fuvarList);
    }

    public Fuvarok(List<Fuvar> fuvarList){
        this.fuvarList = fuvarList;
    }

    public Fuvar getFuvar(int index){
        return fuvarList.get(index);
    }

    public Stream<Fuvar> getStream() {
        return this.fuvarList.stream();
    }

    public long utazasokOszege(){
        return this.getStream().count();
    }
    public Stream<Fuvar> ID(int id){
        return this.getStream().filter(fuvar -> fuvar.getId() ==id);
    }

    public double osszesBevetelID(int id){
        return this.ID(id).mapToDouble(Fuvar::teljesBevetel).sum();
    }

    public long osszesFuvarId(int id){
        return this.ID(id).count();
    }

    public double osszesTaxisMerfold(){
        return this.getStream().mapToDouble(Fuvar::getTavolsag).sum();
    }

    public Fuvar leghosszabbFuvar(){
        return this.getStream().max(Comparator.comparingInt(Fuvar::getIdotartam)).get();
    }

    public Fuvar legbokezubb(){
        return this.getStream().max(Comparator.comparingDouble(Fuvar::bokezuseg)).get();
    }

    public double tavolsagID(int id){
        return this.ID(id).mapToDouble(Fuvar::tavolsagKM).sum();
    }

    public boolean IdSzerepelE(int id){
        return this.getStream().anyMatch(fuvar -> fuvar.getId() == id);
    }

    public  Stream<Fuvar> honapNap(int honap, int nap){
        return this.getStream().filter(fuvar -> fuvar.getIndulasIdopontja().getMonthValue() ==honap
                &&fuvar.getIndulasIdopontja().getDayOfMonth()==nap);
    }

    public long fuvarvoltE(int honap, int nap){
        return this.honapNap(honap,nap).count();
    }


}
