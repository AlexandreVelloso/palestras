<?php

class LeituraArquivo implements leituraFebraban
{
    private $validacao;

    public function __construct(ValidaInterface $validacao)
    {
        $this->validacao = $validacao;
    }

    public function leDados()
    {
        // Lê os dados do arquivo
        $this->validacao->validaHeader($header);
        $this->validacao->validaTransacao($transacao);
        $this->validacao->validaTrailler($trailler);
    }

    public function getDadosCorretos(): array
    { }

    public function getErros(): array
    { }
}
