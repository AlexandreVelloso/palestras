class AlunoMysql implements AlunoDB {
    public void salvar(Aluno aluno) {
        System.out.println("Salvar aluno de nome " + aluno.getNome() + " no banco de dados Mysql");
    }
}

class AlunoPostgress implements AlunoDB {
    public void salvar(Aluno aluno) {
        System.out.println("Salvar aluno de nome " + aluno.getNome() + " no banco de dados Postgress");
    }
}

interface AlunoDB {
    public void salvar(Aluno aluno);
}

class Aluno {

    private String nome;

    public Aluno(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }
}

public class Certo {
    public static void main(String[] args) {
        AlunoDB alunoMysql = new AlunoMysql();
        Aluno aluno = new Aluno("Alexandre");

        alunoMysql.salvar(aluno);
    }
}
