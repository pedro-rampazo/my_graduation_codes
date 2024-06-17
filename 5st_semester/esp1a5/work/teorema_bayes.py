from google.colab import drive
import matplotlib.pyplot as plt
import pandas as pd

# CARREGANDO DADOS DA PLANILHA
drive.mount("/content/drive")
file_path = '/content/drive/My Drive/registro_ocupacao_hospitalar_covid19_2020.csv'

# LENDO DADOS DA PLANILHA
df = pd.read_csv(file_path)

suspeitas_obitos = df["saidaSuspeitaObitos"].dropna()
suspeitas_altas = df["saidaSuspeitaAltas"].dropna()
confirmados_obitos = df["saidaConfirmadaObitos"].dropna()
confirmados_altas = df["saidaConfirmadaAltas"].dropna()

saidos = pd.concat([confirmados_obitos, confirmados_altas, suspeitas_obitos, suspeitas_altas])

confirmados = pd.concat([confirmados_obitos, confirmados_altas])
confirmados_pc = (confirmados.sum() * 100) / saidos.sum()
print(f"Porcentagem de Confirmados: {confirmados_pc}")

obitos = pd.concat([confirmados_obitos, suspeitas_obitos])
obitos_pc = (obitos.sum() * 100) / saidos.sum()
print(f"Porcentagem de Óbitos: {obitos_pc}")

saida_confirmada_obito_pc = (confirmados_obitos.sum() * 100) / saidos.sum()
print(f"Saída confirmada por óbito: {saida_confirmada_obito_pc}")

bayes = (saida_confirmada_obito_pc * obitos_pc) / confirmados_pc
print(f"Resultado: {bayes}")

# DAS SAÍDAS DE OCUPAÇÃO HOSPITALAR, QUAL A PROBABILIDADE DE UM ÓBITO TER SIDO CONFIRMADO
