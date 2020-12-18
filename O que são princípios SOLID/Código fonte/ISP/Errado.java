interface Ave {
    public void anda();

    public void bica();

    public void voa();
}

class Canario implements Ave {
    public void anda() {
        System.out.println("Canário anda");
    }

    public void bica() {
        System.out.println("Canário bica");
    }

    public void voa() {
        System.out.println("Canário voa");
    }
}

class Pinguim implements Ave {
    public void anda() {
        System.out.println("Pinguim anda");
    }

    public void bica() {
        System.out.println("Pinguim bica");
    }

    public void voa() {
        throw new RuntimeException("Método não implementado");
    }
}

public class Errado {
    public static void main(String[] args) {
        Ave canario = new Canario();
        Ave pinguim = new Pinguim();

        canario.voa();
        // vai gerar uma exception
        pinguim.voa();
    }
}
