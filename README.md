# Algoritmo de Clusterizacao

Mudanças no Naive:
- colocar atributos públicos
- não precisa guardar as distâncias (a cada distância calculada pode verificar se é o menor e guardar numa variável)
- guardar os pontos da menor distância
- guardar os testes em um arquivo csv para não ter que printar (ex: tamanhoEntrada, tempo, número de execução
- deixar o algoritmo rodando durante a noite, principalmente o naive por ter uma complexidade alta)
- vai ter mudanças no
- 
Mudanças para heap
- é necessário excluir da fila de prioridade as distâncias que incluem os pontos do novo cluster que foi unido
- quando for excluir as distâncias que incluem os pontos é recomendado: criar um vetor auxiliar sem as distâncias que vão ser excluidas e com as novas distâncias calculadas apartir do cluster novo para todos os outros clusters/pontos, e chamar build heap
