# Green4R-API

### Backend - Projeto de TCC
### Ideia
 - Criar um aplicativo para incentivo e facilitação de resíduos recicláveis. O principal foco do trabalho é a criação de uma ferramenta, app, para incentivo ao descarte consciente de residuos, atráves do engajamento e recompensa financeira. Busca aproximar o produtor, o usuário comum, com um coletor, e aproximar o coletor com uma centro de reciclagem, promovendo uma maior interação e agilidade, além de promover maior participação de pessoas nesse processo.
 - Green4R
 - R´s da Sustentabilidade
    - R - Reduzir - Diminua a quantidade de resíduos que você gera
    - R - Reutilizar - Utilize produtos mais de uma vez sempre que possível, prolongando a vida útil dos materiais e objetos
    - R - Reciclar - Transforme materiais usados em novos produtos
    - R - Repensar - Avalie seus hábitos de consumo e o impacto ambiental das suas ações

### Docs
Atores: **Produtores** - Usuários do App que produzem algum tipo de resíduo reciclável que deseje descartar de forma a receber algo em troca. **Coletores** - Usuários do App que fazem o papel de recolher o resíduos dos **Produtores** e inserir no App quantidades recolhidas e encaminhar esses resíduos aos locais de reciclagem. **Recicladores** - Usuários do App que representam os centros de reciclagem responsáveis pela compra dos materiais e adicionar no App o registro de compra dos **Coletores.**

**Administrador** - Usuários que gerenciam o sistema, bem como cadastrar itens coletáveis e preços.

### **Cenários**

**1° Cenário:** Imagine um fluxo no qual existe um condomínio engajado com a causa de reciclagem de resíduos. Nesse cenário o condomínio é um **Coletor**. 

**2° Cenário:**  Imagine que um local **Coletor**, seja ele condomínio ou um ponto de coleta fixo qualquer, recebe os resíduos, mas outro **Coletor** que fará o trabalho de levar os resíduos para o **Reciclador**. 

**Questionamento:** Nesse cenário, como a gente poderia fazer para manter a integridade da entrega do **Produtor** e garantir que ele vai receber por sua por sua contribuição ? Poderíamos dividir os ganhos entre os **Coletores,** ou ter uma politica que apenas o ultimo **Coletor** ganhe algum valor ?

### **Histórias de usuários**

1. Eu, como **Produtor,** desejo me cadastrar no sistema.
2. Eu, como **Produtor,** quando tiver uma quantidade de resíduos recicláveis, desejo solicitar, via App, o recolhimento dos meus resíduos, informando quantidades e tipos de resíduos, bem como local de coleta.
3. Eu, como **Produtor**, desejo acompanhar e confirmar minha entrega com os coletores(Aqui podem ser coletores moveis, no caso de pegar na residencia, pode ser o condomínio, ou outro ponto de coleta)
4. Eu, como **Produtor**, desejo ter a flexibilidade de “vender” meus resíduos diretamente em locais de coleta/cooperativas e ter minha entrega registrada e confirmada via App
5. Eu, como **Produtor**, desejo acompanhar minhas solicitações de recolhimento.
6. Eu, como **Produtor**, quero poder acompanhar meus históricos de entregas.
7. Eu, como **Produtor**, desejo conseguir visualiza o que tenho de ganhos em minha conta do App.
8. Eu, como **Coletor,** desejo me cadastrar no sistema(Aqui seria interessante informar o tipo de coletor - Se é um coletor local fixo(Um ponto, um condomínio), se é um coletor direto como **Reciclador**(Que pode buscar os resíduos), ou um coletor móvel que apenas busca os resíduos)
9. Eu, como **Coletor**, desejo visualizar solicitações para coletas de materiais recicláveis, com suas quantidades e tipos de materiais, e local, para checar a viabilidade de ir buscar os matérias.
10. Eu, como **Coletor**, quero poder registrar a entrega do **Produtor** com suas quantidades e tipos de resíduos(Aqui é importante validação do **Produtor** na contabilização dos resíduos deixados por eles)
11. Eu, como **Coletor**, desejo confirmar o recolhimento que foi solicitada pelo **Produtor**, bem como confirmar suas quantidades recolhidas.
12. Eu, como **Coletor**, desejo confirmar as quantidades no momento de dar baixa na entrega final junto com o **Reciclador**.
13. Eu, como **Reciclador,** desejo me cadastrar no sistema.
14.  Eu, como **Reciclador**, desejo registrar uma entrega feita pelo próprio **Coletor.**
15. Eu, como **Reciclador**, desejo registrar uma entrega feita pelo próprio **Produtor.**
