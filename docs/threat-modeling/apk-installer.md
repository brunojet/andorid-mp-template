# Modelagem de Ameaças - Camada de Abstração da API de Instalação e Desinstalação de APKs Android

## Visão Geral
A camada de abstração da API de instalação e desinstalação de APKs Android é composta por uma classe abstrata de implementação que todas as plataformas devem seguir e uma classe comum que na inicialização instancia o objeto correspondente à plataforma selecionada.
A biblioteca também possuirá a implementação nativa padrão caso o dispositivo não precise de APIs customizadas.

## Escopo
- Instalação de APKs Android.
- Desinstalação de APKs Android.
- Verificação de integridade antes de instalar.

## Funcionalidades não implementadas
- Autenticação e permissão de usuário: Essa responsabilidade é tratada em uma camada superior do sistema, que também é responsável pelo download do APK. Portanto, a autenticação e validação de permissão de usuários não são implementadas nesta API.
- Verificação de assinatura de executáveis: Essa responsabilidade é tratada pelo equipamento e sistema operacional do terminals POS mobile que possui certificacao PCI.

## Decomposição do Sistema
A camada de abstração é composta por duas partes principais:

1. **Classe Abstrata de Implementação**: Esta classe define os métodos que todas as plataformas devem implementar.
2. **Classe Comum**: Esta classe é responsável por instanciar o objeto correspondente à plataforma selecionada na inicialização. Ela poderá implementar validações adicionais para garantir que o objeto correto seja instanciado e verificado antes de ser usado.

## Identificação de Ameaças
As seguintes ameaças foram identificadas:

1. **Instalação de APKs Maliciosos**
   - Descrição: Um ator mal-intencionado pode tentar instalar um APK malicioso em um terminal Android certificado PCI.
   - Impacto: O aplicativo malicioso pode comprometer a segurança e a privacidade dos usuários, roubar informações sensíveis ou causar danos ao dispositivo.
   - Probabilidade: Nula ou extremamente baixa, devido aos terminais PCI passarem por processos rigorosos de certificação e terem medidas de segurança robustas implementadas para instalação de aplicativos certificados.
   - Severidade: Alta.
   - Mitigação: A instalação de APKs maliciosos pode ser mitigada através da certificação rigorosa do terminal pelo fornecedor do terminal POS mobile.

2. **Desinstalação Não Autorizada de APKs**
   - Descrição: Um ator mal-intencionado pode ter acesso à API e desinstalar APKs sem autorização.
   - Impacto: A desinstalação não autorizada de APKs pode causar perda de dados, interrupção do funcionamento normal do aplicativo.
   - Probabilidade: Baixa. Como a API de instalação e desinstalação de APKs possui a capacidade de validar assinaturas e integridade, isso pode ajudar a mitigar o risco de desinstalações não autorizadas. Além disso, se a validação de usuário e controle de permissões estiverem implementados corretamente na parte do projeto que baixa o APK e chama essa API, a probabilidade de desinstalação não autorizada pode ser considerada baixa.
   - Severidade: Média.
   - Mitigação: O pedido de desinstalação de um APK deve ser validado pelo escopo responsável por baixar o APK e chamar a API de instalação e desinstalação de APKs

3. **Uso Inadequado da Classe Comum**
   - Descrição: Se a classe comum for usada de forma incorreta, pode ocorrer a instanciação do objeto errado, levando a comportamentos inesperados e potenciais vulnerabilidades de segurança.
   - Impacto: Uso inadequado da classe comum pode resultar em falhas de segurança, exposição de dados sensíveis ou mau funcionamento da aplicação.
   - Probabilidade: Baixa, se a classe comum for projetada e documentada corretamente.
   - Severidade: Média.
   - Mitigação: A classe comum deve ser projetada e documentada corretamente para evitar o uso inadequado. Além disso, podemos implementar validações adicionais para garantir que o objeto correto seja instanciado e verificado antes de ser usado. Além disso os testes unitários e de cobertura de código devem cobrir todos os cenários especificados.

## Documentação
Todo o processo de modelagem de ameaças, incluindo a decomposição do sistema, a identificação de ameaças e as medidas de mitigação, foi documentado neste documento.

## Revisão
Este documento de modelagem de ameaças será revisado regularmente para garantir que ele permaneça atualizado à medida que novas features são adicionadas ou as existentes são alteradas.