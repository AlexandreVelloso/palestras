const express = require('express');
const bodyParser = require('body-parser');

const app = express();
const port = 3000;

// Aceitar requisições com JSON
app.use(bodyParser.json());

// Lista de alunos cadastrados
const alunos = [];

// Listar alunos
app.get('/alunos', (req, res) => {
    return res.json(alunos);
});

// Detalhar aluno
app.get('/alunos/:id', (req, res) => {
    // Pega o valor do id do aluno passado na requisição
    const alunoId = parseInt(req.params.id);

    // Procura o aluno com id igual ao alunoId
    const aluno = alunos.find(aluno => aluno.id === alunoId);

    // Se não encontrou o aluno, retorne erro
    if (!aluno) {
        return res.status(400).json({
            mensagem: 'O aluno com esse id não existe'
        });
    }

    return res.json(aluno);
});

// Criar aluno
app.post('/alunos', (req, res) => {
    const nome = req.body.nome;
    const cpf = req.body.cpf;

    if (!nome || !cpf) {
        return res.status(400).json({
            mensagem: 'Os campos nome e cpf são obrigatórios'
        });
    }

    const aluno = {
        id: alunos.length + 1,
        nome: nome,
        cpf: cpf,
    };

    alunos.push(aluno);

    return res.status(201).json(aluno);
});

// Atualizar aluno
app.put('/alunos/:id', (req, res) => {
    const alunoId = parseInt(req.params.id);

    const nome = req.body.nome;
    const cpf = req.body.cpf;

    if (!nome || !cpf) {
        return res.status(400).json({
            mensagem: 'Os campos nome e cpf são obrigatórios'
        });
    }

    // Procura o aluno com id igual ao alunoId
    const aluno = alunos.find(aluno => aluno.id === alunoId);

    // Se não encontrou o aluno, retorne erro
    if (!aluno) {
        return res.status(400).json({
            mensagem: 'O aluno com esse id não existe'
        });
    }

    aluno.nome = nome;
    aluno.cpf = cpf;

    return res.json(aluno);
});

// Deletar aluno
app.delete('/alunos/:id', (req, res) => {
    const alunoId = parseInt(req.params.id);

    // Procura o aluno com id igual ao alunoId
    const aluno = alunos.find(aluno => aluno.id === alunoId);

    // Se não encontrou o aluno, retorne erro
    if (!aluno) {
        return res.status(400).json({
            mensagem: 'O aluno com esse id não existe'
        });
    }

    // Remove aluno do array
    alunos.splice(alunoId - 1, 1);

    return res.status(200).end();
});

app.listen(port, () => {
    console.log(`Example app listening at http://localhost:${port}`);
});
