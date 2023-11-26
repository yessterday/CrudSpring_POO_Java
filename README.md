# CrudSpring_POO_Java
Este projeto apresenta o desenvolvimento de um sistema CRUD em Java Spring Boot como parte da disciplina de Programação Orientada a Objetos. A aplicação utiliza o banco de dados H2, Maven para gerenciamento de dependências e segue a arquitetura de API REST.

- Aluno: Fernando Gabriel Costa Castro 
- RA: 202303208677

##

# O que é um CRUD e para que serve?
- CRUD é um acrônimo que representa quatro operações básicas em bancos de dados:

- Create (Criar): Adiciona novos dados.
- Read (Ler): Recupera dados existentes.
- Update (Atualizar): Modifica dados existentes.
- Delete (Excluir): Remove dados existentes.

Essas operações são fundamentais para manipular informações em sistemas de software, como adicionar novos registros, visualizar dados, fazer atualizações ou excluir informações. O CRUD é uma base comum em muitos tipos de aplicativos e sistemas.

##

# Relacionamento utilizado
Neste projeto foi utilizado um relacionamento de Um-para-muitos (OneToMany) 
<br><br/>

- Guild (OneToMany) - Um-para-muitos
- Players (ManyToOne) -Muitos-para-um

<br><br/>
Os relacionamentos escolhidos foram inspirados em um sistema básico de qualquer RPG, onde vários Players podem pertencer a apenas uma Guilda (Grupo/Clã), e uma Guilda pode possuir vários Players (membros)
