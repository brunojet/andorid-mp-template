# Modelagem de Ameaças - Camada de Abstração da API de Instalação e Desinstalação de APKs Android

## Visão Geral
A camada de abstração da API de instalação e desinstalação de APKs Android é composta por uma classe abstrata de implementação que todas as plataformas devem seguir e uma classe comum que na inicialização instancia o objeto correspondente à plataforma selecionada.
A biblioteca também possuirá a implementação nativa padrão caso o dispositivo não precise de APIs customizadas.

## Escopo

## Funcionalidades não implementadas

## Decomposição do Sistema
A camada de abstração é composta por duas partes principais:

1. **Classe Abstrata de Implementação**: Esta classe define os métodos que todas as plataformas devem implementar.
2. **Classe Comum**: Esta classe é responsável por instanciar o objeto correspondente à plataforma selecionada na inicialização. Ela poderá implementar validações adicionais para garantir que o objeto correto seja instanciado e verificado antes de ser usado.

## Identificação de Ameaças
As seguintes ameaças foram identificadas:

1. **Template**
   - Descrição: Um ator mal-intencionado pode tentar instalar um APK malicioso em um terminal Android certificado PCI.
   - Impacto: O aplicativo malicioso pode comprometer a segurança e a privacidade dos usuários, roubar informações sensíveis ou causar danos ao dispositivo.
   - Probabilidade: Nula ou extremamente baixa, devido aos terminais PCI passarem por processos rigorosos de certificação e terem medidas de segurança robustas implementadas para instalação de aplicativos certificados.
   - Severidade: Alta.
   - Mitigação: A instalação de APKs maliciosos pode ser mitigada através da certificação rigorosa do terminal pelo fornecedor do terminal POS mobile.

## Documentação
Todo o processo de modelagem de ameaças, incluindo a decomposição do sistema, a identificação de ameaças e as medidas de mitigação, foi documentado neste documento.

## Revisão
Este documento de modelagem de ameaças será revisado regularmente para garantir que ele permaneça atualizado à medida que novas features são adicionadas ou as existentes são alteradas.