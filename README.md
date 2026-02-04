# 🛒 The Market - Sistema de Gerenciamento de Mercado


O **The Market** é um sistema de console desenvolvido em Java para simular as operações essenciais de um mercado, incluindo cadastro de usuários (clientes e funcionários), login, gerenciamento de produtos e realização de compras.

Este projeto foi desenvolvido como um marco de conclusão dos meus estudos em **Programação Orientada a Objetos (POO)** e **Programação Funcional**, servindo como transição para o aprendizado de bancos de dados relacionais.

---

## 🚀 Funcionalidades

### Para Clientes:
*   **Cadastro e Login**: Sistema de autenticação seguro.
*   **Visualização de Produtos**: Listagem completa de itens disponíveis, ordenados por nome.
*   **Realização de Compras**: Fluxo de compra simplificado validando o tipo de usuário.

### Para Funcionários:
*   **Gerenciamento de Inventário**: Permissão exclusiva para cadastrar novos produtos no sistema.
*   **Visualização Geral**: Acesso à listagem de produtos cadastrados.

---

## 🛠️ Tecnologias e Conceitos Aplicados

O foco principal deste projeto foi a aplicação de boas práticas e recursos modernos do Java:

*   **Programação Orientada a Objetos (POO)**:
    *   **Encapsulamento**: Uso de atributos privados e métodos acessores.
    *   **Polimorfismo e Interfaces**: Implementação da interface `Comparable` para ordenação natural de coleções.
    *   **Enums**: Padronização de tipos de usuários (CLIENTE, FUNCIONARIO).
*   **Programação Funcional**:
    *   **Java Streams API**: Utilização de `stream()`, `anyMatch()` e `filter()` para buscas eficientes.
    *   **Expressões Lambda**: Código mais conciso e expressivo em iterações e validações.
    *   **Method References**: Uso de `System.out::println` para saída de dados.
*   **Persistência de Dados**:
    *   Manipulação de arquivos de texto (`.txt`) utilizando `BufferedWriter` e `BufferedReader`.
    *   Padrão **DAO (Data Access Object)** para isolar a lógica de persistência.
*   **Arquitetura de Software**:
    *   Divisão clara de responsabilidades em pacotes: `controller`, `service`, `dao`, `model` e `utils`.
    *   Uso de métodos **estáticos** para ferramentas utilitárias (`FileUtils`).

---

## 📁 Estrutura do Projeto

```text
src/main/java/
├── controller/ # Camada de interação com o usuário (Console)
├── dao/        # Camada de acesso aos dados (Leitura/Escrita em TXT)
├── model/      # Entidades (User, Product) e Enums
├── service/    # Regras de negócio e validações
├── utils/      # Classes utilitárias (Ex: Manipulação de arquivos)
└── Main.java   # Ponto de entrada do sistema
```

---

## 🔧 Como Executar

1.  Certifique-se de ter o **JDK 17** ou superior instalado.
2.  Clone o repositório:
    ```bash
    git clone https://github.com/lvpcdev/the-market.git
    ```
3.  O sistema utiliza o caminho `C:\temp` para salvar os arquivos de dados por padrão (configurável nos arquivos DAO).
4.  Compile e execute a classe `Main.java`.

---
Desenvolvido por [Lucas Vicente](https://github.com/lvpcdev) 🚀

