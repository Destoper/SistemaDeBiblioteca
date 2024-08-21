Seria interessante criar uma interface do tipo Item ou Emprestavel para que, no futuro, a blioteca possa emprestar coisas alem de livros?
- S

O que está na linha 50 até a 78 da classe User, não seria melhor criar uma nova classe para esses métodos ? Acho que isso está ferindo o single responsibility e poderíamos aproveitar para adicionar os métodos de reserva direto na classe ILoanable