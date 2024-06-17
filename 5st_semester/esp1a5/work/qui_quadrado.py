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
df = df.dropna()

ocupacao_confirmado_uti = df["ocupacaoConfirmadoUti"]
saida_confirmada_obitos = df["saidaConfirmadaObitos"]

t_stat, p_valor = stats.ttest_ind(ocupacao_confirmado_uti, saida_confirmada_obitos)

print(f'Estatística t: {t_stat}')
print(f'P-valor: {p_valor}')

# Nível de significância
alpha = 0.05

# Interpretação dos resultados
if p_valor < alpha:
    print("Rejeitar a hipótese nula (H0). As médias das colunas são significativamente diferentes.")
else:
    print("Não rejeitar a hipótese nula (H0). As médias das colunas não são significativamente diferentes.")
