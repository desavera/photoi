# photoi
Desafio M4U

Projeto inspirado no exercicio proposto para avaliacao tecnica na M4U. O aplicativo simula um portal de vendas de produtos diversos onde o usuario realiza :

- login 
- logout
- buscas por produtos

o aplicativo , batizado de Photoi , foi desenvolvido com Android API 23 SDK e roda em dispositivos moveis Android com as seguintes especificacoes minimas recomendadas :

- Android 6 (M) ou mais novo

AMBIENTE DE DESENVOLVIMENTO

para instalacao do ambiente de desenvolvimento, a recomendacao minima de infraestrutura eh :

- 700 MHz processor (Intel Celeron ou melhor)
- 512 MiB RAM (system memory)
- 5 GB of hard-drive space 
- Linux system (Ubuntu 14.04 up recommended) admin user account access
- internet access with Download Speed around 2Mbps / 512kbps
- Docker.io installed

para o build dos servicos em sua propria estacao de trabalho deve-se ter instalado :

- Maven
- JDK 1.8

para rodar o servico APIGateway :

# cd dev/server/APIGateway
# mvn install spring-boot:run

para rodar o servico Users :

# cd dev/server/Users
# mvn install tomcat7:run

uma vez rodando os dois servicos basta abrir o Android Studio e carregar o projeto em dev/mobile/Photoi e executar no dispositivo de sua preferencia.


AMBIENTE DE TESTES

foram criados dois modulos de testes somente para os servicos :

- APIGateway : testamos o bootup to servico a partir de um hit local que deve abrir a tela de admin login
- Users : testamos todas as chamadas da API REST



para maiores detalhes sobre a implementacao : desavera@gmail.com
