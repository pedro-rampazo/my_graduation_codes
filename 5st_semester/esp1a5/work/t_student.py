from google.colab import drive
import matplotlib.pyplot as plt
import pandas as pd
from scipy import stats
import numpy as np

# CARREGANDO DADOS DA PLANILHA
drive.mount("/content/drive")
file_path = '/content/drive/My Drive/registro_ocupacao_hospitalar_covid19_2020.csv'

# LENDO DADOS DA PLANILHA
df = pd.read_csv(file_path)

sp = df[df["municipio"] == "São Paulo"].shape[0]
rj = df[df["municipio"] == "Rio de Janeiro"].shape[0]

# Criar listas de ocorrências (assumindo contagem de ocorrências por entrada para manter a variabilidade)
lista_sp = [1] * sp
lista_rj = [1] * rj

# Adicionar alguma variabilidade para evitar listas constantes (não usual, mas para fins ilustrativos)
# Na prática, você deve ter dados mais variados. Aqui adicionamos pequenas variações.
lista_sp = lista_sp + np.random.normal(0, 0.1, len(lista_sp)).tolist()
lista_rj = lista_rj + np.random.normal(0, 0.1, len(lista_rj)).tolist()

# Calcular a média e o desvio padrão de cada lista
media_sp = np.mean(lista_sp)
media_rj = np.mean(lista_rj)
desvio_padrao_sp = np.std(lista_sp, ddof=1)
desvio_padrao_rj = np.std(lista_rj, ddof=1)

print(f'Média de SP: {media_sp}')
print(f'Média de RJ: {media_rj}')
print(f'Desvio padrão de SP: {desvio_padrao_sp}')
print(f'Desvio padrão de RJ: {desvio_padrao_rj}')

# Realizar o teste t para duas amostras independentes
t_stat, p_valor = stats.ttest_ind(lista_sp, lista_rj)

print(f'Estatística t: {t_stat}')
print(f'P-valor: {p_valor}')

# Nível de significância
alpha = 0.05

# Interpretação dos resultados
if p_valor < alpha:
    print("Rejeitar a hipótese nula (H0). As médias das ocorrências são significativamente diferentes.")
else:
    print("Não rejeitar a hipótese nula (H0). As médias das ocorrências não são significativamente diferentes.")
