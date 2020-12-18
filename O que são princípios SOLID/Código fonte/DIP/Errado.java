class AlunoMysql {
    public void salvar(Aluno aluno) {
        System.out.println("Salvar aluno de nome " + aluno.getNome() + " no banco de dados Mysql");
    }
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

public class Errado {
    public static void main(String[] args) {
        AlunoMysql alunoMysql = new AlunoMysql();
        Aluno aluno = new Aluno("Alexandre");

        alunoMysql.salvar(aluno);
    }
}
