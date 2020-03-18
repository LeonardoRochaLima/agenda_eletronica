Diagrama de Classe Agenda
@startuml

title Classes - Class Diagram


class Contato {
  +String nome
  +String contato
  +int opcao
  +Contato inserirContato();
  +Contato excluirContato();
  +Contato buscarContato();
  +Contato listarContato();
}

@enduml


@startuml

User --> (inserirContato)
User --> (excluirContato)
User --> (buscarContato)
User --> (listarContato)

@enduml



@startuml

title "Participants - Sequence Diagram"

actor User as u
boundary "Menu" as m
boundary "Agenda" as a

u -> m : adicionar
m -> a : inserirContato

u -> m : excluir
m -> a : excluirContato

u -> m : buscar
m -> a : buscarContato

u -> m : listar
m -> a : listarContato

@enduml