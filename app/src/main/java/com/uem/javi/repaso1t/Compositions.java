package com.uem.javi.repaso1t;

public class Compositions {
    Composition[] comps;

    public Compositions(){
        this.comps = new Composition[4];
        Composition cantatas = new Composition("Cantatas", "1-224", "1724-1736");
        Composition organ = new Composition("Organ", "525-771", "1728-1740");
        Composition lute = new Composition("Lute", "995-1000", "1736-1741");
        Composition cannons = new Composition("Canons", "1079-1080", "1728-1744");

        comps[0] = cantatas;
        comps[1] = organ;
        comps[2] = lute;
        comps[3] = cannons;
    }

    public Composition[] getComps() {
        return comps;
    }

    public void setComps(Composition[] comps) {
        this.comps = comps;
    }
}
