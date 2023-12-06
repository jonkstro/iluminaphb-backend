# Sistema de Gestão de Iluminação Pública - Backend

O sistema de gestão de iluminação pública utilizará tecnologias robustas no backend para garantir segurança, eficiência e escalabilidade. O desenvolvimento será realizado usando **Spring Boot 3**, **Spring Security**, e **MongoDB** como banco de dados NoSQL.

## Arquitetura do Backend

O backend será estruturado utilizando o framework **Spring Boot 3** para facilitar o desenvolvimento de aplicativos Java baseados em microsserviços. O uso do Spring Boot 3 proporcionará uma configuração simples e rápida, permitindo o desenvolvimento ágil e eficiente.

## Tecnologias Principais

### Spring Boot 3

O **Spring Boot 3** será a espinha dorsal do backend, facilitando a criação de APIs RESTful e serviços web. Sua abordagem de convenção sobre configuração agiliza o desenvolvimento e a manutenção do código.

### Spring Security

O **Spring Security** será implementado para garantir a autenticação e autorização seguras no sistema. Ele oferece recursos robustos para proteger endpoints, controlar o acesso e gerenciar a segurança de forma abrangente.

### MongoDB

O **MongoDB** será utilizado como o banco de dados NoSQL para armazenar os dados relacionados à gestão de iluminação pública. Sua flexibilidade de esquema e escalabilidade horizontal atendem às demandas de um sistema que lida com uma grande quantidade de dados e atualizações frequentes.



## Requisitos Funcionais:

### RF01 - Cadastro de Manutenções:
- **Descrição:** Permitir o cadastro de manutenções relacionadas à iluminação pública.
- **Categoria:** Obrigatório.

### RF02 - Registro de Reclamações:
- **Descrição:** Possibilitar aos usuários registrar reclamações sobre iluminação deficiente.
- **Categoria:** Obrigatório.

### RF03 - Acompanhamento de Status:
- **Descrição:** Proporcionar aos usuários o acompanhamento em tempo real do status das manutenções.
- **Categoria:** Importante.

### RF04 - Mapeamento de Pontos sem Iluminação:
- **Descrição:** Identificar e mapear pontos onde ainda não há instalação de iluminação pública.
- **Categoria:** Obrigatório.

### RF05 - Histórico de Manutenções:
- **Descrição:** Manter um histórico detalhado de todas as manutenções realizadas.
- **Categoria:** Importante.

### RF06 - Integração com GPS:
- **Descrição:** Utilizar o GPS do dispositivo para localização precisa em novos pontos de instalação.
- **Categoria:** Importante.

### RF07 - Notificações em Tempo Real:
- **Descrição:** Enviar notificações em tempo real sobre o andamento das manutenções.
- **Categoria:** Importante.

### RF08 - Relatórios de Desempenho:
- **Descrição:** Gerar relatórios periódicos sobre o desempenho do sistema e das manutenções realizadas.
- **Categoria:** Importante.

### RF09 - Autenticação de Usuários:
- **Descrição:** Implementar autenticação segura para garantir acesso controlado ao sistema.
- **Categoria:** Obrigatório.

### RF10 - Registro de Consumo de Serviços:
- **Descrição:** Permitir o registro do quanto de serviços foram consumidos em cada manutenção.
- **Categoria:** Importante.

### RF11 - Registro de Consumo de Materiais:
- **Descrição:** Possibilitar o registro do consumo de materiais utilizado em cada manutenção.
- **Categoria:** Importante.

### RF12 - Histórico de Consumo:
- **Descrição:** Manter um histórico detalhado do consumo de serviços e materiais em cada manutenção.
- **Categoria:** Desejável.

## Requisitos Não Funcionais:

### RNF01 - Desempenho:
- **Descrição:** O aplicativo deve oferecer uma resposta rápida, mesmo em situações de carga elevada.
- **Categoria:** Obrigatório.

### RNF02 - Segurança:
- **Descrição:** Garantir a segurança dos dados sensíveis dos usuários e das informações sobre manutenções.
- **Categoria:** Obrigatório.

### RNF03 - Usabilidade:
- **Descrição:** Assegurar uma interface intuitiva para facilitar o uso por usuários de diferentes níveis de habilidade.
- **Categoria:** Obrigatório.

### RNF04 - Disponibilidade:
- **Descrição:** Manter o aplicativo disponível 24/7, minimizando períodos de inatividade.
- **Categoria:** Obrigatório.

### RNF05 - Escalabilidade:
- **Descrição:** Ser capaz de lidar com um aumento no número de usuários e dados ao longo do tempo.
- **Categoria:** Importante.

### RNF06 - Compatibilidade:
- **Descrição:** Garantir compatibilidade com diferentes dispositivos móveis e sistemas operacionais.
- **Categoria:** Importante.

### RNF07 - Backup e Recuperação:
- **Descrição:** Implementar um sistema eficaz de backup e recuperação de dados.
- **Categoria:** Importante.

### RNF08 - Privacidade:
- **Descrição:** Respeitar as normas de privacidade e proteção de dados.
- **Categoria:** Obrigatório.

### RNF09 - Manutenibilidade:
- **Descrição:** Facilitar a manutenção do sistema, permitindo atualizações e correções sem impactar o uso.
- **Categoria:** Importante.

### RNF10 - Integração com Sistemas Externos:
- **Descrição:** Ser capaz de integrar-se a sistemas externos, como bases de dados municipais.
- **Categoria:** Desejável.
