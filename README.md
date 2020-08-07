# Exercicio 1

Aplicação: Executar a classe br.com.soft.sieng.ex1.SiengApplication como "SpringBoot App"

Testes: Executar a classe br.com.soft.sieng.ex1.SiengApplicationTests como "JUnitTest"

Criação da classe GeradorObservacaoV2. Este nome foi dado para ficar evidente que se trata da mesma funcionalidade da classe anterior, porém com alguma melhorias. 

A interface Gerador utiliza a lista "List<?>" para que possa tanto ser sobrescrita por "List" da classe legada, por ser 'supertipo' de List<?>, o que faz o Java aceitar a sobrescrita, como também o "Override" do método na classe V2. Com isso, a interface pode ser usada para qualguer tipo de objetos incluindo Integer ou objetos gerados a partir de classes do modelo da aplicação. 

Interface Gerador que sera implementada pela classe GeradorObservacao e pela nova classe GeradorObservacaoV2. Desta forma a classe original não precisará ter seus comportamentos alterados, e somente a aplicação que for usar a funcionalidade poderá instanciar a classe legada ou sua nova versão.

A interface Gerador possui o metodo geraObservacao para se adequar a classe legada, sem alterá-la, pois é o método público que as instâncias da classe GeradorObservacao utilizam quando são criadas.

Para a nova versão, os textos são disponibilizados via arquivo de propriedades "application.properties"

Nos testes unitários foi utilizada a funcao ".strip()" do Java 11 para retirar os espaços em branco das extremidades dos textos e também por aceitar e comparar unicode.

Criação da classe NotaFiscalRepository para representar o banco de dados 

A classe GeradorObservacaoV2 possui algus pequenos métodos privados para uso próprio dividindo entre eles a complexidade do algoritmo, tornando o código mais limpo e mais fácil de manter.

No método gerarRelatorio foi utilizado o laço 'for' tradicional para aproveitar a existência do indice para saber quando um registro tesminará com ", ", " e ", ou ".", sendo respectivamente, "após todos antes do penúltimo a ', '", "após o penúltimo o ' e '", "após o último o '.'". Esta decisão foi tomada para que que o código fique mais claro e sua manutenção, caso necessário, não interfira no laço 'for'

# Exercicio 2

Aplicação: Executar a classe br.com.soft.sieng.ex2.Sieng2Application como "SpringBoot App"

Testes: Executar a classe br.com.soft.sieng.ex2.Sieng2ApplicationTests como "JUnitTest"

Criação da classe abstrata Item e das classes concretas Insumo e Composição para separar os papeis dos itens 

Inclusao da dependencia org.json e explusao da dependecia com.vaadin.external.google para evitar warn de conflito de dependencias

Inclusao da depensdencia StreamEx para alguns tratamentos adicionais de coleções como distinc por atributo no método calcularComposicoes.

cRIAÇÃO DE UMA abstract FACTORY para concentrar a criação de Itens a partir de classes concretas.

Classe Conversor para converter String para Double e prevenir quanto a exceções.

Obsercação sobre os resultados dos cálculos:
Os valores exibidos na saída (abaixo) estão diferentes dos valores do manual do exercício, porém, foram conferidos e estão corretos considerando os valores existentes no arquivo JSON.

               94793 REGISTRO DE GAVETA BRUTO, LATÃO, ROSCÁVEL, 1 1/4, COM ACABAMENTO E CANOPLA CROMADOS, INSTALADO EM RESERVAÇÃO DE ÁGUA DE EDIFICAÇÃO QUE POSSUA RESERVATÓRIO DE FIBRA/FIBROCIMENTO FORNECIMENTO E INSTALAÇÃO. AF_06/2016    UN                128,6
               98561 IMPERMEABILIZAÇÃO DE PAREDES COM ARGAMASSA DE CIMENTO E AREIA, COM ADITIVO IMPERMEABILIZANTE, E = 2CM. AF_06/2018    M2                21,49
               87286 ARGAMASSA TRAÇO 1:1:6 (CIMENTO, CAL E AREIA MÉDIA) PARA EMBOÇO/MASSA ÚNICA/ASSENTAMENTO DE ALVENARIA DE VEDAÇÃO, PREPARO MECÂNICO COM BETONEIRA 400 L. AF_06/2014    M3               287,63
               88830 BETONEIRA CAPACIDADE NOMINAL DE 400 L, CAPACIDADE DE MISTURA 280 L, MOTOR ELÉTRICO TRIFÁSICO POTÊNCIA DE 2 CV, SEM CARREGADOR - CHP DIURNO. AF_10/2014   CHP                 1,25
               88831 BETONEIRA CAPACIDADE NOMINAL DE 400 L, CAPACIDADE DE MISTURA 280 L, MOTOR ELÉTRICO TRIFÁSICO POTÊNCIA DE 2 CV, SEM CARREGADOR - CHI DIURNO. AF_10/2014   CHI                 0,22


Obs.: IDE utilizada foi o Spring Tool Suite 4 (Version: 4.6.0.RELEASE)
