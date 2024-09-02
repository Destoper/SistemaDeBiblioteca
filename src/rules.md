2. Visão Geral do Sistema

	USUARIOS:
		alunos de graduação
		alunos de pósgraduação
		professores

	ACOES:
		empréstimo
		devolução
		reserva 

	OBSERVACOES:
		Um livro específico pode dispor na biblioteca de mais de um exemplar


3. Funcionalidades
	
	1. O sistema deve permitir o empréstimo de livros. Durante o empréstimo, o usuário informará o
	comando “emp” seguido do código do usuário e do código do livro, separados por espaço em
	branco. Ex.: “emp 123 100”. Caso o usuário tenha uma reserva feita previamente por ele para
	o dado livro, a reserva deve ser excluída e o empréstimo efetivado. Ao final do procedimento
	o sistema deve emitir uma mensagem de sucesso ou insucesso, que mencione o nome do
	usuário e o título do livro. Se for uma mensagem de insucesso, ela deve também mencionar o
	motivo do insucesso

---------------------------------------------------------------------------------------------------------------------------------------------------

* Livro:
	Cada livro deve possuir um código que o identifique e um título. Além do código e do título, os livros
devem manter as seguintes informações adicionais: editora, autores, edição e ano da publicação.

* Usuario:
	Cada usuário deve ter um código de identificação e nome.

	Tipo de Usuário:    | Tempo de Empréstimo:
	------------------------------------------
	Aluno Graduação     | 3 dias
	Aluno Pós-Graduação | 5 dias
	entities.Professor           | 7 dias

---------------------------------------------------------------------------------------------------------------------------------------------------

* Regra de Empréstimo para Aluno:
	
	* houver a disponibilidade de algum exemplar daquele livro na biblioteca

	* o usuário não estiver “devedor” de um livro em atraso

	* forem obedecidas as regras específicas daquele tipo de usuário no que se refere à quantidade máxima de empréstimos [GRAD -> 3 livros | POS -> 4 LIVROS]

	* a quantidade de reservas existentes do livro for menor do que a quantidade de exemplares disponíveis, caso o usuário não tenha reserva para ele.

	* a quantidade de reservas for maior ou igual a de exemplares, mas uma das reservas é do 

	* o usuário não tiver nenhum empréstimo em curso de um exemplar daquele mesmo livro