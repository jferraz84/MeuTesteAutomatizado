# Os Testes
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/jferraz84/MeuTesteAutomatizado/blob/main/LICENSE) 

# Sobre os Testes
O desafio dos testes se consite em realizar operações de consulta e validar as respostas de um determinado site https://opentdb.com/

# A solução escolhida
Para a execução foi escolhida a solução GEB pois considero a melhor opção para os testes automatizados de web, por se tratar de um framework que utiliza o Selenium WebDriver muito utilizado no mercado para automações web. Utiliza a linguagem Groovy que é de fácil compreensão e de altíssimo nível e também é baseado em Java com o gradle como gerenciador de dependências, mais detalhes e a documentação pode ser acessada no site oficial http://www.gebish.org/. 
Em conjunto com o GEB são aplicados conceitos de BDD.

# Tecnologias utilizadas
- Java 8
- Cucumber
- SO Linux Ubuntu-18.04
- VsCode

# Clonar repositório
- git clone https://github.com/jferraz84/MeuTesteAutomatizado.git

# Executar o projeto
- Pré-requisitos: Java 8
- Gradle: 4.4.1

Para execução sem o navegador foi utilizado o comando:
- gradle bdd -Penv=chromeheadless -Ptag=BuscarQuestoes

Para execução com o navegador foi utilizado o comando: 
- gradle bdd -Ptag=BuscarQuestoes

Para execução de todos cenários em sequencia sem o navegador
- gradle bdd -Penv=chromeheadless -Ptag=@BuscarQuestoes@TesteAutomatizado

Para execução de todos cenários em sequencia com o navegador foi utilizado o comando: 
- gradle bdd -Ptag=@BuscarQuestoes@TesteAutomatizado

# Autor

Jorge Henrique Ferraz

https://linkedin.com/in/jorge-henrique-932310141
