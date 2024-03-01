package entidades;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List contas;

    public Banco() {
        this.contas = new ArrayList<Conta>();
    }
    
    public List getContas() {
        return contas;
    }
}
