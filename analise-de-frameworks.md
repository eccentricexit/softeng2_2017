% Análise e Comparação dos Frameworks React, Angular e Vue
% Matheus Faria de Alencar
% November 25, 2017

Introdução
===========


Hoje, a TI é o campo em direção ao desenvolvimento móvel, que é, sem dúvida, uma das direções de crescimento mais rápido, lucrativo e popular em termos de número de desenvolvedores. A popularidade e a ampla distribuição de vários dispositivos móveis causaram uma grande agitação no mundo digital, forçando muitas corporações a fazer muito esforço para encontrar um nicho no mercado de produtos de software para dispositivos móveis e não apenas.

Decidir em um framework de JavaScript para seu aplicativo web é uma tarefa que causa impacto durante todo o ciclo de vida do projeto. Angular e React são muito populares nos dias de hoje, e há um novo player que tem recebido muita tração ultimamente: VueJS. 

![](https://cdn-images-1.medium.com/max/1600/1*aPijhbTjT0VOxPYq2RkVUw.png)

Por outro lado, os aplicativos da web ficam cada vez mais complicados, cada vez mais provendo demanda de desenvolvedores web altamente qualificados para aplicações complexas para empresas ou para o consumidor.

Este trabalho tem por objetivo apresentar uma comparação sistemática entre os principais frameworks utilizados no frontend de aplicações web de página única. Serão comparados Vue vs Angular vs React, porque nem todas essas ferramentas são semelhantes, embora tenham muito em comum.


Metodologia
========
Analisar cada framework de forma detalhada leva muito tempo, o que, em alguns casos, pode levar à perda de clientes ou fundos, o que é inaceitável nas realidades atuais do mercado. Para resumir e estruturar a análise, foram definidos as seguintes perguntas a serem realizadas para cada framework

- Maturidade
- Longevidade
- Comunidade
- Curva de aprendizado
- Performance

Resultados
========
Para comparar esses frameworks de forma adequada, eu uso essas estruturas para criar uma pequena aplicação web do mundo real, que possui suporte de autenticação embutido para o serviço de back-end API, e integrada com uma estrutura de interface de usuário adaptável, por exemplo Bootstrap ou Material- Desenhar.

1. Maturidade
Como já observamos, Angular e React são suportados e usados por grandes empresas. Facebook, Instagram e Whatsapp estão usando isso para suas páginas. O Google usa isso em muitos projetos: por exemplo, a nova interface do usuário do Adwords foi implementada usando o Angular & Dart . Mais uma vez, o Vue é realizado por um grupo de indivíduos cujo trabalho é apoiado através de Patreon e outros meios de patrocínio. Você pode decidir por si mesmo se este é positivo ou negativo. Matthias Götzke acha que a pequena equipe do Vue é um benefício porque leva a um código / API mais limpo e menos engenhoso.

![](https://cdn-images-1.medium.com/max/1600/1*vvRdTNyQNrDeAxBXzBbqQw.png)

2. Longevidade
De acordo com a última pesquisa da Stackoverflow 2017 , o React é amado por 67% dos desenvolvedores pesquisados e AngularJS em 52%. "Nenhum interesse em continuar desenvolvendo" registra números maiores para AngularJS (48%) vs. React (33%). O Vue não está no Top 10 em nenhum dos dois casos. Depois, há a pesquisa statejs.com que compara " frameworks finais ". Os fatos mais interessantes: React e Angular têm 100% de consciência, e Vue é desconhecida de 23% das pessoas pesquisadas. Quanto à satisfação, o React obteve 92% para "usar novamente", Vue 89% e Angular 2 apenas 65%.
3. Comunidade
Análise  estatística lista 36 pessoas na página da equipe angular, Vue lista 16 pessoas e React não possui uma página da equipe. 

![](https://cdn-images-1.medium.com/max/1600/1*JKPQhZwOGAAlViSYsUf--w.png)

Em Github, Angular tem> 25.000 estrelas e 463 contribuidores, React tem> 70.000 estrelas e> 1.000 contribuidores, e Vue tem quase 60.000 estrelas e apenas 120 contribuidores. Você também pode verificar o Github Stars History para Angular, React e Vue . Mais uma vez, o Vue parece estar muito bem. De acordo com bestof.js , nos últimos três meses Angular 2 tem recebido uma média de 31 estrelas por dia, React 74 estrelas e Vue.JS 107 estrelas. 
4.  Curva de aprendizado
Se você tem desenvolvedores de HTML internos que não querem aprender mais Javascript, é melhor escolher Angular ou Vue. React implica mais Javascript (falamos sobre isso mais tarde).
Você tem designers trabalhando perto do código? O usuário "pier25" anota no Reddit que React faz sentido se você estiver trabalhando para o Facebook, onde todos são desenvolvedores de super-heróis . No mundo real, você nem sempre encontrará um designer que possa modificar o JSX - como tal, trabalhar com modelos HTML será muito mais fácil.
A coisa boa sobre o quadro angular é que um novo desenvolvedor Angular 2 de outra empresa se familiarizará rapidamente com todas as convenções necessárias. Os projetos de reação são diferentes em termos de decisões arquitetônicas, e os desenvolvedores precisam se familiarizar com a configuração específica do projeto.
5. Performance
Há um flip-side para toda a funcionalidade: o quadro angular é bastante inchado. O tamanho do arquivo gzip é de 143k, em comparação com 23K para Vue e 43k para React.

![](https://cdn-images-1.medium.com/max/1600/1*gpq0Y-rRczJ5C3DI5_EUlw.png)

React e Vue têm um DOM virtual, que é suposto melhorar o desempenho. Se você está interessado nisso, você pode ler sobre as diferenças entre o DOM virtual e DOM , bem como os benefícios reais do Virtual DOM em react.js . Além disso, um dos autores do Virtual-DOM responde uma questão relacionada ao desempenho no Stackoverflow.

![](https://cdn-images-1.medium.com/max/1600/1*YpbalqSUMYIYjXCduq7dcA.png)

Para verificar o desempenho, eu verifiquei o excelente js-framework-benchmark . Você pode baixá-lo e executá-lo, ou veja a tabela de resultados interativa . Antes de verificar os resultados, você deve saber, que as estruturas estão traçando benchmarks - tal verificação de desempenho não deve ser usada para tomar decisões.

Conclusão
========
Como resultado, todas as bibliotecas e frameworks analisadas oferecem um excelente conjunto de possibilidades. Provavelmente a escolha em maior medida pode surgir com um problema, mas pode ser facilmente resolvida com a ajuda de um instrumento específico. Por exemplo, a Vue pode ser considerada como mais simples de usar, React é um pouco mais "de uso geral", e a Angular pode realizar um desenvolvimento paralelo dentro de um único projeto. Deve-se notar que o Vue suporta JSX, mas essa abordagem na criação de Vue-applications raramente é usada.

Referências
========
[1] Unicorn Supplies. https://medium.com/unicorn-supplies/angular-vs-react-vs-vue-a-2017-comparison-c5c52d620176
