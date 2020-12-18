interface Ave {
    public void anda();

    public void bica();
}

interface AveVoadora {
    public void voa();
}

class Canario implements Ave, AveVoadora {
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
}

public class Certo {
    public static void main(String[] args) {
        AveVoadora canario = new Canario();
        Ave pinguim = new Pinguim();

        canario.voa();
        pinguim.anda();
    }
}
