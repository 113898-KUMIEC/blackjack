public class Cartas {
    private char simbolo, type;

    public char getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public int getValue(){
        if (this.simbolo == 'T') return 10;
        else if (this.simbolo == 'J') return 11;
        else if (this.simbolo == 'Q') return 12;
        else if (this.simbolo == 'K') return 13;
        else if (this.simbolo == 'A') return 1;
        else return Integer.parseInt(this.simbolo+"");
    }

    @Override
    public String toString() {
        return  this.simbolo + "" + this.type;
    }
}
