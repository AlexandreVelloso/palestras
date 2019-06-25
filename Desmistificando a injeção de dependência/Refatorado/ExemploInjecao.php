<?php

class ExemploInjecaoDependencia
{

    private $remessaRepository;

    public function __construct(RemessaRepository $remessaRepository)
    {
        $this->remessaRepository = $remessaRepository;
    }

    public function upload(Request $request)
    {
        $arquivo = $request->file('arquivo');

        $validacao = new ValidaRemessaArquivo();
        $leitura = new LeituraXML($validacao, $arquivo);
        $leitura->leDados();

        $dadosRemessa = $leitura->getDadosCorretos();
        $errosRemessa = $leitura->getErros();

        // Se houveram erros, retorne eles para o cliente

        $this->remessaRepository->salvaRemessa($dadosRemessa);
    }

    // ...
}
