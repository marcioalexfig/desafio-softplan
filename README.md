Exercicio 1

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


