from google.colab import drive
import matplotlib.pyplot as plt
import pandas as pd
from scipy.stats import poisson
import numpy as np

# CARREGANDO DADOS DA PLANILHA
drive.mount("/content/drive")
file_path = '/content/drive/My Drive/registro_ocupacao_hospitalar_covid19_2020.csv'

# LENDO DADOS DA PLANILHA
df = pd.read_csv(file_path)

lambda_poisson = df["saidaConfirmadaAltas"].mean()

k = np.arange(0, 25)

pmf = poisson.pmf(k, lambda_poisson)

# Exibir valores da PMF
for i in range(len(k)):
    print(f'P(X = {k[i]}) = {pmf[i]}')

# Plotar a distribuição de Poisson
plt.bar(k, pmf, color='blue', alpha=0.7)
plt.xlabel('Número de ocorrências (k)')
plt.ylabel('Probabilidade')
plt.title(f'Distribuição de Poisson (λ={lambda_poisson})')
plt.grid(True)
plt.show()

# BASEADO NA MÉDIA DE APROXIMADAMENTE 33 PACIENTES RECEBERAM ALTA, QUAL A PROBABILIDADE NO PRÓXIMO ANO OBTERMOS UMA MÉDIA DE 25 PACIENTES TENDO ALTA?
