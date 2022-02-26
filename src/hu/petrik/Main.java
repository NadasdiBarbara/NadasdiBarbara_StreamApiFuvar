package hu.petrik;

import hu.petrik.Fuvarok;

public class Main {

    public static void main(String[] args) {

        Fuvarok fuvarok = new Fuvarok("fuvar.csv");

        System.out.println(fuvarok.utazasokOszege() +" db utazás került feljegyzésre");
        System.out.println("6185-nek "+fuvarok.osszesBevetelID(6185) +" usd volt a bevétele " + fuvarok.osszesFuvarId(6185) +" db fuvarja");
        System.out.println("A taxisok összesen "+fuvarok.osszesTaxisMerfold() +" mérföldet tettek meg");
        System.out.println("Leghosszabb fuvar adatai: "+fuvarok.leghosszabbFuvar());
        System.out.println("Legtöbb borravalójú fuvar adatai: "+fuvarok.legbokezubb());
        System.out.println("4261 azonosító "+fuvarok.tavolsagID(4261)+"km-t tett meg");
        System.out.println("Szerepel-e '1452':"+( fuvarok.IdSzerepelE(1452) ? " igen" : " nem"));
        System.out.println("December 24-én "+fuvarok.fuvarvoltE(12,24)+" db fuvar volt");
    }
}
