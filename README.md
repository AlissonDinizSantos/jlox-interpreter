# JLox - Interpretador da Linguagem Lox

Este repositório contém a implementação completa de um interpretador para a linguagem **Lox**, desenvolvida em Java. O projeto segue as especificações do livro _Crafting Interpreters_ e abrange desde a análise léxica (Scanner) até a execução orientada a objetos (Classes e Herança).

## 🚀 Funcionalidades Implementadas

O interpretador suporta os seguintes recursos da linguagem:

- **Tipos de Dados:** Números, Strings, Booleanos e `nil`.
- **Aritmética e Lógica:** Operadores `+`, `-`, `*`, `/`, `!`, e agrupamento `()`.
- **Variáveis:** Declaração (`var`), atribuição (`=`) e escopo de bloco `{}`.
- **Fluxo de Controle:**
  - Condicionais: `if`, `else`.
  - Operadores Lógicos: `and`, `or` (com curto-circuito).
- **Funções:**
  - Declaração e chamada de funções.
  - Retorno de valores (`return`).
  - **Closures** (Escopo léxico real).
- **Orientação a Objetos (OOP):**
  - Declaração de Classes (`class`).
  - Instanciação e Métodos.
  - Propriedades (`this`).
  - Construtores (`init`).
  - Herança (`<`) e acesso à superclasse (`super`).

---

## 🛠️ Como Rodar

### Pré-requisitos

- Java Development Kit (JDK) instalado.

### 1. Compilar o Projeto

Navegue até a raiz do projeto e compile os arquivos Java:

```bash
# Cria o diretório de binários se não existir
mkdir -p bin

# Compila o interpretador
javac -d bin src/main/java/com/craftinginterpreters/lox/*.java

# Compila a ferramenta de geração de AST (apenas se precisar regenerar código)
javac -d bin src/main/java/com/craftinginterpreters/tool/GenerateAst.java
```

### 2. Executar o REPL (Modo Interativo)

Para digitar códigos linha a linha:

```bash
java -cp bin com.craftinginterpreters.lox.Lox
```

### 3. Executar um Arquivo

Para rodar um script `.lox` existente:

```bash
java -cp bin com.craftinginterpreters.lox.Lox script.lox
```

---

## 📚 Exemplos de Sintaxe

Aqui estão exemplos do que o JLox consegue fazer.

### 1. Variáveis e Controle de Fluxo

```javascript
var a = "global";
{
  var a = "local";
  print a; // Imprime: local
}
print a; // Imprime: global

if (true and 1 < 2) {
  print "Sim, lógica funciona!";
}
```

### 2. Funções e Closures

```javascript
fun criarContador() {
  var i = 0;
  fun contar() {
    i = i + 1;
    print i;
  }
  return contar;
}

var contador = criarContador();
contador(); // 1
contador(); // 2
```

### 3. Classes e Objetos

```javascript
class Bolo {
  comer() {
    print "Que delícia!";
  }
}

var bolo = Bolo();
bolo.comer(); // Imprime: Que delícia!

// Propriedades dinâmicas
bolo.sabor = "Chocolate";
print bolo.sabor; // Chocolate
```

### 4. Herança e Inicializadores

```javascript
class Donut {
  cozinhar() {
    print "Fritando no óleo...";
  }
}

class BostonCream < Donut {
  init() {
    this.recheio = "Creme";
  }

  cozinhar() {
    super.cozinhar();
    print "Recheando com " + this.recheio;
  }
}

BostonCream().cozinhar();
// Imprime:
// Fritando no óleo...
// Recheando com Creme
```
