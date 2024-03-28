# Consumidor de API Android

Este projeto consiste em uma aplicação Android que consome uma API RESTful para exibir dados em uma interface de usuário simples e organizada.

## API Utilizada

A API escolhida para este projeto é a OMDb API. Esta API fornece informações sobre filmes, incluindo títulos, anos de lançamento, enredos, classificações, pôsteres e muito mais.

### Obtenção de uma Chave de API

Para obter uma chave de API válida, siga estas etapas:

- Acesse nosso site www.example.com/api.
- Crie uma conta ou faça login, se já tiver uma.
- Na seção "Gerenciar Chaves de API", clique em "Gerar Nova Chave de API".
- Sua nova chave de API será exibida. Anote esta chave, pois - você precisará dela para fazer solicitações à API.

### Fazendo Solicitações 

Para fazer solicitações à API de Informações de Filmes, siga o exemplo abaixo:

```http
GET /api/movie?id=123456&key=YOUR_API_KEY HTTP/1.1
Host: example.com
```

Substitua 123456 pelo ID do filme desejado e YOUR_API_KEY pela chave de API que você gerou anteriormente.

### Respostas da API

A API retornará os dados do filme solicitado no formato JSON. Aqui está um exemplo de resposta:
```json
{
  "title": "Inception",
  "year": "2010",
  "plot": "A thief who enters the dreams of others to steal secrets from their subconscious.",
  "actors": ["Leonardo DiCaprio", "Joseph Gordon-Levitt", "Ellen Page"],
  "director": "Christopher Nolan",
  ...
}
```

###  Limites de Uso

Para garantir a disponibilidade e o desempenho da API para todos os usuários, impomos limites de uso. Cada chave de API tem um limite de 1000 solicitações por dia

### Exemplos de Uso

Aqui está um exemplo de como você pode usar a API em seu aplicativo:

```java

// Exemplo de código Java para fazer uma solicitação à API de Informações de Filmes
String apiKey = "YOUR_API_KEY";
String movieId = "123456";
String apiUrl = "https://example.com/api/movie?id=" + movieId + "&key=" + apiKey;

// Fazer solicitação HTTP para obter informações do filme
// (código para fazer solicitação HTTP não fornecido)
```

## Funcionalidades

Consumo da API OMDb para obter informações sobre filmes.
Exibição das informações dos filmes em uma interface de usuário simples.
Tratamento de erros e casos em que as informações dos filmes estão ausentes.
Utilização de elementos visuais como TextView e ImageView para apresentar os dados de forma organizada e amigável.

## Como Utilizar

- Clone o repositório para o seu ambiente de desenvolvimento local.
- Abra o projeto no Android Studio.
- Execute o aplicativo em um emulador Android ou dispositivo físico.
- Pesquise por um  filmes.
- Aguarde para exibir suas informações detalhadas.

## Estrutura do Projeto

 - MainActivity.java: Classe responsável por controlar a atividade principal do aplicativo, incluindo a lógica para consumir a API e exibir os resultados na interface do usuário.
 - Movie.java: Classe de modelo que representa um filme e mapeia os campos retornados pela API.
 - activity_main.xml: Layout XML para a atividade principal, onde a lista de filmes é exibida.
 - activity_main.xml: Layout XML para a tela de detalhes do filme, onde as informações detalhadas do filme são exibidas.

## Dependências

- Retrofit: Biblioteca para realizar requisições HTTP de forma simplificada.
- Glide: Biblioteca para carregar e exibir imagens de forma eficiente.
- Gson: Biblioteca para converter objetos Java em JSON e vice-versa.
Observações
- Certifique-se de que seu dispositivo Android tenha uma conexão com a internet para que o aplicativo possa acessar a API OMDb e carregar os dados dos filmes corretamente.

## Contribuições

Contribuições para melhorias no código ou na documentação são bem-vindas! Sinta-se à vontade para abrir uma issue ou enviar um pull request no repositório do projeto.

## Autor

Este projeto foi desenvolvido por [Wesley Silva].

## Licença

Este projeto está licenciado sob a Licença MIT.

## Resultados 

![resultado](/images/WhatsApp%20Image%202024-03-28%20at%2015.13.54%20(1).jpeg)

![reultado](/images/WhatsApp%20Image%202024-03-28%20at%2015.13.54%20(2).jpeg)

![resultado](/images/WhatsApp%20Image%202024-03-28%20at%2015.13.54.jpeg)

![resultado](/images/WhatsApp%20Image%202024-03-28%20at%2015.13.55.jpeg)


